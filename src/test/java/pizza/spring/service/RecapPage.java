package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class RecapPage {
	
	WebDriver webdriver;
	public RecapPage(WebDriver webdriver) {
		this.webdriver = webdriver;

	}
	
	public boolean isNamePresent() {
		System.out.println("Recap name:"+ CommandePage.name);
		return webdriver.getPageSource().contains(CommandePage.name);
		
	}
	public boolean isPizzaPresent() {
		return webdriver.getPageSource().contains(CommandePage.phonenumber);
	}
	public boolean isPhoneNumberPresent() {
		return webdriver.getPageSource().contains(CommandePage.phonenumber);
	}
}
