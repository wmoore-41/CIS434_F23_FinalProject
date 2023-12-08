import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class User {
    final String username;
    String password; // Not secure, but works for the purposes of this project.
    List<Ticket> requestedTickets;


    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.requestedTickets = new ArrayList<Ticket>();
    }



    // search for a ticket based on ID
    Ticket searchTickets(int ticketID){
        List<Ticket> all = new ArrayList<>(HRAgent.openTickets);
        all.addAll(HRAgent.closedTickets);
        for (Ticket t: all){
            if(t.ticketID == ticketID){
                return t;
            }
        }
        return null;
    }



    // creates and returns a Ticket object given a title and a description
    Ticket createTicket(String title, String description){
        return new Ticket(this, title, description);
    }

    void printAvailableTickets(){
        for (Ticket t : requestedTickets) {
            System.out.println(t);
        }
    }

    void userMenuHandler(Ticket selectedTicket) {
        System.out.println(
                "1) View Available Tickets\n" +
                        "2) Open a New Ticket\n" +
                        "3) Log Out"
        );
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            switch (input.nextInt()) {
                case 1:
                    if (!requestedTickets.isEmpty()) {
                        printAvailableTickets();
                    }
                    break;
                case 2:
                    // Add new ticket creation
                    break;
                case 3:
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
