package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class CommandePage {
	
	private WebDriver webdriver;
	public static String name = "";
	public static String phonenumber ="";
	public static String pizza = "";
	
	public CommandePage(WebDriver webdriver){
		this.webdriver = webdriver;
	}
	
	public CommandePage openCommandePage() {
		webdriver.navigate().to("http://localhost:8080/pizza-spring/commande");
		assertTrue(webdriver.getTitle().startsWith("Pizza Spring"));
		return this;
	}
	
	public static CommandePage openWith(WebDriver webDriver) {
		CommandePage commandePage = new CommandePage(webDriver);
		commandePage.openCommandePage();
		return commandePage;
	}

	public CommandePage setName (String... words) {
		WebElement input = webdriver.findElement(By.id("nom"));
		input.sendKeys(String.join(" ", words));
		name = String.join(" ", words);
		System.out.println(name);
		return this;
	}
	

	public CommandePage setPhoneNumber (String phone_number) {
		WebElement input = webdriver.findElement(By.id("telephone"));
		input.sendKeys(phone_number);
		phonenumber = phone_number;
		return this;
	}
	
	public CommandePage SelectPizzas(String pizza) throws Exception {
		WebElement select = webdriver.findElement(By.id("pizzaId"));
        Select selectPizzas = new Select(select);
        selectPizzas.deselectByVisibleText(pizza);   
		return this;
	}
	
	public void clickOnCommander() {
		WebElement submit_button = webdriver.findElement(By.cssSelector("button"));
		submit_button.click();
	}
	public boolean is_phoneInvalid() throws Exception {
		WebElement label = webdriver.findElement(By.id("telephone.errors"));
		return label.isDisplayed();
	}
	public boolean is_pizzaInvalid() throws Exception {
		WebElement label = webdriver.findElement(By.id("pizzaId.errors"));
		return label.isDisplayed();
	}
	
	public CommandePage doNotSelectPizza() {
		WebElement select = webdriver.findElement(By.id("pizzaId"));
        Select selectPizzas = new Select(select);
        selectPizzas.deselectAll();
        return this;
	}
	
}
