package com.resico.plant.mode.observer;

public class ConcreteSubject extends Subject{


    @Override
    public void doSomething() {

        System.out.println("被观察者的事件发生改变!");
        notifyObserver();

    }
}
