import java.util.ArrayList;

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
        String output = String.format("%-10s %-10s \n", "CURRENCY",
                "CURRENCY HOLDINGS");
        output += retrieveCurrencyHolding(currencyList);
        System.out.println(output);
    }

}
