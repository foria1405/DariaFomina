package epam.training.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//36 out 36 tests has passed


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
    public static Object[][] zeroDivisionDataProviderDoublePositive() {
        return new Object[][] {
                {9999999.0, 0.0},
                {12.0, 0.0},
                {-1., -0.}

        };
    }

    @DataProvider
    public static Object[][] zeroDivisionDataProviderDoubleNegative() {
        return new Object[][] {
                {-99999999.0, 0.0},
                {-12.0, 0.0},
                {10.3, -0.}

        };
    }

    @DataProvider
    public static Object[][] zeroDivisionDataProviderDoubleNaN() {
        return new Object[][] {
                {0.0, 0.0},
                {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
                {Double.NaN, 0.},
                {Double.NaN, Double.NaN},
                {12.3, Double.NaN},
                {Double.NaN, -13.2},
                {Double.POSITIVE_INFINITY, Double.NaN},
                {Double.NEGATIVE_INFINITY, Double.NaN},
                {Double.NaN, Double.POSITIVE_INFINITY},
                {Double.NaN, Double.NEGATIVE_INFINITY}
        };
    }

    @Test(testName = "divDoubleTest",
            dataProvider = "doubleDivDataProvider")
    public void divDoubleTest(double a, double b) {
        Assert.assertEquals(calculator.div(a, b), a / b);
    }

    @Test(testName = "divLongTest",
            dataProvider = "longDivDataProvider")
    public void divLongTest(long a, long b) {
        Assert.assertEquals(calculator.div(a, b), a / b);
    }

    @Test(testName = "Zero Division Long",
            dataProvider = "zeroDivisionDataProviderLong",
            expectedExceptions = {NumberFormatException.class})
    public void zeroDivisionTestLong(Long a, Long b) {
        calculator.div(a, b);
    }

    @Test(testName = "Positive Zero Division Double",
            dataProvider = "zeroDivisionDataProviderDoublePositive")
    public void zeroDivisionTestDoublePositive(double a, double b) {
        Assert.assertEquals(calculator.div(a, b), Double.POSITIVE_INFINITY);
    }

    @Test(testName = "Negative Zero Division Double",
            dataProvider = "zeroDivisionDataProviderDoubleNegative")
    public void zeroDivisionTestDoubleNegative(double a, double b) {
        Assert.assertEquals(calculator.div(a, b), Double.NEGATIVE_INFINITY);
    }

    @Test(testName = "Negative Zero Division Double",
            dataProvider = "zeroDivisionDataProviderDoubleNaN")
    public void zeroDivisionTestDoubleNaN(double a, double b) {
        Assert.assertEquals(calculator.div(a, b), Double.NaN);
    }
}
