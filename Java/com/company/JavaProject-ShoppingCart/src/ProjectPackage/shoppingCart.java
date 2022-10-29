package ProjectPackage;
interface inter{
	int getPrice(int price);//Interface With Variables
	default void sayThanks() //Default Method in Interface
	{
		System.out.println("Thank You For Shopping With Us....Visit Again");
	}
}
public class shoppingCart implements inter{

	int price=100;
	public void askchoice() {
		System.out.println("--------WELCOME--------");
		System.out.println("We have fresh Fruits and Vegetables for you");
		System.out.println("Please Enter Your Option");
		System.out.println("1.FRUITS");
		System.out.println("2.VEGETABLES");
		
	}
	public void menu() {
		int banana = 60, mango = 120, apple = 150;
		System.out.println("Enter your choice:");
		System.out.println("1.BANANA ->" + " 1KG Banana is RS." + banana);
		System.out.println("2.MANGO  ->" + " 1KG Mango  is RS." + mango);
		System.out.println("3.APPLE  ->" + " 1KG Apple  is RS." + apple);
	}
	public int getPrice(int price) {
		return price;
	}
}
