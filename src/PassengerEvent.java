/**
 *  * Collaboration: pedri017 & park 1394

 *
 * Created by park1394 on 4/1/18.
 */
public class PassengerEvent implements Event {

    private double[] interval={.75, .75, .5, .5, .5, .2, .2, .2, .2, 0, 0, -.2, -.2, -.2, -.2, -.5, -.5, -.5, -.75, -.75};      //array to distribute the arrival time realistically
    private int start;

    public PassengerEvent (int startLocation) {
        this.start=startLocation;
    }

    public void run() {
        int rand = (int) Math.floor(20 * Math.random());
        double time = interval[rand]*120+120;
        Passenger p=new Passenger(BusSim.agenda.getCurrentTime(), start);
        BusSim.stops[start].add(p);
        BusSim.agenda.add(new PassengerEvent(start),time);
        System.out.println("NEW PASSENGER. Arrival Stop: "+start+ " Current Time: "+ BusSim.agenda.getCurrentTime()+ " Time next person will come: " +time);

    }

}