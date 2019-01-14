/**
 *  * Collaboration: pedri017 & park 1394

 *
 * Created by park1394 on 4/1/18.
 */
public class BusEvent implements Event{

    private Bus bus;
    private int currStop;
    private boolean direction;


    public BusEvent(int stop,boolean dir, Bus businput){
        this.bus = businput;
        this.currStop=stop;
        this.direction=dir;
    }

    public void run() {
        System.out.println("\nCurrent Stop: " +currStop + ". Amt of ppl waiting west: "+BusSim.stops[currStop].getWestbound().length() +
                ". Amt ppl waiting east: " + BusSim.stops[currStop].getEastbound().length()+ ". Direction: "+direction +". Current amt on bus: " + bus.getAmtFull());
        if(BusSim.stops[currStop].getWestbound().length()>BusSim.longestline)
            BusSim.longestline = BusSim.stops[currStop].getWestbound().length();

        if (BusSim.stops[currStop].getEastbound().length()>BusSim.longestline)
            BusSim.longestline = BusSim.stops[currStop].getEastbound().length();

        BusSim.amtStopsMade+=1;
        BusSim.stops[currStop].busArrivedAtStop(direction);  //sets a boolean to true that there is a bus here (so that another bus doesn't pull up)
        int amtGotOff = 0;
        Passenger[] gotoff;
        if(bus.doPplGetOff(currStop)){
            gotoff = bus.removePassengersAtStop(currStop);
            for(int i=0; i<gotoff.length;i++) {
                if (gotoff[i] != null)
                    amtGotOff += 1;
            }
        }


        int amtBoarded = 0;
        Q2 <Passenger> pplwaiting;
        if (direction)
            pplwaiting= BusSim.stops[currStop].getEastbound();
        else
            pplwaiting = BusSim.stops[currStop].getWestbound();

        while(!bus.isFull() && pplwaiting.length()!=0){
            bus.addPassenger(pplwaiting.remove());
            amtBoarded+=1;
        }
        BusSim.amtPplTraveled+=amtBoarded;


        int timeElapsed = 3*amtBoarded + 2*amtGotOff +180;
        if(timeElapsed < 195)
            timeElapsed = 195;

        int nextStop;
        if (!direction)  {
            nextStop=currStop-1;
            if (currStop==0){
                nextStop=1;
                direction=true;
            }
        }
        else{
            nextStop=currStop+1;
            if (currStop==9) {
                nextStop = 8;
                direction = false;
            }
        }


        if(BusSim.stops[nextStop].isBusAtStop(direction))
            timeElapsed +=45;



        /*if (direction && BusSim.stops[nextStop].isBusAtStop(direction))            //declumping code for when there are a lot of buses
            timeElapsed+=60; */



        BusSim.agenda.add(new BusEvent(nextStop, direction, bus),timeElapsed);
        System.out.println( + amtBoarded + " people got on. "+ nextStop + " is the next stop." + " current amt on bus: "+bus.getAmtFull()+"\n");

        if(direction)               //updates the stop telling it there is no longer a bus there
            BusSim.stops[currStop].busLeavingStop(direction);
        else
            BusSim.stops[currStop].busLeavingStop(direction);

    }
}