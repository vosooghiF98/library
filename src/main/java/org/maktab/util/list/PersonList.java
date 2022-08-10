package org.maktab.util.list;

import org.maktab.entity.Person;

import java.util.Arrays;

public class PersonList {

    private Person[] persons = new Person[1000];
    int index = 0;

    public void add(Person person) {
        if (index > persons.length - 1) {
            persons = Arrays.copyOf(persons, persons.length * 2);
        }
        persons[index] = person;
        index++;
    }

    public void remove(int id) {
        if (id < index) {
            persons[id] = null;
        }
        if (index - id >= 0) System.arraycopy(persons, id + 1, persons, id, index - id);
        /*for (int i = id; i < index; i++) {
            books[i] = books[i + 1];
        }*/
    }

}
