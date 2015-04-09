package View.Panels;

import View.Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by Denis on 8.4.2015.
 */
public class RegisterScreen extends JPanel{

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
    public RegisterScreen(final MainFrame mainFrame)
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //info panel
        JPanel infoPanel = new JPanel();
        JTextArea infoLabel = new JTextArea("To register enter your name, surname, e-mail and password, then click \"Register\".\n\n" +
                "If you need to reset your password, enter your e-mail, then click \"Reset password\".");
        infoLabel.setAlignmentX(CENTER_ALIGNMENT);
        infoLabel.setEditable(false);
        infoLabel.setOpaque(false);
        infoPanel.add(infoLabel);
        infoPanel.setMaximumSize(new Dimension(infoPanel.getMaximumSize().width, maxComponentHeight+50));

        //name panel
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name (first name)");
        nameLabel.setPreferredSize(new Dimension(labelLength, nameLabel.getPreferredSize().height));
        namePanel.add(nameLabel);
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(minFieldLength, nameField.getPreferredSize().height));
        namePanel.setMaximumSize(new Dimension(namePanel.getMaximumSize().width, maxComponentHeight));
        namePanel.add(nameField);

        //surname panel
        JPanel surnamePanel = new JPanel();
        JLabel surnameLabel = new JLabel("Surname (last name)");
        surnameLabel.setPreferredSize(new Dimension(labelLength, surnameLabel.getPreferredSize().height));
        surnamePanel.add(surnameLabel);
        surnameField = new JTextField();
        surnameField.setPreferredSize(new Dimension(minFieldLength, surnameField.getPreferredSize().height));
        surnamePanel.setMaximumSize(new Dimension(surnamePanel.getMaximumSize().width, maxComponentHeight));
        surnamePanel.add(surnameField);

        //login panel
        JPanel loginPanel = new JPanel();
        JLabel loginLabel = new JLabel("E-mail");
        loginLabel.setPreferredSize(new Dimension(labelLength, loginLabel.getPreferredSize().height));
        loginPanel.add(loginLabel);
        loginField = new JTextField();
        loginField.setPreferredSize(new Dimension(minFieldLength, loginField.getPreferredSize().height));
        loginPanel.setMaximumSize(new Dimension(loginPanel.getMaximumSize().width, maxComponentHeight));
        loginPanel.add(loginField);

        //password field panel
        JPanel passwordPanel = new JPanel();
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setPreferredSize(new Dimension(labelLength, passwordLabel.getPreferredSize().height));
        passwordPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(minFieldLength, passwordField.getPreferredSize().height));
        passwordPanel.setMaximumSize(new Dimension(passwordPanel.getMaximumSize().width, maxComponentHeight));
        passwordPanel.add(passwordField);

        //password confirm field panel
        JPanel passwordConfirmPanel = new JPanel();
        JLabel passwordConfirmLabel = new JLabel("Confirm password");
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
        JButton resetPasswordButton = new JButton("Reset password");
        JButton registerButton = new JButton("Register");
        controlPanel.add(backButton);
        controlPanel.add(Box.createHorizontalGlue());
        controlPanel.add(resetPasswordButton);
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
                mainFrame.goToStartScreen();
            }
        });
        resetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmPasswordReset = JOptionPane.showOptionDialog(mainFrame, "Reset password for \"" + loginField.getText() + "\"?",
                        "Confirm password reset", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirmPasswordReset==JOptionPane.YES_OPTION)
                {
                    /*
                    TODO
                    - check if e-mail contains "@"
                    - check e-mail existence
                    - change the password to a random one (await confirmation from DB)
                    - If password change confirmed - display new password
                    - ! OR ! send new password to e-mail
                    - If all successful -> return to start screen
                    */
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                TODO
                - check if some field is empty
                - check if password matches
                - check if e-mail contains "@"
                - check e-mail password existence
                - if exists - display error
                - if not - register (await confirmation from DB)
                - If all successful -> return to start screen
                 */
            }
        });
    }
}
