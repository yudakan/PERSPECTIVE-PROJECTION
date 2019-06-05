package com.yudakan.perspective_projection.util;

public class Matrix44d {

    /* Attributes */
    public double[][] content = new double[4][4];

    /* Constructors */
    public Matrix44d() {}

    public Matrix44d(double ... element) {
        if (element.length < content.length*content[0].length)
            throw new IllegalArgumentException("Not enough elements to construct matrix44d");

        int i, j;
        for (i=0; i < content.length; i++)
            for (j=0; j < content[i].length; j++)
                content[i][j] = element[i*content.length+j];
    }

    public Matrix44d(double[][] arr) {
        try {
            int i, j;
            for (i=0; i < content.length; i++)
                for (j=0; j < content[i].length; j++)
                    content[i][j] = arr[i][j];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Not enough elements to construct matrix44d");
        }
    }

    public Matrix44d(Matrix44d mx) {
        content = mx.content.clone();
    }

    /* Methods */
    public Matrix44d add(Matrix44d mx) {
        Matrix44d mxNew = new Matrix44d();

        int i, j;
        for (i=0; i < content.length; i++)
            for (j=0; j < content[i].length; j++)
                mxNew.content[i][j] += mx.content[i][j];

        return mxNew;
    }

    public Matrix44d add(double num) {
        Matrix44d mxNew = new Matrix44d();

        int i, j;
        for (i=0; i < content.length; i++)
            for (j=0; j < content[i].length; j++)
                mxNew.content[i][j] += num;

        return mxNew;
    }

    public Matrix44d sub(Matrix44d mx) {
        Matrix44d mxNew = new Matrix44d();

        int i, j;
        for (i=0; i < content.length; i++)
            for (j=0; j < content[i].length; j++)
                mxNew.content[i][j] -= mx.content[i][j];

        return mxNew;
    }

    public Matrix44d sub(double num) {
        Matrix44d mxNew = new Matrix44d();

        int i, j;
        for (i=0; i < content.length; i++)
            for (j=0; j < content[i].length; j++)
                mxNew.content[i][j] -= num;

        return mxNew;
    }

    public Matrix44d multiply(Matrix44d mx) {
        Matrix44d mxNew = new Matrix44d();

        int i, j, k;
        for (i=0; i < content.length; i++)
            for (j=0; j < content[i].length; j++)

                for (k=0; k < content.length; k++)
                    mxNew.content[i][j] += content[i][k] * mx.content[k][j];

        return mxNew;
    }

    @Override
    public Matrix44d clone() {
        return new Matrix44d(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i, j;
        for (i=0; i < content.length; i++) {
            for (j = 0; j < content[i].length; j++) {
                sb.append(content[i][j]);
                sb.append(", ");
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
