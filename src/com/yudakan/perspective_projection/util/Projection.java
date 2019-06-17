//package com.yudakan.perspective_projection.util;
//
//import com.yudakan.perspective_projection.util.quantum.Matrix44d;
//import com.yudakan.perspective_projection.util.quantum.Vect2i;
//
//public class Projection {
//
//    /* Attributes */
//    private Matrix44d cameraToWorld;
//    private Matrix44d worldToCamera;
//    private double canvasWidth;
//    private double canvasHeight;
//    private int rasterWidth;
//    private int rasterHeight;
//
//    /* Constructors */
//    public Projection() {}
//
//    public Projection(Matrix44d cameraToWorld, double canvasWidth, double canvasHeight, int rasterWidth, int rasterHeight) {
//        this.cameraToWorld = cameraToWorld;
//        this.worldToCamera = worldToCamera;
//        this.canvasWidth = canvasWidth;
//        this.canvasHeight = canvasHeight;
//        this.rasterWidth = rasterWidth;
//        this.rasterHeight = rasterHeight;
//    }
//
//    public Projection(Matrix44d worldToCamera, double canvasWidth, double canvasHeight, int rasterWidth, int rasterHeight) {
//        this.cameraToWorld = cameraToWorld;
//        this.worldToCamera = worldToCamera;
//        this.canvasWidth = canvasWidth;
//        this.canvasHeight = canvasHeight;
//        this.rasterWidth = rasterWidth;
//        this.rasterHeight = rasterHeight;
//    }
//
//    /* Getters & Setters */
//    public Matrix44d getCameraToWorld() {
//        return cameraToWorld;
//    }
//
//    public void setCameraToWorld(Matrix44d cameraToWorld) {
//        this.cameraToWorld = cameraToWorld;
//    }
//
//    public Matrix44d getWorldToCamera() {
//        return worldToCamera;
//    }
//
//    public void setWorldToCamera(Matrix44d worldToCamera) {
//        this.worldToCamera = worldToCamera;
//    }
//
//    public double getCanvasWidth() {
//        return canvasWidth;
//    }
//
//    public void setCanvasWidth(double canvasWidth) {
//        this.canvasWidth = canvasWidth;
//    }
//
//    public double getCanvasHeight() {
//        return canvasHeight;
//    }
//
//    public void setCanvasHeight(double canvasHeight) {
//        this.canvasHeight = canvasHeight;
//    }
//
//    public int getRasterWidth() {
//        return rasterWidth;
//    }
//
//    public void setRasterWidth(int rasterWidth) {
//        this.rasterWidth = rasterWidth;
//    }
//
//    public int getRasterHeight() {
//        return rasterHeight;
//    }
//
//    public void setRasterHeight(int rasterHeight) {
//        this.rasterHeight = rasterHeight;
//    }
//
//    /* Methods */
//    public Vect2i pointToPixel() {
//
//        // Camera space
//
//
//        // Screen space
//
//
//        // NDC space
//
//
//        // Raster space
//
//        return new Vect2i();
//    }
//}
