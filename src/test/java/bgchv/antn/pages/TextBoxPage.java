package bgchv.antn.pages;

import bgchv.antn.pages.components.CurrentAddressComponent;
import bgchv.antn.pages.components.SubmitButtonComponent;
import bgchv.antn.pages.components.UserEmailComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    UserEmailComponent userEmailComponent = new UserEmailComponent();
    CurrentAddressComponent currentAddressComponent = new CurrentAddressComponent();
    SubmitButtonComponent submitButtonComponent = new SubmitButtonComponent();

    SelenideElement
            userNameInput = $("#userName"),
            permanentAddressInput = $("#permanentAddress"),
            output = $("#output"),
            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailComponent.setUserEmail(value);

        return this;
    }

    public TextBoxPage setUserCurrentAddress(String value) {
        currentAddressComponent.setCurrentAddress(value);

        return this;
    }

    public TextBoxPage setUserPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }
    public void clickSubmitButton() {
        submitButtonComponent.clickSubmitButton();

    }

    public TextBoxPage outputAppearanceCheck() {
        output.shouldHave(appear);

        return this;
    }

    public TextBoxPage outputNameCheck(String value) {
        outputName.shouldHave(text(value));

        return this;
    }

    public TextBoxPage outputEmailCheck(String value) {
        outputEmail.shouldHave(text(value));

        return this;
    }

    public TextBoxPage outputCurrentAddressCheck(String value) {
        outputCurrentAddress.shouldHave(text(value));

        return this;
    }

    public void outputPermanentAddressCheck(String value) {
        outputPermanentAddress.shouldHave(text(value));

    }

}