package algorithm;

import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Couple {
    private Person youngest;
    private Person oldest;

    private Couple(Person youngest, Person oldest) {
        this.youngest = youngest;
        this.oldest = oldest;
    }

    public static Couple create(Person person, Person person2) {
        if (person.birthDate().isBefore(person2.birthDate())) {
            return new Couple(person, person2);
        } else {
            return new Couple(person2, person);
        }
    }

    public long getDistance() {
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
        Couple couple = (Couple) o;
        return Objects.equals(youngest, couple.youngest) &&
                Objects.equals(oldest, couple.oldest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(youngest, oldest);
    }
}
