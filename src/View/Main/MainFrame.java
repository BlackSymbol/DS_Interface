package View.Main;

import View.Panels.RegisterScreen;
import View.Panels.StartScreen;

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
        goToStartScreen();
    }
    public void goToStartScreen()
    {
        getContentPane().removeAll();
        StartScreen ss = new StartScreen(this);
        add(ss);
        revalidate();
        repaint();
    }
    public void goToRegisterScreen()
    {
        getContentPane().removeAll();
        RegisterScreen rs = new RegisterScreen(this);
        add(rs);
        revalidate();
        repaint();
    }

}
