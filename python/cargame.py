x = ""
cs,ct = 0,0
while x != "quit":
    x = input(">").lower()
    if(x == "start"):
        if(cs == 0):
            print("car started...Ready to go!")
            cs+=1
        else:
            print("car already started")
        ct = 0

    elif(x == "stop"):
        if(ct == 0):
            print("Car stopped.")
            ct+=1
        else:
            print("Car already stopped")
        cs = 0
    elif(x=="help"):
        print("""
        start - to start the car
        stop - to stop the car
        quit - to quit""")
    elif(x=="quit"):
        break
    else:
        print("I don't understand that...")

    
