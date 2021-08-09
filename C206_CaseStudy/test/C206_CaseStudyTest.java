import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private holdings c1;
	private holdings c2;
	private ArrayList<holdings> currencyList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {

		c1 = new holdings("USD", 100000.00);
		c2 = new holdings("AUD", 253400.00);

		currencyList = new ArrayList<holdings>();
	}

	@After
	public void tearDown() throws Exception {

		currencyList = null;
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
		
		//Test that the button "View All Currencies Holding Records" is able to be clicked.
		String allHolding = C206_CaseStudy.retrieveCurrencyHolding(currencyList);
		String testOutput = String.format("%-10s %-30.2f\n", "USD", 100000.00);
		testOutput += String.format("%-10s %-30.2f\n", "AUD", 253400.00);
		assertEquals("Test that ViewHoldings",testOutput,allHolding);
	}

	@Test
	public void deleteHoldingsTest() {
		
		//
		//Test that when a holding is deleted, the holdings do not show under the list of available holdings.
		C206_CaseStudy.deleteCurrencyHolding(currencyList);
		assertNotEquals("Test that holdings arraylist size is 2", 2, currencyList.size());
		
		//Test that when a holding is deleted, all of their related fields will also be deleted from the system.
		C206_CaseStudy.deleteCurrencyHolding(currencyList);
		assertNull("Test if other fields are null",currencyList);
		
		//Test that the deleted holdings is not stored in the system after being deleted.
		assertNull("Test if other fields are null",currencyList);
		

	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);

	}

}
