package main.java.resources;

import java.util.*;
public class ResourceManager {
    private final HashMap<Resource, Integer> inventory;
    private int credits;

    public ResourceManager(){
        inventory = new HashMap<>();
        inventory.put(Resource.OXYGEN,100);
        inventory.put(Resource.WATER,80);
        inventory.put(Resource.SPARE_PARTS,25);
        inventory.put(Resource.RATIONS,30);
        inventory.put(Resource.POWER,50);
        credits = 1500;
    }

    public int getAmount(Resource r){
        return inventory.getOrDefault(r,0);
    }
    public void restock(Resource r, int amount){
        inventory.put(r,getAmount(r)+amount);
    }
    public boolean hasEnough(Resource r, int amount){
        return getAmount(r)>= amount;
    }
    public void deduct(Resource r, int amount){
        inventory.put(r,getAmount(r)-amount);
    }
    public void setResource(Resource resource,int amount){
        inventory.put(resource,amount);
    }
    public int getCredits(){
        return credits;
    }
    public void addCredits(int amount){
        credits = credits + amount;
    }
    public void deductCredits(int amount){
        credits = credits - amount;
    }
    public void setCredits(int credits){
        this.credits=credits;
    }
    public boolean hasEnoughForTask(Map<Resource,Integer> required){
        for(Map.Entry<Resource,Integer> entry: required.entrySet()){
            if(!hasEnough(entry.getKey(),entry.getValue())) return false;
        }
        return true;
    }
    public void deductAll(Map<Resource,Integer> required){
        for(Map.Entry<Resource,Integer> entry: required.entrySet()){
            deduct(entry.getKey(),entry.getValue());
        }
    }


}
