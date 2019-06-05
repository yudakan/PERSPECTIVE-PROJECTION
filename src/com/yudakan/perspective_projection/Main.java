package com.yudakan.perspective_projection;

import com.yudakan.perspective_projection.util.Matrix44d;

public class Main {

    public static void main(String[] args) {

        double[][] arrA = {
                {5, 4, 21, 8},
                {9, 2, 2, 87},
                {41, 1, 0, 7},
                {3, 3, 0, -8}
        };
        Matrix44d mxA = new Matrix44d(arrA);

        double[][] arrB = {
                {9, 4, 87, 1},
                {7, 1, -4, 0},
                {4, 77, 0, 7},
                {6, 3, -1, 8}
        };
        Matrix44d mxB = new Matrix44d(arrB);

        Matrix44d mxC = mxA.multiply(mxB);

        System.out.println(mxC);
    }
}
