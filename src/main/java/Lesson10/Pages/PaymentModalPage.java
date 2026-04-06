package Lesson10.Pages;


import org.openqa.selenium.By;

public class PaymentModalPage {

    public static final String PHONE_NUMBER = "375297777777";
    public static final String AMOUNT = "100.00";
    public static final String CARD_NUMBER_PLACEHOLDER = "Номер карты";
    public static final String EXPIRY_DATE_PLACEHOLDER = "Срок действия";
    public static final String CVC_PLACEHOLDER = "CVC";
    public static final String CARDHOLDER_NAME_PLACEHOLDER = "Имя держателя";
    public static final By PHONE_MODAL = By.xpath("//span[contains(text(),'Оплата')]");
    public static final By PAY_BUTTON = By.xpath("//button[contains(@class, 'colored')]");
    public static final By PAYMENT_ICONS = By.cssSelector("div.icons-container");
    public static final By IFRAME_LOCATOR = By.cssSelector("iframe[src*='checkout.bepaid.by']");
    public static final By CARD_NUMBER_INPUT = By.xpath("//input[@formcontrolname='creditCard']");
    public static final By EXPIRY_DATE_INPUT = By.xpath("//input[@formcontrolname='expirationDate']");
    public static final By CVC_INPUT = By.xpath("//input[@name='verification_value' and @formcontrolname='cvc']");
    public static final By CARDHOLDER_NAME_INPUT = By.xpath("//input[@formcontrolname='holder']");
}