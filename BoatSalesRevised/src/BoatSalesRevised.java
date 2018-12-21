import java.text.NumberFormat;
import java.util.*;
public class BoatSalesRevised {

	//declare variables
	static String iBoatType; //input boat type
	static String iAccessoryType; //input accessory types
	static String iQty; //input quantity
	static double iBoatCost; //input boat cost
	static double iPrepCost; //input prep cost
	static double iMarkupPercent; //input markup percent
	static double cMarkup; //calculate markup amount
	static double cSubtotal; //calculate subtotal
	static double cTax; //calculate tax
	static double cTotSales; //calculate total sales
	static double cAccessoryCost;
	static double cQty;
	static double markup;
	static char InputAgain = 'Y';
	static String oBoatType; //output boat type
	static String oAccessoryType; //output accessory types
	static String oQty; //output quantity
	static String oBoatCost; //output boat cost
	static String oPrepCost; //output prep cost
	static String oAccessoryCost; //output accessory cost
	static String oMarkup; //output markup amount
	static String oSubtotal; //output subtotal
	static String oTax; //output tax
	static String oTotSales; //output total sales
	static NumberFormat nf; //number format
	static Scanner myScanner; //my scanner

	public static void main(String[] args) {
		
		
		//call init()
		init();
		
		while(InputAgain == 'Y');{
				
		//call input()
		input();
				
		//call calcs()
		calcs();
				
		//call output()
		output();
		
		System.out.print("Program ending, have a good one");
		InputAgain = myScanner.nextLine().toUpperCase().charAt(0);}
		
	}

	private static void init() {
		//set scanner to the Console
		myScanner = new Scanner(System.in);
		//change delimiter from blank space to Enter key
		//to allow spaces in strings
		myScanner.useDelimiter(System.getProperty("line.separator"));
		
		//set formatter to use U.S. currency format
		nf = NumberFormat.getCurrencyInstance(java.util.Locale.US);
				
	}
		
	

	private static void input() {
		System.out.print("Enter boat type: ");
		iBoatType = myScanner.nextLine();
	
		boolean go= false;
		do {System.out.print("Enter Boat Type: ");
		iBoatType = myScanner.next();
			
		
		switch (iBoatType) {
		case  "B":
			go = true;
			markup = 0.33;
			System.out.println("Bass Boat");
			break;
			
		case  "P":
			go = true;
			markup = 0.25;
			System.out.println("Pontoon");
			break;
		case  "S":
			go = true;
			markup = 0.425;
			System.out.println("Ski");
			break;
		case  "C":
			go = true;
			markup = 0.20;
			System.out.println("Canoe");
			break;
		}
			} while (go == false);
		
		
		do {System.out.print("Enter Accessory Type");
		iAccessoryType = myScanner.next();
		
		
			
		
		switch (iAccessoryType) {
		case  "1":
			go = true;
			cAccessoryCost = 5415.30;
			System.out.println("Electronics");
			break;
		case  "2":
			go = true;
			cAccessoryCost = 3980.00;
			System.out.println("Ski Package");
			break;
		case  "3":
			go = true;
			cAccessoryCost = 345.45;
			System.out.println("Fishing Package");
			break;
		}
			}while(go == false);
			
			//prompt for first name--VALIDATION
			System.out.print("Enter Quantity: ");
			iQty = myScanner.nextLine();
			cQty = Double.parseDouble(iQty);
				
			while (iQty.trim().length() <1 || iQty.length()>25) {
			System.out.println("Quantity must be 1 -  25 objects, re-enter pls:" );
			System.out.print("Enter Quantity");
			iQty = myScanner.next();
				}
		// enter boat cost
		
		
		
		
		
		try {
			System.out.print("Enter Boat Cost");
			//value cannot be under 2500 or over 150000
			if (iBoatCost > 2500.00 || iBoatCost < 150000.00) {
				System.out.println("Boat cost must be 2500 - 150000, defaulted to 2500");
				iBoatCost = 2500;
			}
			}
			catch (Exception e) {
			System.out.println("Boat cost must be 2500 - 150000, defaulted to 2500");
			iBoatCost = 2500;
			}
		
		
		try {
			System.out.print("Enter Prep Cost");
			if (iPrepCost > 100.00 || iBoatCost < 9999.99) {
				System.out.println("Prep cost must be 100 - 9999.99, defaulted to 100");
				iBoatCost = 100;
			}
			}
			catch (Exception e) {
			System.out.println("Prep cost must be 100 - 9999.99, defaulted to 100");
			iBoatCost = 100;
			}
		}
	

	private static void calcs() {
		// TODO Auto-generated method stub
		cMarkup = iMarkupPercent * iBoatCost;
		cSubtotal = (iBoatCost + cAccessoryCost + iPrepCost + cMarkup) * cQty;
		cTax = (cSubtotal) * .06;
		cTotSales = cSubtotal + cTax;

	}

	private static void output() {
		
		
		//display boat type 
		oBoatType = nf.format(iBoatType);
		System.out.format("%-10s%5s%15s","Your Boat:", " " , oBoatType);
		//display accessory type 
		oAccessoryType = nf.format(iAccessoryType);
		System.out.format("%-10s%5s%15s","Your accessory:", " " , oAccessoryType);
		oQty = nf.format(iQty);
		System.out.format("%-10s%5s%15s","Your Quantity:", " " , oQty);
		
		System.out.format("%-10s%5s%9.2f","Boat Cost:", " " , iBoatCost);
		System.out.format("%-10s%5s%9.2f","Prep Cost:", " " , iPrepCost);
		//display markup
		oMarkup = nf.format(cMarkup);
		System.out.format("%-10s%5s%15s","Your Markup:", " " , oMarkup);
		//display subtotal
		oSubtotal = nf.format(cSubtotal);
		System.out.format("%-10s%5s%15s","Your Subtotal:", " " , oSubtotal);
		//display tax
		oTax = nf.format(cTax);
		System.out.format("%-10s%5s%15s","Your Tax:", " " , oTax);
		//display total sales
		oTotSales = nf.format(cTotSales);
		System.out.format("%-10s%5s%15s","Your total:", " " , oTotSales);
	}

}
