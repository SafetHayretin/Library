package eu.deltasorce.internship.library.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    JPanel panel;

    public MainPage(){
        this.setSize(300,500);
        JButton login = new JButton("Login");
        JButton register = new JButton("Register");

        panel = new JPanel(new GridLayout(3,1));
        panel.add(login);
        panel.add(register);

        add(panel, BorderLayout.CENTER);

        login.addActionListener(new Login());
        register.addActionListener(new Register());

        setTitle("Library");

        this.setVisible(true);
    }

    class Login implements ActionListener{
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginPage page = new LoginPage();
            panel = page.getPanel();
        }
    }

    class Register implements ActionListener{
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
