package com.yudakan.perspective_projection;

//import com.yudakan.perspective_projection.util.Projection;
import com.yudakan.perspective_projection.util.quantum.SquareMatrixDouble;
import com.yudakan.perspective_projection.util.quantum.Vect2i;
import com.yudakan.perspective_projection.util.quantum.Vect3d;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

//        // Load model
//        ArrayList<Vect3d> vertexes = new ArrayList<>();
//        File xtree = new File("./xtree.obj");
//        BufferedReader xtreeIn = new BufferedReader(new InputStreamReader(new FileInputStream(xtree)));
//
//        String line;
//        StringTokenizer tks;
//        double x, y, z;
//        while ((line = xtreeIn.readLine()) != null) {
//            tks = new StringTokenizer(line, " ", false);
//
//            if (tks.nextToken().equals("v")) {
//                x = Double.parseDouble(tks.nextToken());
//                y = Double.parseDouble(tks.nextToken());
//                z = Double.parseDouble(tks.nextToken());
//                vertexes.add(new Vect3d(x, y, z));
//            }
//        }
//        xtreeIn.close();
//
//        // Render
//        File rendered = new File("./rendered.html");
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rendered)));
//
//        String style = "<body style=\"background-color: #000;\">";
//        String template = "<div style=\"" +
//                "display: block;" +
//                "position: absolute;" +
//                "width: 5px;" +
//                "height: 5px;" +
//                "background-color: #fff;" +
//                "left: %spx;" +
//                "top: %spx;" +
//                "\"></div>";
//        String pixelHTML;
//        Vect2i pixel;
//        Projection proj = new Projection();
//
//        out.write(style, 0, style.length());
//        for (Vect3d point: vertexes) {
//            pixel = proj.pointToPixel();
//            pixel = pixel.scale(5);
//            pixelHTML = String.format(template, pixel.x, pixel.y);
//            out.write(pixelHTML, 0, pixelHTML.length());
//        }
//        out.flush();
//        out.close();

        double[][] arr = {
                {22, 23, -4, 1.0/2.0},
                {7.0/2.0, -3, 1, -65},
                {51, 9, 0, 65.0/37.0},
                {-27, -67, 821, -782}
        };
        SquareMatrixDouble mxA = new SquareMatrixDouble(arr);
        SquareMatrixDouble mxB = new SquareMatrixDouble(2, 3.1, 9, 23, 0, 43.567, 0.23, 78, 97, 34.8, 12, 101, 3, 987, 1, 0);
        SquareMatrixDouble idt = new SquareMatrixDouble(3, 7);

        SquareMatrixDouble mxC = mxA.inverse();
        SquareMatrixDouble mxD = mxC.multiply(mxA);

        System.out.println(mxA+"\n");
        System.out.println(mxB+"\n");
        System.out.println(mxC+"\n");
        System.out.println(idt+"\n");
        System.out.println(mxD+"\n");
    }
}
