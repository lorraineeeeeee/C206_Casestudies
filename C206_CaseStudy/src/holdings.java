import java.util.Date;

public class holdings extends currencies {
	
	private String companyHoldings;

	public holdings(String currencies, double sellRate, double buyRate, String companyHoldings) {
		super(currencies, sellRate, buyRate);
		this.companyHoldings = companyHoldings;
	}

	public String getCompanyHoldings() {
		return companyHoldings;
	}
	
	

}
