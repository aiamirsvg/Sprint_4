package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000); // ждать 10 секунд
        driver.quit();
    }
}