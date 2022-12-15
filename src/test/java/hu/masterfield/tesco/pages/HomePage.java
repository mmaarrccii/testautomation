package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static final String COOKIE_ELFOGADASA = "Minden Cookie elfogadása";
    String lang = null;

    SelenideElement buttonCookies = $(byText(COOKIE_ELFOGADASA));

    public void cookieButtonAvailable(){
        buttonCookies.isDisplayed();
        buttonCookies.isEnabled();
    }

    public void acceptCoockies(){
        if (buttonCookies.isDisplayed()) {
            buttonCookies.click();
        }
    }

    public void validateCookiesAccepted() {
        buttonCookies.shouldNotBe(exist);
    }

}