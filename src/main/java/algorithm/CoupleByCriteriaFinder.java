package algorithm;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
                Couple couple = new Couple();
                if (people.get(i).birthDate().isBefore(people.get(j).birthDate())) {
                    couple.youngest = people.get(i);
                    couple.oldest = people.get(j);
                } else {
                    couple.youngest = people.get(j);
                    couple.oldest = people.get(i);
                }
                couple.distance = ChronoUnit.DAYS.between(couple.youngest.birthDate(), couple.oldest.birthDate());
                coupleCombinations.add(couple);
            }
        }

        if (coupleCombinations.size() < 1) {
            return Optional.empty();
        }

        Couple answer = coupleCombinations.get(0);
        for (Couple potentialResult : coupleCombinations) {
            switch (criteria) {
                case Closest:
                    if (potentialResult.distance < answer.distance) {
                        answer = potentialResult;
                    }
                    break;

                case Farthest:
                    if (potentialResult.distance > answer.distance) {
                        answer = potentialResult;
                    }
                    break;
            }
        }

        return Optional.of(answer);
    }
}
