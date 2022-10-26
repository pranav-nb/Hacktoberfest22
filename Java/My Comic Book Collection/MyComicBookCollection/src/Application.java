import java.io.*;
import java.util.Scanner;

public class Application {
    static String fileName;
    static Repository library = new Repository();
    static Scanner scanner = new Scanner(System.in);
    static boolean running = true;

    public static void main(String[] args) throws IOException {
        System.out.println("                                                                                                                               \n" +
                "                             ,,                                                                                                \n" +
                "`7MMF'     A     `7MF'     `7MM                                                 mm               `7MMM.     ,MMF'              \n" +
                "  `MA     ,MA     ,V         MM                                                 MM                 MMMb    dPMM                \n" +
                "   VM:   ,VVM:   ,V .gP\"Ya   MM  ,p6\"bo   ,pW\"Wq.`7MMpMMMb.pMMMb.  .gP\"Ya     mmMMmm ,pW\"Wq.       M YM   ,M MM `7M'   `MF'    \n" +
                "    MM.  M' MM.  M',M'   Yb  MM 6M'  OO  6W'   `Wb MM    MM    MM ,M'   Yb      MM  6W'   `Wb      M  Mb  M' MM   VA   ,V      \n" +
                "    `MM A'  `MM A' 8M\"\"\"\"\"\"  MM 8M       8M     M8 MM    MM    MM 8M\"\"\"\"\"\"      MM  8M     M8      M  YM.P'  MM    VA ,V       \n" +
                "     :MM;    :MM;  YM.    ,  MM YM.    , YA.   ,A9 MM    MM    MM YM.    ,      MM  YA.   ,A9      M  `YM'   MM     VVV        \n" +
                "      VF      VF    `Mbmmd'.JMML.YMbmd'   `Ybmd9'.JMML  JMML  JMML.`Mbmmd'      `Mbmo`Ybmd9'     .JML. `'  .JMML.   ,V         \n" +
                "                                                   ,,                                                              ,V          \n" +
                "               .g8\"\"\"bgd                           db             `7MM\"\"\"Yp,                   `7MM             OOb\"           \n" +
                "             .dP'     `M                                            MM    Yb                     MM                            \n" +
                "             dM'       ` ,pW\"Wq.`7MMpMMMb.pMMMb. `7MM  ,p6\"bo       MM    dP  ,pW\"Wq.   ,pW\"Wq.  MM  ,MP'                      \n" +
                "             MM         6W'   `Wb MM    MM    MM   MM 6M'  OO       MM\"\"\"bg. 6W'   `Wb 6W'   `Wb MM ;Y                         \n" +
                "             MM.        8M     M8 MM    MM    MM   MM 8M            MM    `Y 8M     M8 8M     M8 MM;Mm                         \n" +
                "             `Mb.     ,'YA.   ,A9 MM    MM    MM   MM YM.    ,      MM    ,9 YA.   ,A9 YA.   ,A9 MM `Mb.                       \n" +
                "               `\"bmmmd'  `Ybmd9'.JMML  JMML  JMML.JMML.YMbmd'     .JMMmmmd9   `Ybmd9'   `Ybmd9'.JMML. YA.                      \n" +
                "                                        ,,   ,,                           ,,                                                   \n" +
                "                     .g8\"\"\"bgd        `7MM `7MM                    mm     db                                                   \n" +
                "                   .dP'     `M          MM   MM                    MM                                                          \n" +
                "                   dM'       ` ,pW\"Wq.  MM   MM  .gP\"Ya   ,p6\"bo mmMMmm `7MM  ,pW\"Wq.`7MMpMMMb.                                \n" +
                "                   MM         6W'   `Wb MM   MM ,M'   Yb 6M'  OO   MM     MM 6W'   `Wb MM    MM                                \n" +
                "                   MM.        8M     M8 MM   MM 8M\"\"\"\"\"\" 8M        MM     MM 8M     M8 MM    MM                                \n" +
                "                   `Mb.     ,'YA.   ,A9 MM   MM YM.    , YM.    ,  MM     MM YA.   ,A9 MM    MM                                \n" +
                "                     `\"bmmmd'  `Ybmd9'.JMML.JMML.`Mbmmd'  YMbmd'   `Mbmo.JMML.`Ybmd9'.JMML  JMML.                              \n" +
                "                                                                                                                               \n" +
                "                                                                                                                               ");
        while (running) {
            System.out.println("""
                    Enter 1 to load a collection.
                    Enter 2 to list all comic books in the collection.
                    Enter 3 to add a comic book to the collection
                    Enter 0 to save and quit.""");
            int response = Integer.parseInt(scanner.nextLine());
            switch (response) {
                case 0 -> saveAndQuit();
                case 1 -> {
                    System.out.println("Enter the name of the collection you would like to load: ");
                    loadScript(scanner.nextLine());
                }
                case 2 -> System.out.println(library.toString());
                case 3 -> addComic();
            }
        }
        System.exit(0);
    }

    private static void addComic() {
        String title;
        int issue;
        String author;
        String artist;
        double originalPrice;
        String publisher;
        int numCopies;
        System.out.println("Enter the title of the comic book: ");
        title = scanner.nextLine();
        System.out.println("Enter the issue number: ");
        issue = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the author's name: ");
        author = scanner.nextLine();
        System.out.println("Enter the artist's name: ");
        artist = scanner.nextLine();
        System.out.println("Enter the original price of the comic book: $");
        originalPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the publisher's name: ");
        publisher = scanner.nextLine();
        System.out.println("Enter how many copies of this comic book you have: ");
        numCopies = Integer.parseInt(scanner.nextLine());

        ComicBook comicBook = new ComicBook(title, issue, author, artist, originalPrice, publisher, numCopies);
        library.addComicBook(comicBook);


    }

    private static void saveAndQuit() throws IOException {
        System.out.println("Enter the name of the file you wish to save: ");
        fileName = scanner.nextLine() + ".ser";
        running = false;

        FileOutputStream outputStream;
        ObjectOutputStream objectOutputStream;

        try {
            outputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(library);
            outputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("That file does not exist.");
        }

    }

    private static void loadScript(String name) throws FileNotFoundException {
        FileInputStream inputStream;
        ObjectInputStream objectInputStream;

        File file = new File(name + ".ser");
        if (file.exists()) {
            try {
                inputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(inputStream);
                library = (Repository) objectInputStream.readObject();
                inputStream.close();
                objectInputStream.close();

            } catch (IOException e) {
                throw new FileNotFoundException("That file does not exist.");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("That file does not exist.");
        }
    }
}
