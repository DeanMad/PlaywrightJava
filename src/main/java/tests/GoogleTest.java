package tests;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pageobject.PageObject;

import static utilities.BaseTest.assertion;
import static utilities.Utilities.*;

@Epic("Google tests")
class GoogleTest extends PageObject {

    private String googleUrl = getUserData().getProperty("googleUrl");

    @Test(description = "Google verify header", priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify header")
    @Story("Verify title - google")
    public void verifyTitleGoogle()  {
        getPage().navigate(googleUrl);
        System.out.println(getPage().title());
        assertion.assertTrue(getPage().title().contentEquals("Google"));
    }

    @Test(description = "Google search test", priority = 2, dependsOnMethods = "verifyTitleGoogle")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test searching")
    @Story("Search google")
    public void searchGoogle()  {
        getGooglePage().fillSearchBox("NBA");
        getPage().keyboard().press("Enter");
        sleep(2000);
        assertion.assertTrue(getGooglePage().getNbaSearchTitleLocator().isVisible());
    }


}
