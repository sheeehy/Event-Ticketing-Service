    //Jack Sheehy C22468732
    // Ticketing Service Assignment - Semsester 2
    import java.util.Calendar;
    import java.util.Random;
    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Scanner;
   
   
   
        public class ticketingService  {
       
           
        //global variables, accessed throughout the program.
        static ArrayList<event> eventSchedule; // declare the ArrayList.
        static int SIZE = 5; // assumes 5 events to be inputted.
       
         static Random code = new Random();
         static int discountCode = code.nextInt((9999 - 1000) + 1) + 1000; // creates random 4 digit discount code.    
         static boolean discountRecieved = false;
       
       
       
        public static void eventDriver () {        
            System.out.print("\f");
            System.out.println("  Discount Code: "+ discountCode); // prints discount code outside of ticketing service.
           
            eventSchedule = new ArrayList<event>();  // delcare ArrayList as "eventSchedule".
           
            inputEvents(); // Inputs events into ArrayList.
                   
            }    
       
   
       
       
        public static void inputEvents() { // allows the user to input information for events.
           
            // delcaring variables for event object.
            String eventName;
            String eventTime;
            String eventDay;
            Double eventPrice;
            int eventTickets = 50; // assumes event capacity is 50.
   
            event anEvent; // creates an event object.
       
            System.out.println("\n  Enter the  info for the upcoming events: ");
           
              for(int count = 0; count <SIZE; count++) { // loops until all events have information.
                 
            // calls methods for each variable to be inputted and updated for each event.      
            eventName = inputEventName(count);
           
            eventDay = inputEventDay();
   
            eventTime = inputEventTime();
   
            eventPrice = inputEventPrice();
           
           
            boolean overlappedEvent = false; // checks if events overlap.
            for (event e : eventSchedule) {
                if (e.eventDay.equalsIgnoreCase(eventDay) && e.eventTime.equalsIgnoreCase(eventTime)) {
                    overlappedEvent = true;
                     break;
                  }
            }
           
            if(overlappedEvent) { // runs if event overlaps.
                System.out.println("  Scheduling error; Please enter a different day or time: ");
                 count--; // repeats the current iteration of loop.
                  continue; // skips the next for loop statements, and jumps to next iteration.
            }        
           
            // updates variables for event and adds it to the ArrayList.
              anEvent = new event(eventName, eventDay, eventTime, eventPrice, eventTickets);
              eventSchedule.add(anEvent);
            }
            System.out.print("\f");
        }
             
       
   
       
       
       
        // 4 Methods for inputting event name, day, time & price.
       
        public static String inputEventName(int num) // input name method, returns eventName.
        {
            Scanner scan = new Scanner(System.in);
            String eventName;
           
           
           
            System.out.println("\n  - Event " + (num +1) + " - ");
           
            do {
           
            System.out.print("  Event Name: ");
            eventName = scan.nextLine();
            eventName = eventName.toUpperCase(); // converts name to 'Upper Case' to improve readability in the console.
           
            if (eventName.isEmpty()) { // if the user leaves the name blank, loop.
                System.out.println("  Please enter a name: ");    
            }  
           }while (eventName.isEmpty());
                       
            return eventName;
        }
       
        public static String inputEventDay() // input day method, returns eventDay.
        {
            Scanner scan = new Scanner(System.in);
            String eventDay;
            System.out.print("  Event Day: ");
            eventDay = scan.nextLine();
           
            while (!eventDay.equalsIgnoreCase("Monday") &&    // ensures input is a day of the week.
                   !eventDay.equalsIgnoreCase("Tuesday") &&
                   !eventDay.equalsIgnoreCase("Wednesday") &&
                   !eventDay.equalsIgnoreCase("Thursday") &&
                   !eventDay.equalsIgnoreCase("Friday") &&
                   !eventDay.equalsIgnoreCase("Saturday") &&
                   !eventDay.equalsIgnoreCase("Sunday"))        
                    {
                System.out.println("  Please enter a valid day: ");
                eventDay = scan.nextLine();
            }
           
            return eventDay;
        }
       
   
        public static String inputEventTime() // input time method, returns eventTime.
        {
            Scanner scan = new Scanner(System.in);
            String eventTime;
            System.out.print("  Event Time (Evening / Night): ");  
            eventTime = scan.nextLine();
           
            while (!eventTime.equalsIgnoreCase("evening") && !eventTime.equalsIgnoreCase("night")) { // ensures input is Evening or Night.
                System.out.println("  Please enter a valid time: ");
                eventTime = scan.nextLine();
            }
           
            return eventTime;
        }
   
       
        public static Double inputEventPrice() // input price method, returns eventPrice.
        {
            Scanner scan = new Scanner(System.in);
            Double eventPrice;
            System.out.print("  Event Price(€): ");
            if(scan.hasNextDouble()) {
                eventPrice = scan.nextDouble(); // ensures input is a double.
            } else {
                System.out.println("  Please enter a valid price."); // if else, display error message, clear scanner, and loop.
                scan.next();
                eventPrice = inputEventPrice();
            }
            return eventPrice;
        }
   
       
       
       
       
       
       
        public static void mainMenu() { // main menu,
        System.out.print("\f");
            Scanner Menu = new Scanner(System.in); // input menu option.
           
            boolean exitOption = false; // if true, exit to main menu.
            while (!exitOption) {  // runs while exitOption is false.
               
               
            System.out.print("\f");
               
            printDelay(10);
            System.out.println("\n  Please select an option 1-5:\n ");
            printDelay(50);
           
            // menu options 1-5.
            printDelay(50);
            System.out.println("  [1] Buy tickets for an event");
                printDelay(50);
                System.out.println("  [2] Cancel tickets for an event");
            printDelay(50);
            System.out.println("  [3] Display full event schedule");
            printDelay(50);
            System.out.println("  [4] Redeem Discount Code");
            printDelay(50);
            System.out.println("  [5] Exit System \n");
            printDelay(50);
           
       
            if(Menu.hasNextInt()) { // returns true if the scanner input is an int, used for error checking.
               
            int MenuOption = Menu.nextInt(); //checks for menu input.
            Menu.nextLine();
            switch (MenuOption) { // switch statement, containg each menu option.
       
           
           
            case 1: // 1.Buy tickets for an event.
                option1();
                while (true) {
                    String option1 = Menu.nextLine();
                    if (option1.equalsIgnoreCase("e")) { // within each case, listens for 'E' input to exit.
                break;
                }
              }
                 break;    
       
                 
       
            case 2: // 2.Cancel tickets for an event.
                option2();
                while (true) {
                    String option2 = Menu.nextLine();
                    if (option2.equalsIgnoreCase("e")) {
                break;
                }
              }
                break;        
               
               
               
            case 3: // 3.Display full event schedule.
                option3(eventSchedule);
                while (true) {
                    String option3 = Menu.nextLine();
                    if (option3.equalsIgnoreCase("e")) {
                break;            
                }    
              }        
                break;    
               
               
               
            case 4: // 4.Redeem Discount Code.
                option4();
                while (true) {
                    String option4 = Menu.nextLine();
                    if (option4.equalsIgnoreCase("e")) {
                break;
                }
              }
                break;    
               
               
               
             case 5: // 5.Exit System.
                option5();
                while (true) {
                    String option5 = Menu.nextLine();
                    if (option5.equalsIgnoreCase("e")) {
                break;
                }
              }    
                break;
                default:
                   
                    System.out.println("  Invalid option, ");
          }
         } else {
             System.out.println("  Error, please input a valid number: ");
             Menu.nextLine(); // else statement prints error message and loops menu until a valid input.
         }
        }        
       }
       
       
       
       
       
       
       
       
        public static void cancelTicket (ArrayList<event> eventSchedule, int index, int unwantedTickets) {
            //cancel ticket method.
            event selectedEvent = eventSchedule.get(index); // Selects which event.
            int currentTickets = selectedEvent.getEventTickets();
             
         
             selectedEvent.setEventTickets(currentTickets + unwantedTickets); // adds unwanted tickets back to current tickets.
             
        }
       
       
   
         public static void buyTicket (ArrayList<event> eventSchedule, int index, int ticketsWanted) {
             //buy ticket method.
             event selectedEvent = eventSchedule.get(index); // Selects which event.
             int currentTickets = selectedEvent.getEventTickets();
         
             selectedEvent.setEventTickets(currentTickets - ticketsWanted); // takes away wanted tickets from current tickets.
         }
             
   
       
         
         
         
         
           public static void option1() {
               System.out.print("\f");
               System.out.println("  [1] Buy tickets for an event: \n ");
                         
               boolean eventFound = false;
               
               do {
               System.out.println("  Enter a NAME and DAY you wish to book tickets for: \n");  
           
               Scanner scanName = new Scanner(System.in);
                String eventNameTS; // added TS to the end of variables unique to 'TicketingService' class. avoids confusion with 'Event' class variables.
                                   
                System.out.print("  Event Name: ");
                eventNameTS = scanName.nextLine();
               
           
                String eventDayTS;
                System.out.print("  Event Day: ");
                Scanner scanDay = new Scanner(System.in);
                eventDayTS = scanDay.nextLine();
               
                while (!eventDayTS.equalsIgnoreCase("Monday") &&    // ensures input is a day of the week.
                       !eventDayTS.equalsIgnoreCase("Tuesday") &&
                       !eventDayTS.equalsIgnoreCase("Wednesday") &&
                       !eventDayTS.equalsIgnoreCase("Thursday") &&
                       !eventDayTS.equalsIgnoreCase("Friday") &&
                       !eventDayTS.equalsIgnoreCase("Saturday") &&
                       !eventDayTS.equalsIgnoreCase("Sunday"))        
                        {
                    System.out.println("  Please enter a valid day: ");
                    eventDayTS = scanDay.nextLine();
                }
               
               
               
             
            System.out.print("\n  Searching for '" + eventNameTS +  "' on " + eventDayTS);
           
             printDelay(600);
             System.out.print(".");
             printDelay(600);
             System.out.print(".");
             printDelay(600);
             System.out.print(".\n");
             printDelay(600);  
             System.out.print("\f");
           
             int ticketsWanted;    
             int index = -1; // initialized to -1 as no event has been found yet.
             
             Scanner scan = new Scanner(System.in);
             
             for (int i = 0; i < eventSchedule.size(); i++) { // for loop to get selected event.
                 event anEvent = eventSchedule.get(i);
                 
                 
                 
                 if (anEvent.eventDay.equalsIgnoreCase(eventDayTS) && anEvent.eventName.equalsIgnoreCase(eventNameTS)) { // found event.
                     System.out.println("\n" + anEvent); //prints event if found.
                     eventFound = true;
                     index = i; // sets index to the events position in the arrayList.
                     
                     if (eventFound = true) {
                     do { // loops until the user inputs a valid amount of tickets (tickets wanted < available tickets).
                         System.out.println("  Enter the amount of tickets you wish to buy: ");            
                         ticketsWanted = scan.nextInt();
                         
                         if(ticketsWanted > eventSchedule.get(index).getEventTickets()) { // not enough tickets.
                           
                        System.out.print("  .");
                        printDelay(600);
                        System.out.print(".");
                        printDelay(600);
                        System.out.print(".\n");
                        printDelay(800);
                            System.out.println("  Sorry, not enough available tickets.");
                            }
                             
                     } while(ticketsWanted > anEvent.getEventTickets()); //loops until valid amount of tickets is input.
                     
                         buyTicket(eventSchedule, index, ticketsWanted); // calls buyTicket method
                         
                         if(ticketsWanted == 1) {
                           
                           System.out.print("  .");
                           printDelay(600);
                           System.out.print(".");
                           printDelay(600);
                           System.out.print(".\n");
                           printDelay(800);
                             System.out.println("  Successfully Purchased " + ticketsWanted + " ticket!"); // if 1 ticket is purchased change "tickets" to "ticket".
                         }else {
                               printDelay(600);
                            System.out.print("  .");
                            printDelay(600);
                            System.out.print(".");
                            printDelay(600);
                            System.out.print(".\n");
                            printDelay(800);
                         System.out.println("  Successfully Purchased " + ticketsWanted + " tickets!");
                         }
                         
                         
                         printDelay(500);
                         System.out.println("\n  Please input a Contact Name and Number:  \n");  // input contact info, used for reciept.
                         
                         Scanner scanContactName = new Scanner (System.in);
                         System.out.println("  First Name:  ");
                         while (!scanContactName.hasNextLine()) { // ensures user inputs something.
                             System.out.println("  Invalid input, please enter a name:  ");
                             scanContactName.next();
                         }                  
                         String contactName  = scanContactName.next();  
                         
                                   
                         Scanner scanContactNumber = new Scanner (System.in);
                       System.out.println("  Contact Number: (+353) ");
                       while(!scanContactNumber.hasNextInt()) {  // ensures user inputs a number.
                           System.out.println("  Invalid input, please enter a number:  ");
                           scanContactNumber.next();
                       }                  
                       int contactNumber  = scanContactNumber.nextInt();
                         
                         
                         System.out.println("  First Name: " + contactName);
                         System.out.println("  Number: +353 " + contactNumber);
                         
                         
                         
                        printDelay(600);
                       System.out.print(".");
                       printDelay(600);
                       System.out.print(".");
                       printDelay(600);
                       System.out.print(".\n");
                       
                       printDelay(600);  
                       
                         
                         
                       Random number = new Random();  
                    int orderNumber = number.nextInt(9999999) +1;  // generates a random number between 1 and 9999999 for order number.
                   
                    String date = new SimpleDateFormat("  dd-MM-yyyy").format(Calendar.getInstance().getTime()); // finds real date of purchase using calander class.
                   
                    System.out.print("\f");
                         
                         // prints reciept.
                         System.out.println("\n ********************************* ");
                         
                         System.out.println("  Order: #" + orderNumber + "   " + date +"\n ");
                         
                         System.out.println(anEvent);
                         System.out.println(" ---------------------");
                             
                         System.out.println("  Customer Name: "+ contactName);
                       System.out.println("  Contact Number: +353 "+ contactNumber);
                       System.out.println(" ---------------------");
                       
                         System.out.println("  Tickets Bought: " + ticketsWanted);
                         
                         System.out.println("  Total: €‎" +  String.format("%.2f",eventSchedule.get(index).getEventPrice() * ticketsWanted));// ensures correct decimal places.
                                                                                      // multiply ticketsWanted by price.
                         System.out.println("\n  Thank You!");
                         
                         
                         System.out.println("\n  ******************************* ");                                    
                 }              
                }      
               }
     
             
             if (!eventFound) {          
                 System.out.println("  No event found.  \n  Would you like to look at the event schedule? \n ");          
                 System.out.println("  [1.Yes]   [2.No]");
             
                    Scanner displaySchedule = new Scanner(System.in);  
                    int scannerAnswer = scan.nextInt();
                   
                   
                     if(scannerAnswer == 1 || scannerAnswer == 2) {
                     
                         if(scannerAnswer == 1) { // displays schedule and prompts input.
                   
                          for (int i = 0; i < SIZE;i++)
                          {
                            printDelay(500);
                            System.out.println(eventSchedule.get(i));
                           }
                              printDelay(500);
                                System.out.println(" ---------------------");
                                }
                       
                     if(scannerAnswer == 2) {                                        
                         break; // break loop and prompt user to exit to main menu.
                     }                            
                 } else {
                     System.out.println("  Invalid option.");
                     break;
                 }              
                }          
               
            } while (!eventFound);
           
            System.out.println("\n  Enter 'E' to exit: ");
         }
           
           
           
     
   
           
           
        public static void option2() { // 2. Cancel tickets for an event
            System.out.print("\f");
            System.out.println("  [2] Cancel tickets for an event:  ");
           
            boolean eventFound = false;
               
               do {
               System.out.println("\n  Enter a NAME and DAY you wish to cancel tickets for: \n");  
               
               
               // same method of finding event as option1.
               Scanner scanName = new Scanner(System.in);
               String eventNameTS;
               
                           
                System.out.print("  Event Name: ");
                eventNameTS = scanName.nextLine();
                       
                String eventDayTS;
                System.out.print("  Event Day: ");
                Scanner scanDay = new Scanner(System.in);
                eventDayTS = scanDay.nextLine();
               
                while (!eventDayTS.equalsIgnoreCase("Monday") &&    // ensures input is a day of the week.
                       !eventDayTS.equalsIgnoreCase("Tuesday") &&
                       !eventDayTS.equalsIgnoreCase("Wednesday") &&
                       !eventDayTS.equalsIgnoreCase("Thursday") &&
                       !eventDayTS.equalsIgnoreCase("Friday") &&
                       !eventDayTS.equalsIgnoreCase("Saturday") &&
                       !eventDayTS.equalsIgnoreCase("Sunday"))        
                        {
                    System.out.println("  Please enter a valid day: ");
                    eventDayTS = scanDay.nextLine();
                }
         
                  System.out.print("\n  Searching for '" + eventNameTS +  "' on " + eventDayTS);
           
                   printDelay(600);
                    System.out.print(".");
                     printDelay(600);
                      System.out.print(".");
                     printDelay(600);
                    System.out.print(".\n");
                      printDelay(600);  
              System.out.print("\f");
                    int index = -1; // initialized to -1 as no event has been found yet.
         
                Scanner scan = new Scanner(System.in);
         
                   for (int i = 0; i < eventSchedule.size(); i++) { // finds selected event.
                    event anEvent = eventSchedule.get(i);
             
             
             
              if (anEvent.eventDay.equalsIgnoreCase(eventDayTS) && anEvent.eventName.equalsIgnoreCase(eventNameTS)) {
                  System.out.println("\n" + anEvent);
                  eventFound = true;
                  index = i; // sets index to the events position in the arrayList.
             
                 
                 
       
                  if (eventFound = true) {
                   
                    int unwantedTickets;
                   
                    do { // loops until the user inputs a valid amount of tickets (unwanted tickets < available tickets).
                      System.out.println("  Enter the amount of tickets you wish to cancel: ");
                    unwantedTickets = scan.nextInt();
                   
                            if(50 - eventSchedule.get(index).getEventTickets() < unwantedTickets) { // max tickets (50) - current tickets  < unwanted tickets. (ensures tickets wont go above 50).
                               System.out.println("  Sorry, you can't cancel more tickets than you have bought;");
                            }
                           
                           }while(50 - eventSchedule.get(index).getEventTickets() < unwantedTickets); // loop until valid input,
                   
                          cancelTicket(eventSchedule, index, unwantedTickets); // call cancel ticket method.
                        System.out.print("  .");
                       printDelay(600);
                       System.out.print(".");
                       printDelay(600);
                       System.out.print(".\n");
                       printDelay(800);
                          System.out.println("  Cancelled " + unwantedTickets + " ticket(s)");    
                       double refundAmount = unwantedTickets * eventSchedule.get(index).getEventPrice(); // gets refund amount.  unwanted tickets * price.
                         
                          System.out.println("  €" + String.format("%.2f", refundAmount) +" has been refunded to your account."); // formats double to only have 2 decimal places.                  
                   }                
               }
              }
         
          if (!eventFound) {
             
              // uses same method as option1 if event is not found.
             System.out.println("  No event found.  \n  Would you like to look at the event schedule? \n ");          
             System.out.println("  [1.Yes]   [2.No]");
           
                Scanner displaySchedule = new Scanner(System.in);  
                int scannerAnswer = scan.nextInt();
                           
                 if(scannerAnswer == 1 || scannerAnswer == 2) {
                 
                     if(scannerAnswer == 1) {
               
                      for (int i = 0; i < SIZE;i++)
                      {
                        printDelay(500);
                        System.out.println(eventSchedule.get(i));
                       }
                          printDelay(500);
                            System.out.println(" ---------------------");
                            }
                   
                 if(scannerAnswer == 2) {                                        
                     break;
                 }        
             } else {
                 System.out.println("  Invalid option.");
                 break;
             }    
            }      
             }while (!eventFound);          
               System.out.println("\n  Enter 'E' to exit: ");
        }
       
       
       
       
     
        public static void option3(ArrayList<event> eventSchedule) { // 3.Display full event schedule
            System.out.print("\f");
            System.out.println("  [3] Displaying full event schedule: \n ");
               
            for (int i = 0; i < SIZE;i++) // for loop iterates through each event.
            {
                printDelay(500);
                System.out.println(eventSchedule.get(i)); // prints event.
            }
            printDelay(300);
            System.out.println("  Enter 'E' to exit: ");
            }
       
       
       
       
       
        public static void option4() { // 4. Redeem discount Code.
            System.out.print("\f");
            System.out.println("  [4] Redeem Discount Code ");
           
            while(discountRecieved) { // prints if code is already redeemed.
                System.out.println("\n  Code already Redeemed. \n");
                break;
            }
       
            Scanner scan = new Scanner (System.in);
           
        while(!discountRecieved) {
            System.out.println("\n  Please input discount code:  "); // displays if code is not redeemed.
            int inputtedCode =scan.nextInt();
                 
            System.out.print("\n  Verifying ['" + inputtedCode + "']");
           
             printDelay(600);
            System.out.print(".");
            printDelay(600);
            System.out.print(".");
            printDelay(600);
            System.out.print(".\n");
            printDelay(600);  
           
            if (inputtedCode == discountCode) { // runs if input = discountCode.
                // discountCode is a randomly generated 4 digit code, displayed at the top of the program.
                 discountRecieved = true;        
                 
                 Random code = new Random();
                 Double discountPercentage = code.nextDouble() + 1; // sets discount randomly between 1% and 50%.
                         
                 String displayDiscount = String.format("%.0f", discountPercentage); // converts double to string to print with 0 decimal places.
                                                                                      // only used when displaying the discount amount.
                System.out.println("  Congratulations! \n");
                System.out.println("  You recieved a " + displayDiscount + "% discount on all tickets!");
               
           
               
                discountPercentage = discountPercentage/100; // update statement divides by 100, to make it easier to calculate total discount later.
               
               
                for (event e : eventSchedule) { // for loop iterates through ArrayList.
                    Double discountAmount =e.getEventPrice() * discountPercentage;  // calculates discount amount.
                    Double newPrice = e.getEventPrice() - discountAmount; // calculates new eventPrice.
                   
                    e.setEventPrice(newPrice, newPrice); // passes the newPrice value as the regular price and the discounted price.
                }          // sets new price in ArrayList.
            }
         
            if (inputtedCode != discountCode) { // display error if discount code is wrong.
                System.out.println("  Invalid or Expired code. \n");
                break; // break loop.
            }      
        }
            System.out.println("  Enter 'E' to exit: "); // switch statement listening in background for 'E' input.
        }    
           
       
       
        public static void option5() {  // 5.Exit System
            System.out.print("\f");
            System.out.print("  Exiting Ticketing Service ");
            printDelay(600);
            System.out.print(".");
            printDelay(600);
            System.out.print(".");
            printDelay(600);
            System.out.print(".\n");
            printDelay(800);
           
            System.out.print("  Ticket Service Closed.\n");
             
             System.exit(0); // exits program.
                   
        }
           
     
         
            // print Delay function to add some realism to the system.    
            private static void printDelay(Integer delay) {   // delay is counted in miliseconds.
            try {                                        
                      Thread.sleep(delay);                    
               } catch (InterruptedException ignore) {}
            }
           
           
           
            // displays a welcome message
            private static void welcome() {
                printDelay(0);
                System.out.println("\n");
                String welcomeMessage = "  Welcome to Jack's Ticketing Service!\n";  // Itterates through string and adds a delay to create an animated effect.
           
                for (int i = 0; i <welcomeMessage.length(); i++) {
                    System.out.print(welcomeMessage.charAt(i));
                    printDelay(10);
                }
               
               
                String welcomeUnderline = "  --------------------------------";
                for (int i = 0; i <welcomeUnderline.length(); i++) {
                    System.out.print(welcomeUnderline.charAt(i));
                    printDelay(10);
                   
                }
                String delay = "            ";
                for (int i = 0; i <delay.length(); i++) {
                    System.out.print(delay.charAt(i));
                    printDelay(100);
                   
                }
               
               
            }
               
           
   
   
       
        public static void main(String[] args) {
           
            // event driver is used to create the ArrayList and input data into all 5 events.
            eventDriver(); // also checks for overlapping events.
           
            // welcome method displays a welcome message.
            welcome(); // chose to not include this in the main menu as it only needs to be displayed once.
       
            // main menu method allows the user to navigate between all 5 options using a switch statement.
            mainMenu(); // also contains each options method i.e,  option3() // display event schedule.
           
        }
       
    }