package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ================= ЛОКАТОРЫ =================

    // Кнопка "Да всё привыкли"
    private By cookieButton = By.id("rcc-confirm-button");

    // Верхняя кнопка "Заказать"
    private By topOrderButton = By.xpath(".//button[text()='Заказать']");

    // Нижняя кнопка "Заказать"
    private By bottomOrderButton =
            By.xpath(".//div[contains(@class,'Home_FinishButton')]//button");

    // ================= МЕТОДЫ =================

    // Принять cookies
    public void acceptCookies() {
        driver.findElement(cookieButton).click();
    }

    // Нажать верхнюю кнопку "Заказать"
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    // Нажать нижнюю кнопку "Заказать"
    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }
}