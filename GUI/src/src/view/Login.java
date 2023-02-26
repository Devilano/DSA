package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JButton loginbutton, registerbutton, submitbutton, showpasswordbutton;
    JTextField emailfield;
    JPasswordField passwordfield;
    JLabel image;
    public static int USER_ID = 0;
    User user;
    UserController userController;

    ImageIcon show = new ImageIcon("Public\\Show.png");
    ImageIcon hide = new ImageIcon("Public\\Hide.png");

    public Login() {
        uI();
        banner();// the banner of the login and register page
        signUpButton(); // the button that leads to register page
        logInButton();// the button that leads to login page
        passwordButton(); // the button for showpassword
        submitButton();// the button that authenticates the user

        email();
        password();

        setLayout(null);
        setVisible(true);
        handleAction();
    }

    public void uI() {
        setTitle("Login Page");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 10, 489, 650);
        setBackground(Color.decode(("#EBEBEB")));
    }

    public void email() {
        emailfield = new Base.TextField("Email", 18, 41, 330, 392, 45);
        add(emailfield);
    }

    //  password text filed
    public void password() {
        passwordfield = new Base.PasswordField("Password", 18, 41, 390, 349, 45, showpasswordbutton);
        add(passwordfield);
    }

    // password side button
    public void passwordButton() {
        showpasswordbutton = new Base.ShowPassword(387, 390, 45, 45);
        add(showpasswordbutton);
    }

    public void signUpButton() {
        registerbutton = new JButton("Register");
        registerbutton.setFont(new Font("Hornbill", Font.BOLD, 35));
        registerbutton.setAlignmentX(CENTER_ALIGNMENT);
        registerbutton.setAlignmentY(CENTER_ALIGNMENT);
        registerbutton.setBounds(242, 228, 225, 70);
        registerbutton.setBackground(Color.decode("#FFFFFF"));
        registerbutton.setForeground(Color.decode("#202A44"));
        registerbutton.setBorderPainted(false);
        add(registerbutton);
    }

    public void logInButton() {
        loginbutton = new JButton("Login");
        loginbutton.setFont(new Font("Hornbill", Font.BOLD, 34));
        loginbutton.setAlignmentX(CENTER_ALIGNMENT);
        loginbutton.setAlignmentY(CENTER_ALIGNMENT);
        loginbutton.setBounds(8, 228, 225, 70);
        loginbutton.setBackground(Color.decode("#FFFFFF"));
        loginbutton.setForeground(Color.decode("#202A44"));
        loginbutton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#202A44")));
        add(loginbutton);
    }

    public void submitButton() {
        submitbutton = new Base.Button("Login", 18, 190, 470, 80, 40);
        add(submitbutton);
    }

    public void banner() {
        image = new JLabel(new ImageIcon("public\\banner.png"));
        image.setBounds(2, 2, 471, 218);
        add(image);
    }

    public void handleAction() {
        loginbutton.addActionListener(this);
        registerbutton.addActionListener(this);
        showpasswordbutton.addActionListener(this);
        submitbutton.addActionListener(this);
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submitbutton)) {
            String pass = String.copyValueOf(passwordfield.getPassword());
            if (emailfield.getText().equals("Email") && passwordfield.equals("Password")) {
                JOptionPane.showMessageDialog(null, "Fill all the details");
            } else if (emailfield.getText().equals("Email") || passwordfield.equals("Password")) {
                JOptionPane.showMessageDialog(null, "One of the box is empty");
            } else {
                userController = new UserController();
                user = userController.loginUser(emailfield.getText(),
                        String.copyValueOf(passwordfield.getPassword()));
                if (user != null) {
                    new Homepage().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        }

        if (e.getSource().equals(registerbutton)) {
            new Register().setVisible(true);
            dispose();
        }


        if (e.getSource().equals(showpasswordbutton)) {
            if (passwordfield.getEchoChar() == (char) 0 && (!String.copyValueOf(passwordfield.getPassword()).equals("Password"))) {
                showpasswordbutton.setIcon(show);
                passwordfield.setEchoChar('\u25cf');
            } else {
                showpasswordbutton.setIcon(hide);
                passwordfield.setEchoChar((char) 0);
            }
        }
    }
}
