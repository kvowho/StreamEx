import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExp {
    public static void main(String[] args) {

        /**
         * to print HashMap elements
         */


        Map<Integer, String> m = new HashMap<>();
        m.put(1,"DockingStation");
        m.put(2,"Screen");
        m.put(3,"KeyBoard");
        m.put(4,"Mouse");
        m.put(5,"Chair");
        m.put(6,"Table");
        m.put(7,"Plant");

        //
        System.out.println("Traditional approach...");
        for(Map.Entry item : m.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }

        //
        System.out.println("Stream approach...");
        m.entrySet().stream().forEach(e-> System.out.println(e));
        m.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        // It is impassible to reuse one stream, we need to create one for each expression

        //
        System.out.println("Stream print key only...");
        Stream.of(m.keySet().toArray())
                .forEach(System.out::println);
        //
        System.out.println("Stream print values only...");
        m.values().stream()
                .forEach(System.out::println);

        //
        System.out.println("Print map with lambda...");
        m.forEach((k, v) -> System.out.println((k + " " + v)));

        /**
         * to get sum of all List elements
         */

        List<Integer> numbersList = Arrays.asList( 15, 45, 20, 70);
        Double doubleSum = numbersList.stream()
                .mapToDouble(a -> a) //Why we need to mapTo if we already have Integer
                .sum();
        // or/and
        Long intSum = numbersList.stream()
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println( "Double summ:" + doubleSum + "  int summ:" + intSum);
        // or
        System.out.println( numbersList.stream().reduce(0, (a,b) -> a + b) );

        Collection<String> stringList = Arrays.asList( "DockingStation", "Screen", "KeyBoard", "Mouse", "Chair", "Table", "Plant");

        System.out.println(stringList);

        // NOT WORKING
        /*Iterator<String> i = stringList.iterator();
        while(i.hasNext()) {
            String e = i.next();
            if (e.startsWith("K")) {
                i.remove();
            }
        }*/

        // NOT WORKING
        //stringList.removeIf(e -> e.startsWith("S"));
        //stringList.removeIf(e -> e.contains("a"));

        List<String> filteredList = stringList.stream()
                .filter(e -> !e.contains("a") )
                .collect( Collectors.toList());
        System.out.println(filteredList);


        //Stream mapStream = m.stream();





        /*long count = Stream.of(1,2,3,4,5)
                .peek(System.out::println)  // not working in Java after 8... We need to avoid use stream for "side effect" like println here
                .count();*/

        System.out.println(IntStream.rangeClosed(1, 6)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply)
        );



    }
}
