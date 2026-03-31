package Lesson10.Steps;

import Lesson10.Pages.PaymentModalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Lesson10.Pages.PaymentModalPage.IFRAME_LOCATOR;
import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PaymentModalPageSteps extends BaseSteps {

    public PaymentModalPageSteps(WebDriver driver) {
        super(driver);
    }

    public void verifyPaymentDetails() {
        switchToIframe();
        System.out.println("Переключение на iframe прошло успешно");
        verifyPaymentButtonAmount();
        verifyPhoneNumberInModal();
        verifyInputPlaceholders();
        verifyPaymentIconsPresence();
        System.out.println("Все проверки в модальном окне прошли успешно");
    }

    private void verifyInputPlaceholders() {
        getInputValue(PaymentModalPage.CARD_NUMBER_INPUT, "placeholder", PaymentModalPage.CARD_NUMBER_PLACEHOLDER);
        getInputValue(PaymentModalPage.EXPIRY_DATE_INPUT, "placeholder", PaymentModalPage.EXPIRY_DATE_PLACEHOLDER);
        getInputValue(PaymentModalPage.CVC_INPUT, "placeholder", PaymentModalPage.CVC_PLACEHOLDER);
        getInputValue(PaymentModalPage.CARDHOLDER_NAME_INPUT, "placeholder", PaymentModalPage.CARDHOLDER_NAME_PLACEHOLDER);
    }

    private void switchToIframe() {
        wait.until(frameToBeAvailableAndSwitchToIt(IFRAME_LOCATOR));
    }

    private void verifyPaymentButtonAmount() {
        String expectedAmount = String.format("Оплатить %.2f BYN", Double.parseDouble(PaymentModalPage.AMOUNT)).replace(",", ".");
        WebElement button = wait.until(visibilityOfElementLocated(PaymentModalPage.PAY_BUTTON));
        assert button != null;
        String actualAmount = button.getText().replace(",", ".");
        assertEquals(expectedAmount, actualAmount, "Кнопка оплаты должна отображать правильную сумму");
    }

    private void verifyPhoneNumberInModal() {
        WebElement element = wait.until(visibilityOfElementLocated(PaymentModalPage.PHONE_MODAL));
        assert element != null;
        String actualValue = element.getText();
        assertNotNull(actualValue, "Текст элемента не должен быть null");
        assertTrue(actualValue.contains(PaymentModalPage.PHONE_NUMBER),
                "Номер телефона в модальном окне | Ожидалось, что '" + actualValue + "' содержит '" + PaymentModalPage.PHONE_NUMBER + "'");
    }

    public void getInputValue(By locator, String attribute, String description) {
        System.out.println("Поиск элемента: " + description + "...");
        WebElement input = wait.until(visibilityOfElementLocated(locator));
        assert input != null;
        String value = input.getAttribute(attribute);
        System.out.println("Считывание значения прошло успешно: '" + value + "'");
        assertNotNull(value, description + " | Значение атрибута не должно быть null");
    }

    private void verifyPaymentIconsPresence() {
        var elements = wait.until(presenceOfAllElementsLocatedBy(PaymentModalPage.PAYMENT_ICONS));
        assert elements != null;
        System.out.println("Найдено элементов: " + elements.size());
        assertFalse(elements.isEmpty(), "Иконки платёжных систем | Список элементов не должен быть пустым");
    }
}