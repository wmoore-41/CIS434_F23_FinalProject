import javax.swing.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args){
        printLoginMenu();
    }

    public static void printLoginMenu(){
        String username;
        String password;
        User defaultUser = new User(Constants.defaultUserLogin[0], Constants.defaultUserLogin[1]);
        Agent defaultAgent = new Agent(Constants.defaultAgentLogin[0], Constants.defaultAgentLogin[1]);
        Constants.generateUsers();
        Constants.generateAgents();
        Constants.generateTickets();
        Constants.assignDefaultTickets(defaultAgent);

        Scanner loginInput = new Scanner(System.in);
        //LoginGUI LoginWindow = new LoginGUI();


        System.out.println("\nEnter your username:");
        username = loginInput.nextLine();
        System.out.println("\nEnter your password:");
        password = loginInput.nextLine();
        // This whole section is a) not secure and b) not how it would be implemented real world
        if (logIn(username, password)){
            if (username.equals(Constants.defaultUserLogin[0])){
                // Run user session
                UserSession(defaultUser);
            } else if (username.equals(Constants.defaultAgentLogin[0])) {
                // Run agent session
                AgentSession(defaultAgent);
            }
        }
        else {
            JOptionPane messagePopup = new JOptionPane();
            messagePopup.createDialog("Invalid Login!");
            messagePopup.setMessage("You have entered an incorrect username or password. Please retry.");
        }
    }





    public static boolean logIn(String username, String password){
        if (username.equals(Constants.defaultUserLogin[0])){
            return (password.equals(Constants.defaultUserLogin[1]));
        } else if (username.equals(Constants.defaultAgentLogin[0])) {
            return (password.equals(Constants.defaultUserLogin[1]));
        }
        return false;
    }

    public static void UserSession(User user){
        //UserGUI UserSessionWindow = new UserGUI();
        System.out.println("\nWelcome, " + user.username + "!");

    }
    public static void AgentSession(Agent agent){
        //AgentGUI AgentSessionWindow = new AgentGUI();
        System.out.println("\nWelcome, " + agent.username + "!");
        do{
            if (agent.currentTicket != null){
                if (agent.currentTicket.isOpen){
                    agent.agentMenuHandler(agent.currentTicket);
                }
                else{
                    agent.agentMenuHandler(null);
                }
            }
            else {
                agent.agentMenuHandler(null);
            }
        }while(true);
    }
}
