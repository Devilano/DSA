package controller;

import database.DBConnection;
import model.Dependency;
import model.Job;
import model.User;
import view.Homepage;
import view.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DependencyController {
    DBConnection db = new DBConnection();

    public int addDependency(int userId, String name){
        String query = "insert into dependency (userId,jobId, name) values ('"+
                Login.USER_ID+"', '"+Homepage.JOB_ID+"', '"+
                name+"');";
        return db.manipulate(query);
    }
    public int returnId(String name) throws SQLException {
        String query = "select * from dependency where userId = '" + Login.USER_ID + "' and jobId = '" + Homepage.JOB_ID+  "' and name = '" + name+ "';";
        ResultSet rs = db.retrieve(query);
        int myInt = 0;
        if (rs.next()) {
            myInt = rs.getInt("dependencyId");
            System.out.println(myInt);
        }
        return myInt;
    }
    public ArrayList<String> fetchAllDependency (){
        String query = "select name from dependency where userId= '" +Login.USER_ID+"';";
        ResultSet rs = db.retrieve(query);
        Dependency dependency;
        ArrayList<String> dependencies=new ArrayList<>();
        try {
            while (rs.next()) {
                dependency=new Dependency();
                dependencies.add(rs.getString("name"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(dependencies);
        return dependencies;
    }
}
