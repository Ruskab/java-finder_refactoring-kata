package algorithm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class CoupleByCriteriaFinder {
    private final List<Person> people;

    public CoupleByCriteriaFinder(List<Person> people) {
        this.people = people;
    }

    public Optional<OrderedByAgeCouple> find(Criteria criteria) {
        List<OrderedByAgeCouple> coupleCombinations = people.stream().flatMap(person -> mapPossiblesCouples(person, people)).distinct().collect(toList());
        switch (criteria) {
            case Closest:
                return coupleCombinations.stream().min(comparing(OrderedByAgeCouple::getAgeDifference));
            case Farthest:
                return coupleCombinations.stream().max(comparing(OrderedByAgeCouple::getAgeDifference));
            default:
                return Optional.empty();
        }

    }

    private Stream<OrderedByAgeCouple> mapPossiblesCouples(Person person, List<Person> candidates) {
        return candidates.stream().filter(candidate -> !candidate.equals(person)).map(candidate -> OrderedByAgeCouple.create(person, candidate));
    }
}
