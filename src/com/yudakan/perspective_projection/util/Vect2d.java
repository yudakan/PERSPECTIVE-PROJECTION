package com.yudakan.perspective_projection.util;

public class Vect2d {

    /* Atributes */
    public double x, y, z;

    /* Constructors */
    public Vect2d() {}

    public Vect2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vect2d(Vect2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vect2d(Vect3d v) {
        this.x = v.x;
        this.y = v.y;
    }

    /* Methods */
    public Vect2d add(Vect2d v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public Vect2d add(double num) {
        x += num;
        y += num;
        return this;
    }

    public Vect2d sub(Vect2d v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    public Vect2d sub(double num) {
        x -= num;
        y -= num;
        return this;
    }

    public Vect2d scale(double num) {
        x *= num;
        y *= num;
        return this;
    }

    public double dot(Vect2d v) {
        return x*v.x + y*v.y;
    }

    public double length() {
        return Math.sqrt(x*x + y*y);
    }

    public Vect2d normalize() {
        double len = length();
        x = x/len;
        y = y/len;
        return this;
    }

    public Vect2d clone() {
        return new Vect2d(this);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
