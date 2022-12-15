package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static final String COOKIE_ELFOGADASA = "Minden Cookie elfogadása";

    SelenideElement buttonCookies = $(byText(COOKIE_ELFOGADASA));

    public void cookieButtonAvailable(){
        buttonCookies.isEnabled();
    }

    public void acceptCoockies(){
        if (buttonCookies.isEnabled()) {
            buttonCookies.click();
        }
    }

    public void validateCookiesAccepted() {
        buttonCookies.shouldNotBe(exist);
    }

}