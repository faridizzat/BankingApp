package guis;

import db_objs.myJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGui extends BaseFrame {
    public RegisterGui() {
        super("Banking App Register");
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
        passwordLabel.setBounds(20, 220, super.getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        //create password text field
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setBounds(20, 260, super.getWidth() - 50, 40);
        passwordTextField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(passwordTextField);

        //repeat password label
        JLabel repeatPasswordLabel = new JLabel("Repeat Password:");

        //getWidth() returns the width of the frame
        repeatPasswordLabel.setBounds(20, 320, super.getWidth() - 50, 24);
        repeatPasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(repeatPasswordLabel);

        //create repeat password text field
        JPasswordField repeatPasswordTextField = new JPasswordField();
        repeatPasswordTextField.setBounds(20, 360, super.getWidth() - 50, 40);
        repeatPasswordTextField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(repeatPasswordTextField);

        //create register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 460, super.getWidth() - 50, 40);
        registerButton.setFont(new Font("Dialog", Font.BOLD, 20));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get username
                String username = userNameTextField.getText();

                //get password
                String password = String.valueOf(passwordTextField.getPassword());

                //get repeat password
                String repeatPassword = String.valueOf(repeatPasswordTextField.getPassword());

                //validate the user input
                if(validateUserInput(username, password, repeatPassword)) {
                    //attempt to register user to the db
                    if(myJDBC.register(username, password)) {
                        //register success
                        //dispose of this gui
                        RegisterGui.this.dispose();

                        //launch the login gui
                        LoginGui loginGui = new LoginGui();
                        loginGui.setVisible(true);

                        //create dialog box
                        JOptionPane.showMessageDialog(loginGui, "Registered Account Successfully");

                    } else {
                        //register failed
                        JOptionPane.showMessageDialog(RegisterGui.this, "Error: Username already taken");

                    }

                } else {
                    //invalid user input
                    JOptionPane.showMessageDialog(RegisterGui.this, "Error: Username must be at least 6 characteres\n" + "and/or Password must match");
                }
            }
        });
        add(registerButton);

        //create login label
        JLabel loginLabel = new JLabel("<html><a href=\"#\">Have an account? Login here</a></html>");
        loginLabel.setBounds(0, 510, super.getWidth() - 10, 30);
        loginLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);

    }

    private boolean validateUserInput (String username, String password, String repeatPassword) {
        //all fields must have value
        if (username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            return false;
        }

        //username has to be at least 6 characters long
        if (username.length() < 6) {
            return false;
        }

        //password and repeat password must be the same
        if (!password.equals(repeatPassword)) {
            return false;
        }
        //passes validation
        return true;
    }
}
