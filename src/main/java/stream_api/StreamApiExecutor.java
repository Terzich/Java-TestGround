package stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamApiExecutor {

    public void execute() {
        List<Person> people = getPeople();
        people.forEach(System.out::println);
        System.out.println("\n");

        //filtering
        List<Person> females = people.stream().
                filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        //sorting
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender)).collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println("\n");

        List<Person> sortedMalesByAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .sorted(Comparator.comparing(Person::getAge).reversed()).
                collect(Collectors.toList());
        sortedMalesByAge.forEach(System.out::println);
        System.out.println("\n");

        //grouping
        Map<Gender, List<Person>> peopleGroupedByGender =
                people.stream().collect(Collectors.groupingBy(Person::getGender));
        peopleGroupedByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

        //name of the oldest male
        Optional<String> oldestMale = people.stream().
                filter(person -> person.getGender().equals(Gender.MALE))
                .max(Comparator.comparing(Person::getAge)).map(Person::getName);
        oldestMale.ifPresent(System.out::println);
    }

    public static List<Person> getPeople() {
        return List.of(
                new Person("Joey Tribiani", 30, Gender.MALE),
                new Person("Ross Geller", 29, Gender.MALE),
                new Person("Chandler Bing", 31, Gender.MALE),
                new Person("Sheldon Cooper", 28, Gender.MALE),
                new Person("Penny Hofstadter", 27, Gender.FEMALE),
                new Person("Rachel Green", 26, Gender.FEMALE),
                new Person("Phoebe Buffay", 28, Gender.FEMALE)
                );
    }
}
