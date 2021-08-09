
public class holdings extends currency {

	private double companyHoldings;

	public holdings(String currencies, double companyHoldings) {
		super(currencies);
		this.companyHoldings = companyHoldings;
	}

	public double getCompanyHoldings() {
		return companyHoldings;
	}

}
