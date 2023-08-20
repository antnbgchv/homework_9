package bgchv.antn.tests;

import bgchv.antn.pages.TextBoxPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static bgchv.antn.utils.GenerateTestData.*;
import static bgchv.antn.utils.GenerateTestData.userPermanentAddress;

public class TextBox extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @CsvSource(value = {
            "Homer Simpson, mr.plow@gmail.com, 742 Evergreen Terrace, 742 Evergreen Terrace",
            "Marge Simpson, marjorie_bouvier@gmail.com, 742 Evergreen Terrace, 742 Evergreen Terrace",
            "Bart Simpson, el-barto@gmail.com, 742 Evergreen Terrace, 742 Evergreen Terrace",
            "Lisa Simpson, ladypenelopeariel@gmail.com, 742 Evergreen Terrace, 742 Evergreen Terrace"
    })

    @DisplayName("CsvSourceTest")
    @ParameterizedTest()
    void fillTextBoxCsvSourceTest
            (String fullName, String email, String currentAddress, String permanentAddress) {

        textBoxPage.openPage()
                .setUserName(fullName)
                .setUserEmail(email)
                .setUserCurrentAddress(currentAddress)
                .setUserPermanentAddress(permanentAddress)
                .clickSubmitButton();

        textBoxPage.outputAppearanceCheck()
                .outputNameCheck(fullName)
                .outputEmailCheck(email)
                .outputCurrentAddressCheck(currentAddress)
                .outputPermanentAddressCheck(permanentAddress);

    }

    @CsvFileSource(resources = "/fillTextBoxTestData.csv")
    @DisplayName("CsvFileSourceTest")
    @ParameterizedTest()
    void fillTextBoxFromCsvFileTest
            (String fullName, String email, String currentAddress, String permanentAddress) {

        textBoxPage.openPage()
                .setUserName(fullName)
                .setUserEmail(email)
                .setUserCurrentAddress(currentAddress)
                .setUserPermanentAddress(permanentAddress)
                .clickSubmitButton();

        textBoxPage.outputAppearanceCheck()
                .outputNameCheck(fullName)
                .outputEmailCheck(email)
                .outputCurrentAddressCheck(currentAddress)
                .outputPermanentAddressCheck(permanentAddress);

    }

    static Stream<Arguments> fillTextBoxFromMethodSource() {
        return Stream.of(
                Arguments.of(userFullName, userEmail, userCurrentAddress, userPermanentAddress)
        );
    }

    @MethodSource
    @DisplayName("MethodSourceTest")
    @ParameterizedTest
    void fillTextBoxFromMethodSource
            (String randomUserFullName, String randomUserEmail, String randomUserCurrentAddress, String randomUserPermanentAddress) {

        textBoxPage.openPage()
                .setUserName(randomUserFullName)
                .setUserEmail(randomUserEmail)
                .setUserCurrentAddress(randomUserCurrentAddress)
                .setUserPermanentAddress(randomUserPermanentAddress)
                .clickSubmitButton();

        textBoxPage.outputAppearanceCheck()
                .outputNameCheck(randomUserFullName)
                .outputEmailCheck(randomUserEmail)
                .outputCurrentAddressCheck(randomUserCurrentAddress)
                .outputPermanentAddressCheck(randomUserPermanentAddress);

    }





}