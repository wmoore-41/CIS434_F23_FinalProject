import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class LoginGUI extends JFrame{
    private JButton CancelButton;
    private JButton LogInButton;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JTextField UsernameTextField;
    private JPanel MainPanel;
    private JTextField PasswordTextField;
    private JOptionPane IncorrectLogin;


    public LoginGUI() {

        this.setContentPane(this.MainPanel);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

        LogInButton.addActionListener(e -> {
            if (e.getSource() == LogInButton){

            }

        });
        CancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



    }


    public String getUsername(){
        return UsernameTextField.getText();
    }

    public String getPassword(){
        return PasswordTextField.getText();
    }
    private void $$$setupUI$$$() {
        CancelButton = new JButton();
        LogInButton = new JButton();
        UsernameLabel = new JLabel();
        PasswordLabel = new JLabel();
        UsernameTextField = new JFormattedTextField();
        PasswordTextField = new JFormattedTextField();
        MainPanel = new JPanel();
    }

    public void close(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
