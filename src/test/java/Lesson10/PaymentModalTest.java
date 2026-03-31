package Lesson10;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PaymentModalTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "(29)777-77-77, 100",
    })
    @DisplayName("Проверка заполнения телефона и суммы, появления модального окна и его элементов")
    public void testMtsServicePage(String phoneNumber, String amount) {
        paymentSteps
                .fillFieldsAndSubmit(phoneNumber, amount)
                .verifyPaymentDetails();
        System.out.println("Тест 5 пройден: модальное окно и его элементы проверены");
    }
}