package controller;

import com.mysql.cj.log.Log;
import database.DBConnection;
import model.Job;
import view.Homepage;
import view.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JobController {
    DBConnection db=new DBConnection();
    public int returnId() throws SQLException {
        String query = "select * from job where name = '" + Homepage.JOB_NAME + "' and userId = '" + Login.USER_ID + "';";
        ResultSet rs = db.retrieve(query);
        int myInt = 0;
        if (rs.next()) {
            myInt = rs.getInt("jobId");
            System.out.println(myInt);
        }
        return myInt;
    }
    public int createJob(int userId, String name){
        String query = "insert into job (userId, name) values ('"+
                Login.USER_ID+"', '"+
                name+"');";
        return db.manipulate(query);
    }
//    public int getID(String name){
//        String query="select jobId from job where name='"+ Homepage.JOB_ID
//    }
    public ArrayList<String> fetchAllJobs (){
        String query = "select name from job where userId= '" +Login.USER_ID+"';";
        ResultSet rs = db.retrieve(query);
        Job job;
        ArrayList<String> jobs=new ArrayList<>();
        try {
            while (rs.next()) {
                job=new Job();
                jobs.add(rs.getString("name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(jobs);
        return jobs;
    }
}

