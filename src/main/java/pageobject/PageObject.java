package pageobject;

import pageobject.pages.GooglePage;
import utilities.PlaywrightFactory;

public class PageObject extends PlaywrightFactory {

    public GooglePage getGooglePage(){
        return new GooglePage(getPage());
    }


}
