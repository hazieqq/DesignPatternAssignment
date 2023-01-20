package com.example.layout;

public interface Publisher {
    public void registerSubscriber(Subscriber subs);

    public void removeSubscriber(Subscriber subs);

    public void notifySubscriber();
}
