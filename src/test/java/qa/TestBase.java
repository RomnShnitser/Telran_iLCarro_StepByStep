package qa;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
	public static ApplicationManager app = new ApplicationManager();
	public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

	@BeforeSuite
	public void setup () {
		app.init();
	}



	@AfterSuite
	public void tearDown () {
		//app.stop();
	}

	@BeforeMethod
	public void startTest(Method method){
		logger.info("\nStart test " + method.getName());
	}

	@AfterMethod
	public void stopTest(Method method){
		logger.info("The End of test " + method.getName()+"\n=========================================" +
				"==========================================");

	}
}

