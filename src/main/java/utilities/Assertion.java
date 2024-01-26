package utilities;

import com.microsoft.playwright.Page;
import org.testng.AssertJUnit;

import static utilities.Utilities.takeScreenshots;

public class Assertion extends org.testng.asserts.Assertion {

    Page page;

    public Assertion(Page page) {
        this.page = page;
    }

    @Override
    public void assertEquals(String actual, String expected) {
        takeScreenshots(page);
        try {
            AssertJUnit.assertEquals(actual, expected);
        }
        catch (Exception e){
            System.out.println("Expected: "+expected+", actual: "+actual);
        }
    }

    @Override
    public void assertTrue(boolean condition) {
        takeScreenshots(page);
        try {
            AssertJUnit.assertTrue(condition);
        }
        catch (Exception e){
            System.out.println("Assertion is false");
        }
    }

    @Override
    public void assertFalse(boolean condition) {
        takeScreenshots(page);
        try {
            AssertJUnit.assertFalse(condition);
        }
        catch (Exception e){
            System.out.println("Expected false but found true");
        }
    }

}
