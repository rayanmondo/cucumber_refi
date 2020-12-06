package refiSteps_cucumber;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.NavigationBar;
import page_object.Refi_Calculate;

public class DataParam {
    private static Logger LOGGER = LogManager.getLogger(LoginAmazon.class);
    WebDriver driver;
    @Given("^mortgage calculator home page$")
    public void homePage(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
        LOGGER.info("homepage");
    }
    @When("^mousehover on Refinance and click RefiCalculator$")
    public void mouseHoverToRefi(){
        new NavigationBar(driver)
                .mouseHover()
                .clickLink();
        LOGGER.info("select refiCalculator ");
    }
    @And("^enter input values \"(.+?)\", \"(.+?)\", \"(.+?)\", \"(.+?)\"and click on calculate button$")
    public void dataSet(String homeprice, String downpay, String loanTerm, String loanDuration ){
        new Refi_Calculate(driver)
                .homeValue(homeprice)
                .downPayment(downpay)
                .loanLenght(loanTerm)
                .interestValue(loanDuration)
                .enterCalculateButton();

        LOGGER.info("all the data entered ");
    }
    @Then("^validate the monthly payment \"(.+?)\" and return to homepage$")
    public void validateMonthlyPay(String monthlyPay){
        new Refi_Calculate(driver)
                .priceVal(monthlyPay)
                .clickLogo();
        LOGGER.info("price validate and homepage");
        ActOn.browser(driver).closeBrowser();

    }
}
