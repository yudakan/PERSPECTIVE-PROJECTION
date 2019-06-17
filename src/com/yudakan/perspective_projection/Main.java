package com.yudakan.perspective_projection;

import com.yudakan.perspective_projection.util.Projection;
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

        // Load model
        ArrayList<Vector> vertexes = new ArrayList<>();
        ArrayList<VectorInt> triangles = new ArrayList<>();
        File xtree = new File("./xtree.obj");
        BufferedReader xtreeIn = new BufferedReader(new InputStreamReader(new FileInputStream(xtree)));

        String line;
        StringTokenizer tks;
        double x, y, z;
        while ((line = xtreeIn.readLine()) != null) {
            tks = new StringTokenizer(line, " ", false);

            if (tks.nextToken().equals("v")) {
                x = Double.parseDouble(tks.nextToken());
                y = Double.parseDouble(tks.nextToken());
                z = Double.parseDouble(tks.nextToken());
                vertexes.add(new Vector(x, y, z));
            }
            else {
                int a = Integer.parseInt(tks.nextToken());
                int b = Integer.parseInt(tks.nextToken());
                int c = Integer.parseInt(tks.nextToken());
                triangles.add(new VectorInt(a, b, c));
            }
        }
        xtreeIn.close();

        // Render
        File rendered = new File("./rendered.html");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rendered)));

        int width = 512;
        int height = 512;
        String style = "<body style=\"background-color: #000;\"><svg height=\""+height+"\" width=\""+width+"\">";
        String template = "<line x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\"" +
                "style=\"stroke:rgb(255,255,255);stroke-width:2\" />";

        VectorInt pixelA, pixelB, pixelC;
        Projection proj = new Projection.Builder()
                .setRasterWidth(width)
                .setRasterHeight(height)
                .build();

        out.write(style, 0, style.length());
        for (VectorInt tri: triangles) {

            pixelA = proj.pointToPixel(vertexes.get(tri.get(0)-1));
            pixelB = proj.pointToPixel(vertexes.get(tri.get(1)-1));
            pixelC = proj.pointToPixel(vertexes.get(tri.get(2)-1));
            if (pixelA == null || pixelB == null || pixelC == null)
                continue;

            String pixelHTML = "";
            pixelHTML += String.format(template, pixelA.get(0), pixelA.get(1), pixelB.get(0), pixelB.get(1));
            pixelHTML += String.format(template, pixelB.get(0), pixelB.get(1), pixelC.get(0), pixelC.get(1));
            pixelHTML += String.format(template, pixelC.get(0), pixelC.get(1), pixelA.get(0), pixelA.get(1));
            out.write(pixelHTML, 0, pixelHTML.length());
        }
        out.write("</svg>", 0, 6);
        out.flush();
        out.close();
    }
}
