package pageobject.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.Assertion;

import static utilities.BaseTest.assertion;

public class GooglePage extends Assertion {

    private final Page page;

    public GooglePage(Page page){
        super(page);
        this.page = page;
    }

    public void fillSearchBox(String toSearch){
        page.locator(".gLFyf").fill(toSearch);
    }

    public Locator getNbaSearchTitleLocator(){
        return page.locator("//span[text() = 'NBA' and @dir = itr]");
    }

    public void verifyGoogleTitle() {
        assertion.assertTrue(page.title().contentEquals("Google"));
    }

    public void verifyNbaSearchPage() {
        assertion.assertTrue(getNbaSearchTitleLocator().isVisible());
    }
}
