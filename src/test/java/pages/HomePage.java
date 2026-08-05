package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.time.Duration;

public class HomePage {

    public static final String HOME_PAGE_URL =
            "https://qa-scooter.praktikum-services.ru/";

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ================= ЛОКАТОРЫ =================

    // Кнопка "Да всё привыкли"
    private final By cookieButton = By.id("rcc-confirm-button");

    // Верхняя кнопка "Заказать"
    private final By topOrderButton =
            By.xpath("//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    // Нижняя кнопка "Заказать"
    private final By bottomOrderButton =
            By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // Вопросы FAQ
    private final By[] questions = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")
    };

    // Ответы FAQ
    private final By[] answers = {
            By.id("accordion__panel-0"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7")
    };

    // ================= МЕТОДЫ =================

    // Принять cookies
    public void acceptCookies() {
        List<WebElement> cookies = driver.findElements(cookieButton);

        if (!cookies.isEmpty()) {
            cookies.get(0).click();
        }
    }

    // Верхняя кнопка "Заказать"
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    // Нижняя кнопка "Заказать"
    public void clickBottomOrderButton() {
        WebElement button = driver.findElement(bottomOrderButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", button);

        button.click();
    }

    // Нажать вопрос FAQ
    public void clickQuestion(int index) {

        WebElement question = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(questions[index]));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", question);

        question.click();
    }

    // Получить текст ответа FAQ
    public String getAnswerText(int index) {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(answers[index]));

        return driver.findElement(answers[index]).getText();
    }
}