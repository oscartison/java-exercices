/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atl.grade.date;

import atl.grade.Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author oscar
 */
public class ex3 extends Demo{
    
    @Override
    public void execute(String url) {
        try {
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);

            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url, config.toProperties());
            Statement stmt = connexion.createStatement();

            LocalDateTime localLast = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String formatDateTime = localLast.format(formatter);
            

            String query = "INSERT INTO GRADES(score,date,dateModified,id_student,id_lesson) values ('15','" + LocalDate.now() + "','" + formatDateTime+ "','1','ATL')";

            int count = stmt.executeUpdate(query);
            System.out.println("\t Nombre de record modifié : " + count);
            
            query = "SELECT score, date, dateModified FROM GRADES";

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("score");
                String dateText = result.getString("date");
                String modifiedText = result.getString("dateModified");
                //Conversion d'un String en LocalDate, format standard
                LocalDate date = LocalDate.parse(dateText);
                
                //Conversion d'un String en LocalDateTime, format non-standard
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime modified = LocalDateTime.parse(modifiedText,formatter);
                System.out.println("\t record : " + id + " " + date + " " + modified);
            }
        } catch (SQLException ex) {
            System.out.println("DEMO_DATE_UPDATE | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }
    
        @Override
    public String getTitle() {
        return "Mises à jour des Dates et des Timestamp";
    }
    
}
