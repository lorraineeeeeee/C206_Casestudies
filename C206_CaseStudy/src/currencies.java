import java.util.Date;

public class currencies {

	private String currencies;
	private double sellRate;
	private double buyRate;
	private Date dateOfTransaction;

	public currencies(String currencies) {
		this.currencies = currencies;

	}

	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	public double getSellRate() {
		return sellRate;
	}

	public void setSellRate(double sellRate) {
		this.sellRate = sellRate;
	}

	public double getBuyRate() {
		return buyRate;
	}

	public void setBuyRate(double buyRate) {
		this.buyRate = buyRate;
	}

	public void setCurrencies(String currencies) {
		this.currencies = currencies;
	}

	public String getCurrencies() {
		return currencies;
	}

}
