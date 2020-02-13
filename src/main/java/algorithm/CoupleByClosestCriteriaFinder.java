package algorithm;

import java.util.List;
import java.util.Optional;

import static algorithm.CouplesGenerator.generatePossiblesCouples;
import static java.util.Comparator.comparing;

public class CoupleByClosestCriteriaFinder implements CoupleByCriteriaFinder {

    @Override
    public Optional<OrderedByAgeCouple> find(List<Person> people) {
        return people.stream()
                .flatMap(person -> generatePossiblesCouples(person, people))
                .distinct()
                .min(comparing(OrderedByAgeCouple::getAgeDifference));
    }


}
