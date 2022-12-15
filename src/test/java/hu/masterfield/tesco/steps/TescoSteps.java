package hu.masterfield.tesco.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Selenide.open;

public class TescoSteps {
    @Given("open main page")
    public void openMainPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;

        open("https://bevasarlas.tesco.hu/groceries/hu-HU");
    }

    @Then("I should see the accept cookies button")
    public void iShouldSeeTheAcceptCookiesButton() {

    }
}
