package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerificationPage extends BasePage {

	public VerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@role='alert']")
	WebElement msgLogin;
	String errormsgverify;

	String messageStr;
	String msgDisplay;
	// msgDisplay= "password_mismatch:The two password fields didn’t match.";
	// String popUpDisplay="Please fill out this field.";
	String successMsg = "New Account Created. You are logged in as";

	public void popup() {
		WebElement activeElement = driver.switchTo().activeElement();
		messageStr = activeElement.getAttribute("validationMessage");
		System.out.println("Actual message appeared on screen: " + messageStr);
	}

	public String isLoginPageExists() {
		try {

			if (msgLogin.isDisplayed()) {
				errormsgverify = msgLogin.getText();
				System.out.println("isdisplayed");

			}
			return (errormsgverify);

		} catch (Exception e) {
			popup();
			if (messageStr.equalsIgnoreCase("Please fill out this field.")) {
				System.out.println("Please fill out field");
				return (messageStr);
			}
		}
		return successMsg;

	}

}
