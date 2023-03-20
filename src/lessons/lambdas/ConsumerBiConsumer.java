package lessons.lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class ConsumerBiConsumer {
    public static void consumer() {
        Consumer<String> printList = System.out::println;
    //    static Consumer<String> printList = s -> System.out.println(s);
        List<String> nameList = new ArrayList<>();
        nameList.add("Jack");
        nameList.add("Steve");
        nameList.add("Tom");
        nameList.add("Larry");
        nameList.forEach(printList);
        System.out.println();
    }

    public static void biConsumer(){
        HashMap<String,String> capitalCitiesMap = new HashMap<String,String>();
        BiConsumer<String,String> biCon = capitalCitiesMap::put;
        //        BiConsumer<String,String> biCon = (key,value) -> capitalCitiesMap.put(key,value);

        biCon.accept("Dublin","Ireland");
        biCon.accept("DC","USA");
        biCon.accept("Paris","France");
        System.out.println(capitalCitiesMap);

        BiConsumer<String,String> printMap = (key,value) -> System.out.println(key + " is the capital of "+ value);
        capitalCitiesMap.forEach(printMap);
    }

    public static void function(){
        Function<String,Integer> lenOfString = String::length;
        //Function<String,Integer> lenOfString = s -> s.length();

        System.out.println( "Length of String: "+ lenOfString.apply("hat") );
        System.out.println( "Length of String: "+ lenOfString.apply("cats") );
    }
    public static void biFunction(){
        BiFunction<String, String, Integer> addLen = (s1,s2) -> s1.length() + s2.length();
        System.out.println("len of two strings combined: " + addLen.apply("week ","end"));

        BiFunction<String, String, String> concatStrings = String::concat;
      //  BiFunction<String, String, String> concatStrings = (s1,s2) -> s1.concat(s2);
        System.out.println("concat two strings: " + concatStrings.apply("week ","end"));
    }
    public static void unaryBinaryOperator(){
        UnaryOperator<String> inputString = name -> "My name is "+ name;
        System.out.println(inputString.apply("sean"));

        BinaryOperator<String> concatFnameLname = String::concat;
        //BinaryOperator<String> concatFnameLname = (s1,s2) -> s1.concat(s2);
        System.out.println(concatFnameLname.apply("William ", "Shakespeare"));
    }

    public static void main(String[] args) {
        consumer();
        biConsumer();
        function();
        biFunction();
        unaryBinaryOperator();
    }
}

