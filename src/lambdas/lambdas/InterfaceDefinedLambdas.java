package lambdas.lambdas;

import lambdas.lambdaInterfaces.Evaluate;
import lambdas.lambdaInterfaces.iLambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class InterfaceDefinedLambdas {
    public static iLambda lambdaI = () ->{
        System.out.println("lambdaI...");
    };
    public static iLambda lambdaII = () -> System.out.println("lambdaII...");

    //static Evaluate<Integer> lambdaEval= i -> i < 0;
    public static Evaluate<Double> lambdaEval= i ->{return i*1000 < i*100;};
    public static <T> boolean check(T t, Predicate<T> lambda){ return lambda.test(t); }
    public static void printLambdas() {
        lambdaI.m();
        lambdaII.m();
        System.out.println("Eval: " + lambdaEval.isNegative((double) -1));
        System.out.println("Eval: " + lambdaEval.isNegative((double) +1));
        System.out.println("Eval: " + lambdaEval.isNegative((double) +100));

        boolean check_val = check(5, i -> i % 2 == 0);
        System.out.println("Number is odd: " + check_val);
        boolean check_val2 = check(6, i -> i % 2 == 0);
        System.out.println("Number is odd: " + check_val2);
    }

    public static void predicate(){
        Predicate<String> predicateString = s -> s.contains("City");
        System.out.println("Kansas City" +" contains substr: ");
        System.out.println(predicateString.test("Kansas City"));

        System.out.println("Kansas" +" contains substr: ");
        System.out.println(predicateString.test("Kansas"));
        System.out.println("\ncheckLen:");

        BiPredicate<String, Integer> checkLen = (str,len) -> str.length() == len;
        System.out.println(checkLen.test("hat",3));
        System.out.println(checkLen.test("hat",4));

    }
    public static void main(String[] args){
        printLambdas();
        predicate();
    }

}


