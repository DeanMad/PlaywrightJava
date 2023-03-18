package pageobject;

import pageobject.pages.GooglePage;
import utilities.BaseTest;

public class PageObject extends BaseTest {

    public GooglePage getGooglePage(){
        return new GooglePage(getPage());
    }


}
