package view;

import controller.DependencyController;
import controller.JobController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static view.Homepage.JOB_ID;
import static view.Homepage.JOB_NAME;

public class JobDesc extends JFrame implements ActionListener {
    JButton returnbutton,logoutbutton,schedulebutton,dependencybutton,mapbutton;
    JLabel jobname,label;
    ImageIcon logout = new ImageIcon("Public\\Logoutb.png");
    static JobController jobController= new JobController();
    static DependencyController dependencyController= new DependencyController();
    public static ArrayList<String> dependencies=dependencyController.fetchAllDependency();
    JobDesc(){
        System.out.println(JOB_NAME);
        uI();
        returnButton();
        logoutButton();
        jobName();
        addLabel();
        dependencyButton();
        mapDependency();
        scheduleButton();
        setLayout(null);
        setVisible(true);
        handleAction();
    }
    void uI(){
        setTitle("Job Description");
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 10, 489, 650);
        setBackground(Color.decode(("#EBEBEB")));
    }
    void returnButton(){
        returnbutton = new Base.Button( "Back",18, 10, 10, 90, 40);
        returnbutton.setForeground(Color.decode("#202A44"));
        returnbutton.setBackground(Color.WHITE);
        add(returnbutton);
    }
    void logoutButton(){
        logoutbutton = new Base.Button( "",18, 420, 10, 50, 40);
        logoutbutton.setIcon(logout);
        logoutbutton.setBackground(Color.WHITE);
        add(logoutbutton);
    }
    void jobName(){
        jobname= new Base.Label(JOB_NAME,20);
        jobname.setForeground(Color.BLACK);
        add(jobname);
    }

    void addLabel(){
        label=new Base.Label("You can only map existing dependencies","Poppins",20,10,60,400,50);
        label.setForeground(Color.red);
        add(label);
    }
    void dependencyButton(){
        dependencybutton = new Base.Button( "Add Dependency ",18, 30, 200, 300, 50);
        add(dependencybutton);
    }
    void mapDependency(){
        mapbutton = new Base.Button( "Map Dependency",18, 30, 280, 300, 50);
        add(mapbutton);
    }

    void scheduleButton(){
        schedulebutton = new Base.Button( "Show Schedule",18, 30, 360, 300, 50);
//        schedulebutton.setBackground(Color.WHITE);
        add(schedulebutton);
    }
    public void handleAction(){
        schedulebutton.addActionListener(this);
        logoutbutton.addActionListener(this);
        dependencybutton.addActionListener(this);
        mapbutton.addActionListener(this);
        returnbutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(logoutbutton)) {
            int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new Login().setVisible(true);
                dispose();
            }
        }
        if (e.getSource().equals(returnbutton)) {
            JOB_ID=0;
            new Homepage().setVisible(true);
            dispose();
        }
        if (e.getSource().equals(dependencybutton)) {
            new AddDependency().setVisible(true);
            dispose();
        }
        if (e.getSource().equals(mapbutton)) {
            new MapDependency().setVisible(true);
            dispose();
        }
        if (e.getSource().equals(schedulebutton)) {
            new Homepage().setVisible(true);
            dispose();
        }
    }
    public static void main(String[] args) {
        new JobDesc().setVisible(true);
    }
}
