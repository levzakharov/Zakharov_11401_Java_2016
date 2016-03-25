package ru.kpfu.itis.lzakharov;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lzakharov on 23.02.16.
 */
public class ComplexMatrix2x2Test {
    private static final double EPS = 1e-9;
    private static ApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    public void defaultConstructorShouldCreateZeroMatrix() {
        ComplexMatrix2x2 m = (ComplexMatrix2x2) context.getBean("complexMatrix2x2Zero");

        ComplexNumber cnum = (ComplexNumber) context.getBean("cnum0");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cnum.getIm(), m.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(cnum.getRe(), m.getMatrix()[i][j].getRe(), EPS);
            }
        }

    }

    @Test
    public void constructorWithComplexNumberXInParamsShouldCreateMatrixWhereAllValuesEqX() {
        ComplexNumber cnum = (ComplexNumber) context.getBean("cnum0");
        ComplexMatrix2x2 m = (ComplexMatrix2x2) context.getBean("complexMatrix2x2ZeroConstructor");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cnum.getIm(), m.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(cnum.getRe(), m.getMatrix()[i][j].getRe(), EPS);
            }
        }
    }

    @Test
    public void constructorWithFourComplexNumberShouldWorkCorrect() {
        ComplexNumber cnum0 = (ComplexNumber) context.getBean("cnum0");
        ComplexNumber cnum1 = (ComplexNumber) context.getBean("cnum1");
        ComplexNumber cnum2 = (ComplexNumber) context.getBean("cnum2");
        ComplexNumber cnum3 = (ComplexNumber) context.getBean("cnum3");

        ComplexMatrix2x2 m = (ComplexMatrix2x2) context.getBean("complexMatrix2x2");

        Assert.assertEquals(cnum0.getIm(), m.getMatrix()[0][0].getIm(), EPS);
        Assert.assertEquals(cnum0.getRe(), m.getMatrix()[0][0].getRe(), EPS);
        Assert.assertEquals(cnum1.getIm(), m.getMatrix()[0][1].getIm(), EPS);
        Assert.assertEquals(cnum1.getRe(), m.getMatrix()[0][1].getRe(), EPS);
        Assert.assertEquals(cnum2.getIm(), m.getMatrix()[1][0].getIm(), EPS);
        Assert.assertEquals(cnum2.getRe(), m.getMatrix()[1][0].getRe(), EPS);
        Assert.assertEquals(cnum3.getIm(), m.getMatrix()[1][1].getIm(), EPS);
        Assert.assertEquals(cnum3.getRe(), m.getMatrix()[1][1].getRe(), EPS);
    }

    @Test
    public void methodAddShouldReturnSumOfTwoMatrices() {
        ComplexNumber cnum1 = (ComplexNumber) context.getBean("cnum1");

        ComplexMatrix2x2 ma = (ComplexMatrix2x2) context.getBean("complexMatrix2x2ZeroConstructor");
        ComplexMatrix2x2 mb = (ComplexMatrix2x2) context.getBean("complexMatrix2x2OneConstructor");

        ma = ma.add(mb);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cnum1.getIm(), ma.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(cnum1.getRe(), ma.getMatrix()[i][j].getRe(), EPS);
            }
        }
    }

    @Test
    public void methodMultShouldReturnMultOfTwoMatrices() {
        ComplexNumber zero = (ComplexNumber) context.getBean("cnum0");

        ComplexMatrix2x2 ma = (ComplexMatrix2x2) context.getBean("complexMatrix2x2OneConstructor");
        ComplexMatrix2x2 mb = (ComplexMatrix2x2) context.getBean("complexMatrix2x2ZeroConstructor");

        ma = ma.mult(mb);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(zero.getIm(), ma.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(zero.getRe(), ma.getMatrix()[i][j].getRe(), EPS);
            }
        }

    }

    @Test
    public void methodDetShouldWorkCorrect() {
        ComplexNumber zero = (ComplexNumber) context.getBean("cnum0");

        ComplexMatrix2x2 m = (ComplexMatrix2x2) context.getBean("complexMatrix2x2OneConstructor");

        ComplexNumber det = m.det();

        Assert.assertEquals(zero.getRe(), det.getRe(), EPS);
        Assert.assertEquals(zero.getIm(), det.getIm(), EPS);
    }

    @Test
    public void methodMultVectorShouldWorkCorrect() {
        ComplexNumber cnum = (ComplexNumber) context.getBean("cnum1");

        ComplexVector2D cv = (ComplexVector2D) context.getBean("complexVector2D");

        ComplexMatrix2x2 m = (ComplexMatrix2x2) context.getBean("complexMatrix2x2OneConstructor");

        m.multVector(cv);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cnum.getIm(), m.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(cnum.getRe(), m.getMatrix()[i][j].getRe(), EPS);
            }
        }

    }
}
