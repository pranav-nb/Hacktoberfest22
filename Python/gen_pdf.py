import os
from InvoiceGenerator.api import Invoice, Item, Client, Provider, Creator
from InvoiceGenerator.pdf import SimpleInvoice
import random
from datetime import date, datetime,time
os.environ["INVOICE_LANG"] = "en"
provider = Provider('XYZ COMPANY',address="DENIED, AT DENIED", bank_account='213123', bank_code='2021',division=date.today().strftime("%d/%m/%Y"))
creator = Creator('XYZ1 COMPANY')
def genpdf(id, amount, phone, name, email, category):
    client = Client(name,phone=phone,email=email)
    invoice = Invoice(client, provider, creator)
    if category=="1":
        invoice.add_item(Item(1, amount, description="Put whatever you want"))
    elif category=="2":
        invoice.add_item(Item(1, amount, description="Put whatever you want"))
    elif category=="3":
        invoice.add_item(Item(1, amount, description="Put whatever you want"))
    elif category=="4":
        invoice.add_item(Item(1, amount, description="Put whatever you want"))
    invoice.currency = "Rs."
    invoice.number = 10000+id
    docu = SimpleInvoice(invoice)
    docu.gen("invoice.pdf", generate_qr_code=False) 
