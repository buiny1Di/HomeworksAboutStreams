import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class People {
    private String name;
    private int age;
    private boolean sex;
    private static String MAN;

    public People(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static void main(String[] args) {
        // first lesson
        List<People> peopleList =  Arrays.asList(new People("Вася", 16, true),
                new People("Петя", 23, true),
                new People("Елена", 42, false),
                new People("Иван Иванович", 69, true));
        List<People> peopleMilitaryEntitled =  peopleList.stream()
                .filter(e -> e.age >= 18 && e.age <= 27)
                .collect(Collectors.toList());
        System.out.println(peopleMilitaryEntitled);

        // second
        int sumOfAge = peopleList.stream()
                .map(e -> e.getAge())
                .reduce((accumulutor, next) -> accumulutor + next).get();
        int countOfPeople = (int) peopleList.stream().count();
        double average = sumOfAge * 1.0 / countOfPeople;
        System.out.println(average);

        //third
        List<People> peopleFitToWork =  peopleList.stream()
                .filter(e -> e.age >= 18 && (((e.age <= 60) && (e.sex == true)) || ((e.age <= 55) && (e.sex == false))))
                .collect(Collectors.toList());



        //Block 4
        //5
        System.out.println("==  Block 4.5   == ");
        peopleList.stream()
                .sorted(((o1, o2) -> o2.name.compareTo(o1.name)))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //6
        System.out.println("==  Block 4.6   == ");
        peopleList.stream()
                .sorted(new Comparator<People>() {
                    @Override
                    public int compare(People o1, People o2) {
                        if (o1.sex && o2.sex) {
                            if (o1.getAge() > o2.getAge())
                                return 1;
                            else
                                return -1;
                        } else if (o1.sex && !o2.sex) {
                            return -1;
                        } else if (!o1.sex && o2.sex) {
                            return 1;
                        } else if (!o1.sex && !o2.sex) {
                            if (o1.getAge() > o2.getAge())
                                return 1;
                            else
                                return -1;
                        } else
                            return 1;

                    }
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);


        //Block 5
        System.out.println("==  Block 5.1   == ");
        List<String> stringsOFBlock5 = Arrays.asList("a1", "a2", "a3", "a1");
        //1
        int min = stringsOFBlock5.stream()
                .map(e -> Integer.parseInt(e.substring(e.length()-1)))
                .min((x,y) -> x - y)
                .get();
        System.out.println(min);
        //2
        System.out.println("==  Block 5.2   == ");
        int max = stringsOFBlock5.stream()
                .map(e -> Integer.parseInt(e.substring(e.length()-1)))
                .max((x,y) -> x - y)
                .get();
        System.out.println(max);

        //Block 6
        //6.1
        System.out.println("==  Block 6.1   == ");

        List<Integer> integersFromBlock6 = Arrays.asList(1, 2, 3, 4, 2);
        Optional<Integer> sum = integersFromBlock6.stream()
                .reduce((accumulator, next) -> accumulator + next);
        if (sum.isPresent())
            System.out.println(sum.get());
        else
            System.out.println(0);

        //6.2
        System.out.println("==  Block 6.2   == ");
        Optional<Integer> maxBlock6 = integersFromBlock6.stream()
                .max((x,y) -> x - y);

        if (sum.isPresent())
            System.out.println(maxBlock6.get());
        else
            System.out.println(-1);


        //6.3
        System.out.println("==  Block 6.3   == ");
        Integer sumBlock63 = integersFromBlock6.stream()
                .reduce(0 , (accumulator, next) -> {
                    if (next % 2 == 0)
                     return accumulator + next;
                    return accumulator;
                });
        System.out.println(sumBlock63);











    }
}
