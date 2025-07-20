package guis;

import javax.swing.*;

/*
    Creating an abstract class helps us setup the blueprint that our GUIs will follow, for example
    in each of the GUISs they will be the same size and will need to invoke their own addGuiComponents()
    which will be unique to each subclass
 */
public abstract class BaseFrame extends JFrame {
    public BaseFrame(String title) {
        initialize(title);
    }

    private void initialize(String title) {
        //instantiates jframe properties and add a title to the bar
        setTitle(title);

        //set size (in pixels)
        setSize(420, 600);

        //terminate program on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set Layout to null to have absolute layout which allows us to manually specify the size and position of each gui component
        setLayout(null);

        //prevent resizing
        setResizable(false);

        //set location center on screen
        setLocationRelativeTo(null);

        //call on the subclass addGuiComponents method
        addGuiComponents();
    }

    //abstract method for adding GUI components
    public abstract void addGuiComponents();

}
