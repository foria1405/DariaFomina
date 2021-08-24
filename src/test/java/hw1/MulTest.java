package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//4 out of 14 tests has failed. The method public double mult() in library Calculator returns a number
// rounded down to the nearest integer by using the method Math.floor(a*b)

public class MulTest {
    static Calculator calculator = new Calculator();

    @DataProvider
    public static Object[][] doubleMulDataProvider() {
        return new Object[][]{
                {0.0, 0.0},
                {0.0, 365.99},
                {73.1, 0.0},

                {-0.02, 300.0},
                {-10.0, -0.08},
                {0.1, -8500.0},
                {-0.001, -0.001},

                {1.009, 1.009},
                {0.00078, 314.0}

        };
    }

    @DataProvider
    public static Object[][] longMulDataProvider() {
        return new Object[][]{
                {0L, 0L},
                {0L, 36L},
                {72L, 0L},

                {-7L, 6L},
                {7L, -140L},
                {-10L, -800L},
                {-12L, -12L},

                {6L, 4L},
                {10L, 10L}

        };
    }

    @Test(testName = "mulDoubleTest",
            dataProvider = "doubleMulDataProvider")
    public void mulDoubleTest(double a, double b){
        Assert.assertEquals(calculator.mult(a, b), a*b);
    }

    @Test(testName = "mulLongTest",
            dataProvider = "longMulDataProvider")
    public void mulLongTest(long a, long b){
        Assert.assertEquals(calculator.mult(a, b), a*b);
    }
}
