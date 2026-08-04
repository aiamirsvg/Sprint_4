package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePage {

    public static final String HOME_PAGE_URL =
            "https://qa-scooter.praktikum-services.ru/";

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ================= ЛОКАТОРЫ =================

    // Кнопка "Да всё привыкли"
    private By cookieButton = By.id("rcc-confirm-button");

    // Верхняя кнопка "Заказать"
    private final By topOrderButton =
            By.xpath("//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    // Нижняя кнопка "Заказать"
    private final By bottomOrderButton =
            By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // ================= МЕТОДЫ =================

    // Принять cookies
    public void acceptCookies() {
        driver.findElement(cookieButton).click();
    }

    // Нажать верхнюю кнопку "Заказать"
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        WebElement button = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }
}