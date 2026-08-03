package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;
import pages.OrderPage;
import utils.BaseTest;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;

    public OrderTest(String name,
                     String surname,
                     String address,
                     String metro,
                     String phone) {

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {
                        "Айман",
                        "Амирханова",
                        "Астана",
                        "Преображенская площадь",
                        "87771234567"
                },
                {
                        "Иван",
                        "Иванов",
                        "Москва",
                        "Черкизовская",
                        "89991234567"
                }
        };
    }

    @Test
    public void createOrderTest() {

        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);

        // принять cookies
        homePage.acceptCookies();

        // нажать верхнюю кнопку "Заказать"
        homePage.clickTopOrderButton();;

        // заполнить первую страницу
        orderPage.fillFirstPage(
                name,
                surname,
                address,
                metro,
                phone
        );

        // заполнить вторую страницу
        orderPage.fillSecondPage(
                "05.08.2026",
                "Автотест"
        );

        // проверить успешное оформление
        assertTrue(orderPage.isOrderCreated());
    }
}