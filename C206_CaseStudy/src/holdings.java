
public class holdings extends currencies {

	private double companyHoldings;

	public holdings(String currencies, double buyRate, double sellRate, double companyHoldings) {
		super(currencies, buyRate, sellRate);
		this.companyHoldings = companyHoldings;
	}

	public double getCompanyHoldings() {
		return companyHoldings;
	}
}
