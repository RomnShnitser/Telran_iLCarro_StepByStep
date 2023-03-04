package qa.login;

import models.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class LoginPositiveTest extends TestBase {
	@BeforeMethod
	public void precondition() {
		if (app.user().isLogged()) {
			app.user().logout();
		}
	}

	@Test
	public void loginSuccess() {
//		String email = "romn.shnitser@gmail.com";
		String email = "romn.shnitsergmail.com";
		String password = "$Qwerty12345";

		UserData userData = new UserData()
				.withEmail(email)
				.withPassword(password);

		app.user().openLoginForm();
		app.user().fillingLoginForm(userData);
		app.user().submitLogin();
		Assert.assertTrue(app.user().isLoggedSuccess());
	}

	@AfterMethod
	public void postCondition() {
		app.user().clickOkButtonOnLogin();
		app.user().outOfTest();
	}
}
