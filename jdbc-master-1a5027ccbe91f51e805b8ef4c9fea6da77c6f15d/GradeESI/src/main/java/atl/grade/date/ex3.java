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

            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url,config.toProperties());
            Statement stmt = connexion.createStatement();

             LocalDateTime localLast = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = localLast.format(formatter);

            String query = "INSERT INTO Grades(score, date, dateModified, id_student, id_lesson) "
                    + "values('1', '" + LocalDate.now() + "', '" + formatDateTime + "',  '1', 'ATL')";
            int count = stmt.executeUpdate(query);
            System.out.println("\t Nombre de record modifié : " + count);

            System.out.println("\n" + getTitle() + "\n");
            query = "SELECT * FROM Grades";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                int score = result.getInt("score");
                String date = result.getString("date");
                String dateModified = result.getString("dateModified");
                int id_student = result.getInt("id_student");
                String id_lesson = result.getString("id_lesson");

                System.out.println("\t" + score + " - " + date + " - " + dateModified + " - " + id_student + " - " + id_lesson);
            }

            System.out.println("\n" + getTitle() + "\n");
            query = "DELETE FROM Grades WHERE id_lesson = 'ATL' AND id_student = 1";
            count = stmt.executeUpdate(query);
            System.out.println("\t Nombre de record supprimé : " + count);

        } catch (SQLException ex) {
            System.out.println("DEMO_DATE_SELECT | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }
    
        @Override
    public String getTitle() {
        return "Lecture des Dates et des Timestamp";
    }
}
