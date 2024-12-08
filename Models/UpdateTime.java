package AmazonLLD.Models;

import java.util.ArrayList;
import java.util.List;

public class UpdateTime {
    int currentDay;
    List<Timer> lockerTimers;
    public UpdateTime() {
        this.currentDay = 0;
        lockerTimers = new ArrayList<>();
    }

    public void addTimers(Timer timer){
        lockerTimers.add(timer);
    }

    public void removeTimer(Timer timer){
        lockerTimers.remove(timer);
    }

    public void incrementDay(){
        currentDay = currentDay+1;
        for(Timer t: lockerTimers){
            t.updateTimeInLockers();
        }
    }
}
