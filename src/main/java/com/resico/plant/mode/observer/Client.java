package com.resico.plant.mode.observer;

public class Client {


    public static void main(String[] args) {

        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.addObserver(new ConcreteObserver1());
        concreteSubject.addObserver(new ConcreteObserver2());
        concreteSubject.doSomething();

    }

}
