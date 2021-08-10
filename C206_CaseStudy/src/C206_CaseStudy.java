import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<holdings> currencyList = new ArrayList<holdings>();

		holdings c1 = new holdings("USD", 100000.00);
		holdings c2 = new holdings("AUD", 253400.00);

		currencyList.add(c1);
		currencyList.add(c2);

		int option = 0;

		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				C206_CaseStudy.viewCurrencyHolding(currencyList);

			} else if (option == 2) {
				C206_CaseStudy.addCurrencyHolding(currencyList);

			} else if (option == 3) {
				C206_CaseStudy.deleteCurrencyHolding(currencyList);
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
		System.out.println("4. Quit");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static holdings inputHolding() {
		String currency = Helper.readString("Enter currency > ");
		double amount = Helper.readDouble("Enter the amount > ");

		holdings hd = new holdings(currency, amount);
		return hd;

	}

	public static void addCurrencyHolding(ArrayList<holdings> currencyList) {

		currencyList.add(inputHolding());
		System.out.println("Currency of holding added");
	}

	public static void deleteCurrencyHolding(ArrayList<holdings> currencyList) {
		currencyList.remove(inputHolding());
		System.out.println("Currency of holding deleted");
	}

	public static String retrieveCurrencyHolding(ArrayList<holdings> currencyList) {
		String output = "";
		for (int i = 0; i < currencyList.size(); i++) {

			output += String.format("%-10s %-10.2f \n", currencyList.get(i).getCurrencies(),
					currencyList.get(i).getCompanyHoldings());
		}
		return output;
	}

	public static void viewCurrencyHolding(ArrayList<holdings> currencyList) {
		C206_CaseStudy.setHeader("CURRENCY LIST");
		String output = String.format("%-10s %-10s \n", "CURRENCY", "CURRENCY HOLDINGS");
		output += retrieveCurrencyHolding(currencyList);
		System.out.println(output);
	}

	ArrayList<holdings> holdingList = new ArrayList<holdings>();

	currenciesList.add(new currencies("SGD",3.5,4.0));currenciesList.add(new currencies("THB",2.0,5.0));holdingList.add(new holdings("SGD",3.5,4.0,"SINGAPORE POOL"));holdingList.add(new holdings("THB",2.0,5.0,"Comfort DELGRO"));

	int option = 0;

	private static void itemTypeMenu() {
		C206_CaseStudy.setHeader("ITEM TYPES");
		System.out.println("1. currencies");
		System.out.println("2. holdings");
	}

	public static boolean doDeleteCurrency(ArrayList<currencies> currenciesList, String currencies) {
		boolean isDeleted = false;

		for (int i = 0; i < currenciesList.size(); i++) {
			if (currencies.equalsIgnoreCase(currenciesList.get(i).getCurrencies())) {
				isDeleted = true;
			}
		}
		return isDeleted;
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
}=======

>>>>>>>branch'master'

of https:
// github.com/lorraineeeeeee/C206_Casestudies.git
