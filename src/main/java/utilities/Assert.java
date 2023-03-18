package utilities;

import com.microsoft.playwright.Page;
import org.testng.AssertJUnit;
import org.testng.asserts.Assertion;
import static utilities.Utilities.takeScreenshots;

public class Assert extends Assertion {

    Page page;

    public Assert(Page page) {
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
