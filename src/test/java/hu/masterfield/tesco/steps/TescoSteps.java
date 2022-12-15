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

    HomePage homePage;
    LoginPage loginPage;
    WebShopPage webShopPage;
    ProductPage productPage;

    @Given("open the main page")
    public void openTheMainPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;

        open("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }

    @And("accept cookies")
    public void acceptCookies() {
        homePage.acceptCoockies();
        homePage.validateCookiesAccepted();
    }

    @And("the page is online")
    public void thePageIsOnline() {
        homePage.cookieButtonAvailable();
    }

    @Then("the cookie panel closes")
    public void theCookiePanelCloses() {
        homePage.validateCookiesAccepted();
    }
}

