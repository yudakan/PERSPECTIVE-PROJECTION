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

    public Vector(int dim, double fill) {
        this.dim = dim;
        me = new double[dim];
        for (int i=0; i < dim; i++)
            me[i] = fill;
    }

    public Vector(double ... elements) {
        dim = elements.length;
        me = elements.clone();
    }

    public Vector(Vector ... vArr) {
        int i, j, k;
        for (i=0; i < vArr.length; i++)
            dim += vArr[i].getDim();

        me = new double[dim];
        for (i=0, k=0; i < vArr.length; i++)
            for (j=0; j < vArr[i].getDim(); j++)
                me[k++] = vArr[i].get(j);
    }

    /* Getters & Setters */
    public double get(int i) {
        if (i < dim && i >= 0)
            return me[i];
        else
            throw new IllegalArgumentException("Out of rang");
    }

    public void set(int i, double value) {
        if (i < dim && i >= 0)
            me[i] = value;
        else
            throw new IllegalArgumentException("Out of rang");
    }

    public int getDim() {
        return dim;
    }

    /* Methods */
    public Vector concat(Vector v) {
        return new Vector(this, v);
    }

    public Vector concat(double ... nums) {
        return new Vector(this, new Vector(nums));
    }

    public Vector subVector(int start, int end) { // Start included, end excluded
        if (start < end && start < dim && start >= 0 && end <= dim) {
            double[] arr = new double[end-start];
            System.arraycopy(this.me, start, arr, 0, end-start);
            return new Vector(arr);
        }
        else
            throw new IllegalArgumentException("Out of rang");
    }

    public Vector add(Vector v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimension");

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
            throw new IllegalArgumentException("Not same dimension");

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
            throw new IllegalArgumentException("Not same dimension");
        else if (dim != 3)
            throw new IllegalArgumentException("Cross product just lives in three-dimensional space, not "+dim+"d space");

        double x = me[1]*v.me[2] - me[2]*v.me[1];
        double y = me[2]*v.me[0] - me[0]*v.me[2];
        double z = me[0]*v.me[1] - me[1]*v.me[0];
        return new Vector(x, y, z);
    }

    public double dot(Vector v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimension");

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
