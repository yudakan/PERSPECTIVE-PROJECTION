package com.yudakan.perspective_projection.util.quantum;

public class Vect2i {

    /* Attributes */
    public int x, y;

    /* Constructors */
    public Vect2i() {}

    public Vect2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vect2i(Vect2i v) {
        this.x = v.x;
        this.y = v.y;
    }

    public Vect2i(Vect2d v) {
        this.x = (int)v.x;
        this.y = (int)v.y;
    }

    /* Methods */
    public Vect2i add(Vect2i v) {
        return new Vect2i(x + v.x, y + v.y);
    }

    public Vect2i add(int num) {
        return new Vect2i(x + num, y + num);
    }

    public Vect2i sub(Vect2i v) {
        return new Vect2i(x - v.x, y - v.y);
    }

    public Vect2i sub(int num) {
        return new Vect2i(x - num, y - num);
    }

    public Vect2i scale(int num) {
        return new Vect2i(x * num, y * num);
    }

    public int dot(Vect2i v) {
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
    public Vect2i clone() {
        return new Vect2i(this);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
