import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private currencies cc1;
	private currencies cc2;
	private holdings cb1;
	private holdings cb2;

	private ArrayList<currencies> currenciesList;

	public C206_CaseStudyTest() {
		super();

	}

	@Before
	public void setUp() throws Exception {
		// prepare test data

		currenciesList = new ArrayList<currencies>();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void buyTest() {
		//test if there are available arraylist to get data from
		assertNotNull("test if there is any currencies to buy from ", currenciesList);

		// test if buy rate is correct
		double buyRate = 2.5;
		boolean can = C206_CaseStudy.DoBuyData(currenciesList, buyRate);
		assertFalse("check that calculation is correct ", can);
		
		// test if can add transaction successfully
		C206_CaseStudy.doBuy(currenciesList, cc1);
		assertEquals("Check that currency arraylist size is 1", 1, currenciesList);
		assertSame("Check that currency is added", cc1, currenciesList.get(0));

		C206_CaseStudy.doBuy(currenciesList, cc2);
		assertEquals("Check that currency arraylist size is 2", 2, currenciesList);
		assertSame("Check that Currency is added", cc2, currenciesList.get(1));
	}

	@Test
	public void sellTest() {
		assertNotNull("test if there are any currencies to sell", currenciesList);
		C206_CaseStudy.doSell(currenciesList);
		double calculation = 0.0;
		assertEquals("check that calculation is correct ", currenciesList, calculation);

		assertNotNull("check that system can display amount", currenciesList);
	}

	@Test
	public void ShowTest() {
		assertNotNull("check if there is valid buyList to retrieve currency from", currenciesList);
		C206_CaseStudy.doBuy(currenciesList, cc2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, currenciesList.size());
		assertSame("Check that Camcorder is added", cc2, currenciesList.get(1));
	}

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		currenciesList = null;
	}

}
