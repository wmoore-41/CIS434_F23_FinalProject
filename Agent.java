import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Agent {
    // Can close tickets
    // Is assigned to tickets
    // Can be assigned multiple tickets
    // Can change current ticket and see all available tickets
    final String username;
    private String password;
    List<Ticket> assignedTickets;
    Ticket currentTicket;

    public Agent(String username, String password){
        this.username = username;
        this.password = password;
        this.assignedTickets = new ArrayList<Ticket>();
    }

    // Close ticket
    void closeTicket(Ticket ticket){
        ticket.close();
    }

    // Search for a ticket based on Ticket ID
    Ticket searchTicket(int ticketID){
        for (Ticket t: this.assignedTickets) {
            if (ticketID == t.ticketID){
                return t;
            }
        }
        return null;
    }

    void printAvailableTickets(){
        for (Ticket t :
                assignedTickets) {
            System.out.println( + t.ticketID + ": " + t.title);
        }
    }

    void agentMenuHandler(Ticket selectedTicket){
        if (selectedTicket!= null){
            System.out.println(
                    "\nCurrently Selected Ticket: " +
                            selectedTicket.ticketID +
                            "\n1) Change Selected Ticket" +
                            "\n2) Resolve Ticket" +
                            "\n3) View Available Tickets" +
                            "\n4) View Info on Current Ticket" +
                            "\n5) Log Out"
            );
        }
        else{
            System.out.println(
                    "\nCurrently Selected Ticket: none" +
                            "\n1) Change Selected Ticket" +
                            "\n2) Resolve Ticket" +
                            "\n3) View Available Tickets" +
                            "\n4) View Info on Current Ticket" +
                            "\n5) Log Out"
            );
        }
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()){
            switch (input.nextInt()){
                case 1:
                    // Change selected Ticket
                    changeCurrentTicket();
                    break;
                case 2:
                    if (selectedTicket != null){
                        closeTicket(currentTicket);
                        System.out.println("\nTicket # " + selectedTicket.ticketID + " closed.");
                    }
                    else{
                        System.out.println("\nThere is no currently selected ticket. Please select a ticket, then close it.");
                    }
                    break;
                case 3:
                    if (!assignedTickets.isEmpty()){
                        printAvailableTickets();
                    }
                    else{
                        System.out.println("\nNo assigned tickets. No work for you!");
                    }
                    break;
                case 4:
                    if (currentTicket != null){
                        System.out.println(currentTicket);
                    }
                    else{
                        System.out.println("\nThere is no currently selected ticket.");
                    }
                    break;
                case 5:
                    logOut(); // Exits program
                default:
                    System.out.println("\nInvalid menu option - please input an available integer.");
                    break;
            }
        }
    }

    void changeCurrentTicket(){
        Scanner input = new Scanner(System.in);
        int attemptTicketID;
        System.out.println("\nPlease select an new ticket:");
        if (input.hasNextInt()){
            attemptTicketID = input.nextInt();
            if (assignedTickets.contains(searchTicket(attemptTicketID))){
                int index = IntStream.range(0, assignedTickets.size()).filter(i -> assignedTickets.get(i).ticketID == attemptTicketID).findFirst().orElse(-1);
                currentTicket = assignedTickets.get(index);
            }
        }
    }

    // Request Help on specific ticket
    // No current use, still need to implement
    void requestHelp(Ticket ticket){
        HRAgent.helpRequestListener(ticket);
    }

    void logOut(){
        System.out.println("\nAs this is a demo of a project with randomly generated data, " +
                "logging out will not save any of your changes. \nLogging out...");
        System.exit(0);
    }
}
