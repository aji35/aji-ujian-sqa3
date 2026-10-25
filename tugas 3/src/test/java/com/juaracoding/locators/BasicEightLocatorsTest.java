package com.juaracoding.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicEightLocatorsTest extends BaseTest {

    @BeforeMethod(dependsOnMethods = "setUp")
    public void loadPage() {
        openPracticePage();
    }

    @Test(description = "Locator 1: By.id")
    public void shouldLocateElementById() {
        WebElement title = driver.findElement(By.id("page-title"));
        Assert.assertEquals(title.getText(), "Latihan Locator Selenium");
    }

    @Test(description = "Locator 2: By.name")
    public void shouldLocateElementByName() {
        WebElement fullName = driver.findElement(By.name("fullName"));
        Assert.assertEquals(fullName.getAttribute("id"), "full-name");
    }

    @Test(description = "Locator 3: By.className")
    public void shouldLocateElementByClassName() {
        WebElement title = driver.findElement(By.className("main-title"));
        Assert.assertEquals(title.getAttribute("data-role"), "heading");
    }

    @Test(description = "Locator 4: By.tagName")
    public void shouldLocateElementByTagName() {
        WebElement heading = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(heading.isDisplayed());
    }

    @Test(description = "Locator 5: By.linkText")
    public void shouldLocateElementByLinkText() {
        WebElement documentation = driver.findElement(By.linkText("Dokumentasi Selenium"));
        Assert.assertEquals(documentation.getAttribute("href").split("#")[1], "documentation");
    }

    @Test(description = "Locator 6: By.partialLinkText")
    public void shouldLocateElementByPartialLinkText() {
        WebElement help = driver.findElement(By.partialLinkText("Bantuan"));
        Assert.assertEquals(help.getAttribute("id"), "help-link");
    }

    @Test(description = "Locator 7: By.cssSelector")
    public void shouldLocateElementByCssSelector() {
        WebElement email = driver.findElement(By.cssSelector("input[data-purpose='customer-email']"));
        Assert.assertEquals(email.getAttribute("name"), "userEmail");
    }

    @Test(description = "Locator 8: By.xpath")
    public void shouldLocateElementByXPath() {
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit-button']"));
        Assert.assertEquals(submit.getText(), "Kirim Formulir");
    }
}
