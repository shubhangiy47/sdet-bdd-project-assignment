package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.searchResturant;
import PageObjects.swiggyHomepage;
import PageObjects.addItem;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
//import cucumber.api.java.en.*;

public class searchResturantsStepDef {
	WebDriver driver;
	swiggyHomepage swiggyHomepage ;
	searchResturant searchResturant;
	addItem addItem;

	@Given("^I want to go to swiggy web application$")
	public void i_want_to_go_to_swiggy_web_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.swiggy.com/");
	}

	@When("I want to enter pincode {string} in area,street or pincode in area section and select the option from suggested list")
	public void i_want_to_enter_pincode_in_area_street_or_pincode_in_area_section(String pincode) throws Throwable {
		swiggyHomepage = new swiggyHomepage(driver);
		swiggyHomepage.enterAreaCode(pincode,driver);;
	}
	
	@When("Click on Search button on next page and enter resturant name {string} in search field")
	public void click_on_search_button_on_next_page(String resturantName) {
	   searchResturant = new searchResturant(driver);
	   searchResturant.selectResturant(resturantName,driver);
	}

	@Then("Select the resturant {string} from the displayed options")
	public void select_the_resturant_from_the_displayed_options(String resturantName) throws Throwable {
		//searchResturant = new searchResturant(driver);
		searchResturant.selectResturantFromSuggestions(resturantName,driver);
	    
	}
	@Then("Add items from the resturant")
	public void add_items_from_the_resturant(DataTable data) {
		addItem = new addItem(driver);
		addItem.selectItem(data, driver);
	}

	@Then("remove items")
	public void remove_items(DataTable removeFoodItemdata) {
		addItem.removeItem(removeFoodItemdata, driver);
	}

	@Then("check pricing")
	public void check_pricing() throws InterruptedException {
		addItem.getPricingOfItem(driver);
		
	}

	
}
