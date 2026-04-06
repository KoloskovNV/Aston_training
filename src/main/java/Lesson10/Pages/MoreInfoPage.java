package Lesson10.Pages;

import org.openqa.selenium.By;

public class MoreInfoPage {

    public static final String HELP_URL_FRAGMENT = "/help/poryadok-oplaty";
    public static final By PAYMENT_CARD_TITLE = By.xpath("//h3[contains(text(),'Оплата банковской картой')]");
}
