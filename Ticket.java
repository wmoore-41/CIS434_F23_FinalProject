import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Priority {
    LOW,
    MEDIUM,
    HIGH
}



public class Ticket {
    enum Category {
        GENERAL,
        SPECIAL,
        OTHER
    }
    List<Agent> assignedAgents;
    final int ticketID;
    final User requester;
    String title;
    String description;
    Priority priority;
    Category category;
    LocalDateTime dueDate;
    boolean isOpen;

    // Default constructor for Ticket instances
    public Ticket(User requester, String title, String description, Priority priority, Category category){
        this.requester = requester;
        Random r = new Random();
        this.ticketID = r.nextInt(1000, 10000);
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.dueDate = LocalDateTime.now().plusDays(3);
        this.assignedAgents = new ArrayList<Agent>();
        this.isOpen = true;
    }


    void close(){
        this.isOpen = false;
        // Remove the ticket from any agents' assigned tickets, then remove all assigned agents from it
        for (Agent a :assignedAgents) {
            a.assignedTickets.remove(this);
        }
        assignedAgents.clear();
    }

}
