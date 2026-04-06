package Lesson10.Steps;

import Lesson10.Pages.MtsPaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class MtsPaymentPageSteps extends BaseSteps {

    public MtsPaymentPageSteps(WebDriver driver) {
        super(driver);
    }

    public boolean isOnlinePayBlockDisplayed() {
        try {
            return Objects.requireNonNull(
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MtsPaymentPage.ONLINE_PAY_BLOCK))
            ).isDisplayed();
        } catch (Exception e) {
            System.out.println("Блок оплаты не найден: " + e.getMessage());
            return false;
        }
    }

    public String getBlockTitle() {
        try {
            return Objects.requireNonNull(
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MtsPaymentPage.BLOCK_TITLE))
            ).getText();
        } catch (Exception e) {
            System.out.println("Не удалось получить заголовок: " + e.getMessage());
            return "";
        }
    }

    public boolean isBlockTitleCorrect() {
        String title = getBlockTitle();
        return title.contains("Онлайн пополнение") && title.contains("без комиссии");
    }

    public boolean arePaymentLogosDisplayed() {
        try {
            List<WebElement> logos = wait.until(
                    ExpectedConditions.presenceOfAllElementsLocatedBy(MtsPaymentPage.PAYMENT_LOGOS)
            );
            return !Objects.requireNonNull(logos).isEmpty();
        } catch (Exception e) {
            System.out.println("Логотипы не найдены: " + e.getMessage());
            return false;
        }
    }

    public boolean isMoreInfoLinkClickable() {
        try {
            return Objects.requireNonNull(
                    wait.until(elementToBeClickable(MtsPaymentPage.MORE_INFO_LINK))
            ).isEnabled();
        } catch (Exception e) {
            System.out.println("Ссылка не кликабельна: " + e.getMessage());
            return false;
        }
    }

    public void clickMoreInfoLink() {
        try {
            Objects.requireNonNull(
                    wait.until(elementToBeClickable(MtsPaymentPage.MORE_INFO_LINK))
            ).click();
        } catch (Exception e) {
            System.out.println("Не удалось кликнуть по ссылке: " + e.getMessage());
        }
    }

    public String getMoreInfoLinkUrl() {
        try {
            return Objects.requireNonNull(
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MtsPaymentPage.MORE_INFO_LINK))
            ).getAttribute("href");
        } catch (Exception e) {
            System.out.println("Не удалось получить URL: " + e.getMessage());
            return "";
        }
    }

    public void selectServiceType(String serviceType) {
        try {
            WebElement dropdownButton = wait.until(
                    elementToBeClickable(MtsPaymentPage.SERVICE_DROPDOWN_BUTTON)
            );

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownButton);
            assert dropdownButton != null;
            dropdownButton.click();

            List<WebElement> options = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(MtsPaymentPage.SERVICE_DROPDOWN_OPTIONS)
            );

            assert options != null;
            for (WebElement option : options) {
                if (option.getText().trim().equals(serviceType)) {
                    option.click();
                    System.out.println("Выбрана услуга: " + serviceType);
                    return;
                }
            }
            throw new NoSuchElementException("Опция '" + serviceType + "' не найдена в выпадающем списке!");

        } catch (Exception e) {
            System.out.println("Не удалось выбрать услугу '" + serviceType + "': " + e.getMessage());
        }
    }

    public void checkFieldsForService(String serviceType) {
        selectServiceType(serviceType);
        assertField(MtsPaymentPage.SERVICE_FIELDS.get(serviceType), MtsPaymentPage.EXPECTED_PLACEHOLDERS.get(serviceType));
        assertField(MtsPaymentPage.EMAIL_FIELDS.get(serviceType), MtsPaymentPage.EXPECTED_PLACEHOLDERS.get("Email"));
        assertField(MtsPaymentPage.AMOUNT_FIELDS.get(serviceType), MtsPaymentPage.EXPECTED_PLACEHOLDERS.get("Сумма"));
    }

    private void assertField(By locator, String expectedPlaceholder) {
        String actualPlaceholder = Objects.requireNonNull(
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
        ).getAttribute("placeholder");

        assertEquals(expectedPlaceholder, actualPlaceholder, "Некорректный placeholder для " + locator);
    }

    private void fillField(By locator, String value) {
        WebElement input = wait.until(presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(value);
        String actualValue = input.getAttribute("value");
        assertEquals(value, actualValue, "Поле должно содержать введенное значение");
    }

    public PaymentModalPageSteps fillFieldsAndSubmit(String phoneNumber, String amount) {
        fillField(MtsPaymentPage.PHONE_INPUT, phoneNumber);
        fillField(MtsPaymentPage.AMOUNT_INPUT, amount);
        Objects.requireNonNull(wait.until(elementToBeClickable(MtsPaymentPage.CONTINUE_BUTTON))).click();
        return new PaymentModalPageSteps(driver);
    }
}
