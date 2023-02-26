package controller;

import database.DBConnection;
import view.Homepage;
import view.Login;

public class StructureController
{
    DBConnection db=new DBConnection();
    public int addStructure(int parent, int child){
        String query = "insert into structure (userId,jobId,parent,child) values ('"+
                Login.USER_ID+"', '"+ Homepage.JOB_ID+"','"+ parent+"', '"+ child+"');";
        return db.manipulate(query);
    }
}
