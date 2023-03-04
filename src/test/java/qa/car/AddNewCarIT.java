package qa.car;

import models.Car;
import models.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.TestBase;

public class AddNewCarIT extends TestBase {
	//===========================================================================================
	@BeforeMethod


	public void precondition () {
		if(!app.user().isLogged()) {
			app.user().login(new UserData().withEmail("romn.shnitser@gmail.com").withPassword("$Qwerty12345"));
			app.user().clickOkButtonOnLogin();
		}
	}

	//===========================================================================================
	@Test
	public void addNewCarPositiveTest () {

		logger.info("Method 'addNewCarPositiveTest' started");

		int a = (int) (System.currentTimeMillis() / 1000) % 3600;

		Car car = Car.builder()
				.address("Tel Aviv")
				.make("KIA")
				.model("Sportage")
				.year("2020")
				.fuel("Petrol")
				.seats("4")
				.carClass("5")
				.carRegNumber("100-200-" + a)
				.price("150")

				.build();

		app.car().openCarForm();
		app.car().fillCarForm(car);
		app.car().submitCarForm();

		logger.info("Method 'addNewCar' Stopped");
		logger.info("Method added car: \n" + car);
	}

	//===========================================================================================
	@AfterMethod
	public void postCondition () {

		//app.getUser().outOfTest();
	}
}
