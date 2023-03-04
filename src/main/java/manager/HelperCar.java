package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HelperCar extends HelperBase {
	//===========================================================================================
	public HelperCar (WebDriver wd) {
		super(wd);
	}

	//===========================================================================================
	public void openCarForm () {

		pauseThreadSleep(2000);

		new WebDriverWait(wd, 10)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='1']")));

		System.out.println("Works Fine");
		WebElement element = wd.findElement(By.xpath("//a[@id='1']"));

		if(element != null) {
			element.click();
		}
		Assert.assertTrue(isElementPresent(By.xpath("//a[@id='1']")));
	}

	public boolean isCarFormPresent () {

		return new WebDriverWait(wd, 10)
				.until(ExpectedConditions.textToBePresentInElement(wd.findElement(By.xpath("//div[@class='car-card']//h1[.='Let the car work ']")), " Let the car work "));
	}

	public void typeLocation (String address) {
		type(By.xpath("//input[@id='pickUpPlace']"), "Tel Aviv");
		mouseClick(By.cssSelector("div.pac-item"));
		pauseThreadSleep(1);
	}

	public void select (By locator, String option) {
		new Select(wd.findElement(locator)).selectByValue(option);
	}

	public void fillCarForm (Car car) {
		typeLocation(car.getAddress());
		type(By.id("make"), car.getMake());
		type(By.id("model"), car.getModel());
		type(By.id("year"), car.getYear());
		select(By.id("fuel"), car.getFuel());
		type(By.id("seats"), car.getSeats());
		type(By.id("class"), car.getCarClass());
		type(By.id("serialNumber"), car.getCarRegNumber());
		type(By.id("price"), car.getPrice());
	}

	public void submitCarForm () {
		mouseClick(By.cssSelector("button[type='submit']"));
		pauseThreadSleep(1000);
		wd.findElement(By.xpath("//*[contains(text(), 'Search cars')]")).click();
	}
}
