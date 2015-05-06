package View.Panels;

import View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Denis on 9.4.2015.
 */
public class UserTripsPanel extends JPanel{
    private Map<JButton, Integer> uidMap = new HashMap<JButton, Integer>();         //used to access trips by button click
    private final Dimension preferredScrollerPanelSize = new Dimension(640, 400);   //max size of scroller
    private JPanel thisPanel;                                                       //reference to this panel
    public UserTripsPanel(final MainFrame mainFrame, final int userID)
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //user info
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setAlignmentX(CENTER_ALIGNMENT);
        userInfoPanel.setLayout(new BoxLayout(userInfoPanel, BoxLayout.PAGE_AXIS));
        JLabel userEmailLabel = new JLabel("Logged in as : blah@gmail.com");
        JLabel userNameLabel = new JLabel("Name: Joe Doe");

        userInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        userInfoPanel.add(userEmailLabel);
        userInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        userInfoPanel.add(userNameLabel);
        userInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        //construct jpanels for view
        List<JPanel> panelList = new ArrayList<JPanel>();
        for (int i = 0; i < 10; i++) {

            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.LINE_AXIS));
            tempPanel.setBorder(BorderFactory.createTitledBorder(""));
            int uid = (int) (i * (Math.random() * 100));
            int cost = i * 7365;
            String location = "Somewhere";
            JTextArea tripInfo = new JTextArea("This is trip number " + i + ". It shows surroundings of " + location + " for only " + cost + "!\nOverall cost: " + cost +
                    "\nUnique ID: " + uid);
            tripInfo.setOpaque(false);
            tripInfo.setEditable(false);
            tempPanel.add(tripInfo);
            JButton viewTripButton = new JButton("View");
            uidMap.put(viewTripButton, uid);
            viewTripButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainFrame.goToViewTrip(uidMap.get((JButton) e.getSource()), thisPanel);
                }
            });
            tempPanel.add(viewTripButton);
            panelList.add(tempPanel);
        }

        //construct list view
        JPanel tripsListPanel = new JPanel();
        tripsListPanel.setLayout(new BoxLayout(tripsListPanel, BoxLayout.PAGE_AXIS));
        for (int i = 0; i < 10; i++) {
            tripsListPanel.add(panelList.get(i));
        }

        //create a scroller for list
        JScrollPane tripsListScroller = new JScrollPane(tripsListPanel);
        //TODO: vertical scroll bar's position should be at top
        // tripsListScroller.getVerticalScrollBar().setValue(tripsListScroller.getVerticalScrollBar().getMinimum());
        tripsListScroller.setPreferredSize(preferredScrollerPanelSize);


        //control buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
        JButton quitButton = new JButton("Quit");
        JButton browseTripsButton = new JButton("Browse trips");

        controlPanel.add(quitButton);
        controlPanel.add(Box.createHorizontalGlue());
        controlPanel.add(browseTripsButton);

        //construct overall view
        add(userInfoPanel);
        add(tripsListScroller);
        add(controlPanel);
        tripsListScroller.setBorder(BorderFactory.createTitledBorder("My trips"));

        thisPanel = this;

        //button listeners
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        browseTripsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.goToTripsBrowsing(0, userID);
            }
        });
    }
}
