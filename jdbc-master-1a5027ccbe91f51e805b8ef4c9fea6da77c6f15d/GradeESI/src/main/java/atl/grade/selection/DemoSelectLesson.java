package atl.grade.selection;

import atl.grade.Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jlc
 */
public class DemoSelectLesson extends Demo {

    @Override
    public void execute(String url) {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            Statement stmt = connexion.createStatement();

            String query = "SELECT * FROM LESSONS";
            
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String name = result.getString("acronym");
                System.out.println("\t record : " + name);
            }
        } catch (SQLException ex) {
            System.out.println("DEMO_SELECT_ALL | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }

    @Override
    public String getTitle() {
        return "La liste des lessons";
    }
}
