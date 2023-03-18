package utilities;

import com.microsoft.playwright.*;

public class PlaywrightFactory extends BaseTest{

    public Page initPage(String browserName) {
        Playwright playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                context = browser.newContext();
                page = context.newPage();
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                context = browser.newContext();
                page = context.newPage();
                break;
        }

        return page;
    }

}
