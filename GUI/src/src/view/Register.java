package view;

import controller.UserController;
import model.User;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Register extends JFrame implements ActionListener {
    JButton loginbutton, signupbutton, submitbutton, showpasswordbutton, show;
    JTextField fnamefield, lnamefield, emailfield;
    JPasswordField passwordfield, cpasswordfield;
    JLabel fname, lname, email, password, cpassword, image;
    ImageIcon showicon = new ImageIcon("Public\\Show.png");
    ImageIcon hide = new ImageIcon("Public\\Hide.png");

    public Register() {
        uI();
        banner();

        // buttons
        submitButton();
        showPasswordButton();
        confirmPasswordButton();
        loginButton();
        signupButton();

        // text label
        firstname();
        lastname();
        email();
        password();
        confirmPassword();

        setLayout(null);
        setVisible(true);
        handleAction();

    }

    public void uI() {
        setTitle("Register Page");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 10, 489, 650);
        setBackground(Color.decode(("#EBEBEB")));
    }

    public void firstname() {
        fnamefield = new Base.TextField("First Name", 17, 41, 315, 190, 45);
        add(fnamefield);
    }

    // last name text field
    public void lastname() {
        lnamefield = new Base.TextField("Last Name", 17, 241, 315, 190, 45);
        add(lnamefield);
    }


    // email text field
    public void email() {
        emailfield = new Base.TextField("Email", 17, 41, 370, 390, 45);
        add(emailfield);
    }

    //  password text filed
    public void password() {
        passwordfield = new Base.PasswordField("Password", 17, 41, 425, 347, 45, showpasswordbutton);
        add(passwordfield);
    }

    // confirm password text field
    public void confirmPassword() {
        cpasswordfield = new Base.PasswordField("Confirm Password", 17, 41, 480, 347, 45, show);
        add(cpasswordfield);
    }


    public void signupButton() {
        signupbutton = new JButton("Register");
        signupbutton.setFont(new Font("Hornbill", Font.BOLD, 35));
        signupbutton.setAlignmentX(CENTER_ALIGNMENT);
        signupbutton.setAlignmentY(CENTER_ALIGNMENT);
        signupbutton.setBounds(242, 228, 225, 70);
        signupbutton.setBackground(Color.decode("#FFFFFF"));
        signupbutton.setForeground(Color.decode("#202A44"));
        signupbutton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#202A44")));
        add(signupbutton);
    }


    // password side button
    public void showPasswordButton() {
        showpasswordbutton = new Base.ShowPassword(385, 425, 45, 45);
        add(showpasswordbutton);
    }


    // confirm password button
    public void confirmPasswordButton() {
        show = new Base.ShowPassword(385, 480, 45, 45);
        add(show);
    }

    // top login button
    public void loginButton() {
        loginbutton = new JButton("Login");
        loginbutton.setFont(new Font("Hornbill", Font.BOLD, 34));
        loginbutton.setAlignmentX(CENTER_ALIGNMENT);
        loginbutton.setAlignmentY(CENTER_ALIGNMENT);
        loginbutton.setBounds(8, 228, 225, 70);
        loginbutton.setBackground(Color.decode("#FFFFFF"));
        loginbutton.setForeground(Color.decode("#202A44"));
        loginbutton.setBorderPainted(false);
        add(loginbutton);
    }

    // top signup button
    public void submitButton() {
        submitbutton = new Base.Button("Signup", 18, 190, 540, 80, 40);
        add(submitbutton);
    }

    public void banner() {
        image = new JLabel(new ImageIcon("public\\banner.png"));
        image.setBounds(2, 2, 471, 218);
        add(image);
    }

    public void handleAction() {
        loginbutton.addActionListener(this);
        signupbutton.addActionListener(this);
        submitbutton.addActionListener(this);
        showpasswordbutton.addActionListener(this);
        show.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submitbutton)) {
            String fname = fnamefield.getText();
            String lname = lnamefield.getText();
            String email = emailfield.getText();
            String pass = String.copyValueOf(passwordfield.getPassword());
            String cpass = String.copyValueOf(cpasswordfield.getPassword());

            if (fname.equals("First Name") && lname.equals("Last Name") && email.equals("Email") && pass.equals("Password") && cpass.equals("Confirm Password")) {
                JOptionPane.showMessageDialog(null, "All fields are required.");
            } else if (fname.equals("First Name")) {
                JOptionPane.showMessageDialog(null, "First name is required.");

            } else if (lname.equals("Last Name")) {
                JOptionPane.showMessageDialog(null, "Last name is required.");
            } else if (email.equals("Email")) {
                JOptionPane.showMessageDialog(null, "Password is required.");
            } else if (pass.equals("Password") || cpass.equals("Confirm Password")) {
                JOptionPane.showMessageDialog(null, "Password is required.");
            } else if (pass.length() < 6) {
                JOptionPane.showMessageDialog(null, "Password should be more than 6 characters!");
            } else if (pass.equals(cpass)) {
                JOptionPane.showMessageDialog(null, "Confirming..");

                try {


                            User user = new User(fname,lname,email,pass);
                            UserController userController = new UserController();
                            int insert = userController.userRegister(user);

                            if (insert > 0) {
                                JOptionPane.showMessageDialog(null, "Account registered\n Directing to Login");
                                new Login().setVisible(true);
                                dispose();
                            } else
                                JOptionPane.showMessageDialog(null, "Failed to Register");

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "The account cannot be created at the moment\nPlease try again later");
                }
            }else {
                JOptionPane.showMessageDialog(null, "Your passwords do not match");
                cpasswordfield.requestFocus();
            }
            }
            if (e.getSource().equals(showpasswordbutton)) {
                if (passwordfield.getEchoChar() == (char) 0 && (!String.copyValueOf(passwordfield.getPassword()).equals("Password"))) {
                    showpasswordbutton.setIcon(showicon);
                    passwordfield.setEchoChar('\u25cf');
                } else {
                    showpasswordbutton.setIcon(hide);
                    passwordfield.setEchoChar((char) 0);
                }
            }
            if (e.getSource().equals(show)) {
                if (cpasswordfield.getEchoChar() == (char) 0 && (!String.copyValueOf(cpasswordfield.getPassword()).equals("Confirm Password"))) {
                    show.setIcon(showicon);
                    cpasswordfield.setEchoChar('\u25cf');
                } else {
                    show.setIcon(hide);
                    cpasswordfield.setEchoChar((char) 0);
                }
            }
            if (e.getSource().equals(loginbutton)) {
                new Login().setVisible(true);
                dispose();
            }
        }
}
