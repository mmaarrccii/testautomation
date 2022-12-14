package hu.masterfield.tesco.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import hu.masterfield.tesco.pages.LoginPage;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TescoSteps {

    HomePage homePage;
    LoginPage loginPage;
    WebShopPage webShopPage;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;
    }

    @After
    public void cleanup() {
        WebDriverRunner.getWebDriver().quit();
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

    @When("I search for {string}")
    public void searchProductWith(String productName) {
        webShopPage = webShopPage.search(productName);
        webShopPage.validateProduct(productName);
    }

    @Then("I can see the {string} in results")
    public void isProductInResults(String productName) {
        webShopPage.validateProduct(productName);
    }

    @Given("language is set to {string}")
    public void languageIsSetTo(String lang) {
        iChangeTheLanguageTo(lang);
    }

    @When("I change the language to {string}")
    public void iChangeTheLanguageTo(String lang) {
        if (!homePage.getLang().equals(lang)) {
            homePage.changeLang();
        }
    }

    @Then("it shows elements in {string}")
    public void itShowsElementsIn(String lang) {
        assertEquals(lang, homePage.getLang());
    }

    @When("I add an item")
    public void iAddAnItem() {
        webShopPage.addItem();
    }

    @Then("item is displayed in the basket")
    public void itemIsDisplayedInTheBasket() {
        webShopPage.validateBasketIcon();
    }

    @When("I remove an item")
    public void iRemoveAnItem() {
        webShopPage.removeItem();
    }

    @Then("product will disappear from the basket")
    public void productWillDisappearFromTheBasket() {
    }
}

