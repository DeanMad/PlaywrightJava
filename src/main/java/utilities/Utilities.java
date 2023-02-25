package utilities;

import com.microsoft.playwright.*;
import io.qameta.allure.Attachment;
import java.nio.file.Paths;


import static org.testng.AssertJUnit.assertTrue;

public class Utilities extends PlaywrightFactory {

    @Attachment (value = "screenshot", type = "image/png")
    public static void takeScreenshots(Page page) {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("test-output/Screenshots/screenshot.png")).setFullPage(true));
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void assertTrueWithScreenshot(Boolean condition, Page page){
        takeScreenshots(page);
          assertTrue(condition);
        }

}


