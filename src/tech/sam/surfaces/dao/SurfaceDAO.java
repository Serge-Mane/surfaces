package tech.sam.surfaces.dao;


import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurfaceDAO {
    public void savePoint(tech.sam.surfaces.entities.Point point){
        String url="jdbc:mysql://localhost:3306/surfaces";
        String user="root";
        String password="bootcamp2024";
        //connexion
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);

    //requete
            String query="insert into point (X,Y) values(?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,point.getX());
            preparedStatement.setInt(2,point.getY());
    //executer la requete
            int result=preparedStatement.executeUpdate();

            if (result>0){
                System.out.println(String.format("%s lignes mises en jour",result));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}