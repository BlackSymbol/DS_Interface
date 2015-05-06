package View.Panels;

import View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Denis on 8.4.2015.
 */
public class RegisterPanel extends JPanel{
    private JLabel nameLabel;                       //name label
    private JLabel surnameLabel;                    //surname label
    private JLabel loginLabel;                      //e-mail label
    private JLabel passwordLabel;                   //password label
    private JLabel passwordConfirmLabel;            //password confirm label

    private JTextField nameField;                   //name
    private JTextField surnameField;                //surname
    private JTextField loginField;                  //e-mail
    private JPasswordField passwordField;           //password
    private JPasswordField passwordConfirmField;    //used to confirm password

    private final int labelLength = 150;            //preferred width of labels positioned before fields
    private final int minFieldLength = 150;         //minimum width of fields
    private final int maxComponentHeight = 50;      //maximum height of labels/fields

    /**
     * @param mainFrame parent frame (final because is used in button listeners to load certain parent methods)
     */
    public RegisterPanel(final MainFrame mainFrame)
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //info panel
        JPanel infoPanel = new JPanel();
        JTextArea infoLabel = new JTextArea("To register enter your name, surname, e-mail and password, then click \"Register\".");
        infoLabel.setAlignmentX(CENTER_ALIGNMENT);
        infoLabel.setEditable(false);
        infoLabel.setOpaque(false);
        infoPanel.add(infoLabel);
        infoPanel.setMaximumSize(new Dimension(infoPanel.getMaximumSize().width, maxComponentHeight+50));

        //name panel
        JPanel namePanel = new JPanel();
        nameLabel = new JLabel("Name (first name)");
        nameLabel.setPreferredSize(new Dimension(labelLength, nameLabel.getPreferredSize().height));
        namePanel.add(nameLabel);
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(minFieldLength, nameField.getPreferredSize().height));
        namePanel.setMaximumSize(new Dimension(namePanel.getMaximumSize().width, maxComponentHeight));
        namePanel.add(nameField);

        //surname panel
        JPanel surnamePanel = new JPanel();
        surnameLabel = new JLabel("Surname (last name)");
        surnameLabel.setPreferredSize(new Dimension(labelLength, surnameLabel.getPreferredSize().height));
        surnamePanel.add(surnameLabel);
        surnameField = new JTextField();
        surnameField.setPreferredSize(new Dimension(minFieldLength, surnameField.getPreferredSize().height));
        surnamePanel.setMaximumSize(new Dimension(surnamePanel.getMaximumSize().width, maxComponentHeight));
        surnamePanel.add(surnameField);

        //login panel
        JPanel loginPanel = new JPanel();
        loginLabel = new JLabel("E-mail");
        loginLabel.setPreferredSize(new Dimension(labelLength, loginLabel.getPreferredSize().height));
        loginPanel.add(loginLabel);
        loginField = new JTextField();
        loginField.setPreferredSize(new Dimension(minFieldLength, loginField.getPreferredSize().height));
        loginPanel.setMaximumSize(new Dimension(loginPanel.getMaximumSize().width, maxComponentHeight));
        loginPanel.add(loginField);

        //password field panel
        JPanel passwordPanel = new JPanel();
        passwordLabel = new JLabel("Password");
        passwordLabel.setPreferredSize(new Dimension(labelLength, passwordLabel.getPreferredSize().height));
        passwordPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(minFieldLength, passwordField.getPreferredSize().height));
        passwordPanel.setMaximumSize(new Dimension(passwordPanel.getMaximumSize().width, maxComponentHeight));
        passwordPanel.add(passwordField);

        //password confirm field panel
        final JPanel passwordConfirmPanel = new JPanel();
        passwordConfirmLabel = new JLabel("Confirm password");
        passwordConfirmLabel.setPreferredSize(new Dimension(labelLength, passwordConfirmLabel.getPreferredSize().height));
        passwordConfirmPanel.add(passwordConfirmLabel);
        passwordConfirmField = new JPasswordField();
        passwordConfirmField.setPreferredSize(new Dimension(minFieldLength, passwordConfirmField.getPreferredSize().height));
        passwordConfirmPanel.setMaximumSize(new Dimension(passwordConfirmPanel.getMaximumSize().width, maxComponentHeight));
        passwordConfirmPanel.add(passwordConfirmField);

        //control buttons
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.LINE_AXIS));
        controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        JButton backButton = new JButton("Back");
        JButton registerButton = new JButton("Register");
        controlPanel.add(backButton);
        controlPanel.add(Box.createHorizontalGlue());
        controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        controlPanel.add(registerButton);
        controlPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        //overall view
        add(Box.createVerticalGlue());
        add(infoPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(namePanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(surnamePanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(loginPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(passwordPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(passwordConfirmPanel);
        add(Box.createVerticalGlue());
        add(controlPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));

        //button listeners
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.goToWelcomeScreen();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = nameField.getText();
                if (temp.isEmpty())
                {
                    JOptionPane.showMessageDialog(mainFrame, "Name field is empty, please enter your name", "Error", JOptionPane.ERROR_MESSAGE);
                    nameLabel.setForeground(Color.RED);
                }
                else
                {
                    nameLabel.setForeground(Color.BLACK);
                }
                temp = surnameField.getText();
                if (temp.isEmpty())
                {
                    JOptionPane.showMessageDialog(mainFrame, "Surname field is empty, please enter your surname", "Error", JOptionPane.ERROR_MESSAGE);
                    surnameLabel.setForeground(Color.RED);
                }
                else
                {
                    surnameLabel.setForeground(Color.BLACK);
                }
                String login = loginField.getText();
                if (login.isEmpty())
                {
                    JOptionPane.showMessageDialog(mainFrame, "E-mail field is empty, please enter you email", "Error", JOptionPane.ERROR_MESSAGE);
                    loginLabel.setForeground(Color.RED);
                }
                else
                {
                    loginLabel.setForeground(Color.BLACK);
                }
                if (passwordField.getPassword().length==0)
                {
                    JOptionPane.showMessageDialog(mainFrame, "Password field is empty, please enter you password", "Error", JOptionPane.ERROR_MESSAGE);
                    passwordLabel.setForeground(Color.RED);
                }
                else {
                    passwordLabel.setForeground(Color.BLACK);
                }
                if (!Arrays.equals(passwordField.getPassword(), passwordConfirmField.getPassword()))
                {
                    JOptionPane.showMessageDialog(mainFrame, "Passwords mismatch", "Error", JOptionPane.ERROR_MESSAGE);
                    passwordLabel.setForeground(Color.RED);
                    passwordConfirmLabel.setForeground(Color.RED);
                }
                else {
                    passwordLabel.setForeground(Color.BLACK);
                    passwordConfirmLabel.setForeground(Color.BLACK);
                }
                /*
                TODO
                - check e-mail password existence
                - if exists - display error
                - if not - register (await confirmation from DB)
                - If all successful -> return to start screen
                 */
            }
        });
    }
}
