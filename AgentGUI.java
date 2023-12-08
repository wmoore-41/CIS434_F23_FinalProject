import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgentGUI extends JFrame{
    private JButton SelectTicketButton;
    private JButton CompleteTicketButton;
    private JButton LogOutButton;
    private JLabel TitleLabel;
    private JPanel MainPanel;

    public AgentGUI() {

        this.setContentPane(this.MainPanel);
        this.setLocationRelativeTo(null);
        this.setTitle("Support System - Agent");
        this.pack();
        this.setVisible(true);

        SelectTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectTicketButtonHandler();
            }
        });
    }

    private void $$$setupUI$$$(){
        SelectTicketButton = new JButton();
        CompleteTicketButton = new JButton();
        LogOutButton = new JButton();
        TitleLabel = new JLabel();
    }

    private void selectTicketButtonHandler(){

    }
}
