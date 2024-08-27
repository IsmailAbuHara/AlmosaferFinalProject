package homePage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	WebDriver driver = new ChromeDriver();

	String Almosafer = "Https://www.almosafer.com/en";

	String ExpectedDefaultLange = "en";

	Random rand = new Random();

	String ExpectedCurrency = "SAR";

	String ExpectedContactNumber = "+966554400000";

	boolean ExpectedResultsForTheLogo = true;

	String expectedValue = "false";

	LocalDate todayDate = LocalDate.now();

	int Today = todayDate.getDayOfMonth();

	int Tomorrow = todayDate.plusDays(1).getDayOfMonth();
	int ThedayAfterTomorrow = todayDate.plusDays(2).getDayOfMonth();

	String[] EnglishCities = { "Dubai", "Jeddah", "Riyadh" };
	int randomEnglishCity = rand.nextInt(EnglishCities.length);

	String[] ArabicCities = { "دبي", "جدة" };
	int randomArabicCity = rand.nextInt(ArabicCities.length);

	boolean expectedResult = true;

	boolean expectedResults = true;

	public void RandomSelectTheLanguageOfTheWebSite() {
		String[] URLs = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar", };
		int RandomIndex = rand.nextInt(URLs.length);

		driver.get(URLs[RandomIndex]);
	}

	public void GeneralSetup() {

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(Almosafer);

	}
}
