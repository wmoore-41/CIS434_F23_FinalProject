import java.util.ArrayList;
import java.util.List;

public class Agent {
    // Are assigned to/removed from tickets
    // Can close tickets
    // Can request help from HR (HR will then assign another agent to ticket)
    // Can be assigned multiple tickets
    String username;
    private String password;
    List<Ticket> assignedTickets;

    public Agent(String username, String pw){
        this.username = username;
        this.password = pw;
        this.assignedTickets = new ArrayList<Ticket>(5);
    }




    // Close ticket
    void closeTicket(Ticket ticket){
        ticket.close();
    }

    Ticket searchTicket(int ticketID){
        for (Ticket t: this.assignedTickets) {
            if (ticketID == t.ticketID){
                return t;
            }
        }
        return null;
    }

    // Request Help on specific ticket


}
