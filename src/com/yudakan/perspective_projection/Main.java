package com.yudakan.perspective_projection;

//import com.yudakan.perspective_projection.util.Projection;
import com.yudakan.perspective_projection.util.quantum.SquareMatrix;
import com.yudakan.perspective_projection.util.quantum.Vector;
import com.yudakan.perspective_projection.util.quantum.VectorInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

//        // Load model
//        ArrayList<Vector> vertexes = new ArrayList<>();
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
//                vertexes.add(new Vector(x, y, z));
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
//        int[] pixel;
//        Projection proj = new Projection();
//
//        out.write(style, 0, style.length());
//        for (Vector point: vertexes) {
//            pixel = proj.pointToPixel();
//            pixel = pixel.scale(5);
//            pixelHTML = String.format(template, pixel.x, pixel.y);
//            out.write(pixelHTML, 0, pixelHTML.length());
//        }
//        out.flush();
//        out.close();
    }
}
