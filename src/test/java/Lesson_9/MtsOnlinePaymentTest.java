package Lesson_9;

import Configuration.WebDriverUtil;
import Pages.MtsOnlinePaymentPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsOnlinePaymentTest {

    private WebDriver driver;
    private MtsOnlinePaymentPage paymentPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverUtil.createDriver();
        paymentPage = new MtsOnlinePaymentPage(driver);
        paymentPage.open();
        paymentPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        WebDriverUtil.quitDriver(driver);
    }

    @Test
    @Order(1)
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {
        assertTrue(paymentPage.isOnlinePayBlockDisplayed(), "Блок 'Онлайн пополнение' не отображается");
        assertTrue(paymentPage.isBlockTitleCorrect(), "Заголовок не содержит 'Онлайн пополнение' и/или 'без комиссии'");
        System.out.println("Тест 1 пройден: " + paymentPage.getBlockTitle());
    }

    @Test
    @Order(2)
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void testPaymentLogos() {
        assertTrue(paymentPage.arePaymentLogosDisplayed(), "Логотипы платёжных систем не найдены");
        System.out.println("Тест 2 пройден: логотипы найдены");
    }

    @Test
    @Order(3)
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreInfoLink() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(paymentPage.isMoreInfoLinkClickable(), "Ссылка 'Подробнее о сервисе' не кликабельна");
        String linkUrl = paymentPage.getMoreInfoLinkUrl();
        assertNotNull(linkUrl, "URL ссылки не должен быть null");
        assertTrue(linkUrl.contains("/help/poryadok-oplaty"), "URL ссылки не содержит ожидаемый путь. Фактический: " + linkUrl);
        paymentPage.clickMoreInfoLink();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("/help/poryadok-oplaty"));
        String newUrl = driver.getCurrentUrl();
        assertNotEquals(currentUrl, newUrl, "После клика не произошёл переход");
        assertTrue(Objects.requireNonNull(newUrl).contains("/help/poryadok-oplaty"), "Новая страница не содержит ожидаемый путь");
        System.out.println("Тест 3 пройден: переход на " + newUrl);
    }

    @Test
    @Order(4)
    @DisplayName("Заполнение формы и проверка кнопки 'Продолжить'")
    public void testFormSubmission() {
        paymentPage.enterPhoneNumber("297777777");
        paymentPage.enterSum("100");
        assertTrue(paymentPage.isContinueButtonEnabled(), "Кнопка 'Продолжить' не активна");
        paymentPage.clickContinueButton();
        boolean modalVisible = paymentPage.isPaymentModalDisplayed();
        assertTrue(modalVisible, "Модальное окно оплаты не появилось после нажатия 'Продолжить'");
        System.out.println("Тест 4 пройден: формы заполнены, переход в следующее меню осуществлён");
    }
}
