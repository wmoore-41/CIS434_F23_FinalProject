import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
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
    int ticketID;
    User requester;
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
        this.ticketID = r.nextInt(1000, 9999);
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.dueDate = LocalDateTime.now().plusDays(3);
        this.isOpen = true;

    }


    void close(){
        this.isOpen = false;
    }

}
