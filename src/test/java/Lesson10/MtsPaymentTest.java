package Lesson10;

import Lesson10.Pages.MoreInfoPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsPaymentTest extends BaseTest {

    @Test
    @Order(1)
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {
        assertTrue(paymentSteps.isOnlinePayBlockDisplayed(), "Блок 'Онлайн пополнение' не отображается");
        assertTrue(paymentSteps.isBlockTitleCorrect(), "Заголовок не содержит ожидаемый текст");
        System.out.println("Тест 1 пройден: " + paymentSteps.getBlockTitle());
    }

    @Test
    @Order(2)
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void testPaymentLogos() {
        assertTrue(paymentSteps.arePaymentLogosDisplayed(), "Логотипы платёжных систем не найдены");
        System.out.println("Тест 2 пройден: логотипы найдены");
    }

    @Test
    @Order(3)
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreInfoLink() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(paymentSteps.isMoreInfoLinkClickable(), "Ссылка 'Подробнее о сервисе' не кликабельна");
        String linkUrl = paymentSteps.getMoreInfoLinkUrl();
        assertNotNull(linkUrl, "URL ссылки не должен быть null");
        assertTrue(linkUrl.contains(MoreInfoPage.HELP_URL_FRAGMENT),
                "URL ссылки не содержит ожидаемый путь. Фактический: " + linkUrl);
        paymentSteps.clickMoreInfoLink();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains(MoreInfoPage.HELP_URL_FRAGMENT));
        String newUrl = driver.getCurrentUrl();
        assertNotEquals(currentUrl, newUrl, "После клика не произошёл переход");
        assertTrue(Objects.requireNonNull(newUrl).contains(MoreInfoPage.HELP_URL_FRAGMENT),
                "Новая страница не содержит ожидаемый путь");
        moreInfoSteps.verifyPaymentCardTitle();
        System.out.println("Тест 3 пройден: переход на " + newUrl + ", заголовок проверен");
    }

    @ParameterizedTest
    @Order(4)
    @ValueSource(strings = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"})
    @DisplayName("Проверка отображения полей и их надписей для услуги")
    public void shouldCheckFieldsForService(String serviceType) {
        paymentSteps.checkFieldsForService(serviceType);
        System.out.println("Тест 4 пройден: проверены поля и их надписи для услуги: " + serviceType);
    }
}