package algorithm;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CoupleByCriteriaFinder {
    private final List<Person> people;

    public CoupleByCriteriaFinder(List<Person> people) {
        this.people = people;
    }

    public Optional<Couple> find(Criteria criteria) {
        List<Couple> coupleCombinations = new ArrayList<Couple>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                coupleCombinations.add(Couple.create(people.get(i), people.get(j)));
            }
        }

        switch (criteria) {
            case Closest:
                return coupleCombinations.stream().min(Comparator.comparing(Couple::getDistance));
            case Farthest:
                return coupleCombinations.stream().max(Comparator.comparing(Couple::getDistance));
            default:
                return Optional.empty();
        }

    }
}
