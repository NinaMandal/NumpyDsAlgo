package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegistrationFormPage extends BasePage {

	//private WebDriver driver;
   // By register = By.partialLinkText("Register");

    public RegistrationFormPage(WebDriver driver) {
		super(driver);
	}
    
	
	  @FindBy(id = "id_username")
	  
	  @CacheLookup 
	  WebElement username;
	 
	
	@FindBy(id = "id_password1")
	WebElement pwd;
	
	@FindBy(id = "id_password2")
	WebElement confpwd;
	
	@FindBy(xpath="//input[@value = 'Register']")
	WebElement btnRegister;
	
	
	public void setUserName(String uname) {

		//WebElement username = driver.findElement(By.id("id_username"));
		username.sendKeys(uname);
	}
	public void setPwdName(String password) {
		pwd.sendKeys(password);
	}
	public void setConfpwdName(String confpassword) {
		confpwd.sendKeys(confpassword);
	}

    public void ClickRegister() {
    	btnRegister.click();
    }
}
