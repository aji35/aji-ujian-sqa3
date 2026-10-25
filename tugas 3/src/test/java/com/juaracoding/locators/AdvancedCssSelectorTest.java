package com.juaracoding.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AdvancedCssSelectorTest extends BaseTest {

    @BeforeMethod(dependsOnMethods = "setUp")
    public void loadPage() {
        openPracticePage();
    }

    @Test(description = "CSS substring matchers: starts-with, ends-with, dan contains")
    public void shouldUseSubstringMatchers() {
        WebElement startsWith = driver.findElement(By.cssSelector("input[name^='user']"));
        WebElement endsWith = driver.findElement(By.cssSelector("input[name$='Email']"));
        WebElement contains = driver.findElement(By.cssSelector("input[name*='serEma']"));

        Assert.assertEquals(startsWith.getAttribute("id"), "user-email");
        Assert.assertEquals(endsWith.getAttribute("id"), "user-email");
        Assert.assertEquals(contains.getAttribute("id"), "user-email");
    }

    @Test(description = "CSS direct child combinator")
    public void shouldUseDirectChildCombinator() {
        WebElement fullName = driver.findElement(By.cssSelector("#registration-form > #full-name"));
        List<WebElement> panelValues = driver.findElements(By.cssSelector("#profile-panel > .value"));

        Assert.assertEquals(fullName.getAttribute("name"), "fullName");
        Assert.assertEquals(panelValues.size(), 1);
        Assert.assertEquals(panelValues.get(0).getText(), "Andi");
    }

    @Test(description = "CSS adjacent sibling combinator")
    public void shouldUseAdjacentSiblingCombinator() {
        WebElement fullName = driver.findElement(By.cssSelector("label[for='full-name'] + input"));
        WebElement summary = driver.findElement(By.cssSelector("#profile-heading + p"));

        Assert.assertEquals(fullName.getAttribute("id"), "full-name");
        Assert.assertEquals(summary.getText(), "Ringkasan profil Andi");
    }

    @Test(description = "CSS pseudo-classes: nth-child, first-child, last-child, checked, dan not")
    public void shouldUsePseudoClasses() {
        WebElement secondSkill = driver.findElement(By.cssSelector("#skill-list li:nth-child(2)"));
        WebElement firstSkill = driver.findElement(By.cssSelector("#skill-list li:first-child"));
        WebElement lastSkill = driver.findElement(By.cssSelector("#skill-list li:last-child"));
        WebElement selectedGender = driver.findElement(By.cssSelector("input[name='gender']:checked"));
        List<WebElement> basicSkills = driver.findElements(
                By.cssSelector("#skill-list li:not([data-level='advanced'])")
        );

        Assert.assertEquals(secondSkill.getText(), "Name");
        Assert.assertEquals(firstSkill.getText(), "ID");
        Assert.assertEquals(lastSkill.getText(), "XPath");
        Assert.assertEquals(selectedGender.getAttribute("value"), "Male");
        Assert.assertEquals(basicSkills.size(), 2);
    }
}
