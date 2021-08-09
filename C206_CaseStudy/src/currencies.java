
public class currencies {

	private String currencies;
	private double sellRate;
	private double buyRate;

	public currencies(String currencies, double sellRate, double buyRate) {
		this.currencies = currencies;
		this.sellRate = sellRate;
		this.buyRate = buyRate;
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

	public String getCurrencies() {
		return currencies;
	}

}
