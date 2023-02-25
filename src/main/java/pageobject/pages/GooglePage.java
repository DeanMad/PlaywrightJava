package pageobject.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class GooglePage {

    private Page page;

    public GooglePage(Page page){
        this.page = page;
    }

    public void fillSearchBox(String toSearch){
        page.locator(".gLFyf").fill(toSearch);
    }

    public Locator getNbaSearchTitleLocator(){
        return page.locator("#sports-app > div > div.imso-loa.imso-lhof.QMSMXe.Wrsj9b > div > div > div > div > div.S9Uogc > div.ofy7ae");
    }


}
