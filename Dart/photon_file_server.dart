// Pure CLI implementation of Photon file-transfer app.
// Install dart-sdk to run the code

import 'dart:io';
import 'dart:convert';

HttpServer? server;
void main() async {
  print('\x1B[32mPaste the path of the file that you want to serve (share) 👇');
  String? name = stdin.readLineSync();
  await _start([name!.replaceAll('"', '')]);
}

Future<void> _start(fileData) async {
  String? ip;
  List interfaces = await NetworkInterface.list();
  for (NetworkInterface i in interfaces) {
    for (var add in i.addresses) {
      if (add.address.toString().startsWith('192.168')) {
        ip = add.address;
      }
    }
  }

  server = await HttpServer.bind(ip, 4040);
  List fileList = fileData;
  print('listening at ${server!.address}');
  print("""\x1B[36m
Your file :${fileList[0].toString().split(Platform.pathSeparator).last} is ready to be shared 🔥\n
\x1B[31m=== Note:Both devices must be connected to same Wi-fi OR mobile-hotspot ===\n
\x1B[37mType \x1B[32m ${server!.address.address}:${server!.port}/0 \x1B[37mon any browser to save the file
""");
  server!.listen((HttpRequest request) async {
    HttpHeaders data = request.headers;
    String check = '';
    data.forEach((name, values) {
      check = values[0];
    });

    if (check == "send_file_list") {
      var payload = {"data": fileList};
      request.response.headers.add('files-count', fileList.length);

      request.response.write(json.encode(payload));
      request.response.close();
      // continue;
    } else if (request.requestedUri.toString() ==
        'http://$ip:4040/photon-server') {
      try {
        request.response.write(json.encode({
          "os": Platform.operatingSystem.toString(),
          "ip": ip,
          "port": 4040
        }));
        request.response.close();
        //   continue;
      } catch (e) {}
    } else if (request.requestedUri.toString() ==
        "http://$ip:4040/favicon.ico") {
      request.response.write(
          'https://cdn.mos.cms.futurecdn.net/zLQKXnQPuX3PDV8qAQjVxN.jpg');
      request.response.close();
    } else {
      //imp

      await _serveFile(request, check, fileList);
      //   continue;
    }
  });
}

_stop() async {
  await server!.close();
}

_serveFile(HttpRequest request, check, fileList) async {
  print('serving');
  late String fileName;
  late File file;
  late int size;
  //to serve the requested file among the list of files
  fileName =
      fileList[int.parse(request.requestedUri.toString().split('4040/').last)];

  file = File(fileName);
  size = await file.length();
  request.response.headers.contentType =
      ContentType('application', 'octet-stream', charset: 'utf-8');

  request.response.headers.add(
    'Content-Transfer-Encoding',
    'Binary',
  );

  request.response.headers.add(
    'Content-disposition',
    'attachment; filename=${Uri.encodeComponent(fileName.split(Platform.isWindows ? r'\' : '/').last)}',
  );

  request.response.headers.add(
    'Content-length',
    size,
  );
  await file.openRead().pipe(request.response).catchError((err) {}).then((val) {
    request.response.close();
  });
}
