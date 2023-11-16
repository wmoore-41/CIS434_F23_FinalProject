import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class User {
    final String username;
    String password; // Not secure, but works for the purposes of this project.


    public User(String username, String password){
        this.username = username;
        this.password = password;
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

    // creates and returns a Ticket object given title, description, priority and a category
    Ticket createTicket(String title, String description, Priority priority, Ticket.Category category){
        return new Ticket(this, title, description, priority, category);
    }
}
