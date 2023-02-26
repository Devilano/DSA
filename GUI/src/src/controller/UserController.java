package controller;

import database.DBConnection;
import model.User;
import view.Login;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {
    DBConnection db = new DBConnection();

    public int userRegister(User user){
        String query;
        query = "insert into user(fName,lName,email,password)" +
                " values('" +
                user.getfName() + "','" +
                user.getlName() + "','" +
                user.getEmail() + "','" +
                user.getPassword() +"');";
        return db.manipulate(query);
    }

    public User loginUser(String email, String password){
        String query;
        query = "select userId from user where email = '" + email +
                "' and password = '" + password + "';";
        ResultSet rs = db.retrieve(query);
        User user = null;
        try{
            while (rs.next()){
                user = new User();
                user.setUserId(rs.getInt("UserId"));
                Login.USER_ID=rs.getInt("UserId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
