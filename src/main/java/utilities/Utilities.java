package utilities;

import com.microsoft.playwright.*;
import io.qameta.allure.Attachment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;


import static org.testng.AssertJUnit.assertTrue;

public class Utilities extends PlaywrightFactory {

    @Attachment(value = "screenshot", type = "image/png")
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

    public static void assertTrueWithScreenshot(Boolean condition, Page page) {
        takeScreenshots(page);
        assertTrue(condition);
    }

    public static Properties getUserData() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/users.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}


