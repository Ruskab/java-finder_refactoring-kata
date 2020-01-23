package algorithm;

import java.time.temporal.ChronoUnit;

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

    public void setYoungest(Person youngest) {
        this.youngest = youngest;
    }

    public Person getYoungest() {
        return youngest;
    }

    public void setOldest(Person oldest) {
        this.oldest = oldest;
    }

    public Person getOldest() {
        return oldest;
    }
}
