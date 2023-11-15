import java.util.List;
public class HRAgent {
    // Can assign/remove tickets to other agents
    // Can't work on tickets
    // Can create profiles
    //

    String username;
    private String password;
    static List<Agent> allAgents;


    // Default constructor
    public HRAgent(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Assign Ticket to Agent
    void assignTickettoAgent(Ticket ticket, Agent agent){
        ticket.assignedAgents.add(agent);
        agent.assignedTickets.add(ticket);
    }

    void removeTicketfromAgent(Ticket ticket, Agent agent){
        ticket.assignedAgents.remove(agent);
        agent.assignedTickets.remove(ticket);
    }


    void helpRequestListener(Ticket ticket){
        // add random agent from allagents where agent is not in ticket.assignedAgents
        for (Agent a:
                allAgents) {
            if (!ticket.assignedAgents.contains(a)){
                assignTickettoAgent(ticket, a);
            }
        }
    }



}
