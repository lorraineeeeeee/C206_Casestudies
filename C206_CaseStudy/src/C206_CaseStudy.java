import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<currencies> currenciesList = new ArrayList<currencies>();
		ArrayList<holdings> holdingList = new ArrayList<holdings>();

		currenciesList.add(new currencies("SGD", 3.5, 4.0));
		currenciesList.add(new currencies("THB", 2.0, 5.0));
		holdingList.add(new holdings("SGD", 3.5, 4.0, "SINGAPORE POOL"));
		holdingList.add(new holdings("THB", 2.0, 5.0, "Comfort DELGRO"));

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

	private static void deleteHoldings(ArrayList<holdings> holdingList) { // yingnan
		// TODO Auto-generated method stub

	}

	private static void deleteCurrencies(ArrayList<currencies> currenciesList) { // haziqah
		// TODO Auto-generated method stub

	}

	public static void doBuy(ArrayList<currencies> currenciesList, currencies cc) {
		double money = Helper.readDouble("please enter the amount of money you want to exchange for");
		for (int i = 0; i < currenciesList.size(); i++) {
			if (currenciesList.get(i).getBuyRate() != 0.0) {
				double calculate = currenciesList.get(i).getBuyRate() * money;
				String currency = Helper.readString("please enter your currency > ");

				System.out.println("you would receive " + calculate + currency);
			}
			currenciesList.add(cc);
		}

	}

	public static boolean DoBuyData(ArrayList<currencies> currenciesList, double buy) {
		boolean isLoaned = false;

		for (int i = 0; i < currenciesList.size(); i++) {
			double buyrate = currenciesList.get(i).getBuyRate();

			if (buy == buyrate) {

				isLoaned = true;

			}
		}
		return isLoaned;

	}

	public static void doSell(ArrayList<currencies> currenciesList) {

		double AMT_OUT = Helper.readDouble("please enter the amount you want to buy from me > ");
		for (int i = 0; i < currenciesList.size(); i++) {
			if (currenciesList.get(i).getSellRate() != 0.0) {
				double calculate = currenciesList.get(i).getSellRate() * AMT_OUT;
				String currency = Helper.readString("please enter your currency > ");
				System.out.println("you are selling $" + calculate + currency);
			}
		}

	}

	public static void viewAllTransaction(ArrayList<currencies> currenciesList, LocalDate date) {
		int input = Helper.readInt("please input how many weeks of data you want > ");
		if (input == 1 || input == 2 || input == 3) {
			for (int i = 0; i < currenciesList.size(); i++) {
				System.out.println(currenciesList.get(i).getDateOfTransaction() + currenciesList.get(i).getCurrencies()
						+ currenciesList.get(i).getBuyRate());
			}

		} else {
			System.out.println("no such transaction");
		}
	}
}
