package com.labs.spring.carapps;

public class Engine {

    String type;
    int capacity;

    public Engine() {

    }

    public Engine(String type, int capacity) {
        super();
        this.type = type;
        this.capacity = capacity;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Engine [type=" + type + ", capacity=" + capacity + "]";
    }
}
