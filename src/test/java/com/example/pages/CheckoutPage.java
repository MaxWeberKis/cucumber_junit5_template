package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    public CheckoutPage(TestContext context) {
        super(context);
    }
    @FindBy(css= "#first-name")
    public WebElement firstName;
    @FindBy(css= "#last-name")
    public WebElement lastName;
    @FindBy(css= "#postal-code")
    public WebElement zip;

}
