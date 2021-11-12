/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recriutment;

import java.util.ArrayList;

/**
 *
 * @author mazen174825
 */
public class WatchVacancies implements Subject{
    private ArrayList<Observer> Observers;
    private String NS;
    public WatchVacancies(){
        Observers = new ArrayList<Observer>();
    }
    @Override
    public void register(Observer o) {
      Observers.add(o);  
    }

    @Override
    public void unregister(Observer o) {
      int observeI = Observers.indexOf(o);
      Observers.remove(observeI);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : Observers){
            observer.update(NS);
        }
    }

    public void setNS(String NS) {
        this.NS = NS;
        notifyObserver();
    }
    
    
    
}
