import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Ticket {
    enum Priority {LOW, MEDIUM, HIGH}
    enum Category {GENERAL, SPECIAL, OTHER}
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
    public Ticket(User requester, String title, String description){
        this.requester = requester;
        requester.requestedTickets.add(this);
        this.ticketID = new Random().nextInt(1000, 10000); // random four-digit number
        this.title = title;
        this.description = description;
        this.priority = Priority.LOW; // default low priority unless changed
        this.category = Category.GENERAL; // default general category unless changed
        this.dueDate = LocalDateTime.now().plusDays(3); // default deadline of 3 days
        this.assignedAgents = new ArrayList<Agent>();
        this.isOpen = true;
    }


    void close(){
        this.isOpen = false;
        // Remove the ticket from all agents' assigned tickets, then remove all assigned agents from it
        for (Agent a :assignedAgents) {
            a.assignedTickets.remove(this);
        }
        assignedAgents.clear();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Ticket ID: ").append(this.ticketID).append("\n");
        res.append("Ticket Status: ").append(isOpen ? "Open" : "Closed").append("\n");
        res.append("Title: ").append(this.title).append("\n");
        res.append("Description: ").append(this.description).append("\n");
        res.append("Requested by User: ").append(this.requester.username).append("\n");
        res.append("Assigned Agents: "); // Agents block
        for (Agent a :
                this.assignedAgents) {
            res.append(a.username).append(" ");
        }
        res.append("\n");
        res.append("Due By: ").append(this.dueDate).append("\n");
        res.append("Priority: ").append(this.priority).append(", Category: ").append(this.category).append("\n");
        return res.toString();
    }
}
