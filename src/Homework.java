import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {

        //Block 1
        System.out.println("==  Block 1.1  == ");
        List<String> strings = Arrays.asList("a1", "a2", "a3", "a1");

        //1 count
        long count = strings.stream()
                .filter(e -> e.equals("a1"))
                .count();
        System.out.println(count);

        //2 findfirst
        System.out.println("==  Block 1.2  == ");
        String first = strings.stream().findFirst().get();
        System.out.println(first);

        //3 findEnd
        System.out.println("==  Block 1.3  == ");
        String lust = strings.stream()
                .reduce((prev , next) -> next)
                .orElse("empty");
        System.out.println(lust);

        //4 find "a3" or mistake
        System.out.println("==  Block 1.4  == ");
        String thirdOrMistake = strings.stream()
                .filter(e -> e.equals("a3"))
                .findAny()
                .get();
        System.out.println(thirdOrMistake);


        //5 find third
        System.out.println("==  Block 1.5  == ");
        String third = strings.stream()
                .skip(2)
                .findFirst()
                .get();
        System.out.println(third);

        //6 find two elements past 2
        System.out.println("==  Block 1.6  == ");
        List<String> twoElements = strings.stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(twoElements);

        //Block 3
        Boolean result;

        //1
        System.out.println("==  Block 3.1  == ");
        List<String> findStrings = strings.stream()
                .filter(e -> e.equals("a3"))
                .collect(Collectors.toList());
        if (findStrings.stream().count() > 0)
            System.out.println("Found a3");
        else
            System.out.println("Empry");

        //2
        System.out.println("==  Block 3.2  == ");
        List<String> findStrings1 = strings.stream()
                .filter(e -> e.equals("a8"))
                .collect(Collectors.toList());
        if (findStrings.stream().count() > 0)
            System.out.println("Found a8");
        else
            System.out.println("Empry");

        //3
        System.out.println("==  Block 3.3  == ");
        List<String> findCharFromStrings2 = strings.stream()
                .filter(e -> {
                    char[] charsOfElement = e.toCharArray();
                    for (int i = 0; i < charsOfElement.length; i++) {
                        if (charsOfElement[i] == '1')
                            return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        if (findStrings.stream().count() > 0)
            System.out.println("Found 1");
        else
            System.out.println("Empry");

        //4
        System.out.println("==  Block 3.4  == ");
        List<String> findA7 = strings.stream()
                .filter(e -> {
                    if (e.equals("a7")) {
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        if (findA7.stream().count() == 0)
            System.out.println("The List doesn't have element a7");
        else
            System.out.println("The List has element a7");

        //Block 4
        //1
        System.out.println("==  Block 4.1  == ");
        List<String> stringBlock5 = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");
        stringBlock5.stream()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //2
        System.out.println("==  Block 4.2  == ");
        stringBlock5.stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //3
        System.out.println("==  Block 4.3  == ");
        stringBlock5.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //4
        System.out.println("==  Block 4.4  == ");
        stringBlock5.stream()
                .distinct()
                .sorted(((o1, o2) -> o2.compareTo(o1)))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
