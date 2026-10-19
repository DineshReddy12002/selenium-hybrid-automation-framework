package testBase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	protected static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master", "dataDriven" })
	@Parameters({ "os", "br" })
	public void setup(String os, String br) throws IOException {

		p = new Properties();
		p.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

		logger = LogManager.getLogger(this.getClass());

		if (p.getProperty("environment_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else {
				System.out.println("Invalid OS detected");
				return;
			}

			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");

				break;

			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");

				break;

			default:
				System.out.println("Invalid Browser detected");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wb/hub"), capabilities);

		}

		else if (p.getProperty("environment_env").equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid browser");
				return;
			}
			
		}
		
		

		driver.get(p.getProperty("appURL"));

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master", "dataDriven" })
	public void teardown() {
		driver.quit();
	}

	public String randomString() {
		return RandomStringUtils.secure().nextAlphabetic(5);
	}

	public String randomNumber() {
		return RandomStringUtils.secure().nextNumeric(10);
	}

	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.secure().nextAlphabetic(5);
		String generatedNumber = RandomStringUtils.secure().nextNumeric(3);
		return (generatedString + "@" + generatedNumber);
	}

	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + " _ " + timeStamp;
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}