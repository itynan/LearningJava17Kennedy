package lessons.methodReferences;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodRefs {

    public static void staticMethodRefs(){
        Consumer<List<Integer>> sortL = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(1,2,65,99,133,0,3,5,43234,235,13,356);
        sortMR.accept(listOfNumbers);
        System.out.println(listOfNumbers);

    }
    public static void boundMethodRefs(){
        String name = "Mr. John Smith";

        Supplier<String> lowerL = () -> name.toLowerCase();
        Supplier<String> lowerMR = name::toLowerCase;

        System.out.println(lowerL.get());
        System.out.println(lowerMR.get());

        Predicate<String> titleL = (title) -> name.startsWith(title);
        System.out.println(titleL.test("Mr."));
        Predicate<String> titleMR = name::startsWith;
        System.out.println(titleMR.test("Mr."));

        System.out.println(titleL.test("Ms."));
        System.out.println(titleMR.test("Ms."));

    }
    public static void unboundMethodRefs(){
        Function<String,String> upperL = s -> s.toUpperCase();
        Function<String,String> upperMR = String::toUpperCase;

        System.out.println(upperL.apply("john"));
        System.out.println(upperMR.apply("lower to upper"));

        BiFunction<String,String,String> unboundConcatL = (s1,s2) -> s1.concat(s2);
        BiFunction<String,String,String> unboundConcatMR = String::concat;

        System.out.println(unboundConcatL.apply("This is ", "a..."));
        System.out.println(unboundConcatMR.apply("Very useful ", "course"));
    }

    public static void constructorMethodRefs(){
        Supplier<StringBuilder> sbL = () -> new StringBuilder();
        Supplier<StringBuilder> sMR = StringBuilder::new;

        StringBuilder sb1 = sbL.get(); sb1.append("this is ").append("the first part");
        sb1.append("this is the second "); sb1.append("part");
        System.out.println(sb1);
    }
    public static void main(String[] args) {
        boundMethodRefs();
        unboundMethodRefs();
        staticMethodRefs();
    }
}
