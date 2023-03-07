package optionals;

import stream_api.Gender;
import stream_api.Person;
import stream_api.StreamApiExecutor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalExecutor {

    public static void execute() {
        Optional<Cat> catOptional = findCatByName("Charlie");
        System.out.println(catOptional.map(Cat::getAge).orElse(0));
        getOptPeople().ifPresent(people -> {
            List<Person> collect = people.stream()
                    .filter(person -> person.getGender().equals(Gender.MALE))
                    .filter(person -> person.getAge() > 28).collect(Collectors.toList());
            collect.forEach(System.out::println);
        });
    }
    public void test () {

    }
    private  static Optional<Cat> findCatByName(String name) {
        Cat cat = new Cat(name, 4);
        return Optional.ofNullable(cat);
    }

    private static Optional<List<Person>> getOptPeople() {
        List<Person> people = StreamApiExecutor.getPeople();
        return Optional.of(people);
    }
}
