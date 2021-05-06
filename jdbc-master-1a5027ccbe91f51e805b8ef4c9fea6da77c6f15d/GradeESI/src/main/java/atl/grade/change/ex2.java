package atl.grade.change;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import atl.grade.Demo;
import java.sql.ResultSet;

/**
 *
 * @author jlc
 */
public class ex2 extends Demo {

    @Override
    public void execute(String url) {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            Statement stmt = connexion.createStatement();

            String query = "INSERT INTO LESSONS values('ANLL')";

            int count = stmt.executeUpdate(query);

            query = "SELECT * FROM LESSONS";

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String name = result.getString("acronym");
                System.out.println("\t record : " + name);
            }
            System.out.println("\n=====================================================");
            System.out.println("\t Aftter Delete");
            System.out.println("=====================================================");

            query = "DELETE FROM LESSONS WHERE acronym ='ANLL'";

            count = stmt.executeUpdate(query);

            query = "SELECT * FROM LESSONS";

            result = stmt.executeQuery(query);

            while (result.next()) {
                String name = result.getString("acronym");
                System.out.println("\t record : " + name);
            }

        } catch (SQLException ex) {
            System.out.println("DEMO_DELETE | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }

    @Override
    public String getTitle() {
        return "Exercice 2";
    }
}
