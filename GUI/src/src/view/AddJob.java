package view;

import controller.JobController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.Login.USER_ID;

public class AddJob extends JFrame implements ActionListener {
    JButton addJobbutton,cancelbutton,logoutbutton;
    JTextField jobfield;
    JLabel joblabel;
    ImageIcon cancel = new ImageIcon("Public\\cancel.png");
    ImageIcon logout = new ImageIcon("Public\\Logoutb.png");
    AddJob(){
        uI();
        addJobButton();
        logoutButton();
        cancelButton();
        labels();
        jobField();
        setLayout(null);
        setVisible(true);
        handleAction();
    }
    void uI(){
        setTitle("Add Job");
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 10, 489, 650);
        setBackground(Color.decode(("#EBEBEB")));
    }
    void cancelButton(){
        cancelbutton = new Base.Button( "",18, 10, 10, 50, 40);
        cancelbutton.setIcon(cancel);
        cancelbutton.setBackground(Color.WHITE);
        add(cancelbutton);
    }
    void logoutButton(){
        logoutbutton = new Base.Button( "",18, 420, 10, 50, 40);
        logoutbutton.setIcon(logout);
        logoutbutton.setBackground(Color.WHITE);
        add(logoutbutton);
    }
    void addJobButton(){
        addJobbutton = new Base.Button("Insert", 18, 150, 340, 180, 40);
        add(addJobbutton);
    }
    void labels() {
        joblabel= new Base.Label("Job Name","Poppins",18,10,160,100,40);
        add(joblabel);
    }
    void jobField(){
        jobfield= new Base.TextField("Enter the job",18,10,200,450,40);
        add(jobfield);
    }
    void handleAction(){
        cancelbutton.addActionListener(this);
        addJobbutton.addActionListener(this);
        logoutbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String jobName=jobfield.getText();
        if (e.getSource().equals(logoutbutton)) {
            int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new Login().setVisible(true);
                dispose();
            }
        }
        if (e.getSource().equals(cancelbutton)) {
                int reply = JOptionPane.showConfirmDialog(this, "The job cannot be saved if cancelled.", "Cancel", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    new Homepage().setVisible(true);
                    dispose();
                }
            }
        if (e.getSource().equals(addJobbutton)) {
            if(jobName=="Enter the job"||jobName==""){
            }
            else {
                JobController jobController = new JobController();
                jobController.createJob(USER_ID, jobName);}
                new Homepage().setVisible(true);
                dispose();
        }
    }

    public static void main(String[] args) {
        new AddJob().setVisible(true);
    }
}
