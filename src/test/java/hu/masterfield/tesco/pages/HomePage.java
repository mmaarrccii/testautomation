package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static final String COOKIE_ELFOGADASA = "Minden Cookie elfogadása";
    SelenideElement buttonLanguage = $(byId("utility-header-language-switch-link"));
    SelenideElement buttonSignIn = $(byId("utility-header-login-link"));

    SelenideElement buttonCookies = $(byText(COOKIE_ELFOGADASA));


    public void acceptCoockies(){
        if (buttonCookies.exists()) {
            buttonCookies.click();
        }
    }

    public void validateCookiesAccepted() {
        buttonCookies.shouldNotBe(exist);
    }

    public LoginPage openLogin(){
        buttonSignIn.click();
        return new LoginPage();
    }

    public void validatePage() {
        buttonLanguage.shouldBe(visible).shouldBe(enabled);
        buttonSignIn.shouldBe(visible).shouldBe(enabled);
    }

}