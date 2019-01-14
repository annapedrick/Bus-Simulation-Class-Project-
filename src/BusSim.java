/**
 * Collaboration: pedri017 & park 1394
 *
 * Created by park1394 on 4/1/18.
 */
public class BusSim {

    static PQ agenda = new PQ();
    static int amtPplTraveled;
    static int amtStopsMade;
    static double totWaitTime;
    static double totRideTime;
    static int longestline=0;

    public static Stop[] stops = new Stop [10];

    public static void main (String[] args) {

        for (int i = 0; i < 10; i+=1) {              //creates the passengers arrival events for each of our 10 stops
            stops[i] = new Stop();
            agenda.add(new PassengerEvent(i), 0);
        }
        agenda.add(new PassengerEvent(7),0);    //There are three more passenger events outside of the ten in the for loop to take into consideration that
        agenda.add(new PassengerEvent(8), 0);   //Passengers are arriving at the downtown stops 50% more frequently
        agenda.add(new PassengerEvent(9),0);

       /* for(int p=0; p<9;p+=3){
            agenda.add(new BusEvent(p,false, new Bus()),0);
        }
        for (int j = 1; j<10;j+=3)
            agenda.add(new BusEvent(j,true, new Bus()),0);*/
        agenda.add(new BusEvent(3,false, new Bus()),0);
        agenda.add(new BusEvent(7,true, new Bus()),0);
        agenda.add(new BusEvent(8,false, new Bus()),0);
        agenda.add(new BusEvent(2,true, new Bus()),0);







        while (!agenda.isEmpty() && agenda.getCurrentTime() < 100000) {
            agenda.remove().run();
        }
        System.out.println("Total stops made: " +amtStopsMade+" Total ppl who rode with us: " + amtPplTraveled +
                " Total wait time: "+totWaitTime/amtPplTraveled+ " Total ride time: " + totRideTime/amtPplTraveled+ " longest line "+ longestline);

    }

}