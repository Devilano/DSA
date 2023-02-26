package view;

import controller.JobController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Homepage extends JFrame implements ActionListener {
    JButton addtaskbutton,logoutbutton;
    JLabel jLabel;
    private JTable jobTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    ImageIcon logout = new ImageIcon("Public\\Logoutb.png");
    static JobController jobController= new JobController();
    public static ArrayList<String> jobs=jobController.fetchAllJobs();
    public static String JOB_NAME="";
    public static int JOB_ID=0;
    Homepage(){
        uI();
        addTaskButton();
        logoutButton();
        label();
        showTask();
        setLayout(null);
        setVisible(true);
        handleAction();
    }
    void uI(){
        setTitle("Dashboard");
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(250, 10, 489, 650);
        setBackground(Color.decode(("#EBEBEB")));
    }
    void addTaskButton(){
        addtaskbutton = new Base.Button("+ Add Job", 18, 10, 10, 180, 40);
        add(addtaskbutton);
    }
    void tables(){
        String[] arr= new String[jobs.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=jobs.get(i);
        }
        tableModel = new DefaultTableModel(arr,0);
        jobTable = new JTable(tableModel);
        scrollPane = new JScrollPane(jobTable);
        add(scrollPane, BorderLayout.CENTER);
    }
    void logoutButton(){
        logoutbutton = new Base.Button( "",18, 420, 10, 60, 40);
        logoutbutton.setIcon(logout);
        logoutbutton.setBackground(Color.WHITE);
        add(logoutbutton);
    }
    void label(){
        jLabel= new Base.Label("Please insert unique job names only","Poppins",20,10,50,400,30);
        jLabel.setForeground(Color.red);
        add(jLabel);
    }

    void handleAction(){
        addtaskbutton.addActionListener(this);
        logoutbutton.addActionListener(this);
    }
    void showTask(){
        int j=70;
        for(int i=0;i<jobs.size();i++){
            j=j+i+20;
            int k=i;
            JLabel jobName=new Base.Label(jobs.get(i),"Poppins",12,50,j,200,15);
            jobName.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        JOB_NAME=jobs.get(k);
                        JOB_ID=jobController.returnId();
                       new JobDesc().setVisible(true);
                       dispose();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            add(jobName);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(addtaskbutton)) {
            new AddJob().setVisible(true);
            dispose();
        }
        if (e.getSource().equals(logoutbutton)) {
            int reply = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                new Login().setVisible(true);
                dispose();
            }
        }

    }

    public static void main(String[] args) {
        new Homepage().setVisible(true);
    }
}
