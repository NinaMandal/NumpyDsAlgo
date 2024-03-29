package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.MyLoginVerificationPage;
import pageObjects.RegistrationFormPage;
import pageObjects.VerificationPage;
import testBase.BaseClass;

public class RegistrationStepDefinition extends BaseClass {
	WebDriver driver;
    HomePage hp;
    MyLoginVerificationPage verifyLogin;

	RegistrationFormPage registrationPage = new RegistrationFormPage(BaseClass.getDriver());

	// RegistrationPage registrationPage;
	@Given("The user opens Register Page")
	public void the_user_opens_register_page() {
		BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
    	hp=new HomePage(BaseClass.getDriver());
    	
    	//hp.clickMyAccount();
    	hp.clickRegister();
	}

	@When("^The user fill in the registration form with given data (.*), (.*), and (.*)$")
	public void the_user_fill_in_the_RegistrationFormWithInvalidData(String username, String password,
			String confirmpwd) {

		BaseClass.getLogger().info("The user fill in the registration form with given data");

		registrationPage.setUserName(username);
		registrationPage.setPwdName(password);
		registrationPage.setConfpwdName(confirmpwd);
		registrationPage.ClickRegister();
		BaseClass.getLogger().info("Clicked on Registration Button");

		// driver.findElement(By.xpath("//input[@value = 'Register']")).click();

	}

	@Then("^User should see an error\\/success message(.*),(.*)$")
	public void user_should_see_an_error_success_message(String message, String status) {
		
		 verifyLogin=new MyLoginVerificationPage(BaseClass.getDriver());
		//String actualMsg = verifylogin.isLoginPageExists();
		
	     try
	        {
	            boolean targetpage=verifyLogin.isLoginPageExists(message);
	            System.out.println("target page: "+ targetpage);
	            if(status.equals("Valid"))
	            {
	                if(targetpage==true)
	                {
	                	MyLoginVerificationPage myaccpage=new MyLoginVerificationPage(BaseClass.getDriver());
	                    myaccpage.clickLogout();
	                    Assert.assertTrue(true);
	                }
	                else
	                {
	                    Assert.assertTrue(false);
	                }
	            }

	            if(status.equals("Invalid"))
	            {
	                if(targetpage==true)
	                {
	                    
	                    Assert.assertTrue(true);
	                }
	                else
	                {
	                    Assert.assertTrue(false);
	                }
	            }


	        }
	        catch(Exception e)
	        {

	            Assert.assertTrue(false);
	        }
		
		
		
		

		/*try {
			if (message.contains("New Account Created")) {
				BaseClass.getLogger().info("USER Registered");
				//String successMesg = message.concat(" " + username);
				//Assert.assertEquals(successMesg.trim(), actualMsg.trim());
				Assert.assertTrue(true);
			} else

			{
				BaseClass.getLogger().info("USER GOT ERrror MSG");
				Assert.assertEquals(message.trim(), actualMsg.trim());
				System.out.println("INSIDE ELSE" + message);
				System.out.println("INSIDE ELSE" + actualMsg);
				Assert.assertTrue(true);

			}
		} catch (AssertionError e) {
			BaseClass.getLogger().error("TEST FAILED");
			Assert.fail("Fail" + e.getMessage());*/

		}
	}


