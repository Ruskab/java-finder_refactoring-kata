package algorithm;

import java.util.List;
import java.util.Optional;

public interface CoupleByCriteriaFinder {

    Optional<OrderedByAgeCouple> find(List<Person> people);

}
