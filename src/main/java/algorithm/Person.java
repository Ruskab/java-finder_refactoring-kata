package algorithm;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String name;
    private LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public LocalDate birthDate() {
        return birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(birthDate, person.birthDate);
    }
}

