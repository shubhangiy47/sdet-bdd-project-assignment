package PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

public class addItem {
	
	public addItem(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebDriverWait wait;
	public void selectItem(DataTable foodItem,WebDriver driver)
	{
		wait = new WebDriverWait(driver, 20);
		List<String> addfoodItems = foodItem.asList(String.class);
		for (String s: addfoodItems) 
		{
			By selectFoodItem = By.xpath("//h3[contains(text(),'"+s+"')]/../../following-sibling::div//div[contains(text(),'ADD')]");
			WebElement selectFoodItem1 = wait.until(ExpectedConditions.presenceOfElementLocated(selectFoodItem));
			selectFoodItem1.click();
		}    
	}
	public void removeItem(DataTable foodItem,WebDriver driver)
	{
		List<String> removefoodItem = foodItem.asList(String.class);
		for (String s: removefoodItem) 
		{
			By removeFoodItem = By.xpath("//div[contains(text(),'"+s+"')]/../following-sibling::div/div/div/div[3]");
			WebElement removeFoodItem1 = wait.until(ExpectedConditions.presenceOfElementLocated(removeFoodItem));
			removeFoodItem1.click();
		}    
	}
	public void getPricingOfItem(WebDriver driver) throws InterruptedException
	{
		wait =new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		List<WebElement> pricingList = driver.findElements(By.xpath("(//div[contains(text(),'Cart')]/following-sibling::div/div[2]/div//div[contains(text(),'+')]/../following-sibling::div/span)"));
		//System.out.println(pricingList.size());
		int i=0;
		System.out.println("Prices of items in cart are as below");
		while (i < pricingList.size()) 
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String price=pricingList.get(i).getText();
			System.out.println(price);
            i++;
		}
	}
}
