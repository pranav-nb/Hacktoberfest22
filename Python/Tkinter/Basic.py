#Basic Intro to TKinter
from tkinter import *

#root application 
root=Tk()
root.title("Denied Application") #Give it a name
root.geometry('500x500') #Give it a size

#Label a question or text
lable= Label(root,text="Are you being denied at DENIED?")
lable.grid()

#function to define working of a button 
def clicked():
    lable.configure(text="Yeah, even I am!")

#Creating button 
btn=Button(root,text="Yeah",fg="blue",command=clicked)
btn.grid(column=3,row=0)

root.mainloop()