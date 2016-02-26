package ru.kpfu.itis.lzakharov;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by lzakharov on 23.02.16.
 */

public class Matrix2x2Test {
    private static final double EPS = 1e-9;

    @Test
    public void constructorWithOneParamShouldWorkCorrect() {
        Matrix2x2 m = new Matrix2x2(8);

        double[][] check = {{8, 8}, {8, 8}};

        Assert.assertArrayEquals(check, m.matrix);

    }

    @Test
    public void constructorWithNoParamsShouldCreateMatrixWithZeroValues() {
        Matrix2x2 m = new Matrix2x2();

        double[][] check = {{0, 0}, {0, 0}};

        Assert.assertArrayEquals(check, m.matrix);
    }

    @Test
    public void constructorWithFourParamsShouldWorkCorrect() {
        Matrix2x2 m = new Matrix2x2(1, 2, 4, 8);

        double[][] check = {{1, 2}, {4, 8}};

        Assert.assertArrayEquals(check, m.matrix);
    }

    @Test
    public void constructorWithTwoDimensionalArrayShouldWorkCorrect() {
        double[][] check = {{1, 2}, {4, 8}};
        Matrix2x2 m = new Matrix2x2(check);

        Assert.assertArrayEquals(check, m.matrix);
    }

    @Test
    public void methodAddShouldWorkCorrectAndReturnCorrectRes() {
        double[][] a = {{1, 1}, {1, 1}};
        double[][] b = {{2, 2}, {2, 2}};
        double[][] res = {{3, 3}, {3, 3}};

        Matrix2x2 ma = new Matrix2x2(a);
        Matrix2x2 mb = new Matrix2x2(b);
        Matrix2x2 mres = ma.add(mb);

        Assert.assertArrayEquals(res, mres.matrix);
    }

    @Test
    public void methodAdd2ShouldWorkCorrect() {
        double[][] a = {{1, 1}, {1, 1}};
        double[][] b = {{2, 2}, {2, 2}};
        double[][] res = {{3, 3}, {3, 3}};

        Matrix2x2 ma = new Matrix2x2(a);
        Matrix2x2 mb = new Matrix2x2(b);
        ma.add2(mb);

        Assert.assertArrayEquals(res, ma.matrix);
    }

    @Test
    public void methodSubShouldWorkCorrectAndReturnCorrectRes() {
        double[][] a = {{1, 1}, {1, 1}};
        double[][] b = {{2, 2}, {2, 2}};
        double[][] res = {{1, 1}, {1, 1}};

        Matrix2x2 ma = new Matrix2x2(a);
        Matrix2x2 mb = new Matrix2x2(b);
        Matrix2x2 mres = mb.sub(ma);

        Assert.assertArrayEquals(res, mres.matrix);
    }

    @Test
    public void methodSub2ShouldWorkCorrect() {
        double[][] a = {{1, 1}, {1, 1}};
        double[][] b = {{2, 2}, {2, 2}};
        double[][] res = {{1, 1}, {1, 1}};

        Matrix2x2 ma = new Matrix2x2(a);
        Matrix2x2 mb = new Matrix2x2(b);
        mb.sub2(ma);

        Assert.assertArrayEquals(res, mb.matrix);
    }

    @Test
    public void methodMultNumberShouldWorkCorrectAndReturnCorrectRes() {
        double[][] a = {{1, 2}, {4, 8}};
        double k = 2;
        double[][] res  = {{2, 4}, {8, 16}};

        Matrix2x2 m = new Matrix2x2(a);
        Matrix2x2 mres = m.multNumber(k);

        Assert.assertArrayEquals(res, mres.matrix);
    }

    @Test
    public void methodMultNumber2ShouldWorkCorrect() {
        double[][] a = {{1, 2}, {4, 8}};
        double k = 2;
        double[][] res  = {{2, 4}, {8, 16}};

        Matrix2x2 m = new Matrix2x2(a);
        m.multNumber2(k);

        Assert.assertArrayEquals(res, m.matrix);
    }


    @Test
    public void methodMultShouldWorkCorrectAndReturnCorrectRes() {
        double[][] a = {{2, -3}, {4, -6}};
        double[][] b = {{9, -6}, {6, -4}};

        Matrix2x2 ma = new Matrix2x2(a);
        Matrix2x2 mb = new Matrix2x2(b);
        Matrix2x2 mres = ma.mult(mb);

        Assert.assertArrayEquals((new Matrix2x2()).matrix, mres.matrix);
    }

    @Test
    public void methodMult2ShouldWorkCorrect() {
        double[][] a = {{2, -3}, {4, -6}};
        double[][] b = {{9, -6}, {6, -4}};

        Matrix2x2 ma = new Matrix2x2(a);
        Matrix2x2 mb = new Matrix2x2(b);

        ma.mult2(mb);

        Assert.assertArrayEquals((new Matrix2x2()).matrix, ma.matrix);
    }

    @Test
    public void methodDetShouldWorkCorrect() {
        double[][] a = {{1, 2}, {4, 8}};
        Matrix2x2 ma = new Matrix2x2(a);

        Assert.assertEquals(0, ma.det(), EPS);
    }

    @Test
    public void methodTransponShouldWorkCorrect() {
        double[][] a = {{1, 2}, {4, 8}};
        double[][] tr = {{1, 4}, {2, 8}};
        Matrix2x2 ma = new Matrix2x2(a);
        ma.transpon();

        Assert.assertArrayEquals(tr, ma.matrix);
    }

    @Test
    public void methodInverseMatrixShouldPrintErrorAndReturnZeroMatrixIfDetEqZero() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double[][] a = {{1, 2}, {4, 8}};
        Matrix2x2 ma = new Matrix2x2(a);

        Matrix2x2 mres = ma.inverseMatrix();
        Assert.assertEquals("Error", out.toString().trim());
        Assert.assertArrayEquals(new Matrix2x2().matrix, mres.matrix);
    }

    @Test
    public void methodInverseMatrixShouldReturnInvertedMatrixIfDetNotEqZero() {
        double[][] a = {{7, 4}, {5, 3}};
        double[][] res = {{3, -4}, {-5, 7}};
        Matrix2x2 ma = new Matrix2x2(a);
        Matrix2x2 mres = ma.inverseMatrix();

        Assert.assertArrayEquals(res, mres.matrix);
    }

    @Test
    public void methodEquivalentDiagonalShouldWorkCorrect() {
        double[][] a = {{1, 2}, {4, 8}};
        Matrix2x2 ma = new Matrix2x2(a);
        ma = ma.equivalentDiagonal();

        Assert.assertArrayEquals(new Matrix2x2().matrix, ma.matrix);
    }

    @Test
    public void methodMultVectorShouldWorkCorrect() {
        Vector2D v = new Vector2D(2, 2);
        double[][] a = {{1, 2}, {4, 8}};
        Matrix2x2 ma = new Matrix2x2(a);
        Vector2D res = ma.multVector(v);

        Assert.assertEquals(10, res.getX(), EPS);
        Assert.assertEquals(20, res.getY(), EPS);

    }
}
