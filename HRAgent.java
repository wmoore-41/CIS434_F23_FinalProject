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
    static void assignTicketToAgent(Ticket ticket, Agent agent){
        ticket.assignedAgents.add(agent);
        agent.assignedTickets.add(ticket);
    }

    void removeTicketFromAgent(Ticket ticket, Agent agent){
        ticket.assignedAgents.remove(agent);
        agent.assignedTickets.remove(ticket);
    }


    static void helpRequestListener(Ticket ticket){
        // add random agent from allAgents where agent is not in ticket.assignedAgents
        for (Agent a: allAgents) {
            if (!ticket.assignedAgents.contains(a)){    // if agent a is not an already assigned agent on this ticket, add him
                assignTicketToAgent(ticket, a);
            }
        }
    }



}
