package Lesson10.Steps;

import Lesson10.Pages.MoreInfoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MoreInfoPageSteps extends BaseSteps {

    public MoreInfoPageSteps(WebDriver driver) {
        super(driver);
    }

    public void verifyPaymentCardTitle() {
        WebElement titleElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(MoreInfoPage.PAYMENT_CARD_TITLE)
        );
        assert titleElement != null;
        String actualText = titleElement.getText();
        assertEquals("Оплата банковской картой", actualText,
                "Заголовок должен содержать 'Оплата банковской картой'");
        System.out.println("Заголовок 'Оплата банковской картой' найден и проверен");
    }
}
