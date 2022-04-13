package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class swiggyHomepage {
	
	public swiggyHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='location']")
	private WebElement deliveryLocationSearchBox;
	
	@FindBy(xpath = "//span[contains(text(),'FIND FOOD')]")
	private WebElement findFoodButton;
	
	@FindBy(xpath = "//div[contains(text(),'Clear')]/following-sibling::div//span[2]")
	private WebElement firstAreaSuggestion;
	
	public void enterAreaCode(String areaCode,WebDriver driver) {
		deliveryLocationSearchBox.sendKeys(areaCode);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement firstAreaSuggestion1 = wait.until(ExpectedConditions.visibilityOf(firstAreaSuggestion));
		firstAreaSuggestion1.click();
	}

}
