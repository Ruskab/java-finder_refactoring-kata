package algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoupleByCriteriaFinder {
    private final List<Person> people;

    public CoupleByCriteriaFinder(List<Person> people) {
        this.people = people;
    }

    public Optional<Couple> find(Criteria criteria) {
        List<Couple> coupleCombinations = people.stream().flatMap(person -> mapPossiblesCouples(person, people)).distinct().collect(Collectors.toList());

        switch (criteria) {
            case Closest:
                return coupleCombinations.stream().min(Comparator.comparing(Couple::getDistance));
            case Farthest:
                return coupleCombinations.stream().max(Comparator.comparing(Couple::getDistance));
            default:
                return Optional.empty();
        }

    }

    private Stream<Couple> mapPossiblesCouples(Person person, List<Person> candidates) {
        return candidates.stream().filter(candidate -> !candidate.equals(person)).map(candidate -> Couple.create(person, candidate));
    }
}
