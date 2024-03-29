package StepDefinitions;

import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import pageObjects.MyLoginVerificationPage;
import testBase.BaseClass;
import utilities.DataReader;


public class LoginSteps {
     WebDriver driver;
     HomePage hp;
     LoginPage lp;
     MyLoginVerificationPage verifyLogin;
  
     List<HashMap<String, String>> datamap; //Data driven
     
   
    @Given("the user navigates to login page")
    public void user_navigate_to_login_page() {
    	
    	BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
    	hp=new HomePage(BaseClass.getDriver());
    	
    	//hp.clickMyAccount();
    	hp.clickSignin();
    }

 
    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String uname, String pwd) {
    	BaseClass.getLogger().info("Entering email and password.. ");
    	
    	lp=new LoginPage(BaseClass.getDriver());
       	lp.sendUserName(uname);
        lp.sendPwdName(pwd);
        }

    @When("the user clicks on the Login button")
    public void click_on_login_button() {
        lp.clickLogin();
        BaseClass.getLogger().info("clicked on login button...");
    	
        
    }
	/*
	 * 
	 * @Then("the user should be redirected to the MyAccount Page") public void
	 * user_navigates_to_my_account_page() { verifyLogin=new
	 * MyAccountPage(BaseClass.getDriver()); boolean
	 * targetpage=verifyLogin.isMyAccountPageExists();
	 * 
	 * Assert.assertEquals(targetpage, true);
	 * 
	 * }
	 */
    
   

    //*******   Data Driven test **************
    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(String rows)
    {
    	datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\ExcelData.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String uname= datamap.get(index).get("username");
        String pwd= datamap.get(index).get("password");
        String status= datamap.get(index).get("status");
        String msg= datamap.get(index).get("message");

    	lp=new LoginPage(BaseClass.getDriver());
       	lp.sendUserName(uname);
        lp.sendPwdName(pwd);
        lp.clickLogin();
        verifyLogin=new MyLoginVerificationPage(BaseClass.getDriver());
        try
        {
            boolean targetpage=verifyLogin.isLoginPageExists(msg);
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
      }
 
}
