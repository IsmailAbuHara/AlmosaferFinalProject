package homePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestcases {

	WebDriver driver = new ChromeDriver();

	String Almosafer = "Https://www.almosafer.com/en";

	String ExpectedDefaultLange = "en";

	@BeforeTest
	public void myTest() {

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(Almosafer);

		driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary")).click();

	}

	@Test(priority = 1)
	public void ExpectedDefaultLange() {

		String ActualLanguge = driver.findElement(By.tagName("html")).getAttribute("lang");

		Assert.assertEquals(ActualLanguge, ExpectedDefaultLange);

	}

	@Test(priority = 2)
	public void CheckdefaultCurrency() {

		String ExpectedCurrency = "SAR";

		WebElement Currency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"));

		String ActualCurrency = Currency.getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3)
	public void CheckContactNumber() {

		String ExpectedContactNumber = "+966554400000";

		String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();

		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
	}

	@Test(priority = 4)
	public void CheckQitagLogo() {
		
		boolean ExpectedResultsForTheLogo = true;
	
		WebElement theFooter = driver.findElement(By.tagName("footer"));

		WebElement logo = theFooter.findElement(By.cssSelector(".sc-fihHvN.eYrDjb")) .findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));

		boolean ActualResultForThelogo = logo.isDisplayed();

		Assert.assertEquals(ActualResultForThelogo, ExpectedResultsForTheLogo);
	}
	
	
}
