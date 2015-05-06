package View.Main;

import View.Panels.RegisterPanel;
import View.Panels.TripsBrowsePanel;
import View.Panels.WelcomePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Denis on 29.3.2015.
 */
public class MainFrame extends JFrame{
    public MainFrame()
    {
        setTitle("The title should be changed!");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        setSize(640, 480);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(640, 480));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //TODO: perform logouts and other non-handled staff here
                System.out.println("Frame closing");
                super.windowClosing(e);
            }
        });
        //goToWelcomeScreen();
        goToTripsBrowsing(0, 0);
    }
    public void goToWelcomeScreen()
    {
        getContentPane().removeAll();
        WelcomePanel wp = new WelcomePanel(this);
        add(wp);
        revalidate();
        repaint();
    }
    public void goToRegisterScreen()
    {
        getContentPane().removeAll();
        RegisterPanel rp = new RegisterPanel(this);
        add(rp);
        revalidate();
        repaint();
    }
    public void goToTripsBrowsing(int startFrom, int userID)
    {
        getContentPane().removeAll();
        TripsBrowsePanel tbp = new TripsBrowsePanel(this, startFrom, userID);
        add(tbp);
        revalidate();
        repaint();
    }

}
