package qa.registration;

import models.UserData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class RegistrationPositiveTest extends TestBase {
	@BeforeMethod
	public void precondition () {
		if(app.user().isLogged()) {
			app.user().logout();
		}
	}

	@Test
	public void registrationSuccess () {
		int a = (int) (System.currentTimeMillis() / 1000) % 3600;

		String name = "Jack";
		String lastName = "Ramble";
		String email = "jack" + a + "@gmail.com";
		String password = "$ABCdef12345";

		UserData userData = new UserData()
				.withName(name)
				.withLastName(lastName)
				.withEmail(email)
				.withPassword(password);

		logger.info("registrationPositiveTest with email: " + userData.getEmail() + " & password: " + userData.getPassword());


		app.user().openRegistrationForm();
		app.user().fillingRegistrationForm(userData);
		app.user().clickAgreeWithTermsOfUse();
		app.user().submitRegistration();

		Assert.assertTrue(app.user().isRegisteredSuccess());
	}

	@AfterMethod
	public void postCondition () {
		app.user().mouseClick(By.xpath("//button[@type='button']"));
		app.user().outOfTest();
	}
}
