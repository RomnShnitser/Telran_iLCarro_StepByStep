package qa.registration;

import models.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class RegNegative_WrongEmail_IT extends TestBase {
	@BeforeMethod
	public void precondition() {
		if (app.user().isLogged()) {
			app.user().logout();
		}
	}

	@Test
	public void loginWrongEmailTest() {
		int a = (int) (System.currentTimeMillis() / 1000) % 3600;

		String name = "Jack";
		String lastName = "Ramble";
		String email = "jack" + a + "gmail.com";
		String password = "$ABCdef12345";

		UserData userData = new UserData()
				.withName(name)
				.withLastName(lastName)
				.withEmail(email)
				.withPassword(password);

		app.user().openRegistrationForm();
		app.user().fillingRegistrationForm(userData);
		app.user().submitRegistration();
	}

	@AfterMethod
	public void postCondition() {
		app.user().outOfTest();
	}
}
