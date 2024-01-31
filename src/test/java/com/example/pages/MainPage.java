package com.example.pages;
import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;



public class MainPage extends BasePage {

    @FindBy(css = "#root > div > div > div.Form > input[type=text]")
    public WebElement placeEnter;
    @FindBy(css = "i")
    public WebElement buttonPlus;
    @FindBy(css = "#root > div > div > div.Todo > div:nth-child(1) > p")
    public WebElement textNewRecord;
    @FindBy(xpath = "//p[contains(text(),'Ami')]")
    public WebElement recordAmi;
    @FindBy(css = "#root > div > div > div.alert.alert-success.mt-2")
    public WebElement allertNoToDo;
    @FindBy(xpath = "//p[contains(text(),'Ami')]/following-sibling::*[2]")
    public WebElement deleteRecord;
    @FindBy(css = "#root > div > div > div.Form > input[type=text]")
    public WebElement editRecord;
    @FindBy(css = "#root > div > div > div.Todo > div > i.fa-solid.fa-marker.E")
    public WebElement buttonEditRecordAmi;
    @FindBy(css = "#root > div > div > div.Form > div > i")
    public WebElement editRecordConfirm;
    @FindBy(css = "#root > div > div > div.Todo > div > p")
    public WebElement newEditedRecord;


    public MainPage(TestContext context) {
        super(context);
    }
}
