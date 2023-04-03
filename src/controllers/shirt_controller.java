package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Clothes;

public class shirt_controller {

    public Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/5style", "Enrique", "@Aguia019");
            return con;
        } catch (Exception e) {
            System.out.println(e.getMessage());           
            return null;
        }
    }

    public ObservableList<Clothes> getShirtList() {
        ObservableList<Clothes> shirt_list = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from roupa";
        Statement st;
        ResultSet rs;

        try {
            
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Clothes clothes;

            while(rs.next()) {
                clothes = new Clothes(rs.getString("size"), rs.getString("color"), rs.getString("name"), rs.getFloat("value"), rs.getString("image"));
                shirt_list.add(clothes);
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return shirt_list;
    }

    public void showShirts() {
        ObservableList<Clothes> list = getShirtList();
    }
}
