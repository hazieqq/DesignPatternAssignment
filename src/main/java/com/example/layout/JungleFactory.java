package com.example.layout;

public class JungleFactory implements AnimalFactory {

    @Override
    public Entity createTiger() {
        return new Tiger("jungle");
    }

    @Override
    public Entity createLion() {
        return new Lion("jungle");
    }

    @Override
    public Entity createDeer() {
        // TODO Auto-generated method stub
        return new Deer("jungle");
    }

    @Override
    public Entity createDoll() {
        // TODO Auto-generated method stub
        return new Doll("none");
    }

    @Override
    public Entity createGorilla() {
        // TODO Auto-generated method stub
        return new Gorilla("jungle");
    }

    @Override
    public Entity createLight() {
        // TODO Auto-generated method stub
        return new Lights("none");
    }

    @Override
    public Entity createMonitor() {
        // TODO Auto-generated method stub
        return new Monitor("none");
    }

    @Override
    public Entity createParrot() {
        // TODO Auto-generated method stub
        return new Parrot("jungle");
    }

    @Override
    public Entity createRafflesia() {
        // TODO Auto-generated method stub
        return new Rafflesia("jungle");
    }

    @Override
    public Entity createTrash() {
        // TODO Auto-generated method stub
        return new Trash("none");
    }

    @Override
    public Entity createWhale() {
        // TODO Auto-generated method stub
        return new Whale("jungle");
    }

    public int totalAnimals(){
        return 7;
    }

    
}
