/**
 *  * Collaboration: pedri017 & park 1394

 *
 * Created by park1394 on 4/1/18.
 */
public class Passenger {

    private double arrivalTime;
    private double boardTime;
    private int start;              //Stop where passenger is starting
    private int destination;        //Passenger's Destination

    /*
        This creates a new passenger with a random destination assigned to it that is not the same place as where they are starting
     */
    public Passenger(double t, int start) {
        this.arrivalTime=t;
        this.start=start;
        do {
            destination= (int) Math.floor(10 * Math.random());
        } while (destination!=start);
    }
    public int getDestination() {
        return destination;
    }
    public boolean getDirection(){  //true east False west
        return (destination<start);     //making university Ave and 27th st SE the furthest stop east
    }

    public double getArrivalTime(){
        return arrivalTime;
    }

    public double getBoardTime() {
        return boardTime;
    }

    public void setBoardTime(double time){
        boardTime = time;
    }


}