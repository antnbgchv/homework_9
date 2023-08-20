package bgchv.antn.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CurrentAddressComponent {

    public void setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
    }
}
