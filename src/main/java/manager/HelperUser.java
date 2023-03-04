package manager;

import models.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{
	//Constructor
	public HelperUser (WebDriver wd) {
		super(wd);
	}

	//Login Block
	//===========================================================================================
	// Check, if user is loggedIn
	public boolean isLogged () {
		return isElementPresent(By.xpath("//a[normalize-space()='Logout']"));
	}

	// Logout
	public void logout () {
		mouseClick(By.xpath("//a[normalize-space()='Logout']"));
	}

	// Open Login Form
	public void openLoginForm () {
		mouseClick(By.xpath("//a[text()=' Log in ']"));
	}

	// Filling Login Form (with 'models' > 'User')
	public void fillingLoginForm (UserData userData) {
		type(By.xpath("//input[@id='email']"), userData.getEmail());
		type(By.xpath("//input[@id='password']"), userData.getPassword());
	}

	// Click Agree button when login form is done
	public void submitLogin () {
		mouseClick(By.xpath("//button[@type='submit']"));
	}

	public boolean isLoggedSuccess () {
		WebDriverWait wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
		return wd.findElement(By.cssSelector(".dialog-container")).getText().contains("success");
	}

	public void clickOkButtonOnLogin () {
		mouseClick(By.xpath("//button[@type='button']"));
	}

	// Registration Block
	//============================================================================================================================

	public void openRegistrationForm () {
		mouseClick(By.xpath("//a[.=' Sign up ']"));
	}

	public void fillingRegistrationForm (UserData userData) {
		type(By.xpath("//input[@id='name']"), userData.getName());
		type(By.xpath("//input[@id='lastName']"), userData.getLastName());
		type(By.xpath("//input[@id='email']"), userData.getEmail());
		type(By.xpath("//input[@id='password']"), userData.getPassword());
	}

	public void clickAgreeWithTermsOfUse () {
		//Variant 1
		//mouseClick(By.cssSelector("label[for='terms-of-use']"));

		//Variant 2
		//JavascriptExecutor js = (JavascriptExecutor) wd;
		//js.executeScript("document.querySelector('#terms-of-use').click();");

		//Variant 3
		Rectangle rect = wd.findElement(By.cssSelector(".checkbox-container")).getRect();
		int x = rect.getX() + 5;
		int y = rect.getY() + 5;
		Actions actions = new Actions(wd);
		actions.moveByOffset(x,y).click().perform();
	}

	public void submitRegistration () {
		mouseClick(By.xpath("//button[@type='submit']"));
	}

	public boolean isRegisteredSuccess () {
		WebDriverWait wait = new WebDriverWait(wd, 5);
		wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".mat-dialog-container"))));
		return wd.findElement(By.cssSelector(".mat-dialog-container")).getText().contains("success");
	}

	//============================================================================================================================

	public void outOfTest () {
		if(isLogged()) {
			logout();
		}
		wd.findElement(By.xpath("(//img[@alt='logo'])[1]")).click();
	}

	public void login (UserData userData) {
		openLoginForm();
		fillingLoginForm(userData);
		submitLogin();
		clickOkButtonOnLogin();
	}

}
