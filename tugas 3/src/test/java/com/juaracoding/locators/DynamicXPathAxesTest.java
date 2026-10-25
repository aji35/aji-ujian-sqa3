package com.juaracoding.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicXPathAxesTest extends BaseTest {

    @BeforeMethod(dependsOnMethods = "setUp")
    public void loadPage() {
        openPracticePage();
    }

    @Test(description = "XPath untuk teks dan atribut dinamis")
    public void shouldLocateDynamicText() {
        WebElement session = driver.findElement(By.xpath(
                "//span[contains(@id, 'session') and starts-with(normalize-space(), 'SESSION-')]"
        ));
        WebElement welcome = driver.findElement(By.xpath(
                "//span[contains(normalize-space(), 'Selamat datang')]"
        ));

        Assert.assertEquals(session.getText(), "SESSION-2026-001");
        Assert.assertTrue(welcome.getText().endsWith("Andi"));
    }

    @Test(description = "XPath dengan kondisi boolean AND dan OR")
    public void shouldUseBooleanConditions() {
        WebElement male = driver.findElement(By.xpath(
                "//input[@name='gender' and @value='Male']"
        ));
        WebElement adminOrManager = driver.findElement(By.xpath(
                "//td[@class='user-role' and (text()='Admin' or text()='Manager')]"
        ));

        Assert.assertTrue(male.isSelected());
        Assert.assertEquals(adminOrManager.getText(), "Admin");
    }

    @Test(description = "XPath following-sibling untuk navigasi baris tabel")
    public void shouldNavigateUsingFollowingSibling() {
        WebElement role = driver.findElement(By.xpath(
                "//td[normalize-space()='Andi']/following-sibling::td[@class='user-role']"
        ));
        WebElement status = driver.findElement(By.xpath(
                "//td[normalize-space()='Andi']/following-sibling::td[@class='user-status']/span"
        ));

        Assert.assertEquals(role.getText(), "Admin");
        Assert.assertEquals(status.getText(), "Aktif");
    }

    @Test(description = "XPath ancestor untuk menemukan konteks baris tabel")
    public void shouldNavigateUsingAncestor() {
        WebElement andiRow = driver.findElement(By.xpath(
                "//td[normalize-space()='Andi']/ancestor::tr"
        ));
        WebElement budiEditButton = driver.findElement(By.xpath(
                "//button[@data-action='edit' and ancestor::tr[td[normalize-space()='Budi']]]"
        ));
        WebElement citraStatus = driver.findElement(By.xpath(
                "//span[ancestor::tr[@data-user-id='103'] and contains(@class, 'status-badge')]"
        ));

        Assert.assertEquals(andiRow.getAttribute("data-user-id"), "101");
        Assert.assertEquals(budiEditButton.getText(), "Ubah Budi");
        Assert.assertEquals(citraStatus.getText(), "Aktif");
    }
}
