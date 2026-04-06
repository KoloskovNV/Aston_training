package Lesson10.Pages;

import org.openqa.selenium.By;

import java.util.Map;

public class MtsPaymentPage {

    public static final Map<String, String> EXPECTED_PLACEHOLDERS = Map.of(
            "Услуги связи", "Номер телефона",
            "Домашний интернет", "Номер абонента",
            "Рассрочка", "Номер счета на 44",
            "Задолженность", "Номер счета на 2073",
            "Email", "E-mail для отправки чека",
            "Сумма", "Сумма"
    );

    public static final By ONLINE_PAY_BLOCK = By.cssSelector("div.pay__wrapper");
    public static final By BLOCK_TITLE = By.xpath("//h2[contains(., 'Онлайн пополнение') and contains(., 'без комиссии')]");
    public static final By PAYMENT_LOGOS = By.cssSelector("div.pay__partners ul li img");
    public static final By MORE_INFO_LINK = By.linkText("Подробнее о сервисе");
    public static final By AMOUNT_INPUT = By.cssSelector("input.total_rub");
    public static final By PHONE_INPUT = By.id("connection-phone");
    public static final By CONTINUE_BUTTON = By.xpath("//form[@id='pay-connection']//button[@type='submit' and contains(text(), 'Продолжить')]");
    public static final By SERVICE_DROPDOWN_BUTTON = By.cssSelector("button.select__header");
    public static final By SERVICE_DROPDOWN_OPTIONS = By.cssSelector("ul.select__list li");

    public static final Map<String, By> SERVICE_FIELDS = Map.of(
            "Услуги связи", By.id("connection-phone"),
            "Домашний интернет", By.id("internet-phone"),
            "Рассрочка", By.id("score-instalment"),
            "Задолженность", By.id("score-arrears")
    );

    public static final Map<String, By> EMAIL_FIELDS = Map.of(
            "Услуги связи", By.id("connection-email"),
            "Домашний интернет", By.id("internet-email"),
            "Рассрочка", By.id("instalment-email"),
            "Задолженность", By.id("arrears-email")
    );

    public static final Map<String, By> AMOUNT_FIELDS = Map.of(
            "Услуги связи", By.id("connection-sum"),
            "Домашний интернет", By.id("internet-sum"),
            "Рассрочка", By.id("instalment-sum"),
            "Задолженность", By.id("arrears-sum")
    );
}







