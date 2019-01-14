/**
 *  * Collaboration: pedri017 & park 1394

 *
 * Created by park1394 on 4/1/18.
 */
public class Stop {

    private Q2<Passenger> eastbound;
    private Q2<Passenger> westbound;
    private boolean busAtStopEast;
    private boolean busAtStopWest;

    private String[] stops = {"University Ave and 27th Street SE", "Raymond Ave Station", "University Ave and Fairview Ave", "University Ave and Snelling Ave",
            "University Ave and Lexington Parkway", "University Ave and Dale Street", "University Ave and Marion Street" , "Cedar Street and 5th Street",
            "Minnesota Street and 4th Street" , "Union Depot"};

    public Stop () {
        this.eastbound=new Q2<Passenger>();
        this.westbound=new Q2<Passenger>();

    }
    public void add(Passenger p){
        if ( p.getDirection())    //eastbound bus
            eastbound.add(p);
        else
            westbound.add(p);      //westbound bus

    }

    public Q2<Passenger> getEastbound() {
        return eastbound;
    }

    public Q2  getWestbound() {
        return westbound;
    }

    public boolean isBusAtStop( boolean direction){   //method to check if a bus is at a stop
        if (direction)
            return busAtStopEast;
        else
            return busAtStopWest;
    }

    public void busArrivedAtStop(boolean direction){     //method to let the other buses "know" that there is a bus currently at said stop
        if (direction)
            busAtStopEast = true;
        else
            busAtStopWest = true;
    }

    public void busLeavingStop(boolean direction){       //bus is no longer at stop
        if (direction)
            busAtStopEast = false;
        else
            busAtStopWest = false;
    }
}