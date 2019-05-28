package com.yudakan.perspective_projection.util;

public class Matrix44d {

    public double[][] content = new double[4][4];

    public Matrix44d() {}

    public Matrix44d(double ... els) {
        try {
            int i, j;
            for (i=0; i < content.length; i++)
                for (j=0; j < content.length; j++)
                    content[i][j] = els[i*content.length+j];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }

}
