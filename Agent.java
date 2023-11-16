import java.util.ArrayList;
import java.util.List;

public class Agent {
    // Are assigned to/removed from tickets
    // Can close tickets
    // Can request help from HR (HR will then assign another agent to ticket)
    // Can be assigned multiple tickets
    final String username;
    private String password;
    List<Ticket> assignedTickets;

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

    // Request Help on specific ticket
    void requestHelp(Ticket ticket){
        HRAgent.helpRequestListener(ticket);
    }
}
