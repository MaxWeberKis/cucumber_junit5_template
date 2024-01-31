package com.example.steps;

import com.example.context.TestContext;
import com.example.pages.MainPage;
import com.example.utils.ConfigurationReader;
import com.example.utils.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleSteps {
    TestContext context;
    StringBuilder logs;

    @Before
    public void beforeMethod() {
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.js = (JavascriptExecutor) context.driver;
        context.driver.get(ConfigurationReader.get("base_url"));
        logs = new StringBuilder();
    }

    @After
    public void afterMethod() {
        Allure.addAttachment("Console log: ", String.valueOf(logs));
        if (context.driver != null) {
            context.driver.quit();
        }
    }

    @BeforeStep
    public void beforeEveryStep() {
        logs.append(context.driver.getCurrentUrl());
    }

    @Given("the user is on the ToDo app homepage")
    public void userOnMainPage() {
        logs.append("Entered main page");
    }

    @When("the user adds a new task with title {string}")
    public void addNewTask(String str1) {
        MainPage mp = new MainPage(context);
        mp.placeEnter.sendKeys(str1);
        mp.buttonPlus.click();
    }
    @Then("the task {string} should appear in the task list")
    public void taskAppearsInTaskList(String str1) {
        assertEquals(str1, new MainPage(context).textNewRecord.getText());
    }

    @When("the user deletes a task")
    public void deleteTask() {
        MainPage mp = new MainPage(context);
        mp.deleteRecord.click();
    }
    @Then("the task list should not contain the deleted task")
    public void listNotContainsDeleted() {
        MainPage mp = new MainPage(context);
        assertEquals("No To Do Available Yet !!", mp.allertNoToDo.getText());
        System.out.println("Запись No To Do проверена");
            try {
                mp.recordAmi.isDisplayed();
            } catch (NoSuchElementException e) {
                System.out.println("Запись удалена. Она не найдена");
            }
        }

    @When("the user edits a task {string} to {string}")
    public void theUserEditsATaskTo(String str4, String str5) {
        MainPage mp = new MainPage(context);
        mp.buttonEditRecordAmi.click();
        mp.editRecord.click();
        mp.editRecord.sendKeys(Keys.COMMAND+"a");
        mp.editRecord.sendKeys(Keys.BACK_SPACE);
        mp.editRecord.sendKeys(str5);
        mp.editRecordConfirm.click();

    }

    @Then("the task list should display {string}")
    public void theTaskListShouldDisplay(String str6) {
        assertEquals(str6, new MainPage(context).newEditedRecord.getText());
    }
}

