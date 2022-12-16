package hu.masterfield.tesco.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class WebShopPage {

    SelenideElement buttonGreetings = $(byId("utility-header-greetings"));
    SelenideElement inputSearch = $(byId("search-input"));
    SelenideElement buttonLogout = $(byId("utility-header-logout-link"));
    SelenideElement buttonBasket = $("#mini-trolley > div.sc-ikJyIC.hkPkEY > a > span");
    SelenideElement buttonAdd = $(byText("Hozzáad"));
    SelenideElement buttonRemove = $(byId("delete-single-item mini-tile__delete button-secondary"));

    public WebShopPage search (String productName) {
        inputSearch.clear();
        inputSearch.setValue(productName);
        inputSearch.pressEnter();
        return new WebShopPage();
    }

    public void validateProduct (String productName) {
        SelenideElement product = $(byPartialLinkText(productName));
        product.should(exist);
    }

    public HomePage logout(){
        buttonLogout.click();
        return new HomePage();
    }

    public void validatePage() {
        buttonLogout.shouldBe(visible).shouldBe(enabled);
        buttonGreetings.shouldBe(visible).shouldBe(enabled);
        inputSearch.shouldBe(visible).shouldBe(enabled);
    }

    public void addItem() { buttonAdd.should(exist).click(); }

    public void validateBasketIcon() {
        buttonBasket.should(exist).shouldBe(visible);
    }

    public void validateMissingBasket() {
        buttonBasket.shouldNot(exist);
    }





}