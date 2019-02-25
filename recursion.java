import java.util.* ;
import java.io.* ;

public class recursion{
  public static void main(String[] args) {
    System.out.println("We are testing the fib function!") ;
    for (int i = 0 ; i < 6 ; i++) {
      System.out.println("We are on index " + i) ;
      testFib(i) ;
    }
    System.out.println("We are testing the square root function!") ;
    for (int i = 0 ; i < 5 ; i++) {
      System.out.println("We are on index " + i) ;
      testSqrt(i) ;
    }
    /*System.out.println("-----------------------------------------------------------------") ;
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
    System.out.println("-----------------------------------------------------------------") ;
    // Testing makeAllSums methods
    System.out.println("Testing how the makeAllSums methods works!") ;
    System.out.println("makeAllSums(1) should return: [0,1]") ;
    System.out.println(makeAllSums(1)) ;
    System.out.println("makeAllSums(2) should return: [0,1,2,3]") ;
    System.out.println(makeAllSums(2)) ;
    System.out.println("makeAllSums(3) should return: [0,1,2,3,3,4,5,6]") ;
    System.out.println(makeAllSums(3)) ;*/
  }
  /*Recursively find the sqrt using Newton's approximation
  *tolerance is the allowed percent error the squared answer is away from n.
  *precondition: n is non-negative
  */
  public static double sqrt(double n, double tolerance) {
    return sqH(n,tolerance,1) ;
  }
  // helper function for finding the square root
  public static double sqH(double n, double percentError, double guess) {
    guess = (n/guess + guess) / 2 ;
    if (guess*guess >= n - percentError*n && guess*guess <= n + percentError*n) return guess ;
    else {
      return sqH(n, percentError, guess) ;
    }
  }

  /*Recursively find the n'th fibbonaci number in linear time
  *fib(0) = 1; fib(1) = 1; fib(5) = 5
  *precondition: n is non-negative
  */
  public static int fib(int n) {
    return fibHelper(n,0,1,0) ;
  }
  // helper function for finding the nth fibbonaci number using recursion to calculate terms before the nth term
  public static int fibHelper(int n, int first, int next, int current) {
    if (current == n) return first ;
    else {
      return fibHelper(n , next , first + next, current + 1) ;
    }
  }

  /*As Per classwork*/
  public static ArrayList<Integer> makeAllSums(int n) {
    ArrayList<Integer> result = new ArrayList<Integer>() ;
    mSums(n, 0, result) ;
    return result ;
  }
  public static void mSums(int n, int sum, ArrayList<Integer> result) {
    if (n == 0) {
      result.add(sum) ;
    }
    else {
      mSums(n - 1, sum, result) ;
      mSums(n - 1, sum + n, result) ;
    }
  }
  ///////////////////////////////////////////////////////////////////////////////////
  //testcase must be a valid index of your input/output array
  public static void testFib(int testcase){
    recursion r = new recursion();
    int[] input = {0,1,2,3,5,30};
    int[] output ={0,1,1,2,5,832040};
    int max = input.length;
    if(testcase < input.length){
      int in = input[testcase];
      try{
        int ans = r.fib(in);
        int correct = output[testcase];
        if(ans == correct){
          System.out.println("PASS test fib "+in+". "+correct);
        }
        else{
          System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test fib"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }
  //testcase must be a valid index of your input/output array
  public static void testSqrt(int testcase) {
    recursion r = new recursion();
    double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
    double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
    int max = input.length;
    if(testcase < input.length){
      double in = input[testcase];
      try{
        double n = 0.00001 ;
        double ans = r.sqrt(in,.00001);
        double correct = Math.sqrt(in);
        if(ans*ans >= correct - n*correct && ans*ans <= correct + correct*n){
          System.out.println("PASS test sqrt "+in+" "+ans);
        }
        else{
          System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

        }
      }catch(IllegalArgumentException n){
        if(in < 0){
          System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
        }else{
          System.out.println(" FAIL IllegalArgumentException in test case:"+in);
        }
      }catch(Exception e){
        System.out.println(" FAIL Some exception in test case:"+in);
      }
    }
  }
}
