package tech.sam.surfaces.dao;


import tech.sam.surfaces.dto.FigureDTO;
import tech.sam.surfaces.entities.Figure;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurfaceDAO {
    private final String URL="jdbc:mysql://localhost:3306/surfaces";
    private final String USER="root";
    private final String PASSWORD="bootcamp2024";

    public void savePoint(tech.sam.surfaces.entities.Point point,int figureId){
       //connexion
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);

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
            connection = DriverManager.getConnection(URL,USER,PASSWORD);

            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,figure.getName().name());
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

 public List<FigureDTO> readFigure(){
     Connection connection = null;
     List<FigureDTO> dtos=new ArrayList<>();
     //requete
     String query="select f.id,f.name,p.x,p.y from figures f join points p on f.id=p.figure_id";
     PreparedStatement preparedStatement= null;
     try {
         connection = DriverManager.getConnection(URL,USER,PASSWORD);

         preparedStatement = connection.prepareStatement(query);
         //executer la requete
         ResultSet resultSet=preparedStatement.executeQuery();
         while (resultSet.next()){
             int id=resultSet.getInt("id");
             int x=resultSet.getInt("x");
             int y=resultSet.getInt("y");
             String name=resultSet.getString("name");
             dtos.add(new FigureDTO(id,name,x,y));
         }
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
   return dtos;
 }
}