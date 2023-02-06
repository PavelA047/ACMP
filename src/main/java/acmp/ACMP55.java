package acmp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ACMP55 {
    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(System.in);
             PrintWriter out = new PrintWriter(System.out)) {
            method(in, out);
        }
    }

    public static void method(Scanner in, PrintWriter out) {
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double rTwo = in.nextDouble();
        double sOne = in.nextDouble();

        double d = Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );

        double sTwo;

        if (d >= rTwo * 2) {
            sTwo = Math.PI * Math.pow(rTwo, 2) * 2;
        } else if (d > 0) {
            double f = 2 * Math.acos(Math.pow(d, 2) / (2 * rTwo * d));
            double sSector = (Math.pow(rTwo, 2) * (f - Math.sin(f))) / 2;
            double crossSector = sSector * 2;
            sTwo = Math.PI * Math.pow(rTwo, 2) * 2 - crossSector;
        } else {
            sTwo = Math.PI * Math.pow(rTwo, 2);
        }

        if (sTwo > sOne) out.println("YES");
        else out.println("NO");
        out.flush();
    }

}
