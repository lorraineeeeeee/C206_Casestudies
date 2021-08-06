
public class holdings extends currencies {
	
	private double companyHoldings;

	public holdings(String currencies, double sellRate, double buyRate, double companyHoldings) {
		super(currencies, sellRate, buyRate);
		this.companyHoldings = companyHoldings;
	}

	public double getCompanyHoldings() {
		return companyHoldings;
	}
	
	

}
