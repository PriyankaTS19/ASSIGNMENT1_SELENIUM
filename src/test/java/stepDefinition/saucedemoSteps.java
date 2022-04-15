package stepDefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class saucedemoSteps {
	WebDriver driver;
	public saucedemoSteps() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priyanka Sasargoan\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    this.driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@Given("user is on saucedemo homepage")
	public void user_is_on_saucedemo_homepage() {
	    driver.get("https://www.saucedemo.com");
	}

	@Given("user logged in using correct credential")
	public void user_logged_in_using_correct_credential(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("user-name")).sendKeys(data.get("username"));
		driver.findElement(By.name("password")).sendKeys(data.get("password"));
		driver.findElement(By.id("login-button")).click();
	}

	@Given("user adds required item to cart")
	public void user_adds_required_item_to_cart() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	}

	@Given("user proceeds to checkout")
	public void user_proceeds_to_checkout() {
	    driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).click();
	    driver.findElement(By.id("checkout")).click();
	}

	@Given("user enters the following details for checkout")
	public void user_enters_the_following_details_for_checkout(io.cucumber.datatable.DataTable dataTable) {
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("first-name")).sendKeys(data.get("FirstName"));
		driver.findElement(By.id("last-name")).sendKeys(data.get("LastName"));
		driver.findElement(By.id("postal-code")).sendKeys(data.get("PostalCode"));
	}

	@When("user confirm checkout")
	public void user_confirm_checkout() {
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
	}

	@Then("user verify final confirmation message")
	public void user_verify_final_confirmation_message() {
	   driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']")).isDisplayed();
	   driver.close();
	}

	@Given("user adds one item and then remove that item to go back")
	public void user_adds_one_item_and_then_remove_that_item_to_go_back() {
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
	}

	@Given("user sorts item low to high")
	public void user_sorts_item_low_to_high() {
		 driver.findElement(By.xpath("//*[@id='header_container']/div[2]/div[2]/span")).click();
		 driver.findElement(By.xpath("//*[@id='header_container']/div[2]/div[2]/span/select/option[3]")).click();
		
	}
}
