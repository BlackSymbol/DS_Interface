package View.Panels;

import View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 9.4.2015.
 */
public class TripInfoPanel extends JPanel {
    //should display info about trip (incl. price)
    //buttons: "view guides", "add to basket", "back to browsing"
    //name, start, finish, time, cost, quantity of POI, available guides
    private final Dimension scrollerPreferredSize = new Dimension(250, 100);
    public TripInfoPanel(final MainFrame mainFrame, int tripID, final JPanel prevPanel)
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        //main trip info
        JPanel tripInfoPanel = new JPanel();
        tripInfoPanel.setLayout(new BoxLayout(tripInfoPanel, BoxLayout.PAGE_AXIS));
        JLabel tripNameLabel = new JLabel("Name: Something");
        JLabel startLocationLabel = new JLabel("Starts at: here");
        JLabel finishLocationLabel = new JLabel("Finishes at: there");
        JLabel timeLabel = new JLabel("Time of trip: 1H 23M");
        JLabel costLabel = new JLabel("Cost: 17350 CZK");
        JLabel poiLabel = new JLabel("Points of interests visited: 17");

        tripInfoPanel.add(Box.createRigidArea(new Dimension (0, 10)));
        tripInfoPanel.add(tripNameLabel);
        tripInfoPanel.add(Box.createRigidArea(new Dimension (0, 10)));
        tripInfoPanel.add(startLocationLabel);
        tripInfoPanel.add(Box.createRigidArea(new Dimension (0, 10)));
        tripInfoPanel.add(finishLocationLabel);
        tripInfoPanel.add(Box.createRigidArea(new Dimension (0, 10)));
        tripInfoPanel.add(timeLabel);
        tripInfoPanel.add(Box.createRigidArea(new Dimension (0, 10)));
        tripInfoPanel.add(costLabel);
        tripInfoPanel.add(Box.createRigidArea(new Dimension (0, 10)));
        tripInfoPanel.add(poiLabel);
        tripInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        //guides info panel
        JPanel guidesInfoPanel = new JPanel();
        guidesInfoPanel.setLayout(new BoxLayout(guidesInfoPanel, BoxLayout.PAGE_AXIS));
        JLabel guidesInfoLabel = new JLabel("Guides available for this trip");
        guidesInfoLabel.setAlignmentX(CENTER_ALIGNMENT);
        JPanel guidesListPanel = new JPanel();
        guidesListPanel.setLayout(new BoxLayout(guidesListPanel, BoxLayout.PAGE_AXIS));
        //get all guides
        for (int i=0;i<25;i++)
        {
            guidesListPanel.add(new JLabel("Name Surname " + i));
        }
        JScrollPane guidesListScroller = new JScrollPane(guidesListPanel);
        guidesListScroller.setMaximumSize(scrollerPreferredSize);
        guidesInfoPanel.add(guidesInfoLabel);
        guidesInfoPanel.add(guidesListScroller);

        //control buttons
        JButton returnButton = new JButton("Back");
        returnButton.setAlignmentX(CENTER_ALIGNMENT);

        //construct overall view
        topPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        topPanel.add(tripInfoPanel);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(guidesInfoPanel);
        topPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        add(Box.createRigidArea(new Dimension(0, 10)));
        add(topPanel);
        add(Box.createVerticalGlue());
        add(returnButton);
        add(Box.createRigidArea(new Dimension(0, 10)));

        //button listeners
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.goToPanel(prevPanel);
            }
        });
    }
}
