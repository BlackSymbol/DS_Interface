package View.Panels;

import View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Denis on 9.4.2015.
 */
//used to browse trips
    //TODO:
//each trip has "add to basket" and "view trip" button
public class TripsBrowsePanel extends JPanel{
    private final Dimension maxComboBoxSize = new Dimension(200, 25);               //max size of comboboxes
    private final Dimension preferredScrollerPanelSize = new Dimension(640, 400);   //preferred size of scroller
    private Map<JButton, Integer> uidMap = new HashMap<JButton, Integer>();         //used to access trips by button click
    private JPanel thisPanel;
    public TripsBrowsePanel(final MainFrame mainFrame, final int startFrom, final int userID) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //construct sorts
        JPanel sortSelectionPanel = new JPanel();
        sortSelectionPanel.setLayout(new BoxLayout(sortSelectionPanel, BoxLayout.LINE_AXIS));
        JLabel sortByLabel = new JLabel("Sort by: ");
        String[] sortType = {"Rating", "Price"};
        JComboBox sortTypeBox = new JComboBox(sortType);
        sortTypeBox.setMaximumSize(maxComboBoxSize);
        JLabel sortOrderLabel = new JLabel("Ordering: ");
        String[] sortOrder = {"From highest to lowest", "From lowest to highest"};
        JComboBox sortOrderBox = new JComboBox(sortOrder);
        sortOrderBox.setMaximumSize(maxComboBoxSize);

        sortSelectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        sortSelectionPanel.add(sortByLabel);
        sortSelectionPanel.add(sortTypeBox);
        sortSelectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        sortSelectionPanel.add(sortOrderLabel);
        sortSelectionPanel.add(sortOrderBox);
        sortSelectionPanel.add(Box.createRigidArea(new Dimension(10, 0)));


        //we will receive 10 trips from DB
        //Set<Trip> tripsSet = getFromDB(n, n+10);

        //construct jpanels for view
        List<JPanel> panelList = new ArrayList<JPanel>();
        //clear uidMap for futher usage
        uidMap.clear();
        for (int i = 0; i < 10; i++) {
            JPanel tempPanel = new JPanel();
            tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.LINE_AXIS));
            tempPanel.setBorder(BorderFactory.createTitledBorder(""));
            int uid = (int) ((i+startFrom) * (Math.random() * 100));
            int cost = (i+startFrom) * 7365;
            String location = "Somewhere";
            JTextArea tripInfo = new JTextArea("This is trip number " + i + ". It shows surroundings of " + location + " for only " + cost + "!\nOverall cost: " + cost +
                    "\nUnique ID: " + uid);
            tripInfo.setOpaque(false);
            tripInfo.setEditable(false);
            tempPanel.add(tripInfo);
            JButton viewTripButton = new JButton("View");
            JButton payForTrip = new JButton("Pay");
            uidMap.put(viewTripButton, uid);
            viewTripButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO: should redirect here to TripInfoPanel
                    mainFrame.goToViewTrip(uidMap.get((JButton) e.getSource()), thisPanel);
                }
            });
            tempPanel.add(viewTripButton);
            tempPanel.add(payForTrip);
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
        tripsListScroller.setPreferredSize(preferredScrollerPanelSize);
        //tripsListScroller.getVerticalScrollBar().setValue(tripsListScroller.getVerticalScrollBar().getMinimum());


        //create control buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
        JButton prevTripsButton = new JButton("Previous");
        JButton nextTripsButton = new JButton("Next");
        JButton userStartScreenButton = new JButton("View my trips");

        controlPanel.add(prevTripsButton);
        controlPanel.add(nextTripsButton);
        controlPanel.add(Box.createHorizontalGlue());
        controlPanel.add(userStartScreenButton);

        //overall view construction
        add(sortSelectionPanel);
        add(tripsListScroller);
        add(controlPanel);
        tripsListScroller.setBorder(BorderFactory.createTitledBorder("Trips"));

        thisPanel = this;
        //button listeners
        prevTripsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newStartFrom = startFrom - 10;
                if (newStartFrom < 0) {
                    newStartFrom = 0;
                }
                mainFrame.goToTripsBrowsing(newStartFrom, userID);
            }
        });
        nextTripsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newStartFrom = startFrom + 10;
                mainFrame.goToTripsBrowsing(newStartFrom, userID);
            }
        });
        userStartScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.goToUserTripsPanel(userID);
            }
        });
    }
}
