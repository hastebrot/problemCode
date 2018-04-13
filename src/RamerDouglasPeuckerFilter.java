import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.abs;

class RamerDouglasPeuckerFilter {

    public static void main(String args[]) {
        Random random = new Random();
        double[] points = new double[20];
        double[] fpoints;
        for (int i = 0; i < points.length; i++)
            points[i] = random.nextInt(10);
        RamerDouglasPeuckerFilter rdpf = new RamerDouglasPeuckerFilter(1);
        fpoints = rdpf.filter(points);

        System.out.println("Orginal points");
        for (int i = 0; i < points.length; i++)
            System.out.print(points[i] + " ");

        System.out.println("\nFiltered points");
        for (int i = 0; i < fpoints.length; i++)
            System.out.print(fpoints[i] + " ");
    }

    private double epsilon;

    public RamerDouglasPeuckerFilter(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Epsilon nust be > 0");
        }
        this.epsilon = epsilon;
    }

    public double[] filter(double[] data) {
        return ramerDouglasPeuckerFunction(data, 0, data.length - 1);
    }

    public double getEpsilon() {
        return epsilon;
    }

    protected double[] ramerDouglasPeuckerFunction(double[] points,
                                                   int startIndex, int endIndex) {
        double dmax = 0;
        int idx = 0;
        double a = endIndex - startIndex;
        double b = points[endIndex] - points[startIndex];
        double c = -(b * startIndex - a * points[startIndex]);
        double norm = sqrt(pow(a, 2) + pow(b, 2));
        for (int i = startIndex + 1; i < endIndex; i++) {
            double distance = abs(b * i - a * points[i] + c) / norm;
            if (distance > dmax) {
                idx = i;
                dmax = distance;
            }
        }
        if (dmax >= epsilon) {
            double[] recursiveResult1 = ramerDouglasPeuckerFunction(points,
                    startIndex, idx);
            double[] recursiveResult2 = ramerDouglasPeuckerFunction(points,
                    idx, endIndex);
            double[] result = new double[(recursiveResult1.length - 1)
                    + recursiveResult2.length];
            System.arraycopy(recursiveResult1, 0, result, 0,
                    recursiveResult1.length - 1);
            System.arraycopy(recursiveResult2, 0, result,
                    recursiveResult1.length - 1, recursiveResult2.length);
            return result;
        }
        else {
            return new double[]{points[startIndex], points[endIndex]};
        }
    }

    public void setEpsilon(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Epsilon nust be > 0");
        }
        this.epsilon = epsilon;
    }

}
