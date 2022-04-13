package PageObjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchResturant {
	
	public searchResturant(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Search')]")
	private WebElement searchButton;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement resturantSearchBox;
	
	@FindBy(xpath = "(//input[@type='text']/../following-sibling::div/div/div/div[2])[1]")
	private WebElement firstReturantSuggestion;
	

	public WebDriverWait wait ;
	public void selectResturant(String resturantName,WebDriver driver) {
		wait = new WebDriverWait(driver, 20);
		WebElement searchButton1 = wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton1.click();
		//resturantSearchBox.clear();
		WebElement resturantSearchBox1 = wait.until(ExpectedConditions.visibilityOf(resturantSearchBox));
		resturantSearchBox1.sendKeys(resturantName);
		WebElement firstReturantSuggestion1 = wait.until(ExpectedConditions.visibilityOf(firstReturantSuggestion));
		firstReturantSuggestion1.click();
		
	}
	
	public void selectResturantFromSuggestions(String resturantName,WebDriver driver) throws InterruptedException
	{
		boolean flag=false;
		wait = new WebDriverWait(driver, 50);
		By selectResturantIcon = By.xpath("//div[contains(text(),'"+resturantName+"')]");
		WebElement selectResturantIcon1 = wait.until(ExpectedConditions.presenceOfElementLocated(selectResturantIcon));
		//By res;
		flag=selectResturantIcon1.isDisplayed();
		assertTrue("Resturant not available",flag);
		selectResturantIcon1.click();
	}

}
