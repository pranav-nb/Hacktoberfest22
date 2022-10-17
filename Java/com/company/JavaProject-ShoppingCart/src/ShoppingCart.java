import java.util.*;
import ProjectPackage.shoppingCart;//Importing Package
import SelectPackage.selectMenu;//Importing Package

interface inter {
	String getFruit();
}

class Items extends Thread implements inter {
	String Name;
	int Price;
	int Quantity;

	// Default Constructor
	Items() {
		Name = null;
		Price = 0;
	}

	// Parametric Constructor
	Items(String Name, int Price) {
		this.Name = Name;
		this.Price = Price;
	}

	// Constructor Overloading
	Items(String Name, int Price, int Quantity) {
		this.Name = Name;
		this.Price = Price;
		this.Quantity = Quantity;
	}

	void addItem(String name, float price) {
		System.out.println("The item added is " + name);
		System.out.println("Its Price is " + price);
	}

	public float getBill() {
		float total = Price * Quantity;
		return total;
	}

	void display() {
		System.out.println();
		System.out.println("----------CART DETAILS----------");
		System.out.println("Name of the Item is " + Name);
		System.out.println("Price of the Item is " + Price);
		System.out.println("Quantity = " + Quantity);
		System.out.println("Your Total Bill: " + getBill());
		System.out.println();
		System.out.println();
	}

	void discount(String offer) {
		if (offer.equals("SKP20") || offer.equals("skp20")) {
			System.out.println("Wohoo!!! 20% discount applied");
			System.out.println("Total bill amount after discount is " + getBill() * 0.8);
		} else
			System.out.println("Invalid Offer Code");
	}

	public String getFruit() {
		return Name;
	}

	// Overriding Method
	void methodOverride() {
		System.out.println("INSIDE THE CLASS : ITEMS");
	}
}

class NewThread extends Thread {
	Thread t;

	NewThread() {
		t = new Thread("Fetch Thread");
		t.start();
	}

	public void run() {
		System.out.println("Fetching Discount Coupons in.....");
		try {
			for (int i = 3; i > 0; i--) {
				System.out.println(i + "...");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception Caught !!!" + e);
		}
	}
}

class Fruits extends Items {
	int Weight;

	// Method Returning Object
	Fruits retObject() {
		Fruits litchi = new Fruits();
		return litchi;
	}

	Fruits() {
		super();
		Weight = 0;
	}

	Fruits(String Name, int Price, int Quantity, int Weight) {
		super(Name, Price, Quantity);
		Weight = 0;
	}

	// Passing Objects as Parameter
	void passObj(Fruits item) {
		Fruits apple = retObject();
		item = apple;
	}

	// Overriding Method
	void methodOverride() {
		System.out.println("INSIDE THE CLASS : FRUITS");
	}
}

class Vegetables extends Fruits {
	String variety;

	Vegetables(String Name, int Price, int Quantity, int Weight, String variety) {
		super(Name, Price, Quantity, Weight);
		variety = "organic";
	}

	// Overriding Method
	void methodOverride() {
		System.out.println("INSIDE THE CLASS : VEGETABLES");
	}
}
//Inherited Class
class Stationery extends Items {
	String brand;
	
	Stationery(String Name, int Price, int Quantity,String brand){
		super(Name, Price, Quantity);
		brand="Nataraj";
	}
	//String Method
	void stringmethod(String brand){
		System.out.println(brand.charAt(4));
	}
	// Overriding Method
	void methodOverride() {
		System.out.println("INSIDE THE CLASS : STATIONERY");
	}
}
//Custom Exception
class NegativeException extends Exception {
	public NegativeException(String e) {
		super(e);
	}
}

public class ShoppingCart {

	public static void main(String[] args) throws NegativeException {
		Scanner scan = new Scanner(System.in);
		int Quantity = 3;
		Items item = null;
		int banana = 60, mango = 120, apple = 150;
		int tomato = 20, potato = 40, onion = 30;
		int choice = -1, choose = -1;

		shoppingCart callmenu = new shoppingCart();
		callmenu.askchoice();
		choose = scan.nextInt();
		if (choose == 1) {
			callmenu.menu();
			choice = scan.nextInt();
			if (choice == 1) {
				System.out.println("Enter the Quantity of Bananas");
				try {
					Quantity = scan.nextInt();
					if (Quantity < 0) {
						throw new NegativeException("e");
					}
				} catch (NegativeException e) {
					System.out.println("Negative Exception!!! Only Enter positive values");
					System.exit(0);
				}
				item = new Items("BANANA", banana, Quantity);
				item.display();
			} else if (choice == 2) {
				System.out.println("Enter the Quantity of Mangoes");
				try {
					Quantity = scan.nextInt();
					if (Quantity < 0) {
						throw new NegativeException("e");
					}
				} catch (NegativeException e) {
					System.out.println("Negative Exception!!! Only Enter positive values");
					System.exit(0);
				}
				item = new Items("MANGO", mango, Quantity);
				item.display();
			} else if (choice == 3) {
				System.out.println("Enter the Quantity of Apples");
				try {
					Quantity = scan.nextInt();
					if (Quantity < 0) {
						throw new NegativeException("e");
					}
				} catch (NegativeException e) {
					System.out.println("Negative Exception!!! Only Enter positive values");
					System.exit(0);
				}
				item = new Items("APPLE", apple, Quantity);
				item.display();
			} else {
				System.out.println("You have entered wrong choice!!!");
				System.exit(0);
			}
		}

		else if (choose == 2) {
			selectMenu call = new selectMenu();
			call.menu();
			choice = scan.nextInt();
			if (choice == 1) {
				System.out.println("Enter the Quantity of Tomatoes");
				try {
					Quantity = scan.nextInt();
					if (Quantity < 0) {
						throw new NegativeException("e");
					}
				} catch (NegativeException e) {
					System.out.println("Negative Exception!!! Only Enter positive values");
				}
				item = new Items("TOMATO", tomato, Quantity);
				item.display();
			} else if (choice == 2) {
				System.out.println("Enter the Quantity of Potatoes");
				try {
					Quantity = scan.nextInt();
					if (Quantity < 0) {
						throw new NegativeException("e");
					}
				} catch (NegativeException e) {
					System.out.println("Negative Exception!!! Only Enter positive values");
					System.exit(0);
				}
				item = new Items("POTATOES", potato, Quantity);
				item.display();
			} else if (choice == 3) {
				System.out.println("Enter the Quantity of Onions");
				try {
					Quantity = scan.nextInt();
					if (Quantity < 0) {
						throw new NegativeException("e");
					}
				} catch (NegativeException e) {
					System.out.println("Negative Exception!!! Only Enter positive values");
					System.exit(0);
				}
				item = new Items("ONION", onion, Quantity);
				item.display();
			} else {
				System.out.println("You have entered wrong choice!!!");
				System.exit(0);

			}
		}

		else {
			System.out.println("You have entered wrong choice!!!");
			System.exit(0);
		}
		System.out.println("Do you have Promo Code?  Y/N");
		// String y = scan.nextLine();
		String y = scan.next();
		if (y.equals("y") || y.equals("Y")) // String Function "equals"
		{
			try {
				System.out.println("Fetching Discount Coupons in ....");
				for (int i = 3; i > 0; i--) {
					System.out.print(i + "...");
					Thread.sleep(1000);
			}
			System.out.println();
			}
			catch (InterruptedException e) {
				System.out.println("Main thread interrupted.");
			}
			System.out.println("Available Promo: SKP20");
			System.out.println("Enter Promo Code");
			String promo = scan.next();

			item.discount(promo);
		} else if (y.equals("n") || y.equals("N")) {
			System.out.println("No discount applicable");
		} else {
			System.out.println("ERROR!!! INVALID CHOICE!!!");
		}
		shoppingCart ob = new shoppingCart();
		ob.sayThanks();
		scan.close();
	}

}
