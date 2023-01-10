package com.resico.plant.mode.observer;

import java.util.Vector;

public abstract class Subject {


    private Vector<Observer> observerList = new Vector<>();


    /**
     * 添加观察者
     *
     * @param observer
     */
    public void addObserver(Observer observer) {

        observerList.add(observer);

    }

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void delObserver(Observer observer) {

        observerList.remove(observer);
    }

    /**
     * 通知观察者
     */
    protected void notifyObserver() {
        observerList.forEach(Observer::update);
    }

    /**
     * 业务逻辑
     */
    public abstract void doSomething();

}
