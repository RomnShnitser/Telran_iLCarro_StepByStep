package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
	//===========================================================================================
	Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
	//===========================================================================================
	WebDriver wd;
	HelperUser user;
	HelperCar car;

	//#########################################################################################*/
	/*=========================================================================================*/
	public void init () {
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");

		//- - - - - - - - - - - - - - - - - - - - - - -
		wd = new ChromeDriver();
		user = new HelperUser(wd);
		car = new HelperCar(wd);

		//- - - - - - - - - - - - - - - - - - - - - - -
		wd.manage().window().maximize();
		wd.navigate().to("https://ilcarro.web.app");
		wd.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	/*=========================================================================================*/
	//#########################################################################################*/

	public void stop () {
		wd.quit();
	}
	//===========================================================================================

	public HelperUser user () {
		return user;
	}
	//- - - - - - - - - - - - - - - - - - - - - - -

	public HelperCar car () {
		return car;
	}
}
