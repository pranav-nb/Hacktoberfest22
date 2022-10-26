#Login Part of the Application 
from tkinter import *

top = Tk()
top.geometry("450x500")

user_name = Label(top,text="Username").place(x=40, y=60)
user_pass = Label(top,text="Password").place(x=50, y=100)

submit_button = Button(top,text = "Submit").place(x = 150, y = 130)
   
user_name_input_area = Entry(top,width = 30).place(x = 110, y = 60)  
user_password_entry_area = Entry(top,width = 30).place(x = 110, y = 100) 
     
top.mainloop()