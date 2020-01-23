package test;

import algorithm.Couple;
import algorithm.CoupleByCriteriaFinder;
import algorithm.Criteria;
import algorithm.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class CoupleByCriteriaFinderTests {
    Person sue   = new Person("Sue", new Date(50, 0, 1));
    Person greg  = new Person("Greg", new Date(52, 5, 1));
    Person sarah = new Person("Sarah", new Date(82, 0, 1));
    Person mike  = new Person("Mike", new Date(79, 0, 1));

    @Test
    public void Returns_Empty_Couple_When_Given_Empty_List() {
        List<Person>           list   = new ArrayList<Person>();
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Optional<Couple> couple = finder.find(Criteria.Closest);
        assertEquals(Optional.empty(), couple);
    }

    @Test
    public void Returns_Empty_Couple_When_Given_One_Person() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Optional<Couple> couple = finder.find(Criteria.Closest);

        assertEquals(Optional.empty(), couple);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(greg);
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple couple = finder.find(Criteria.Closest).get();

        assertEquals(sue, couple.youngest);
        assertEquals(greg, couple.oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(mike);
        list.add(greg);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple couple = finder.find(Criteria.Farthest).get();

        assertEquals(greg, couple.youngest);
        assertEquals(mike, couple.oldest);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple couple = finder.find(Criteria.Farthest).get();

        assertEquals(sue, couple.youngest);
        assertEquals(sarah, couple.oldest);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<Person>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        CoupleByCriteriaFinder finder = new CoupleByCriteriaFinder(list);

        Couple couple = finder.find(Criteria.Closest).get();

        assertEquals(sue, couple.youngest);
        assertEquals(greg, couple.oldest);
    }
}
