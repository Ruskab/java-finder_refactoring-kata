package algorithm;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class CoupleByFarthestCriteriaFinder implements CoupleByCriteriaFinder {

    @Override
    public Optional<OrderedByAgeCouple> find(List<Person> people) {
        List<OrderedByAgeCouple> coupleCombinations = people.stream().flatMap(person -> mapPossiblesCouples(person, people)).distinct().collect(toList());
        return coupleCombinations.stream().max(comparing(OrderedByAgeCouple::getAgeDifference));
    }
}
