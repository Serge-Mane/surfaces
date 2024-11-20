package tech.sam.surfaces.dao;


import tech.sam.surfaces.entities.Figure;

import java.awt.*;
import java.sql.*;

public class SurfaceDAO {
    String url="jdbc:mysql://localhost:3306/surfaces";
    String user="root";
    String password="bootcamp2024";

    public void savePoint(tech.sam.surfaces.entities.Point point,int figureId){
       //connexion
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);

    //requete
            String query="insert into points (X,Y,figure_id) values(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,point.getX());
            preparedStatement.setInt(2,point.getY());
            preparedStatement.setInt(3,figureId);
    //executer la requete
            int result=preparedStatement.executeUpdate();

            if (result>0){
                System.out.println(String.format("%s lignes mises en jour",result));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public  int saveFigure(Figure figure){
        Connection connection = null;
        int id=0;
     //requete
        String query="insert into figures (name) values(?)";
        PreparedStatement preparedStatement= null;
        try {
            connection = DriverManager.getConnection(url,user,password);

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,figure.getName());
            //executer la requete
            int result=preparedStatement.executeUpdate();
            if (result>0){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()){
                    id=generatedKeys.getInt(1);
                }
            }
  } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  id;
 }
}