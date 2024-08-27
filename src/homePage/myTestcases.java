package homePage;

//import java.time.Duration;
//import java.time.LocalDate;
import java.util.List;
//import java.util.Random;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestcases extends Parameters {

	@BeforeTest
	public void myTest() {

		GeneralSetup();
		WebElement GreenButton = driver
				.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		GreenButton.click();

	}

	@Test(priority = 1)
	public void ExpectedDefaultLange() {

		String ActualLanguge = driver.findElement(By.tagName("html")).getAttribute("lang");

		Assert.assertEquals(ActualLanguge, ExpectedDefaultLange);

	}

	@Test(priority = 2)
	public void CheckdefaultCurrency() {

		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(priority = 3)
	public void CheckContactNumber() {

		String ActualContactNumber = driver.findElement(By.tagName("strong")).getText();

		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
	}

	@Test(priority = 4)
	public void CheckQitagLogo() {

		WebElement theFooter = driver.findElement(By.tagName("footer"));

		WebElement logo = theFooter.findElement(By.cssSelector(".sc-fihHvN.eYrDjb"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-ekulBa.eYboXF"));

		boolean ActualResultForThelogo = logo.isDisplayed();

		Assert.assertEquals(ActualResultForThelogo, ExpectedResultsForTheLogo);
	}

	@Test(priority = 5)
	public void TestHotelTabIsNotSelected() {
		String ActualValue = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"))
				.getAttribute("aria-selected");
		;

		Assert.assertEquals(ActualValue, expectedValue);
	}

	@Test(priority = 6)

	public void CheckDepatureDate() {

		List<WebElement> depatureAndArrivalDates = driver.findElements(By.className("LiroG"));

		String ActualDepatureDate = depatureAndArrivalDates.get(0).getText();
		String ActualReturnDate = depatureAndArrivalDates.get(1).getText();

		int ActualDepatureDateAsInt = Integer.parseInt(ActualDepatureDate);
		int ActualreturnDateAsInt = Integer.parseInt(ActualReturnDate);

		Assert.assertEquals(ActualDepatureDateAsInt, Tomorrow);
		Assert.assertEquals(ActualreturnDateAsInt, ThedayAfterTomorrow);

	}

	@Test(priority = 7)

	public void RandomlyChangeTheLanguage() {

		RandomSelectTheLanguageOfTheWebSite();
	}

	@Test(priority = 8)

	public void FillHotelTab() {

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));

		HotelTab.click();
		WebElement SearchHotelInputField = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));

		String WebsiteURL = driver.getCurrentUrl();

		if (WebsiteURL.contains("ar")) {

			SearchHotelInputField.sendKeys(ArabicCities[randomArabicCity]);
		} else {
			SearchHotelInputField.sendKeys(EnglishCities[randomEnglishCity]);

		}

		WebElement ListOfLocations = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));

		WebElement firstResult = ListOfLocations.findElements(By.tagName("li")).get(1);
		firstResult.click();

	}

	@Test(priority = 9)

	public void RandomlySelectTheNumberOfVistor() {

		WebElement SelectorofTheVistor = driver
				.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));

		Select select = new Select(SelectorofTheVistor);

		// By index

		int randomIndex = rand.nextInt(2);
		select.selectByIndex(randomIndex);

		// By value
//		select.selectByValue("B"); 

		// by visibleText
//		if(driver.getCurrentUrl().contains("ar")) {
//			select.selectByVisibleText("1 غرفة، 1 بالغ، 0 أطفال"); 
//
//		}else {
//			select.selectByValue("1 Room, 1 Adult, 0 Children"); 
//		}
//		

		WebElement SearchHotelButton = driver
				.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		SearchHotelButton.click();
	}

	@Test(priority = 10)

	public void CheckThePageFullyLoaded() throws InterruptedException {

		Thread.sleep(10000);
		String results = driver.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']"))
				.getText();

		boolean finished = results.contains("وجدنا") || results.contains("found");

		Assert.assertEquals(finished, expectedResult);

	}

	@Test(priority = 11, description = "We explain if anything is related to the test")

	public void SortItemsLowestToHighestPrice() {

		WebElement LowestPriceSortButton = driver
				.findElement(By.xpath("//button[@data-testid='HotelSearchResult__sort__LOWEST_PRICE']"));

		LowestPriceSortButton.click();

		WebElement PricesContainer = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));

		List<WebElement> AllPrices = PricesContainer.findElements(By.className("Price__Value"));

//		List<WebElement> thePrices = driver.findElements(By.cssSelector(".Price__Wrapper.PriceDisplay__FinalRate.sc-dRCTWM.GFIG"));
//		
//		
		String LowestPrice = AllPrices.get(0).getText();
		String HighestPrice = AllPrices.get(AllPrices.size() - 1).getText();

		System.out.println(LowestPrice);
		System.out.println(HighestPrice);

//		

		int LowestPriceAsInt = Integer.parseInt(LowestPrice);
		int HighestPriceAsInt = Integer.parseInt(HighestPrice);

		boolean ActualResults = LowestPriceAsInt < HighestPriceAsInt;

		Assert.assertEquals(ActualResults, expectedResults);

	}

}
