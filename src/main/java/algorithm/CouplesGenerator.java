package algorithm;

import java.util.List;
import java.util.stream.Stream;

public class CouplesGenerator {

    public static Stream<OrderedByAgeCouple> generatePossiblesCouples(Person person, List<Person> candidates) {
        return candidates.stream().filter(candidate -> !candidate.equals(person)).map(candidate -> OrderedByAgeCouple.create(person, candidate));
    }

}
