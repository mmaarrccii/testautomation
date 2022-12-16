package hu.masterfield.tesco.steps;

import com.codeborne.selenide.Configuration;
import hu.masterfield.tesco.pages.LoginPage;
import hu.masterfield.tesco.pages.ProductPage;
import hu.masterfield.tesco.pages.WebShopPage;
import hu.masterfield.tesco.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class TescoSteps {

    HomePage homePage;
    LoginPage loginPage;
    WebShopPage webShopPage;
    ProductPage productPage;


    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;
    }

    @After
    public void cleanup() {
    }

    @Given("open the main page")
    public void openTheMainPage() {
        homePage = open("https://bevasarlas.tesco.hu/groceries/hu-HU", HomePage.class);
    }

    @And("accept cookies")
    public void acceptCookies() {

        homePage.acceptCoockies();
        homePage.validateCookiesAccepted();
    }

    @Then("the cookie panel closes")
    public void theCookiePanelCloses() {
        homePage.validateCookiesAccepted();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage = homePage.openLogin();
        loginPage.validatePage();
    }

    @When("I login account with username and password")
    public void iLoginAccountWithUsernameAndPassword() {
        String email = "szilagyimarci@gmail.com";
        String password = "Teszt123";
        webShopPage = loginPage.loginAccount(email, password);
    }

    @Then("I am on the products page")
    public void iAmOnTheProductsPage() {
        webShopPage.validatePage();
    }

    @And("I should see the basket icon")
    public void iShouldSeeTheBasketIcon() {
        webShopPage.validateBasketIcon();
    }

    @When("I login with invalid username or password")
    public void iLoginWithInvalidUsernameOrPassword() {
        String email = "szilagyimarci@gmail.com";
        String password = "Teszt124";
        webShopPage = loginPage.loginAccount(email, password);
    }

    @Then("I should see the error message on the login page")
    public void iShouldSeeTheErrorMessageOnTheLoginPage() {
        loginPage.errorMessage();
    }

    @When("I sign out")
    public void iSignOut() {
        homePage = webShopPage.logout();
        homePage.validatePage();
    }

    @Then("no basket icon available")
    public void noBasketIconAvailable() {
        webShopPage.validateMissingBasket();
    }
}

