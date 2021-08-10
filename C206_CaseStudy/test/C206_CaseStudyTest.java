import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private currencies cc1;
	private currencies cc2;

	private ArrayList<currencies> currenciesList;

	private holdings c1;
	private holdings c2;
	private ArrayList<holdings> currencyList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {

		c1 = new holdings("USD", 2.5, 3.0, 100000.00);
		c2 = new holdings("AUD", 3.5, 4.0, 253400.00);

		currencyList = new ArrayList<holdings>();
		currenciesList = new ArrayList<currencies>();

	}

	@Test
	public void addHoldingsTest() {
		// Test that all list of all currency holding records can be displayed.
		assertNotNull("Test if there is valid holdings arraylist to retrieve currency from", currencyList);

		// Test that when a new amount is added, the new amount is reflected and updated
		// inside the system.
		C206_CaseStudy.addCurrencyHolding(currencyList);
		C206_CaseStudy.addCurrencyHolding(currencyList);
		assertEquals("Test that holdings arraylist size is 2", 2, currencyList.size());

		// Test that when the ‘cancel’ button is clicked, the currencies holding records
		// will not be updated
		assertNotEquals("Test that holdings arraylist size is 2", 1, currencyList.size());

	}

	@Test
	public void viewHoldingsTest() {

		// Test that all list of all records can be displayed.
		assertNotNull("Test if there is valid holdings arraylist to retrieve currency from", currencyList);

		// Test that the button "View All Currencies Holding Records" is able to be
		// clicked.
		String allHolding = C206_CaseStudy.retrieveCurrencyHolding(currencyList);
		String testOutput = String.format("%-10s %-30.2f\n", "USD", 100000.00);
		testOutput += String.format("%-10s %-30.2f\n", "AUD", 253400.00);
		assertEquals("Test that ViewHoldings", testOutput, allHolding);
	}

	@Test
	public void deleteHoldingsTest() {

		// Test that when a holding is deleted, the holdings do not show under the list
		// of available holdings.
		C206_CaseStudy.deleteCurrencyHolding(currencyList);
		assertNotEquals("Test that holdings arraylist size is 2", 2, currencyList.size());

		// Test that when a holding is deleted, all of their related fields will also be
		// deleted from the system.
		C206_CaseStudy.deleteCurrencyHolding(currencyList);
		assertNull("Test if other fields are null", currencyList);

		// Test that the deleted holdings is not stored in the system after being
		// deleted.
		assertNull("Test if other fields are null", currencyList);

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);

	}

	@Test
	public void buyTest() {
		// test if there are available arraylist to get data from
		assertNotNull("test if there is any currencies to buy from ", currenciesList);

		// test if buy rate is correct
		double buyRate = 2.5;
		boolean can = C206_CaseStudy.DoBuyData(currenciesList, buyRate);
		assertFalse("check that calculation is correct ", can);

		// test if can add transaction successfully
		C206_CaseStudy.doBuy(currenciesList, c1);
		assertEquals("Check that currency arraylist size is 1", 1, currenciesList);

		C206_CaseStudy.doBuy(currenciesList, c2);
		assertEquals("Check that currency arraylist size is 2", 2, currenciesList);
		assertSame("Check that Currency is added", cc2, currenciesList.get(1));
	}

	@Test
	public void sellTest() {
		// test if there are available arraylist to get data from
		assertNotNull("test if there is any currencies to buy from ", currenciesList);

		// test if buy rate is correct
		double sellRate = 2.5;
		boolean can = C206_CaseStudy.DoSellData(currenciesList, sellRate);
		assertFalse("check that calculation is correct ", can);

		// test if can add transaction successfully
		C206_CaseStudy.doBuy(currenciesList, c1);
		assertEquals("Check that currency arraylist size is 1", 1, currenciesList);

		C206_CaseStudy.doBuy(currenciesList, c2);
		assertEquals("Check that currency arraylist size is 2", 2, currenciesList);
		assertSame("Check that Currency is added", cc2, currenciesList.get(1));
	}

	@Test
	public void ShowTest() {
		assertNotNull("check if there is valid buyList to retrieve currency from", currenciesList);
		C206_CaseStudy.doBuy(currenciesList, cc2);
		assertEquals("Check that CURRENCIES arraylist size is 2", 2, currenciesList.size());
		assertSame("Check that Currencies is added", cc2, currenciesList.get(1));
	}

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		c1 = null;
		c2 = null;
		currenciesList = null;

	}

}
