package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_COOKIE_BTN = "//button[contains(@id, \"u_0_m_uU\")]";
    public static final String XPATH_CREATE_BTN = "//a[contains(@id, \"u_0_2_0i\")]";

    public static final String XPATH_INPUT_NAME = "//div[contains(@id, \"u_b_b_8f\")]";
    public static final String XPATH_INPUT_LASTNAME = "//div[contains(@id, \"u_b_d_c8\")]";

    public static final String XPATH_BIRTH_DAY_SEL = "//select[contains(@id, \"day\")]";
    public static final String XPATH_BIRTH_MONTH_SEL = "//select[contains(@id, \"month\")]";
    public static final String XPATH_BIRTH_YEAR_SEL = "//select[contains(@id, \"year\")]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/.");

        WebElement cookieButton = driver.findElement(By.xpath(XPATH_COOKIE_BTN));
        cookieButton.click();
        WebElement createBtn = driver.findElement(By.xpath(XPATH_CREATE_BTN));
        createBtn.click();

        WebElement inputFirstname = driver.findElement(By.xpath(XPATH_INPUT_NAME));
        inputFirstname.sendKeys("Katarzyna");
        WebElement inputLastname = driver.findElement(By.xpath(XPATH_INPUT_LASTNAME));
        inputLastname.sendKeys("Nabożny");

        WebElement daySelect = driver.findElement(By.xpath(XPATH_BIRTH_DAY_SEL));
        Select selectBoard1 = new Select(daySelect);
        selectBoard1.selectByIndex(11);
        WebElement monthSelect = driver.findElement(By.xpath(XPATH_BIRTH_MONTH_SEL));
        Select selectBoard2 = new Select(monthSelect);
        selectBoard2.selectByIndex(11);
        WebElement yearSelect = driver.findElement(By.xpath(XPATH_BIRTH_YEAR_SEL));
        Select selectBoard3 = new Select(yearSelect);
        selectBoard3.selectByIndex(28);
    }
}