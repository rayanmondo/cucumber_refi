package refiSteps_cucumber;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAmazon {
    private final By login = By.id("nav-link-accountList");
    private final By emailBox = By.id("ap_email");
    private final By continueButton= By.id("continue");
    private final By passBox=By.id("ap_password");
    private final By signIn=By.id("signInSubmit");
    private final By clickAmazon=By.id("nav-logo-sprites");
    private final By invalidpassBox=By.xpath("//*[@id='auth-error-message-box']//span[@class='a-list-item']");
    private final By mouseHover=By.id("nav-link-accountList");
    private final By logOut= By.xpath("//*[@id='nav-item-signout']/span[text()='Sign Out']");

    private static Logger LOGGER = LogManager.getLogger(LoginAmazon.class);
    WebDriver driver;
    @Given("^a user is on the login page$")
    public void loginPage(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.amazon.com/");
        LOGGER.info("login page");
    }

    @When("^user enter email \"(.+?)\" and click on continue button and enter password \"(.+?)\"$")
    public void emailAndContinue(String emailaddres, String password){
        ActOn.element(driver,login).click();
        ActOn.element(driver,emailBox).setValue(emailaddres);
        ActOn.element(driver,continueButton).click();
        ActOn.element(driver,passBox).setValue(password);
        LOGGER.info("credentials entered");
    }

    @And("^user click on Sign-in button$")
    public void Singin(){
        ActOn.element(driver,signIn).click();
        LOGGER.info("CLICK ON LOGIN BUTTON");

    }

    @Then("^user is navigated to home page$")
    public void homePage(){
        ActOn.element(driver,clickAmazon).click();
        ActOn.browser(driver).validateTitle("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
    LOGGER.info("User navigated to home page");
    ActOn.element(driver,mouseHover).mouseHover();
    ActOn.element(driver,logOut).click();
    ActOn.browser(driver).closeBrowser();
    }
    @Then("^user is unable navigated to home page$")
    public void wrongPassVal(){
        boolean wrongPassword=driver.findElement(invalidpassBox).isDisplayed();
        Assert.assertTrue("invalid password is not display",wrongPassword);
        LOGGER.info("wrong password");
        ActOn.browser(driver).closeBrowser();

    }

}
