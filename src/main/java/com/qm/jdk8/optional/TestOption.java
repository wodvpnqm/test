package com.qm.jdk8.optional;

import java.util.Optional;

public class TestOption {
    public static void main(String[] args) {
        Person person = new Person();
        Insurance insurance = new Insurance();
        insurance.setName("人民保险");
        Car car = new Car();
        car.setInsurance(insurance);
        person.setCar(car);

        Optional<Person> optionalPerson = Optional.of(person);
        System.out.println(optionalPerson.map(Person::getCar).map(Car::getInsurance).map(Insurance::getName
        ));
//        System.out.println(optionalPerson.flatMap(Person::getCar)
//        .flatMap((Car::getInsurance))
//        .map(Insurance::getName)
//        .orElse("Unknown"));
    }
}
