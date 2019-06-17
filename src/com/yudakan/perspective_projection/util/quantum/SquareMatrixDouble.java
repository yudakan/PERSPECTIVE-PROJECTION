package com.yudakan.perspective_projection.util.quantum;;

public class SquareMatrixDouble {

    /* Attributes */
    private double[][] me;
    private int order;

    /* Constructors */
    public SquareMatrixDouble() {
        order = 1;
        me = new double[order][order];
    }

    public SquareMatrixDouble(int order, double fill) {
        this.order = order;
        me = new double[order][order];
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < order; j++)
                me[i][j] = fill;
    }

    public SquareMatrixDouble(double ... elements) {
        if ((order = quadratic(elements.length)) == -1)
            throw new IllegalArgumentException("Not quadratic matrix");

        me = new double[order][order];
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < order; j++)
                me[i][j] = elements[i*order+j];
    }

    public SquareMatrixDouble(double[][] arr) {
        int i, j;
        boolean quadratic = true;
        for (i=0; i < arr.length; i++) {
            if (arr.length != arr[i].length) {
                quadratic = false;
                break;
            }
        }
        if (!quadratic)
            throw new IllegalArgumentException("Not quadratic matrix");

        order = arr.length;
        me = new double[order][order];
        for (i=0; i < order; i++)
            for (j=0; j < order; j++)
                me[i][j] = arr[i][j];
    }

    public SquareMatrixDouble(SquareMatrixDouble mx) {
        order = mx.order;
        me = new double[order][order];
        for (int i=0; i < order; i++)
            me[i] = mx.me[i].clone();
    }

    /* Getters & Setters */
    public double get(int i, int j) {
        if (i < order && j < order)
            return me[i][j];
        else
            throw new IllegalArgumentException("Out of rang");
    }

    public void set(int i, int j, double value) {
        if (i < order && j < order)
            me[i][j] = value;
        else
            throw new IllegalArgumentException("Out of rang");
    }

    public int getOrder() {
        return order;
    }

    /* Methods */
    public static int quadratic(int n) {
        double sqrt = Math.sqrt(n);
        if (Math.floor(sqrt) == Math.ceil(sqrt))
            return (int)sqrt;
        else
            return -1;
    }

    public SquareMatrixDouble add(SquareMatrixDouble mx) {
        if (mx.order != order)
            throw new IllegalArgumentException("Not same order");

        SquareMatrixDouble mxNew = new SquareMatrixDouble(this);
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < order; j++)
                mxNew.me[i][j] += mx.me[i][j];

        return mxNew;
    }

    public SquareMatrixDouble add(double num) {
        SquareMatrixDouble mxNew = new SquareMatrixDouble(this);
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < me[i].length; j++)
                mxNew.me[i][j] += num;

        return mxNew;
    }

    public SquareMatrixDouble sub(SquareMatrixDouble mx) {
        if (mx.order != order)
            throw new IllegalArgumentException("Not same order");

        SquareMatrixDouble mxNew = new SquareMatrixDouble(this);
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < me[i].length; j++)
                mxNew.me[i][j] -= mx.me[i][j];

        return mxNew;
    }

    public SquareMatrixDouble sub(double num) {
        SquareMatrixDouble mxNew = new SquareMatrixDouble(this);
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < me[i].length; j++)
                mxNew.me[i][j] -= num;

        return mxNew;
    }

    public SquareMatrixDouble scale(double num) {
        SquareMatrixDouble mxNew = new SquareMatrixDouble(this);
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < order; j++)
                mxNew.me[i][j] *= num;

        return mxNew;
    }

    public SquareMatrixDouble multiply(SquareMatrixDouble mx) {
        if (mx.order != order)
            throw new IllegalArgumentException("Not same order");

        SquareMatrixDouble mxNew = new SquareMatrixDouble(order, 0);
        for (int i=0, j=0, k=0; i < order; i++)
            for (j=0; j < order; j++)

                for (k=0; k < order; k++)
                    mxNew.me[i][j] += me[i][k] * mx.me[k][j];

        return mxNew;
    }

    public SquareMatrixDouble transpose() {
        SquareMatrixDouble transpose = new SquareMatrixDouble(order, 0);
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < order; j++)
                transpose.me[j][i] = me[i][j];

        return transpose;
    }

    public static double adj(SquareMatrixDouble mx, int i, int j) {
        if (i >= mx.order || j >= mx.order)
            throw new IllegalArgumentException("Out of rang");

        return Math.pow(-1, i+j) * det(minor(mx, i, j));
    }

    public static SquareMatrixDouble minor(SquareMatrixDouble mx, int i, int j) {
        if (i >= mx.order || j >= mx.order)
            throw new IllegalArgumentException("Out of rang");

        SquareMatrixDouble minor = new SquareMatrixDouble(mx.order-1, 0);
        int ii, jj;

        for (ii=0; ii < mx.order; ii++)
            for (jj = 0; ii != i && jj < mx.order; jj++)
                if (jj != j)
                    minor.me[ii < i ? ii : ii - 1][jj < j ? jj : jj - 1] = mx.me[ii][jj];

        return minor;
    }

    public static double det(SquareMatrixDouble mx) {
        if (mx.order == 2)
            return mx.me[0][0] * mx.me[1][1] - mx.me[0][1] * mx.me[1][0];

        double det = 0;
        for (int i=0, j=0; i < mx.order; i++)
            det += mx.me[i][j] * adj(mx, i, j);

        return det;
    }

    public SquareMatrixDouble cof() {
        SquareMatrixDouble cofactors = new SquareMatrixDouble(order, 0);
        for (int i=0, j=0; i < order; i++)
            for (j=0; j < order; j++)
                cofactors.me[i][j] = adj(this, i, j);

        return cofactors;
    }

    public SquareMatrixDouble adjMx() {
        return this.cof().transpose();
    }

    public SquareMatrixDouble inverse() {
        return this.adjMx().scale(1.0 / det(this));
    }

    @Override
    public SquareMatrixDouble clone() {
        return new SquareMatrixDouble(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0, j=0; i < order; i++) {
            for (j = 0; j < order; j++) {
                sb.append(me[i][j]);
                sb.append(", ");
            }
            sb.append('\n');
        }

        return sb.delete(sb.length()-3, sb.length()).toString();
    }
}
