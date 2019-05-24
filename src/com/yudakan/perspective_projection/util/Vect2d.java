package com.yudakan.perspective_projection.util;

public class Vect2d {

    public double x, y;

    public Vect2d() {}

    public Vect2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vect2d(Vect2d vect) {
        this.x = vect.x;
        this.y = vect.y;
    }

    public Vect2d add(Vect2d vect) {
        return new Vect2d(x + vect.x, y + vect.y);
    }

    public Vect2d add(double num) {
        return new Vect2d(x + num, y + num);
    }

    public Vect2d sub(Vect2d vect) {
        return new Vect2d(x - vect.x, y - vect.y);
    }

    public Vect2d sub(double num) {
        return new Vect2d(x - num, y - num);
    }

    public double dot(Vect2d vect) {
        return x * vect.x + y * vect.y;
    }

    public Vect2d scale(double num) {
        return new Vect2d(x  * num, y * num);
    }

    public double length() {
        return Math.sqrt(x*x + y*y);
    }

    public Vect2d normalize() {
        return new Vect2d( x/length(), y/length());
    }
}
