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

    @Parameters({"browserName"})
    @BeforeClass
    public void initPage(String browserName) {
        Playwright playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chrome":
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                Page page = browser.newPage();
                page.navigate("https://www.google.com");
                System.out.println(page.title());
                break;
            case "firefox":

                break;
        }

    }
}
