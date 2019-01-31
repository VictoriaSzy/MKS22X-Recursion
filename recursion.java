import java.util.* ;
import java.io.* ;

public class recursion{
  public static void main(String[] args) {
    System.out.println("-----------------------------------------------------------------") ;
    // Testing the square root methods
    System.out.println("Testing how the square root function works with Newton's Square Root Approximation!") ;
    System.out.println("Let's start testing!") ;
    System.out.println("What is the square root of 100?  -->  " + sqrt(100,0.00001)) ; // should return 10
    System.out.println("1?  -->   " + sqrt(1,0.1)) ; // should be 1
    System.out.println("2?  -->   " + sqrt(2,0.0001)) ; // should be 1.4142...
    System.out.println("3?  -->   " + sqrt(3,0.00001)) ; // should be 1.732...
    System.out.println("15562?  -->   " + sqrt(15562,0.01)) ; // should be around 124.7477... (probably near 124.8)
    System.out.println("-----------------------------------------------------------------") ;
    // Testing fibbonaci methods
    System.out.println("Testing how the fibbonaci methods work!") ;
    int[] test = {1,1,2,3,5,8,13,21,34,55} ;
    for (int i = 0 ; i < 10 ; i++) {
      System.out.println("The expected answer is: " + test[i]) ;
      System.out.println("fib(" + i + ") = " + fib(i)) ;
    }

  }
  /*Recursively find the sqrt using Newton's approximation
  *tolerance is the allowed percent error the squared answer is away from n.
  *precondition: n is non-negative
  */
  public static double sqrt(double n, double tolerance){
    return h(n,tolerance,1) ;
  }
  // helper function for finding the square root
  public static double h(double n, double percentError, double guess) {
    guess = (n/guess + guess) / 2 ;
    if (guess*guess >= n - percentError*n && guess*guess <= n + percentError*n) return guess ;
    else {
      return h(n, percentError, guess) ;
    }
  }

  /*Recursively find the n'th fibbonaci number in linear time
  *fib(0) = 1; fib(1) = 1; fib(5) = 5
  *precondition: n is non-negative
  */
  public static int fib(int n){
    return fibHelper(n,1,1) ;
  }
  // helper function for finding the nth fibbonaci number using recursion to calculate terms before the nth term
  public static int fibHelper(int n, int first, int next) {
    if (n < 2) return next ;
    else {
      return fibHelper( n - 1 , next , first + next) ;
    }
  }

  /*As Per classwork*/
  //public static ArrayList<Integer> makeAllSums(){

  //}

}
