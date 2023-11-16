public class User {
    final String username;
    String password; // Not secure, but works for the purposes of this project.
    int numActiveTickets;


    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.numActiveTickets = 0;
    }



    // search for a ticket based on ID
    Ticket searchTickets(int ticketID){
        for (Ticket t: HRAgent.allTickets){
            if(t.ticketID == ticketID){
                return t;
            }
        }
        return null;
    }

    // creates and returns a Ticket object given title, description, priority and a category
    Ticket createTicket(String title, String description, Priority priority, Ticket.Category category){
        return new Ticket(this, title, description, priority, category);
    }
}
