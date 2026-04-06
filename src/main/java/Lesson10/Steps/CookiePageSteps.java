package Lesson10.Steps;

import Lesson10.Pages.CookiePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

public class CookiePageSteps extends BaseSteps {

    public CookiePageSteps(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(CookiePage.COOKIE_BANNER));
            Objects.requireNonNull(
                    wait.until(ExpectedConditions.elementToBeClickable(CookiePage.COOKIE_ACCEPT_BUTTON))
            ).click();
            System.out.println("Cookie приняты");
        } catch (Exception e) {
            System.out.println("Баннер cookie не обнаружен");
        }
    }
}
