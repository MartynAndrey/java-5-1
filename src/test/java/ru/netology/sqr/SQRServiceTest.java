package ru.netology.sqr;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SQRServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"left limit and right limit < 100,10,80,0",
                        "left limit < 100 and right limit = 100,10,100,1",
                        "left limit < 100 and right limit > 100,10,200,5",
                        "left limit < 100 and right limit = 9801,10,9801,90",
                        "left limit < 100 and right limit > 9801,10,10000,90",
                        "left limit = 100 and right limit > 100,100,200,5",
                        "left limit = 100 and right limit = 9801,100,9801,90",
                        "left limit = 100 and right limit > 9801,100,10000,90",
                        "left limit > 100 and right limit > 100,200,300,3",
                        "left limit > 100 and right limit = 9801,200,9801,85",
                        "left limit > 100 and right limit > 9801,200,10000,85",
                        "left limit = 9801 and right limit > 9801,9801,10000,1",
                        "left limit > 9801 and right limit > 9801,9900,10000,0"})
    void sqrInLimitsCount(String testName, int leftLimit, int rightLimit, int expected) {

        SQRService service = new SQRService();

        // вызываем целевой метод:
        int actual = service.sqrInLimitsCount(leftLimit, rightLimit);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
}