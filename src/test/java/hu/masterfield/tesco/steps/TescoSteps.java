package hu.masterfield.tesco.steps;

import com.codeborne.selenide.Configuration;
import hu.masterfield.tesco.pages.LoginPage;
import hu.masterfield.tesco.pages.ProductPage;
import hu.masterfield.tesco.pages.WebShopPage;
import hu.masterfield.tesco.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class TescoSteps {

    String baseUrl = "https://bevasarlas.tesco.hu/groceries/hu-HU";
    HomePage homePage;
    LoginPage loginPage;
    WebShopPage webShopPage;
    ProductPage productPage;

    @Given("open main page")
    public void openMainPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;

        open("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }

    @Given("open the main page")
    public void openTheMainPage() throws InterruptedException {
        homePage = open(baseUrl, HomePage.class);
        homePage.validatePage();
    }

    @Then("I should see the accept cookies button")
    public void iShouldSeeTheAcceptCookiesButton() {
        homePage.cookieButtonAvailable();
    }

    @And("accept cookies")
    public void acceptCookies() throws InterruptedException {
        homePage.acceptCoockies();
        homePage.validateCookiesAccepted();
    }
}

