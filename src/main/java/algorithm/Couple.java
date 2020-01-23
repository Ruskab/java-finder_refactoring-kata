package algorithm;

import java.time.temporal.ChronoUnit;

public class Couple {
    public Person youngest;
    public Person oldest;

    public long getDistance() {
        return ChronoUnit.DAYS.between(youngest.birthDate(), oldest.birthDate());
    }

}
