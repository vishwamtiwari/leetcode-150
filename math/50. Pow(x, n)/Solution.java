class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
        }
        double res = powerOne(x, N);


        return (n < 0) ? 1.0/res : res;
    }

    private double powerOne(double x, long n) {
        if (n == 0) return 1.0;

        double half = powerOne(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}