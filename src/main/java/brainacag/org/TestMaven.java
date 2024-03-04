package brainacag.org;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class TestMaven {
    public static void main(String[] args) {
        Multimap<String, String> map = ArrayListMultimap.create();
        Properties properties = new Properties();
        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi");
        List<String> reversedFruits = Lists.reverse(fruits);

        map.put("key", "firstValue");
        map.put("key", "secondValue");
        map.put("key1", "thirdValue");

        fruits.forEach(System.out::println);
        System.out.println("-".repeat(50));
        reversedFruits.forEach(System.out::println);
        System.out.println("-".repeat(50));
        System.out.println(map);
        System.out.println("-".repeat(50));

        try(InputStream resourceStream = TestMaven.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(Objects.requireNonNull(resourceStream));

            System.out.println(properties.get("props.local.hello"));
            System.out.println(properties.get("props.mvn.hello"));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
