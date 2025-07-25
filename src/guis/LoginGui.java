package guis;

/*
    This gui will allow usere to login or launc the register gui
    This extends from the BaseFrame which emans we will need to define our own addGuiComponents()
 */

import db_objs.User;
import db_objs.myJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class LoginGui extends BaseFrame {
    public LoginGui() {
        super("Banking App Login");
    }

    @Override
    public void addGuiComponents() {
        //create banking app label
        JLabel bankingAppLabel = new JLabel("Banking Application");

        //set the location adn the size of the gui component
        bankingAppLabel.setBounds(0, 20, super.getWidth(), 40);

        //change font style
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        //center the text
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //add to gui
        add(bankingAppLabel);

        //username label
        JLabel userNameLabel = new JLabel("Username:");

        //getWidth() returns the width of the frame
        userNameLabel.setBounds(20, 120, super.getWidth() - 30, 24);

        userNameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(userNameLabel);

        //create username text field
        JTextField userNameTextField = new JTextField();
        userNameTextField.setBounds(20, 160, super.getWidth() - 50, 40);
        userNameTextField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(userNameTextField);

        //password label
        JLabel passwordLabel = new JLabel("Password:");

        //getWidth() returns the width of the frame
        passwordLabel.setBounds(20, 280, super.getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        //create password text field
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setBounds(20, 320, super.getWidth() - 50, 40);
        passwordTextField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(passwordTextField);

        //create login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 460, super.getWidth() - 50, 40);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 20));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get username
                String username = userNameTextField.getText();

                //get password
                String password = String.valueOf(passwordTextField.getPassword());

                //validate login
                User user = myJDBC.validateLogin(username, password);

                //if user is null it means invalid otherwise it is a valid accont
                if (user != null) {
                    //means valid login

                    //dispose this gui
                    LoginGui.this.dispose();

                    //launch bank app gui
                    BankingAppGui bankingAppGui = new BankingAppGui(user);
                    bankingAppGui.setVisible(true);

                    //show success message
                    JOptionPane.showMessageDialog(bankingAppGui, "Login successful");
                } else {
                    //invalid login
                    JOptionPane.showMessageDialog(LoginGui.this, "Login failed");
                }
            }
        });
        add(loginButton);

        //create register label
        JLabel registerLabel = new JLabel("<html><a href=\"#\">Don't have an account? Register here</a></html>");
        registerLabel.setBounds(0, 510, super.getWidth() - 10, 30);
        registerLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //adds an event listener so when the mouse is clicked it will launch the register gui
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //dispose of this gui
                LoginGui.this.dispose();

                //launch the register gui
                new RegisterGui().setVisible(true);
            }
        });
        add(registerLabel);




    }
}
