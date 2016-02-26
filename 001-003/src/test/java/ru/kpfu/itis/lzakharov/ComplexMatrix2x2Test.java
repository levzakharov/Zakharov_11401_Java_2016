package ru.kpfu.itis.lzakharov;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by lzakharov on 23.02.16.
 */
public class ComplexMatrix2x2Test {
    private static final double EPS = 1e-9;

    @Test
    public void defaultConstructorShouldCreateZeroMatrix() {
        ComplexMatrix2x2 m = new ComplexMatrix2x2();

        ComplexNumber cnum = mock(ComplexNumber.class);
        when(cnum.getIm()).thenReturn(0.0);
        when(cnum.getRe()).thenReturn(0.0);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cnum.getIm(), m.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(cnum.getRe(), m.getMatrix()[i][j].getRe(), EPS);
            }
        }

    }

    @Test
    public void constructorWithComplexNumberXInParamsShouldCreateMatrixWhereAllValuesEqX() {
        ComplexNumber cnum = mock(ComplexNumber.class);
        when(cnum.getIm()).thenReturn(1.0);
        when(cnum.getRe()).thenReturn(1.0);

        ComplexMatrix2x2 m = new ComplexMatrix2x2(cnum);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cnum.getIm(), m.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(cnum.getRe(), m.getMatrix()[i][j].getRe(), EPS);
            }
        }
    }

    @Test
    public void constructorWithFourComplexNumberShouldWorkCorrect() {
        ComplexNumber cnum = mock(ComplexNumber.class);
        when(cnum.getIm()).thenReturn(0.0, 0.0, 1.0, 1.0, 2.0, 2.0, 3.0, 3.0);
        when(cnum.getRe()).thenReturn(0.0, 0.0, 1.0, 1.0, 2.0, 2.0, 3.0, 3.0);

        ComplexMatrix2x2 m = new ComplexMatrix2x2(cnum);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cnum.getIm(), m.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(cnum.getRe(), m.getMatrix()[i][j].getRe(), EPS);
            }
        }
    }

    @Test
    public void methodAddShouldReturnSumOfTwoMatrices() {
        ComplexNumber cnum = mock(ComplexNumber.class);
        ComplexNumber res = mock(ComplexNumber.class);
        when(res.getIm()).thenReturn(0.0, 0.0, 1.0, 1.0, 2.0, 2.0, 3.0, 3.0);
        when(res.getRe()).thenReturn(0.0, 0.0, 1.0, 1.0, 2.0, 2.0, 3.0, 3.0);
        when(cnum.add(any())).thenReturn(res);

        ComplexMatrix2x2 ma = new ComplexMatrix2x2(cnum);
        ComplexMatrix2x2 mb = new ComplexMatrix2x2(cnum);

        ma = ma.add(mb);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(res.getIm(), ma.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(res.getRe(), ma.getMatrix()[i][j].getRe(), EPS);
            }
        }
    }

    @Test
    public void methodMultShouldReturnMultOfTwoMatrices() {
        ComplexNumber zero = mock(ComplexNumber.class);
        when(zero.getIm()).thenReturn(0.0);
        when(zero.getRe()).thenReturn(0.0);
        when(zero.mult(any())).thenReturn(zero);

        ComplexNumber cnum = mock(ComplexNumber.class);
        when(cnum.getIm()).thenReturn(1.0);
        when(cnum.getRe()).thenReturn(1.0);
        when(cnum.mult(zero)).thenReturn(zero);

        ComplexMatrix2x2 ma = new ComplexMatrix2x2(cnum);
        ComplexMatrix2x2 mb = new ComplexMatrix2x2(zero);

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
        ComplexNumber cnum = mock(ComplexNumber.class);
        when(cnum.getIm()).thenReturn(1.0);
        when(cnum.getRe()).thenReturn(1.0);
        when(cnum.sub(any())).thenReturn(cnum);
        when(cnum.mult(any())).thenReturn(cnum);

        ComplexMatrix2x2 m = new ComplexMatrix2x2(cnum);

        ComplexNumber det = m.det();

        Assert.assertEquals(cnum.getRe(), det.getRe(), EPS);
        Assert.assertEquals(cnum.getIm(), det.getIm(), EPS);
    }

    @Test
    public void methodMultVectorShouldWorkCorrect() {
        ComplexNumber cnum = mock(ComplexNumber.class);
        when(cnum.getIm()).thenReturn(1.0);
        when(cnum.getRe()).thenReturn(1.0);
        when(cnum.sub(any())).thenReturn(cnum);
        when(cnum.mult(any())).thenReturn(cnum);

        ComplexVector2D cv = mock(ComplexVector2D.class);
        when(cv.getX()).thenReturn(cnum);
        when(cv.getY()).thenReturn(cnum);

        ComplexMatrix2x2 m = new ComplexMatrix2x2(cnum);

        m.multVector(cv);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assert.assertEquals(cnum.getIm(), m.getMatrix()[i][j].getIm(), EPS);
                Assert.assertEquals(cnum.getRe(), m.getMatrix()[i][j].getRe(), EPS);
            }
        }

    }
}
