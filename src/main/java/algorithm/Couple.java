package algorithm;

import java.time.temporal.ChronoUnit;

public class Couple {
    private Person youngest;

    private Person oldest;

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
