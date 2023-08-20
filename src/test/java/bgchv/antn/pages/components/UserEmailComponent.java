package bgchv.antn.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class UserEmailComponent {

    public void setUserEmail(String value) {
        $("#userEmail").setValue(value);

    }
}