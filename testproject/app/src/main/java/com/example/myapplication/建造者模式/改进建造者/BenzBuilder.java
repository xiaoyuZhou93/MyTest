package com.example.myapplication.建造者模式.改进建造者;

import java.util.ArrayList;

public class BenzBuilder extends CarBuilder {
    private BenzModel benz = new BenzModel();

    public CarModel getCarModel() {
        return this.benz;
    }

    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }
}
