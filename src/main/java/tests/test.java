package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.PageObject;

class test extends PageObject {

    @Description("Example test")
    @Test
    public void verifyTitleGoogle() {
        getPage().navigate("https://www.google.com");
        System.out.println(getPage().title());
        Assert.assertTrue(getPage().title().contentEquals("Google"), "Expected: Google, Actual: "+getPage().title());
    }
}
