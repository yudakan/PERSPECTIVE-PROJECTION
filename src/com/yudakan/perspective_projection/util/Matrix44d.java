package com.yudakan.perspective_projection.util;

public class Matrix44d {

    public double[][] content = new double[4][4];

    public Matrix44d() {}

    public Matrix44d(double a, double b, double c, double d, double e, double f, double g, double h, double i, double j, double k, double l, double m, double n, double o, double p) {
        content[0][0] = a;
        content[0][1] = b;
        content[0][2] = c;
        content[0][3] = d;
        content[1][0] = e;
        content[1][1] = f;
        content[1][2] = g;
        content[1][3] = h;
        content[2][0] = i;
        content[2][1] = j;
        content[2][2] = k;
        content[2][3] = l;
        content[3][0] = m;
        content[3][1] = n;
        content[3][2] = o;
        content[3][3] = p;
    }

    public Matrix44d(Matrix44d mtrx) {
        content[0][0] = mtrx.content[0][0];
        content[0][1] = mtrx.content[0][1];
        content[0][2] = mtrx.content[0][2];
        content[0][3] = mtrx.content[0][3];
        content[1][0] = mtrx.content[1][0];
        content[1][1] = mtrx.content[1][1];
        content[1][2] = mtrx.content[1][2];
        content[1][3] = mtrx.content[1][3];
        content[2][0] = mtrx.content[2][0];
        content[2][1] = mtrx.content[2][1];
        content[2][2] = mtrx.content[2][2];
        content[2][3] = mtrx.content[2][3];
        content[3][0] = mtrx.content[3][0];
        content[3][1] = mtrx.content[3][1];
        content[3][2] = mtrx.content[3][2];
        content[3][3] = mtrx.content[3][3];
    }

    public Matrix44d(double[][] arr) throws ArrayIndexOutOfBoundsException {
        content[0][0] = arr[0][0];
        content[0][1] = arr[0][1];
        content[0][2] = arr[0][2];
        content[0][3] = arr[0][3];
        content[1][0] = arr[1][0];
        content[1][1] = arr[1][1];
        content[1][2] = arr[1][2];
        content[1][3] = arr[1][3];
        content[2][0] = arr[2][0];
        content[2][1] = arr[2][1];
        content[2][2] = arr[2][2];
        content[2][3] = arr[2][3];
        content[3][0] = arr[3][0];
        content[3][1] = arr[3][1];
        content[3][2] = arr[3][2];
        content[3][3] = arr[3][3];
    }

}
