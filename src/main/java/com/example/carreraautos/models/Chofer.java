package com.example.carreraautos.models;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Chofer extends Observable implements Runnable{
    private Vector pos;
    private boolean status;
    private Random random;

    public Chofer(){
        status = true;
        random = new Random(System.currentTimeMillis());
    }

    public void setPosicion(Vector pos){
        this.pos = pos;
    }
    @Override
    public void run() {
        while (status){
            pos.setX(pos.getX()+(random.nextInt(41)+10));
            setChanged();
            notifyObservers(pos);
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void setStatus(boolean status){
        this.status = status;
    }
}
