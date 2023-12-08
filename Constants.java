import java.util.ArrayList;
import java.util.stream.IntStream;

public class Constants {
    static String[] defaultUserLogin = new String[] {"User", "Password"};
    static String[] defaultAgentLogin = new String[] {"Agent", "Password"};

    static ArrayList<Ticket> defaultTickets = new ArrayList<Ticket>();
    static ArrayList<User> defaultUsers = new ArrayList<User>();
    static ArrayList<Agent> defaultAgents = new ArrayList<Agent>();

    static void generateUsers(){
        defaultUsers.add(new User("User1", "Password1"));
        defaultUsers.add(new User("User2", "Password2"));
        defaultUsers.add(new User("User3", "Password3"));
        defaultUsers.add(new User("User4", "Password4"));
        defaultUsers.add(new User("User5", "Password5"));
    }

    static void generateAgents(){
        defaultAgents.add(new Agent("Agent1", "Password1"));
        defaultAgents.add(new Agent("Agent2", "Password2"));
        defaultAgents.add(new Agent("Agent3", "Password3"));
    }

    static void generateTickets(){
        int index = IntStream.range(0, defaultUsers.size()).filter(i -> defaultUsers.get(i).username.equals("User1")).findFirst().orElse(-1);
        defaultTickets.add(new Ticket(defaultUsers.get(index), "I don't like this program.", "This is difficult to write."));
        index = IntStream.range(0, defaultUsers.size()).filter(i -> defaultUsers.get(i).username.equals("User2")).findFirst().orElse(-1);
        defaultTickets.add(new Ticket(defaultUsers.get(index), "I need help with this program.", "I can't get this thing to work."));
        index = IntStream.range(0, defaultUsers.size()).filter(i -> defaultUsers.get(i).username.equals("User3")).findFirst().orElse(-1);
        defaultTickets.add(new Ticket(defaultUsers.get(index), "Very vague title.", "I just want to know how to randomly generate data."));
        index = IntStream.range(0, defaultUsers.size()).filter(i -> defaultUsers.get(i).username.equals("User4")).findFirst().orElse(-1);
        defaultTickets.add(new Ticket(defaultUsers.get(index), "Extremely descriptive title.", "I would like to know if there's an easier way to do this."));
        index = IntStream.range(0, defaultUsers.size()).filter(i -> defaultUsers.get(i).username.equals("User5")).findFirst().orElse(-1);
        defaultTickets.add(new Ticket(defaultUsers.get(index), "What is the standard Lorem Ipsum text?", "Lorem Ipsum description."));
    }

    static void assignDefaultTickets(Agent agent){
        for (Ticket t: defaultTickets) {
            if (t.assignedAgents.isEmpty()) {
                t.assignedAgents.add(agent);
                agent.assignedTickets.add(t);
            }
        }
    }
}
