//Jack Sheehy C22468732
// Ticketing Service Assignment - Semsester 2
public class event {

         // instance variables for events.
         String eventName;
         String eventDay;
         String eventTime;
         Double eventPrice;
         int eventTickets = 50;   
       
        public event() {  // blank event.
            this.eventName = "";
            this.eventDay = "";
            this.eventTime = "";
            this.eventPrice = 0.0;
            this.eventTickets = 50;
           
        }
       
    public String toString() { // converts event object into a string.
        return      
               "    '" + eventName + "'" +
               "\n ---------------------" +
               "\n  Day: " + eventDay +
               "\n  Time: " + eventTime +
               "\n  Price: €‎ " + String.format("%.2f", eventPrice) + // ensures the price only ever has 2 decimal places after it.
               "\n  Available Tickets: " + eventTickets + "\n";        
    }

    public event(String eventName, String eventDay, String eventTime, Double eventPrice, int eventTickets) { // creates event object with info.    
        this.eventName = eventName;                                                   //also passes in relevent variables in the parameters.
        this.eventDay = eventDay;
        this.eventTime = eventTime;
        this.eventPrice = eventPrice;
        this.eventTickets = eventTickets;
       
    }
   
    public Double getEventPrice() { // gets event price.
        return eventPrice;
    }
   
   
    public int getEventTickets() { // gets event tickets.
        return eventTickets;
    }
   
    public void setEventTickets(int eventTickets) { // updates event tickets.
        this.eventTickets = eventTickets;
    }

    public void setEventPrice(Double newPrice, Double eventPrice) { // updates event prices.
        this.eventPrice = eventPrice;        
    }   
}