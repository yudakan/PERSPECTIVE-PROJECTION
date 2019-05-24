package com.yudakan.perspective_projection.util;

public class Vect3d {

    public double x, y, z;

    public Vect3d() {}

    public Vect3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vect3d(Vect3d vect) {
        this.x = vect.x;
        this.y = vect.y;
        this.z = vect.z;
    }

    public Vect3d add(Vect3d vect) {
        return new Vect3d(x + vect.x, y + vect.y, z + vect.z);
    }

    public Vect3d add(double num) {
        return new Vect3d(x + num, y + num, z + num);
    }

    public Vect3d sub(Vect3d vect) {
        return new Vect3d(x - vect.x, y - vect.y, z - vect.z);
    }

    public Vect3d sub(double num) {
        return new Vect3d(x - num, y - num, z - num);
    }

    public double dot(Vect3d vect) {
        return x * vect.x + y * vect.y + z * vect.z;
    }

    public Vect3d scale(double num) {
        return new Vect3d(x  * num, y * num, z * num);
    }

    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vect3d normalize() {
        return new Vect3d( x/length(), y/length(), z/length());
    }
}
