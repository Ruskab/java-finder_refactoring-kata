package algorithm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface CoupleByCriteriaFinder {

    Optional<OrderedByAgeCouple> find(List<Person> people);

}
