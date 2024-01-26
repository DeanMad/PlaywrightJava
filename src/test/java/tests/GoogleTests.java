package tests;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pageobject.PageObject;
import utilities.Utilities;

@Epic("Google tests")
class GoogleTests extends PageObject {

    private final String googleUrl = Utilities.getUserData().getProperty("googleUrl");

    @Story("Go to Google")
    @Test(description = "Go to Google", priority = 1)
    public void goToGoogle()  {
        getPage().navigate(googleUrl);
        getGooglePage().verifyGoogleTitle();
    }

    @Story("Search google")
    @Test(description = "Google search test", priority = 2, dependsOnMethods = "goToGoogle")
    public void searchGoogle()  {
        getGooglePage().fillSearchBox("NBA");
        getPage().keyboard().press("Enter");
        getGooglePage().verifyNbaSearchPage();
    }


}
