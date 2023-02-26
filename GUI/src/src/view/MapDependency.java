package view;

import controller.DependencyController;
import controller.JobController;
import controller.StructureController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static view.Homepage.JOB_NAME;

public class MapDependency extends JFrame implements ActionListener {
    JButton returnbutton,logoutbutton,addbutton;
    JLabel jobname;
    JTextField parentfield,childfield;
    ImageIcon logout = new ImageIcon("Public\\Logoutb.png");
    static JobController jobController= new JobController();
    static DependencyController dependencyController= new DependencyController();
    static StructureController structureController = new StructureController();
    MapDependency(){
        System.out.println(JOB_NAME);
        uI();
        returnButton();
        logoutButton();
        parentField();
        childField();
        addButton();
        setLayout(null);
        setVisible(true);
        handleAction();
    }
    void uI(){
        setTitle("Map Dependency");
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
    void parentField(){
        parentfield=new Base.TextField("Enter the parent",16,10,100,400,40);
        add(parentfield);
    }
    void childField(){
        childfield=new Base.TextField("Enter the child",16,10,200,400,40);
        add(childfield);
    }
    void addButton(){
        addbutton= new Base.Button("Add",16,50,300,90,50);
        add(addbutton);
    }
    void handleAction(){
        returnbutton.addActionListener(this);
        logoutbutton.addActionListener(this);
        addbutton.addActionListener(this);

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
            int reply = JOptionPane.showConfirmDialog(this, "Data will not saved. Do you want to cancel?", "Logout", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new JobDesc().setVisible(true);
                dispose();
            }
        }
        if(e.getSource().equals(addbutton)){
            String parent= parentfield.getText();
            String child=parentfield.getText();
            if(parent=="Enter the parent"||parent==""){
                JOptionPane.showMessageDialog(null,"Parent is empty");
            } else if(child=="Enter the parent"||child==""){
                JOptionPane.showMessageDialog(null,"Child is empty");
            } else {
                try {
                    int p=dependencyController.returnId(parent);
                    int c=dependencyController.returnId(child);
                    System.out.println(p+"  "+c);
                    structureController.addStructure(p,c);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }

    public static void main(String[] args) {
        new MapDependency().setVisible(true);
    }
}
