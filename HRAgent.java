import java.util.ArrayList;
import java.util.List;
public class HRAgent{
    // Can assign/remove tickets to other agents
    // Can't work on tickets
    // Can create profiles
    //
    static List<Agent> allAgents;
    static List<Ticket> openTickets;
    static List<Ticket> closedTickets;
    final String username;
    private String password;


    // Default constructor
    public HRAgent(String username, String password){
        this.username = username;
        this.password = password;
        allAgents = new ArrayList<>();
        openTickets = new ArrayList<>();
        closedTickets = new ArrayList<>();
    }

    // HRAgent creates Agent profiles
    Agent createAgent(String username, String password){
        return new Agent(username, password);
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
            if (!ticket.assignedAgents.contains(a)){    // if agent is not an already assigned agent on this ticket, add them
                assignTicketToAgent(ticket, a);
            }
        }
    }


}
