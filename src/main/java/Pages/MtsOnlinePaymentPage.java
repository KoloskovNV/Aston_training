package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class MtsOnlinePaymentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By cookieBanner = By.cssSelector("div.cookie__wrapper");
    private final By cookieAcceptButton = By.id("cookie-agree");
    private final By onlinePayBlock = By.cssSelector("div.pay__wrapper");
    private final By blockTitle = By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]");
    private final By paymentLogos = By.cssSelector("div.pay__partners ul li img");
    private final By moreInfoLink = By.linkText("Подробнее о сервисе");
    private final By phoneInput = By.id("connection-phone");
    private final By sumInput = By.id("connection-sum");
    private final By continueButton = By.xpath("//form[@id='pay-connection']//button[@type='submit' and contains(text(), 'Продолжить')]");
    private final By iframeLocator = By.cssSelector("iframe[src*='checkout.bepaid.by']");
    private final By paymentModal = By.cssSelector("app-payment-container, section.payment-page");

    public MtsOnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://mts.by");
    }

    public void acceptCookies() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.presenceOfElementLocated(cookieBanner));
            System.out.println("Обнаружен баннер cookie");
            Objects.requireNonNull(shortWait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton))).click();
            System.out.println("Cookie приняты");
        } catch (Exception e) {
            System.out.println("Баннер cookie не обнаружен");
        }
    }

    public boolean isOnlinePayBlockDisplayed() {
        try {
            return Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(onlinePayBlock))).isDisplayed();
        } catch (Exception e) {
            System.out.println("Блок оплаты не найден: " + e.getMessage());
            return false;
        }
    }

    public String getBlockTitle() {
        try {
            WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle));
            return Objects.requireNonNull(titleElement).getText();
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
            List<WebElement> logos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(paymentLogos));
            return !Objects.requireNonNull(logos).isEmpty();
        } catch (Exception e) {
            System.out.println("Логотипы не найдены: " + e.getMessage());
            return false;
        }
    }

    public boolean isMoreInfoLinkClickable() {
        try {
            return Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink))).isEnabled();
        } catch (Exception e) {
            System.out.println("Ссылка не кликабельна: " + e.getMessage());
            return false;
        }
    }

    public void clickMoreInfoLink() {
        try {
            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(moreInfoLink))).click();
        } catch (Exception e) {
            System.out.println("Не удалось кликнуть по ссылке: " + e.getMessage());
        }
    }

    public String getMoreInfoLinkUrl() {
        try {
            WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(moreInfoLink));
            return Objects.requireNonNull(link).getAttribute("href");
        } catch (Exception e) {
            System.out.println("Не удалось получить URL: " + e.getMessage());
            return "";
        }
    }

    public void enterPhoneNumber(String phone) {
        try {
            WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
            Objects.requireNonNull(phoneField).clear();
            phoneField.sendKeys(phone);
        } catch (Exception e) {
            System.out.println("Не удалось ввести номер: " + e.getMessage());
        }
    }

    public void enterSum(String sum) {
        try {
            WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput));
            Objects.requireNonNull(sumField).clear();
            sumField.sendKeys(sum);
        } catch (Exception e) {
            System.out.println("Не удалось ввести сумму: " + e.getMessage());
        }
    }

    public boolean isContinueButtonEnabled() {
        try {
            return Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(continueButton))).isEnabled();
        } catch (Exception e) {
            System.out.println("Кнопка не активна: " + e.getMessage());
            return false;
        }
    }

    public void clickContinueButton() {
        try {
            Objects.requireNonNull(wait.until(ExpectedConditions.elementToBeClickable(continueButton))).click();
        } catch (Exception e) {
            System.out.println("Не удалось кликнуть по кнопке: " + e.getMessage());
        }
    }

    public boolean isPaymentModalDisplayed() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
            boolean found = Objects.requireNonNull(wait.until(ExpectedConditions.visibilityOfElementLocated(paymentModal)))
                    .isDisplayed();
            driver.switchTo().defaultContent();
            return found;
        } catch (Exception e) {
            driver.switchTo().defaultContent();
            System.out.println("Модальное окно не найдено: " + e.getMessage());
            return false;
        }
    }
}

