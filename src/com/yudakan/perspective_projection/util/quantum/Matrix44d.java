//package com.yudakan.perspective_projection.util.quantum;
//
//import java.util.Arrays;
//
//public class Matrix44d {
//
//    /* Attributes */
//    public double[][] content = new double[4][4];
//
//    /* Constructors */
//    public Matrix44d() {}
//
//    public Matrix44d(double ... element) {
//        if (element.length < content.length*content[0].length)
//            throw new IllegalArgumentException("Not enough elements to construct matrix44d");
//
//        int i, j;
//        for (i=0; i < content.length; i++)
//            for (j=0; j < content[i].length; j++)
//                content[i][j] = element[i*content.length+j];
//    }
//
//    public Matrix44d(double[][] arr) {
//        try {
//            int i, j;
//            for (i=0; i < content.length; i++)
//                for (j=0; j < content[i].length; j++)
//                    content[i][j] = arr[i][j];
//        }
//        catch (ArrayIndexOutOfBoundsException e) {
//            throw new IllegalArgumentException("Not enough elements to construct matrix44d");
//        }
//    }
//
//    public Matrix44d(Matrix44d mx) {
//        content = mx.content.clone();
//    }
//
//    /* Methods */
//    public Matrix44d add(Matrix44d mx) {
//        Matrix44d mxNew = new Matrix44d();
//
//        int i, j;
//        for (i=0; i < content.length; i++)
//            for (j=0; j < content[i].length; j++)
//                mxNew.content[i][j] += mx.content[i][j];
//
//        return mxNew;
//    }
//
//    public Matrix44d add(double num) {
//        Matrix44d mxNew = new Matrix44d();
//
//        int i, j;
//        for (i=0; i < content.length; i++)
//            for (j=0; j < content[i].length; j++)
//                mxNew.content[i][j] += num;
//
//        return mxNew;
//    }
//
//    public Matrix44d sub(Matrix44d mx) {
//        Matrix44d mxNew = new Matrix44d();
//
//        int i, j;
//        for (i=0; i < content.length; i++)
//            for (j=0; j < content[i].length; j++)
//                mxNew.content[i][j] -= mx.content[i][j];
//
//        return mxNew;
//    }
//
//    public Matrix44d sub(double num) {
//        Matrix44d mxNew = new Matrix44d();
//
//        int i, j;
//        for (i=0; i < content.length; i++)
//            for (j=0; j < content[i].length; j++)
//                mxNew.content[i][j] -= num;
//
//        return mxNew;
//    }
//
//    public Matrix44d multiply(Matrix44d mx) {
//        Matrix44d mxNew = new Matrix44d();
//
//        int i, j, k;
//        for (i=0; i < content.length; i++)
//            for (j=0; j < content[i].length; j++)
//
//                for (k=0; k < content.length; k++)
//                    mxNew.content[i][j] += content[i][k] * mx.content[k][j];
//
//        return mxNew;
//    }
//
//    public Matrix44d transpose() {
//        Matrix44d transpose = new Matrix44d();
//
//        for (int i=0; i < content.length; i++)
//            for (int j=0; j < content[i].length; j++)
//                transpose.content[j][i] = content[i][j];
//
//        return transpose;
//    }
//
//    public double adj(double[][] mx, int i, int j) {
//        return Math.pow(-1, i+j) * det(minor(mx, i, j));
//    }
//
//    public double[][] minor(double[][] mx, int i, int j) {
//        double[][] minor = new double[mx.length-1][mx.length-1];
//        int ii, jj;
//
//        for (ii=0; ii < mx.length; ii++)
//            for (jj = 0; ii != i && jj < mx.length; jj++)
//                if (jj != j)
//                    minor[ii < i ? ii : ii - 1][jj < j ? jj : jj - 1] = mx[ii][jj];
//
//        return minor;
//    }
//
//    public double det(double[][] mx) {
//        if (mx.length == 2)
//            return mx[0][0] * mx[1][1] - mx[0][1] * mx[1][0];
//
//        double det = 0;
//        for (int i=0, j=0; i < mx.length; i++)
//            det += mx[i][j] * adj(mx, i, j);
//
//        return det;
//    }
//
//    private static double[][] inverse(double[][] matrix) {
//        double[][] inverse = new double[matrix.length][matrix.length];
//
//        // minors and cofactors
//        for (int i = 0; i < matrix.length; i++)
//            for (int j = 0; j < matrix[i].length; j++)
//                inverse[i][j] = Math.pow(-1, i + j)
//                        * det(minor(matrix, i, j));
//
//        // adjugate and determinant
//        double det = 1.0 / det(matrix);
//        for (int i = 0; i < inverse.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                double temp = inverse[i][j];
//                inverse[i][j] = inverse[j][i] * det;
//                inverse[j][i] = temp * det;
//            }
//        }
//
//        return inverse;
//    }
//
//    @Override
//    public Matrix44d clone() {
//        return new Matrix44d(this);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        int i, j;
//        for (i=0; i < content.length; i++) {
//            for (j = 0; j < content[i].length; j++) {
//                sb.append(content[i][j]);
//                sb.append(", ");
//            }
//            sb.append('\n');
//        }
//
//        return sb.delete(sb.length()-3, sb.length()).toString();
//    }
//}
