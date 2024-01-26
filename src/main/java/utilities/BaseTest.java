package utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    PlaywrightFactory playwrightFactory;
    Page page;
    Browser browser;
    BrowserContext context;
    public static Assertion assertion;

    @Parameters({"browserName"})
    @BeforeClass
    public void initTestCases(@Optional("chrome") String browserName){
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initPage(browserName);
        assertion = new Assertion(page);
    }

    public Page getPage() {
        return page;
    }


}
