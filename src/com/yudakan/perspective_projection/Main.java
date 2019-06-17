package com.yudakan.perspective_projection;

//import com.yudakan.perspective_projection.util.Projection;

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
    }
}
