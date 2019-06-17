package com.yudakan.perspective_projection.util;

import com.yudakan.perspective_projection.util.quantum.SquareMatrix;
import com.yudakan.perspective_projection.util.quantum.Vector;
import com.yudakan.perspective_projection.util.quantum.VectorInt;

public class Projection {

    /* Attributes */
    private SquareMatrix cameraToWorld;
    private SquareMatrix worldToCamera;
    private double canvasWidth;
    private double canvasHeight;
    private int rasterWidth;
    private int rasterHeight;

    /* Constructors */
    public Projection() {
        this(new Projection.Builder().build());
    }

    public Projection(SquareMatrix cameraToWorld, SquareMatrix worldToCamera, double canvasWidth, double canvasHeight, int rasterWidth, int rasterHeight) {
        this.cameraToWorld = cameraToWorld;
        this.worldToCamera = worldToCamera;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.rasterWidth = rasterWidth;
        this.rasterHeight = rasterHeight;
    }

    public Projection(Projection proj) {
        cameraToWorld = proj.cameraToWorld.clone();
        worldToCamera = proj.worldToCamera.clone();
        canvasWidth = proj.canvasWidth;
        canvasHeight = proj.canvasHeight;
        rasterWidth = proj.rasterWidth;
        rasterHeight = proj.rasterHeight;
    }

    public static class Builder {

        /* Attributes */
        private SquareMatrix cameraToWorld;
        private SquareMatrix worldToCamera;
        private double canvasWidth;
        private double canvasHeight;
        private int rasterWidth;
        private int rasterHeight;

        {
            cameraToWorld  = new SquareMatrix(
                    0.871214, 0, -0.490904, 0,
                    -0.192902, 0.919559, -0.342346, 0,
                    0.451415, 0.392953, 0.801132, 0,
                    14.777467, 29.361945, 27.993464, 1
            );
            worldToCamera  = cameraToWorld.inverse();
            canvasWidth    = 2;
            canvasHeight   = 2;
            rasterWidth    = 512;
            rasterHeight   = 512;
        }

        /* Mandatory Parameters */
        public Builder() {}

        /* Optional Parameters*/
        public Builder setCameraToWorld(SquareMatrix cameraToWorld) {
            if (cameraToWorld.getOrder() != 4)
                throw new IllegalArgumentException("CameraToWorld transformation matrix must be of order 4");

            this.cameraToWorld = cameraToWorld.clone();
            this.worldToCamera = cameraToWorld.inverse();
            return this;
        }

        public Builder setWorldToCamera(SquareMatrix worldToCamera) {
            if (worldToCamera.getOrder() != 4)
                throw new IllegalArgumentException("WorldToCamera transformation matrix must be of order 4");

            this.worldToCamera = worldToCamera.clone();
            this.cameraToWorld = worldToCamera.inverse();
            return this;
        }

        public Builder setCanvasWidth(double canvasWidth) {
            if (canvasWidth <= 0)
                throw new IllegalArgumentException("CanvasWidth has to be > 0");

            this.canvasWidth = canvasWidth;
            return this;
        }

        public Builder setCanvasHeight(double canvasHeight) {
            if (canvasHeight <= 0)
                throw new IllegalArgumentException("CanvasHeight has to be > 0");

            this.canvasHeight = canvasHeight;
            return this;
        }

        public Builder setRasterWidth(int rasterWidth) {
            if (rasterWidth <= 0)
                throw new IllegalArgumentException("RasterWidth has to be > 0");

            this.rasterWidth = rasterWidth;
            return this;
        }

        public Builder setRasterHeight(int rasterHeight) {
            if (rasterHeight <= 0)
                throw new IllegalArgumentException("RasterHeight has to be > 0");

            this.rasterHeight = rasterHeight;
            return this;
        }

        public Projection build() {
            return new Projection(cameraToWorld, worldToCamera, canvasWidth, canvasHeight, rasterWidth, rasterHeight);
        }
    }

    /* Getters */
    public SquareMatrix getCameraToWorld() {
        return cameraToWorld.clone();
    }

    public SquareMatrix getWorldToCamera() {
        return worldToCamera.clone();
    }

    public double getCanvasWidth() {
        return canvasWidth;
    }

    public double getCanvasHeight() {
        return canvasHeight;
    }

    public int getRasterWidth() {
        return rasterWidth;
    }

    public int getRasterHeight() {
        return rasterHeight;
    }

    /* Methods */
    public VectorInt pointToPixel(Vector pWorld) {

        // Camera space
        Vector pCamera = pWorld.concat(1).multiply(worldToCamera);

        // Screen space
        if (pCamera.get(2) > -1)
            return null;

        Vector pScreen = new Vector(
                pCamera.get(0) / -pCamera.get(2),
                pCamera.get(1) / -pCamera.get(2)
        );

        // NDC space
        if (Math.abs(pScreen.get(0)) > canvasWidth/2 || Math.abs(pScreen.get(1)) > canvasHeight/2)
            return null;

        Vector pNDC = new Vector(
                (pScreen.get(0) + canvasWidth/2) / canvasWidth,
                (pScreen.get(1) + canvasHeight/2) / canvasHeight
        );

        // Raster space
         VectorInt pRaster = new VectorInt(
                 (int)(pNDC.get(0) * rasterWidth),
                 (int)((1-pNDC.get(1)) * rasterHeight)
         );

        return pRaster;
    }
}
