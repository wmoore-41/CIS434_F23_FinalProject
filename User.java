import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class User {
    final String username;
    String password; // Not secure, but works for the purposes of this project.
    List<Ticket> requestedTickets;
    Ticket currentTicket;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.requestedTickets = new ArrayList<Ticket>();
    }

    // search for all tickets (open and closed) based on ID
    Ticket searchTickets(int ticketID){
        for (Ticket t: this.requestedTickets) {
            if (ticketID == t.ticketID){
                return t;
            }
        }
        return null;
    }

    // creates and returns a Ticket object given a title and a description
    Ticket createTicket(String title, String description){
        return new Ticket(this, title, description);
    }

    // prints all open tickets for the user, to the console
    void printAvailableTickets(){
        for (Ticket t :
                requestedTickets) {
            System.out.println( + t.ticketID + ": " + t.title);
        }
    }

    // Changes currently viewed ticket. If unable to find one, notifies user.
    void changeCurrentTicket(){
        Scanner input = new Scanner(System.in);
        int attemptTicketID;
        System.out.println("\nPlease select an new ticket:");
        if (input.hasNextInt()){
            attemptTicketID = input.nextInt();
            if (requestedTickets.contains(searchTickets(attemptTicketID))){
                int index = IntStream.range(0, requestedTickets.size()).filter(i -> requestedTickets.get(i).ticketID == attemptTicketID).findFirst().orElse(-1);
                currentTicket = requestedTickets.get(index);
            }
            else{
                System.out.println("\nCould not find a ticket with the requested ID.");
            }
        }
    }

    // User menu dialog
    void userMenuHandler(Ticket selectedTicket) {
        if (selectedTicket != null){
            System.out.println(
                    "\nCurrently Selected Ticket: " +
                            selectedTicket.ticketID +
                            "\n1) View Available Tickets" +
                            "\n2) Change Current Ticket" +
                            "\n3) View Current Ticket Details" +
                            "\n4) Open a New Ticket" +
                            "\n5) Log Out"
            );
        }
        else{
            System.out.println(
                    "\nCurrently Selected Ticket: none" +
                            "\n1) View Available Tickets" +
                            "\n2) Change Current Ticket" +
                            "\n3) View Current Ticket Details" +
                            "\n4) Open a New Ticket" +
                            "\n5) Log Out"
            );
        }
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            switch (input.nextInt()) {
                case 1:
                    if (!requestedTickets.isEmpty()) {
                        printAvailableTickets();
                    }
                    else{
                        System.out.println("\nYou have not requested any tickets!");
                    }
                    break;
                case 2:
                    if (!requestedTickets.isEmpty()){
                        changeCurrentTicket();
                    }
                    else {
                        System.out.println("\nThere are no support tickets available. Consider creating a new ticket.");
                    }
                    break;
                case 3:
                    if (currentTicket != null){
                        System.out.println(currentTicket);
                    }
                    else{
                        System.out.println("\nThere is no currently selected ticket.");
                    }
                    break;
                case 4:
                    Scanner newTicketInput = new Scanner(System.in);
                    String newTicketTitle;
                    String newTicketDescription;
                    // Ticket title loop
                    System.out.println("\nTitle your ticket: ");
                    while(true){
                        if (newTicketInput.hasNextLine()){
                            newTicketTitle = newTicketInput.nextLine();
                            break;
                        }
                        else{
                            System.out.println("Please enter a title!");
                        }
                    }
                    // Ticket description loop
                    System.out.println("\nGive a description of the problem you're having: ");
                    while(true){
                        if (newTicketInput.hasNextLine()){
                            newTicketDescription = newTicketInput.nextLine();
                            break;
                        }
                        else{
                            System.out.println("Please enter a description!");
                        }
                    }
                    if ((newTicketTitle != null) && (newTicketDescription != null)){
                        Ticket newTicket = createTicket(newTicketTitle, newTicketDescription); // Creates ticket and adds it to user's tickets
                    }
                    else{
                        System.out.println("There was an error creating your new ticket.");
                    }
                    break;
                case 5:
                    logOut();
                default:
                    System.out.println("\nInvalid menu option - please input an available integer.");
                    break;
            }
        }
    }

    void logOut(){
        System.out.println("\nAs this is a demo of a project with randomly generated data, " +
                "logging out will not save any of your changes. \nLogging out...");
        System.exit(0);
    }
}
