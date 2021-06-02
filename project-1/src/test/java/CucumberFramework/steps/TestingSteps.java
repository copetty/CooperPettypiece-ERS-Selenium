package CucumberFramework.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TestingSteps {
	
	WebDriver driver;
	
	@Before()
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\copet\\OneDrive\\Desktop\\Project1\\project-1-copetty\\project-1\\src\\test\\java\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	@After()
	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
	
	@Given("^User navigates to ers website$")
	public void user_navigates_to_ers_website() throws Throwable {
	    driver.get("http://localhost:8080/project-1/");
	}

	@And("^User enters correct username$")
	public void user_enters_correct_username() throws Throwable {
	    driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/input[1]")).sendKeys("coop");
	}

	@And("^User enters correct password$")
	public void user_enters_correct_password() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[2]/input[1]")).sendKeys("coop123");
	}

	@When("^User clicks login$")
	public void user_clicks_login() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[4]/button[1]")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^User is taken to correct employee homepage$")
	public void user_is_taken_to_correct_employee_homepage() throws Throwable {
		Thread.sleep(3000);
		WebElement pendingRequestsButton = driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/button[1]"));
		Assert.assertEquals(true, pendingRequestsButton.isDisplayed());
	   
	}
	
	@And("^User enters incorrect password$")
	public void user_enters_incorrect_password() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[2]/input[1]")).sendKeys("coopdaloop123");
	}

	@SuppressWarnings("deprecation")
	@Then("^User should see a message saying incorrect username or password$")
	public void user_should_see_a_message_saying_incorrect_username_or_password() throws Throwable {
		Thread.sleep(3000);
		WebElement failedLoginText = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]"));
		Assert.assertEquals(true, failedLoginText.isDisplayed());
	}
	
	
	@And("^Manager enters correct username$")
	public void manager_enters_correct_username() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/input[1]")).sendKeys("may");
	}

	@And("^Manager enters correct password$")
	public void manager_enters_correct_password() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[2]/input[1]")).sendKeys("may123");
	}

	@SuppressWarnings("deprecation")
	@Then("^Manager is taken to correct Manager homepage$")
	public void manager_is_taken_to_correct_Manager_homepage() throws Throwable {
		Thread.sleep(3000);
		WebElement reviewRequestsButton = driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/button[1]"));
		Assert.assertEquals(true, reviewRequestsButton.isDisplayed());
	}
	
	@And("^Manager enters incorrect password$")
	public void manager_enters_incorrect_password() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[2]/input[1]")).sendKeys("maymay123");
	}

	@And("^User(\\d+) clicks submit new request$")
	public void user_clicks_submit_new_request(int arg1) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[3]/td[1]/form[1]/button[1]")).click();
	}

	@And("^User(\\d+) enters request amount$")
	public void user_enters_request_amount(int arg1) throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[1]/input[1]")).sendKeys("220");
	}

	@And("^User(\\d+) enters reason$")
	public void user_enters_reason(int arg1) throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[2]/input[1]")).sendKeys("Test");
	}

	@And("^User(\\d+) clicks other radio button$")
	public void user_clicks_other_radio_button(int arg1) throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[6]/input[1]")).click();
	}

	@And("^User(\\d+) clicks submit for the request$")
	public void user_clicks_submit_for_the_request(int arg1) throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[8]/button[1]")).click();
	}

	@And("^User(\\d+) navigates to homepage$")
	public void user_navigates_to_homepage(int arg1) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='reston']")).click();
	}

	@When("^User(\\d+) clicks pending requests$")
	public void user_clicks_pending_requests(int arg1) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/button[1]")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^User(\\d+) sees new pending request$")
	public void user_sees_new_pending_request(int arg1) throws Throwable {
		Thread.sleep(3000);
		WebElement pendingReimbursementText = driver.findElement(By.xpath("/html[1]/body[1]/h1[1]"));
		Assert.assertEquals(true, pendingReimbursementText.isDisplayed());
	}
	


	@And("^Manager(\\d+) clicks review requests$")
	public void manager_clicks_review_requests(int arg1) throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/button[1]")).click();
	}

	@And("^Manager(\\d+) clicks approve$")
	public void manager_clicks_approve(int arg1) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr[2]/td[9]/button[1]")).click();
	}
	
	@And("^Manager(\\d+) clicks deny$")
	public void manager_clicks_deny(int arg1) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody/tr[2]/td[9]/button[2]")).click();
	}

	@And("^Manager(\\d+) navigates to homepage$")
	public void manager_navigates_to_homepage(int arg1) throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Manager Home')]")).click();
	}

	@When("^Manager(\\d+) clicks resolved requests$")
	public void manager_clicks_resolved_requests(int arg1) throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/button[1]")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^Manager(\\d+) views resolved requests$")
	public void manager_views_resolved_requests(int arg1) throws Throwable {
		Thread.sleep(3000);
		WebElement resolvedRequestsText = driver.findElement(By.xpath("/html[1]/body[1]/h1[1]"));
		Assert.assertEquals(true, resolvedRequestsText.isDisplayed());
	}
	
	@When("^User clicks view and update again$")
	public void user_clicks_view_and_update_again() throws Throwable {
	driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[4]/td[1]/button[1]")).click();
	}
	
	

	@And("^User inputs a new email address$")
	public void user_inputs_a_new_email_address() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='eMail']")).sendKeys("Test@test.com");
	}

	@And("^User clicks update$")
	public void user_clicks_update() throws Throwable {
		driver.findElement(By.xpath("/html[1]/body[1]/form[4]/div[2]/button[1]")).click();
	}

	@And("^User navigates to homepage$")
	public void user_navigates_to_homepage() throws Throwable {
		driver.findElement(By.xpath("//a[contains(text(),'Employee Home')]")).click();
	}

	@And("^User clicks view and update$")
	public void user_clicks_view_and_update() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'View And Update')]")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^User confirms updated email$")
	public void user_confirms_updated_email() throws Throwable {
		Thread.sleep(3000);
		WebElement viewAndUpdateText = driver.findElement(By.xpath("/html[1]/body[1]/h1[1]"));
		Assert.assertEquals(true, viewAndUpdateText.isDisplayed());
	}
	
	@When("^User clicks logout$")
	public void user_clicks_logout() throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Logout')]")).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^User is taken to login screen$")
	public void user_is_taken_to_login_screen() throws Throwable {
		Thread.sleep(3000);
		WebElement loginText = driver.findElement(By.xpath("/html[1]/body[1]/h1[1]"));
		Assert.assertEquals(true, loginText.isDisplayed());
	}
	
	




}





	
	




