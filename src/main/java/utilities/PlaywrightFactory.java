package utilities;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class PlaywrightFactory {

    Page page;

    @Parameters({"browserName"})
    @BeforeClass
    public void initPage(String browserName) {
        Playwright playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chrome":
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                BrowserContext context = browser.newContext();
                page = context.newPage();

                break;
            case "firefox":

                break;
        }

    }

    public Page getPage() {
        return page;
    }
}
