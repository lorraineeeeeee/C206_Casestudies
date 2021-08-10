
import java.util.Date;




public class holdings extends currencies {
	

	private double companyHoldings;

	public holdings(String currencies, double sellRate, double buyRate, String companyHoldings) {
		super(currencies, sellRate, buyRate);

	public holdings(String currencies, double companyHoldings) {
		super(currencies, sellRate,Buyrate);
		this.companyHoldings = companyHoldings;
	}

	public double getCompanyHoldings() {
		return companyHoldings;
	}
}
