package com.yudakan.perspective_projection.util.quantum;

import java.util.Random;

public class VectorInt {

    /* Attributes */
    private int[] me;
    private int dim;

    /* Constructors */
    public VectorInt() {
        dim = 1;
        me = new int[dim];
    }

    public VectorInt(int dim, int fill, boolean random) {
        this.dim = dim;
        me = new int[dim];

        if (random) {
            Random rand = new Random();
            for (int i=0; i < dim; i++)
                me[i] = rand.nextInt(fill);
        }
        else {
            for (int i=0; i < dim; i++)
                me[i] = fill;
        }
    }

    public VectorInt(int ... elements) {
        dim = elements.length;
        me = elements.clone();
    }

    public VectorInt(VectorInt ... vArr) {
        int i, j, k;
        for (i=0; i < vArr.length; i++)
            dim += vArr[i].getDim();

        me = new int[dim];
        for (i=0, k=0; i < vArr.length; i++)
            for (j=0; j < vArr[i].getDim(); j++)
                me[k++] = vArr[i].get(j);
    }

    /* Getters & Setters */
    public int get(int i) {
        if (i < dim && i >= 0)
            return me[i];
        else
            throw new IllegalArgumentException("Out of rang");
    }

    public void set(int i, int value) {
        if (i < dim && i >= 0)
            me[i] = value;
        else
            throw new IllegalArgumentException("Out of rang");
    }

    public int getDim() {
        return dim;
    }

    /* Methods */
    public Vector toDouble() {
        double arr[] = new double[dim];
        for (int i=0; i < dim; i++)
            arr[i] = (double)me[i];

        return new Vector(arr);
    }

    public VectorInt concat(VectorInt v) {
        return new VectorInt(this, v);
    }

    public VectorInt concat(int ... nums) {
        return new VectorInt(this, new VectorInt(nums));
    }

    public VectorInt subVectorInt(int start, int end) { // Start included, end excluded
        if (start < end && start < dim && start >= 0 && end <= dim) {
            int[] arr = new int[end-start];
            System.arraycopy(this.me, start, arr, 0, end-start);
            return new VectorInt(arr);
        }
        else
            throw new IllegalArgumentException("Out of rang");
    }

    public VectorInt add(VectorInt v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimension");

        VectorInt u = new VectorInt(this);
        for (int i=0; i < dim; i++)
            u.me[i] += v.me[i];

        return u;
    }

    public VectorInt add(int num) {
        VectorInt u = new VectorInt(this);
        for (int i=0; i < dim; i++)
            u.me[i] += num;

        return u;
    }

    public VectorInt sub(VectorInt v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimension");

        VectorInt u = new VectorInt(this);
        for (int i=0; i < dim; i++)
            u.me[i] -= v.me[i];

        return u;
    }

    public VectorInt sub(int num) {
        VectorInt u = new VectorInt(this);
        for (int i=0; i < dim; i++)
            u.me[i] -= num;

        return u;
    }

    public VectorInt scale(int num) {
        VectorInt u = new VectorInt(this);
        for (int i=0; i < dim; i++)
            u.me[i] *= num;

        return u;
    }

    public VectorInt cross(VectorInt v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimension");
        else if (dim != 3)
            throw new IllegalArgumentException("Cross product just lives in three-dimensional space, not "+dim+"d space");

        int x = me[1]*v.me[2] - me[2]*v.me[1];
        int y = me[2]*v.me[0] - me[0]*v.me[2];
        int z = me[0]*v.me[1] - me[1]*v.me[0];
        return new VectorInt(x, y, z);
    }

    public int dot(VectorInt v) {
        if (dim != v.dim)
            throw new IllegalArgumentException("Not same dimension");

        int sum = 0;
        for (int i=0; i < dim; i++)
            sum += me[i] * v.me[i];

        return sum;
    }

    public double length() {
        int sum = 0;
        for (int i=0; i < dim; i++)
            sum += me[i] * me[i];

        return Math.sqrt(sum);
    }

    public Vector normalize() {
        double len = length();
        double[] arr = new double[dim];
        for (int i=0; i < dim; i++)
            arr[i] = me[i] / len;

        return new Vector(arr);
    }

    @Override
    public VectorInt clone() {
        return new VectorInt(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < dim; i++)
            sb.append(me[i]+" ");

        return sb.toString();
    }
}
