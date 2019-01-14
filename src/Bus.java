/**
 *  * Collaboration: pedri017 & park 1394

 * Created by park1394 on 4/6/18.
 */
public class Bus {
    private int capacity = 40;
    private Passenger[] passengers = new Passenger[capacity];
    private int amtFull = 0;

    public boolean doPplGetOff(int currStop) {

        for (int passenger = 0; passenger < amtFull; passenger += 1) {
            if (passengers[passenger].getDestination() == currStop)
                return true;
        }
        return false;
    }

    public boolean isFull() {
       return (amtFull==capacity);

    }

    public boolean addPassenger(Passenger p) {
        if (!isFull()) {
            passengers[amtFull] = p;
            amtFull += 1;
            p.setBoardTime(BusSim.agenda.getCurrentTime());         //sets the time this given passenger boarded
            BusSim.totWaitTime+=BusSim.agenda.getCurrentTime()-p.getArrivalTime();       //used to calculate given wait time
            return true;
        } else
            return false;
    }

    public Passenger[] removePassengersAtStop(int stop) {
        Passenger[] gettingOff= new Passenger[60];
        int amtGotOff=0;
        int i=0;
        while(i<amtFull){
            if(passengers[i].getDestination()==stop){
                gettingOff[amtGotOff]=passengers[i];
                BusSim.totRideTime+=BusSim.agenda.getCurrentTime()-passengers[i].getBoardTime();
                passengers[i]=passengers[amtFull-1];
                passengers[amtFull-1]=null;
                amtFull-=1;
                amtGotOff+=1;
            }
            else
                i++;
        }
        System.out.print("AT Stop: "+ stop+ ", "+ amtGotOff +" got off. ");
        return gettingOff;
    }
    public int getAmtFull(){
        return amtFull;
    }



}