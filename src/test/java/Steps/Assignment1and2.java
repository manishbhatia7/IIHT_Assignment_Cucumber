package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Assignment1and2 {
    public WebDriver driver;
    @Before
    public void setup()
    {

        String cwd=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",cwd+"\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @After
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }




        @Given("^I access Cleartrip website$")
        public void i_access_Cleartrip_website() throws Throwable {
        driver.get("https://www.cleartrip.com/");



        }


        @When("^I select \"([^\"]*)\" as FROM$")
        public void i_select_something_as_from(String Arg1) throws Throwable {
            WebElement source=driver.findElement(By.id("FromTag"));
            source.sendKeys("");
            source.sendKeys(Arg1);
            Thread.sleep(5000);
            source.sendKeys(Keys.ARROW_DOWN);
            source.sendKeys(Keys.ENTER);




;

        }



        @And("^I select \"([^\"]*)\" as TO$")
        public void i_select_something_as_to(String Arg2) throws Throwable {
            WebElement dest=driver.findElement(By.id("ToTag"));
            //dest.sendKeys("");
            dest.sendKeys(Arg2);
            Thread.sleep(5000);
            dest.sendKeys(Keys.ARROW_DOWN);
            dest.sendKeys(Keys.ENTER);
        }


    @And("I select a date")
    public void iSelectADate() {
        driver.findElement(By.xpath("//div[@class='monthBlock last']//a[contains(@class,'ui-state-default')][contains(text(),'30')]")).click();
    }



        @And("^I click on Search button$")
        public void i_click_on_search_button() throws Throwable {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.id("SearchBtn")).click();

        }

        @Then("^NonZero search results should populate$")
        public void nonzero_search_results_should_populate() throws Throwable {
            WebDriverWait w=new WebDriverWait(driver,20);
            w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='span span19 truncate']")));
            WebElement result_text=driver.findElement(By.xpath("//span[@class='span span19 truncate']"));
            Assert.assertTrue(result_text.isDisplayed());
        }




    @When("^I click on login button$")
    public void i_click_on_login_button() throws Throwable {
        driver.findElement(By.xpath("//span[contains(text(),'Your trips')]")).click();
        WebDriverWait w=new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("SignIn"))).click();

    }



    @And("^Verify the title$")
    public void verify_the_title() throws Throwable {
        Assert.assertEquals("#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.",driver.getTitle());

    }

    @And("^give username as \"([^\"]*)\"$")
    public void give_username_as_something(String username) throws Throwable {
        driver.switchTo().frame("modal_window");
        driver.findElement(By.id("email")).sendKeys(username);


    }

    @And("^give password as \"([^\"]*)\"$")
    public void give_password_as_something(String password) throws Throwable {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("^click on login button$")
    public void click_on_login_button() throws Throwable {
        driver.findElement(By.id("signInButton")).click();

    }
    @Then("^I should get a valid error message$")
    public void i_should_get_a_valid_error_message() throws Throwable {
        WebDriverWait w=new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'The username or password you entered is incorrect.')]")));
        org.testng.Assert.assertEquals(driver.findElement(By.xpath("//li[contains(text(),'The username or password you entered is incorrect.')]")).getText(),"The username or password you entered is incorrect.");



    }


}

