package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzaSpringPasserUneCommanderAcceptanceTest {
		
	private WebDriver webdriver;
	@Before
	public void creatWebDriver() {
		webdriver = new ChromeDriver();
	}
	
	@After
	public void closeWebDriver() {
		webdriver.quit();
	}
	
	@Test
	public void OrderCommandeSuccessufully() throws Exception {
		RecapPage recapPage = new RecapPage(webdriver);
		CommandePage.openWith(webdriver)
							.SelectPizzas("Margherita")
							.SelectPizzas("Regina")
							.setName("EL OUARDI Abdelilah")
							.setPhoneNumber("0658749702")
							.clickOnCommander();
		assertTrue(recapPage.isPizzaPresent() && recapPage.isPhoneNumberPresent());
	}
	
	@Test
	public void OrderCommandeWithoutPhoneNumber() throws Exception{
		CommandePage commandePage = new CommandePage(webdriver);
		CommandePage.openWith(webdriver)
					.openCommandePage()
					.SelectPizzas("Regina")
					.setName("I'm not giving you my phone number")
					.setPhoneNumber("")
					.clickOnCommander();
		assertTrue(commandePage.is_phoneInvalid());;
	}
	
	@Test
	public void OrderCommandeWithoutPizza() throws Exception{
		CommandePage commandePage = new CommandePage(webdriver);
		CommandePage.openWith(webdriver)
					.openCommandePage()
					.doNotSelectPizza()
					.setName("I don't know which pizza I want")
					.setPhoneNumber("0658749702")
					.clickOnCommander();
		assertTrue(commandePage.is_pizzaInvalid());;
	}
	
}
