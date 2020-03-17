package com.yapeng.designpattern.builder;

/*
Person have many paramters. some are mandantory, some are optional
The original method is

person = new Person(id, name);
person.setAge(46);
person.setXxxx;

There is new way to use builder pattern

*/
class Person {

    private final int id;
    private final String name;
    private final int age;
    private final String gender;
    private final String shoes;
    // private final String clothes;
    // private final String money;

    private Person(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.shoes = builder.shoes;
    }

    public static class Builder {

        private final int id;
        private final String name;
        private int age;
        private String gender;
        private String shoes;
        // private final String clothes;
        // private final String money;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder shoes(String shoes) {
            this.shoes = shoes;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "ID: " + this.id
            + ", NAME: " + this.name
            + ", AGE: " + this.age
            + ", GENDER: " + this.gender
            + ", SHOES: " + this.shoes;
    }
}

public class BuilderPatternDemo02 {
    public static void main(String[] args) {

        Person person1 = new Person.Builder(1, "yapeng").age(46).build();
        System.out.println(person1);

        Person person2 = new Person.Builder(2, "kelly").build();
        System.out.println(person2);

        Person.Builder builder = new Person.Builder(3, "jalen");
        builder.age(32);
        builder.gender("male");
        System.out.println(builder.build());

    }
}