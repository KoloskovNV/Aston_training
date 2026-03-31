package Lesson10;

import Lesson10.Config.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import Lesson10.Steps.*;

public class BaseTest {

    protected WebDriver driver;
    protected CookiePageSteps cookieSteps;
    protected MtsPaymentPageSteps paymentSteps;
    protected PaymentModalPageSteps modalSteps;
    protected MoreInfoPageSteps moreInfoSteps;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverConfig.getDriver();
        driver.get("https://mts.by");
        cookieSteps = new CookiePageSteps(driver);
        paymentSteps = new MtsPaymentPageSteps(driver);
        modalSteps = new PaymentModalPageSteps(driver);
        moreInfoSteps = new MoreInfoPageSteps(driver);
        cookieSteps.acceptCookies();
    }

    @AfterEach
    void tearDown() {
        WebDriverConfig.quitDriver();
    }
}
