package com.yudakan.perspective_projection.util.quantum;

public class Vect2d {

    /* Attributes */
    public double x, y;

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

    public Vect2d(Vect2i v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vect2d(Vect3d v) {
        this.x = v.x;
        this.y = v.y;
    }

    /* Methods */
    public Vect2d add(Vect2d v) {
        return new Vect2d(x + v.x, y + v.y);
    }

    public Vect2d add(double num) {
        return new Vect2d(x + num, y + num);
    }

    public Vect2d sub(Vect2d v) {
        return new Vect2d(x - v.x, y - v.y);
    }

    public Vect2d sub(double num) {
        return new Vect2d(x - num, y - num);
    }

    public Vect2d scale(double num) {
        return new Vect2d(x * num, y * num);
    }

    public double dot(Vect2d v) {
        return x*v.x + y*v.y;
    }

    public double length() {
        return Math.sqrt(x*x + y*y);
    }

    public Vect2d normalize() {
        double len = length();
        return new Vect2d(x/len, y/len);
    }

    @Override
    public Vect2d clone() {
        return new Vect2d(this);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
