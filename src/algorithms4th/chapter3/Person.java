package algorithms4th.chapter3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;

public class Person {
    private String name;
    private long info;

    Person(String name, long info) {
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", info=" + info +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return info == person.info &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info);
    }

    public static void main(String[] args) {
        Person a = new Person("sqh", 22);
        Person b = new Person("lyj", 22);
        Person c = new Person("sqh", 22);
        Person d = a;
        StdOut.println(a == c);
        StdOut.println(a == d);
        StdOut.println(a.equals(c));
    }
}
