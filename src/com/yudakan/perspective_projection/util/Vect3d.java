package com.yudakan.perspective_projection.util;

public class Vect3d {

    /* Atributes */
    public double x, y, z;

    /* Constructors */
    public Vect3d() {}

    public Vect3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vect3d(Vect3d v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public Vect3d(Vect2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    /* Methods */
    public Vect3d add(Vect3d v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    public Vect3d add(double num) {
        x += num;
        y += num;
        z += num;
        return this;
    }

    public Vect3d sub(Vect3d v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    public Vect3d sub(double num) {
        x -= num;
        y -= num;
        z -= num;
        return this;
    }

    public Vect3d scale(double num) {
        x *= num;
        y *= num;
        z *= num;
        return this;
    }

    public Vect3d cross(Vect3d v) {
        double x = this.y*v.z - this.z*v.y;
        double y = this.z*v.x - this.x*v.z;
        double z = this.x*v.y - this.y*v.x;
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public double dot(Vect3d v) {
        return x*v.x + y*v.y + z*v.z;
    }

    public double length() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vect3d normalize() {
        double len = length();
        x = x/len;
        y = y/len;
        z = z/len;
        return this;
    }

    public Vect3d clone() {
        return new Vect3d(this);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", x, y, z);
    }
}
