public class polynomial {
    
    // Function: solve a polynomial p(x) in O(n^2) time
    // Parameters: double [] coefficients: store array of all coefficients 
    //             double x: store value of x that will be passed into p(x) 
    // Return Value: value for polynomial p(x) at x
    // Example: Coefficients (2, 2, 1) and x = 2 >>> p(2) = a0 + a1*x^1 + a2*x^2 = 2 + 2*(2^1) + 1*(2^2) = 2 + 4 + 4 = 10
    public static double solve1(double [] coefficients, double x) {
        double result = 0; // store the return value 
        int n = coefficients.length - 1 ; // coz one coefficient has x^0 
        double term;
        
        for (int i = n; i >= 0; i --)
        {
            int j;
            term = coefficients[i];
            for (j = i; j >0; j--) {
                term = term * x;
            }  
            result = result + term;
        }
        return result;   
    }
    
    // Function: solve a polynomial p(x) in O(n) time using Horner's method
    // Parameters: same as solve1 function
    // Return Value: same as solve1 function
    // Fact used p(x) = a0 + x(a1 + xa2))= a0 + x*result...just focus on a1 + xa2 or a(n-1) + x*a(n) or previous coefficient + x*coefficient[n] (last coeff.)
    public static double solve2(double[] coefficients, double x) {
        int n = coefficients.length - 1;
        double result = coefficients[n];

        for (int i = n - 1; i >= 0; i--) {
            result = result * x + coefficients[i]; 
        }

        return result;
    }
    public static void main (String[] args) {
        double [] coefficients = {5, 7, 8};
        double x = 2;
        
        System.out.println("Answer through solve1 is " + solve1(coefficients,x));
        System.out.println("Answer through solve2 is " + solve2(coefficients,x));

    }
    
    
}