package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==================== ПЕРВАЯ СТРАНИЦА ====================

    private By nameField = By.xpath("//input[@placeholder='* Имя']");

    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");

    private By addressField =
            By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    private By metroField =
            By.xpath("//input[@placeholder='* Станция метро']");

    private By phoneField =
            By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By nextButton =
            By.xpath("//button[text()='Далее']");

    // ==================== ВТОРАЯ СТРАНИЦА ====================

    private By dateField =
            By.xpath("//input[@placeholder='* Когда привезти самокат']");

    private By rentalPeriod =
            By.className("Dropdown-placeholder");

    private By oneDay =
            By.xpath("//div[text()='сутки']");

    private By blackColor =
            By.id("black");

    private By commentField =
            By.xpath("//input[@placeholder='Комментарий для курьера']");

    private By orderButton =
            By.xpath("//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");

    private By yesButton =
            By.xpath("//button[text()='Да']");

    private By successWindow =
            By.xpath("//div[contains(text(),'Заказ оформлен')]");

    // ==================== ПЕРВАЯ СТРАНИЦА ====================

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterMetro(String metro) {
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroField).sendKeys(Keys.ENTER);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void fillFirstPage(String name,
                              String surname,
                              String address,
                              String metro,
                              String phone) {

        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        enterMetro(metro);
        enterPhone(phone);
        clickNextButton();
    }

    // ==================== ВТОРАЯ СТРАНИЦА ====================

    public void enterDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public void chooseRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(oneDay).click();
    }

    public void chooseBlackColor() {
        driver.findElement(blackColor).click();
    }

    public void enterComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void confirmOrder() {
        driver.findElement(yesButton).click();
    }

    public boolean isOrderCreated() {
        return driver.findElement(successWindow).isDisplayed();
    }

    public void fillSecondPage(String date, String comment) {

        enterDate(date);

        chooseRentalPeriod();

        chooseBlackColor();

        enterComment(comment);

        clickOrderButton();

        confirmOrder();
    }
}