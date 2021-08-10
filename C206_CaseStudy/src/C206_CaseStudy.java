import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 7;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<holdings> holdingList = new ArrayList<holdings>();
		ArrayList<currencies> currenciesList = new ArrayList<currencies>();

		holdings c1 = new holdings("USD", 2.5, 3.0, 100000.00);
		holdings c2 = new holdings("AUD", 3.0, 4.0, 253400.00);

		currencies c3 = new currencies("USD", 2.5, 3.0);
		currencies c4 = new currencies("AUD", 3.0, 4.0);

		holdingList.add(c1);
		holdingList.add(c2);

		currenciesList.add(c3);
		currenciesList.add(c4);

		int option = 0;

		while (option != OPTION_QUIT) {

			menu();

			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.viewCurrencyHolding(holdingList);

			} else if (option == 2) {
				C206_CaseStudy.addCurrencyHolding(holdingList);

			} else if (option == 3) {
				C206_CaseStudy.deleteCurrencyHolding(holdingList);

			} else if (option == 4) {
				C206_CaseStudy.viewAllCurrencies(currenciesList);

			} else if (option == 5) {
				C206_CaseStudy.addCurrencies(currenciesList, c3);

			} else if (option == 6) {
				C206_CaseStudy.deleteCurrencies(currenciesList);

			} else if (option == OPTION_QUIT) {

				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("Currency exchange ");
		System.out.println("1. View Currencies Holding");
		System.out.println("2. Add Currencies Holding");
		System.out.println("3. Delete Currencies Holding");
		System.out.println("4 View currencies");
		System.out.println("5.add currencies");
		System.out.println("6. delete currencies");
		System.out.println("7. Quit");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static holdings inputHolding() {
		String currency = Helper.readString("Enter currency > ");
		double amount = Helper.readDouble("Enter the amount > ");
		double buyRate = 0.0;
		double sellRate = 0.0;

		holdings hd = new holdings(currency, buyRate, sellRate, amount);
		return hd;

	}

	public static void addCurrencyHolding(ArrayList<holdings> holdingList) {

		holdingList.add(inputHolding());
		System.out.println("Currency of holding added");
	}

	public static void deleteCurrencyHolding(ArrayList<holdings> holdingList) {
		holdingList.remove(inputHolding());
		System.out.println("Currency of holding deleted");
	}

	public static String retrieveCurrencyHolding(ArrayList<holdings> holdingList) {
		String output = "";
		for (int i = 0; i < holdingList.size(); i++) {

			output += String.format("%-10s %-10.2f \n", holdingList.get(i).getCurrencies(),
					holdingList.get(i).getCompanyHoldings());
		}
		return output;
	}

	public static void viewCurrencyHolding(ArrayList<holdings> holdingList) {
		C206_CaseStudy.setHeader("CURRENCY LIST");
		String output = String.format("%-10s %-10s \n", "CURRENCY", "CURRENCY HOLDINGS");
		output += retrieveCurrencyHolding(holdingList);
		System.out.println(output);
	}

	ArrayList<holdings> holdingList = new ArrayList<holdings>();

	int option = 0;

	public static String retrieveAllCurrencies(ArrayList<currencies> currenciesList) {// haziqah
		String output = "";

		for (int i = 0; i < currenciesList.size(); i++) {
			output += String.format("%-15s %-10s %-10s\n", currenciesList.get(i).getCurrencies(),
					currenciesList.get(i).getBuyRate(), currenciesList.get(i).getSellRate());
		}
		return output;
	}

	private static currencies inputCurrencies() { // haziqah
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("add currencies");
		String currency = Helper.readString("Enter new currency > ");
		double buyrate = Helper.readDouble("Enter new buy rate > ");
		double sellrate = Helper.readDouble("Enter new sell rate > ");

		currencies c = new currencies(currency, buyrate, sellrate);
		return c;
	}

	private static void addCurrencies(ArrayList<currencies> currenciesList, currencies c) { // haziqah
		// TODO Auto-generated method stub
		currenciesList.add(c);
		System.out.println("New currency added!");
	}

	private static void viewAllCurrencies(ArrayList<currencies> currenciesList) {// haziqah
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("view currencies");

		String output = String.format("%-15s %-10s %-10s\n", "CURRENCY", "BUY RATES", "SELL RATES");

		output += retrieveAllCurrencies(currenciesList);
		System.out.println(output);

	}

	public static boolean doDeleteCurrency(ArrayList<currencies> currenciesList, String currencies) { // haziqah
		boolean isDeleted = false;

		for (int i = 0; i < currenciesList.size(); i++) {
			if (currencies.equalsIgnoreCase(currenciesList.get(i).getCurrencies())) {
				isDeleted = true;
			}
		}
		return isDeleted;
	}

	private static void deleteCurrencies(ArrayList<currencies> currenciesList) { // haziqah
		// TODO Auto-generated method stub
		C206_CaseStudy.viewAllCurrencies(currenciesList);
		String currency = Helper.readString("Enter currency > ");
		Boolean isDeleted = doDeleteCurrency(currenciesList, currency);

		if (isDeleted == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println(currency + " is deleted");
		}
	}

	public static void doBuy(ArrayList<currencies> currenciesList, currencies cc2) {
		C206_CaseStudy.viewAllCurrencies(currenciesList);
		double money = Helper.readDouble("please enter the amount of money you want to exchange for");
		for (int i = 0; i < currenciesList.size(); i++) {
			if (currenciesList.get(i).getBuyRate() != 0.0) {
				double calculate = currenciesList.get(i).getBuyRate() * money;
				String currency = Helper.readString("please enter your currency > ");

				System.out.println("you would receive " + calculate + currency);
			}
			currenciesList.add(cc2);
		}

	}

	public static boolean DoBuyData(ArrayList<currencies> currencyList, double buy) {
		boolean isLoaned = false;

		for (int i = 0; i < currencyList.size(); i++) {
			double buyrate = currencyList.get(i).getBuyRate();

			if (buy == buyrate) {

				isLoaned = true;

			}
		}
		return isLoaned;

	}

	static boolean DoSellData(ArrayList<currencies> currencyList, double sell) {
		boolean isLoaned = false;
		for (int i = 0; i < currencyList.size(); i++) {
			double buyrate = currencyList.get(i).getBuyRate();

			if (sell == buyrate) {

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