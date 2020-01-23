package algorithm;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class OrderedByAgeCouple {
    private Person youngest;
    private Person oldest;

    private OrderedByAgeCouple(Person youngest, Person oldest) {
        this.youngest = youngest;
        this.oldest = oldest;
    }

    public static OrderedByAgeCouple create(Person person, Person person2) {
        if (person.birthDate().isBefore(person2.birthDate())) {
            return new OrderedByAgeCouple(person, person2);
        } else {
            return new OrderedByAgeCouple(person2, person);
        }
    }

    public long getAgeDifference() {
        return ChronoUnit.DAYS.between(youngest.birthDate(), oldest.birthDate());
    }

    public Person getYoungest() {
        return youngest;
    }

    public Person getOldest() {
        return oldest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedByAgeCouple orderedByAgeCouple = (OrderedByAgeCouple) o;
        return Objects.equals(youngest, orderedByAgeCouple.youngest) &&
                Objects.equals(oldest, orderedByAgeCouple.oldest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(youngest, oldest);
    }
}
