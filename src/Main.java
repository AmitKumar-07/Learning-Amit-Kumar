import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
        public static void main(String[] args) throws Exception {

            List<String> words = Arrays.asList("java", "code", "python", "stream", "java", "code", "java");

            List<Map.Entry<String, Long>> collect = words.stream().collect(Collectors.groupingBy(ele -> ele, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(),a.getValue()))
                    .limit(2).collect(Collectors.toList());
            for(Map.Entry<String, Long> ele : collect) {
                System.out.println(ele.getKey() + "=" + ele.getValue());
            }

            List<List<Integer>> list = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(4, 5),
                    Arrays.asList(6, 7, 8, 9)
            );

            int sum = list.stream().flatMap(ele -> ele.stream())
                    .filter(ele -> ele % 2 == 0)
                    .reduce(0,(a,b)-> a+b);
            System.out.println(sum);

        }
}