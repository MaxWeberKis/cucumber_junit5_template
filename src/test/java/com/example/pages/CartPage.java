package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public CartPage(TestContext context) {
        super(context);
    }
    @FindBy(css = "#checkout")
    public WebElement checkoutButton;


}
