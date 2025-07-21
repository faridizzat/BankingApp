package guis;
import db_objs.User;

import javax.swing.*;
import java.awt.*;

/*
    Performs banking functions such as depositing, withdrawing, seeing past transaction and transferring
    This extends from the BaseFrame which emans we will need to define our own addGuiComponents()
 */



public class BankingAppGui extends BaseFrame {
    public BankingAppGui(User user) {
        super("Banking App GUI", user);
    }


    @Override
    public void addGuiComponents() {
        //create welcome message
        String welcomeMessage = "<html>" +
                "<body style='text-align:center'>" +
                "<b>Hello " + user.getUsername() + "</b><br>" +
                "What would you like to do today?</body></html>";
        JLabel welcomeMessageLabel = new JLabel(welcomeMessage);
        welcomeMessageLabel.setBounds(0,20, getWidth()-10, 40);
        welcomeMessageLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(welcomeMessageLabel);

    }
}
