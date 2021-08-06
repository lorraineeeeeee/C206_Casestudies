import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<currencies> currenciesList = new ArrayList<currencies>();
		ArrayList<holdings> holdingList = new ArrayList<holdings>();

		int option = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.viewAllCurrencies(currenciesList);
				C206_CaseStudy.viewAllholdings(holdingList);

			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");
				itemTypeMenu();

				int itemType = Helper.readInt("Enter option to select what you want to add on to > ");

				if (itemType == 1) {
					// Add a currencies
					currencies c = inputCurrencies();
					C206_CaseStudy.addCurrencies(currenciesList, c);

				} else if (itemType == 2) {
					// Add holdings
					holdings h = inputHoldings();
					C206_CaseStudy.addholdings(holdingList, h);

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// delete item
				C206_CaseStudy.setHeader("Delete");
				itemTypeMenu();

				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Delete camcorder
					C206_CaseStudy.deleteCurrencies(currenciesList);
				} else if (itemType == 2) {
					// Loan Chromebook
					C206_CaseStudy.deleteHoldings(holdingList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == OPTION_QUIT) {
				// Return item
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}


	private static void itemTypeMenu() {
		C206_CaseStudy.setHeader("ITEM TYPES");
		System.out.println("1. currencies");
		System.out.println("2. holdings");
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Currency exchange ");
		System.out.println("1. View Currencies and holdings");
		System.out.println("2. Add Currencies and holdings");
		System.out.println("3. Delete Currencies and holdings");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	private static void viewAllholdings(ArrayList<holdings> holdingList) {// yingnan
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("view holdings");

	}

	private static void viewAllCurrencies(ArrayList<currencies> currenciesList) {// haziqah 
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("view currencies");

	}

	private static currencies inputCurrencies() { // Haziqah
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("add currencies");
	}

	private static void addCurrencies(ArrayList<currencies> currenciesList, currencies c) { // haziqah
		// TODO Auto-generated method stub

	}

	private static holdings inputHoldings() { // yingnan
		// TODO Auto-generated method stub
	}

	private static void addholdings(ArrayList<holdings> holdingList, holdings h) { // yingnan
		// TODO Auto-generated method stub

	}
	private static void deleteHoldings(ArrayList<holdings> holdingList) { //yingnan
		// TODO Auto-generated method stub
		
	}

	private static void deleteCurrencies(ArrayList<currencies> currenciesList) { //haziqah
		// TODO Auto-generated method stub

	}
	
	public static String searchRate(ArrayList<currencies> currenciesList) { //yunqian
		
		String currencySearch = Helper.readString("Enter a currency to search > ");
		
		C206_CaseStudy.setHeader(currencySearch.toUpperCase());
		String output = "";
		
		for (int i = 0; i < currenciesList.size(); i++) {
		
			if (currencySearch.equals(currenciesList.get(i).getCurrencies())) {
				output += "BUY RATE: " + currenciesList.get(i).getBuyRate();
				output += "SELL RATE: " + currenciesList.get(i).getSellRate();
			}
		}
		
		return output;
	}
	
	public static double currencyCal(ArrayList<currencies> currenciesList) { //yunqian
		
		C206_CaseStudy.setHeader("CURRENCY CALCULATOR");
		C206_CaseStudy.viewAllCurrencies(currenciesList);
		String currencyConvert = Helper.readString("Choose a currency you want to calculate > ");
		String rateType = Helper.readString("Choose type of rate you want to convert (BUY/SELL) > ");
		double amount = Helper.readDouble("Enter an amount to convert");
		double convertedAmt = 0.0;
		
		if (rateType.equalsIgnoreCase("buy")) {
			for (currencies cl:currenciesList) {
				if (cl.getCurrencies().equals(currencyConvert.toLowerCase())) {
					convertedAmt = amount*cl.getBuyRate();
				}
			}
		}
		else if (rateType.equalsIgnoreCase("sell")) {
			for (currencies cl:currenciesList) {
				if (cl.getCurrencies().equals(currencyConvert.toLowerCase())) {
					convertedAmt = amount*cl.getSellRate();
				}
			}
		}
		else {
			System.out.println("Invalid type");
		}
		
		return convertedAmt;
	}

}
