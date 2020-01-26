package algorithm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CoupleByCriteriaFinder {

    Optional<OrderedByAgeCouple> find(List<Person> people);

    default Stream<OrderedByAgeCouple> mapPossiblesCouples(Person person, List<Person> candidates) {
        return candidates.stream().filter(candidate -> !candidate.equals(person)).map(candidate -> OrderedByAgeCouple.create(person, candidate));
    }

}
