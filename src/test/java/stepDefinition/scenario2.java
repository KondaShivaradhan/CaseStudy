package stepDefinition;

import baseClass.driverClass;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.AllOrdersPage;
import pageClass.loginPage;
import pageClass.OrderPage;

public class scenario2 extends driverClass {

//	@After
//	public void closeBrowser() {
//		driver.quit();
//	}
	// --------------- Scenario 2 -----------------------------//
	loginPage lp2 = new loginPage();
	OrderPage op2;
	AllOrdersPage aop2;

	@Given("^Navigate to the application2$")
	public void Navigate_to_the_application2() {
		openURL2("baseURL2");
	}

	@Then("^Login page verification2$")
	public void Login_page_verification2() {

	}

	@When("^login using valid credentials2$")
	public void login_using_valid_credentials2() {

	}

	@Then("^Verify Username2$")
	public void Verify_Username2() {
		op2 = lp2.verifyLogin("loginVerify_xpath");
	}
	@When("^Edit the Order2$")
	public void Edit_the_Order2()
	{
		aop2=op2.AllOrders();
		aop2.EditOrder2();
	}

	@Then("^Verifiy updated order2$")
	public void Verifiy_updated_order2()
	{
		aop2.VerifyEditOrder2();
	}
	@When("^Logout2$")
	public void Logout2()
	{
		aop2.logout();
	}
//	@Then("^close2$")
//	public void closeBrowser()
//	{
//		driver.close();
//	}
}
