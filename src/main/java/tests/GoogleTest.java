package tests;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pageobject.PageObject;
import static utilities.Utilities.*;

class GoogleTest extends PageObject {

    @Test(description = "Verify header", priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify header")
    public void verifyTitleGoogle()  {
        getPage().navigate("https://www.google.com");
        System.out.println(getPage().title());
        assertTrueWithScreenshot(getPage().title().contentEquals("Google"), getPage());
    }

    @Test(description = "Test searching", priority = 2, dependsOnMethods = "verifyTitleGoogle")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test searching")
    public void searchGoogle()  {
        getGooglePage().fillSearchBox("NBA");
        getPage().keyboard().press("Enter");
        sleep(2000);
        assertTrueWithScreenshot(getGooglePage().getNbaSearchTitleLocator().isVisible(), getPage());
    }


}
