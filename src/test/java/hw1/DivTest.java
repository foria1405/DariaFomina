package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//3 out of 17 tests has failed. Method public double div() in library Calculator
// does not contain a check for an attempt to divide by zero

public class DivTest {
    static Calculator calculator = new Calculator();

    @DataProvider
    public static Object[][] doubleDivDataProvider() {
        return new Object[][]{
                {0.0, 5.6},
                {-36.6, -4.6},
                {14.1, -7.5},
                {-121.0, 11.1},
                {-0.001, -0.001},
                {0.05, 0.05},
                {90.0, 3.0},
        };
    }

    @DataProvider
    public static Object[][] longDivDataProvider() {
        return new Object[][] {
                {0L, 123L},
                {-75L, -25L},
                {1L, -8L},
                {-210L, 11L},
                {-9L, -9L},
                {14L, 14L},
                {105L, 25L}
        };
    }

    @DataProvider
    public static Object[][] zeroDivisionDataProviderLong() {
        return new Object[][] {
                {0L, 0L},
                {67L, 0L},
                {-67L, 0L}
        };
    }

    @DataProvider
    public static Object[][] zeroDivisionDataProviderDouble() {
        return new Object[][] {
                {0.0, 0.0},
                {12.0, 0.0},
                {-12.0, 0.0},
        };
    }

    @Test(testName = "divDoubleTest",
            dataProvider = "doubleDivDataProvider")
    public void divDoubleTest(double a, double b){
        Assert.assertEquals(calculator.div(a, b), a/b);
    }

    @Test(testName = "divLongTest",
            dataProvider = "longDivDataProvider")
    public void divLongTest(long a, long b){
        Assert.assertEquals(calculator.div(a, b), a/b);
    }

    @Test(testName = "Zero Division Long",
            dataProvider = "zeroDivisionDataProviderLong",
            expectedExceptions = {NumberFormatException.class})
    public void zeroDivisionTestLong(Long a, Long b) {
        calculator.div(a, b);
    }

    //This test has failed.
    // Method public double div() does not contain a check for an attempt to divide by zero
    @Test(testName = "Zero Division Double",
            dataProvider = "zeroDivisionDataProviderDouble",
            expectedExceptions = {NumberFormatException.class})
    public void zeroDivisionTestDouble(double a, double b) {
        calculator.div(a, b);
    }
}
