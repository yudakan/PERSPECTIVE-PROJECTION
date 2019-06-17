package com.yudakan.perspective_projection.util.quantum;

public class Vector {

    /* Attributes */
    private double[] me;
    private int dim;

    /* Constructors */
    public Vector() {
        dim = 1;
        me = new double[dim];
    }

    public Vector(int dim, int fill) {
        this.dim = dim;
        me = new double[dim];
        for (int i=0; i < dim; i++)
            me[i] = fill;
    }

    public Vector(double ... elements) {
        dim = elements.length;
        me = elements.clone();
    }

    public Vector(Vector v) {
        dim = v.me.length;
        me = v.me.clone();
    }

    /* Methods */
    public Vector add(Vector v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimule");

        Vector u = new Vector(this);
        for (int i=0; i < dim; i++)
            u.me[i] += v.me[i];

        return u;
    }

    public Vector add(double num) {
        Vector u = new Vector(this);
        for (int i=0; i < dim; i++)
            u.me[i] += num;

        return u;
    }

    public Vector sub(Vector v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimule");

        Vector u = new Vector(this);
        for (int i=0; i < dim; i++)
            u.me[i] -= v.me[i];

        return u;
    }

    public Vector sub(double num) {
        Vector u = new Vector(this);
        for (int i=0; i < dim; i++)
            u.me[i] -= num;

        return u;
    }

    public Vector scale(double num) {
        Vector u = new Vector(this);
        for (int i=0; i < dim; i++)
            u.me[i] *= num;

        return u;
    }

    public Vector cross(Vector v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimule");
        else if (dim != 3)
            throw new IllegalArgumentException("Cross product just lives in three-dimensional space, not "+dim+"d space");

        double x = me[1]*v.me[2] - me[2]*v.me[1];
        double y = me[2]*v.me[0] - me[0]*v.me[2];
        double z = me[0]*v.me[1] - me[1]*v.me[0];
        return new Vector(x, y, z);
    }

    public double dot(Vector v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimule");

        double sum = 0;
        for (int i=0; i < dim; i++)
            sum += me[i] * v.me[i];

        return sum;
    }

    public double length() {
        double sum = 0;
        for (int i=0; i < dim; i++)
            sum += me[i] * me[i];

        return Math.sqrt(sum);
    }

    public Vector normalize() {
        double len = length();
        Vector normalized = new Vector(this);
        for (int i=0; i < dim; i++)
            normalized.me[i] /= len;

        return normalized;
    }

    @Override
    public Vector clone() {
        return new Vector(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < dim; i++)
                sb.append(me[i]+" ");

        return sb.toString();
    }
}
