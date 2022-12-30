package utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Locale;

public class PlaywrightFactory {

    Page page;

    @Parameters({"browserName"})
    @BeforeClass
    public void initPage(String browserName) {
        Playwright playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chrome":
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                page = browser.newPage();

                break;
            case "firefox":

                break;
        }

    }

    public Page getPage() {
        return page;
    }
}
