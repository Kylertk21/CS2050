package pack0; 
/*
 * Kyler Kramer
 * Desc: methods complete a math function
 * (add, multiply, etc) and return a value to be
 * used in Program2Test
 */


public class Program2 {

   
    public static double add(double a, double b) {
        return a + b;
    }


    public static double subtract(double a, double b) {
        return a - b;
    }

 
    public static double multiply(double a, double b) {
        return a * b;
    }

  
    public static double divide(double a, double b) {
        return a / b;
    }

 
    public static double sinOfAngle(double oppSide, double hyp) {
      
    	return oppSide / hyp; 
    }

    
    public static double hypOfTriangle(double sideA, double sideB) {
       double hypTriangleValue = (sideA * sideA) + (sideB * sideB);  
       return Math.sqrt(hypTriangleValue);
    }


    public static void main(String[] args) {
    	System.out.println(add(0 , 0));
    	System.out.println(subtract(0 , 5));
    	System.out.println(sinOfAngle(3, 4));
    	System.out.println(hypOfTriangle(1.0, 1.0));

    }
}
