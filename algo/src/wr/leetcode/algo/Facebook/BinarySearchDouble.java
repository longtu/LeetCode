package wr.leetcode.algo.Facebook;

public class BinarySearchDouble {

    public double sqrt(double x) {
        double ret = 0;
        if ( x > 0) {
            double end = Math.max(1.0, x);
            double start = 0;
            double eps = 1e-10;

            while (start <= end) {
                double mid = start + (end-start)/2;
                double val = mid * mid;
                if (Math.abs(val - x) <= eps) {
                    ret = mid;
                    break;
                } else if (val < x) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        BinarySearchDouble sol = new BinarySearchDouble();

        for (double x = 0; x <=2; x += 0.2) {
            System.out.println("----"+ x + "----");
            System.out.println(sol.sqrt(x));
            System.out.println(Math.sqrt(x));
        }
    }

}
