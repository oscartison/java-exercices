package g55315.model;



import g55315.model.config.ConfigManager;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.repository.StopRepository;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author jlc
 */
public class DemoRepository {

    /**
     * Entry points to the <code> Mentoring </code> application.
     *
     * @param args no arguments needed.
     */
    public static void main(String[] args) {
        try {
            ConfigManager.getInstance().load();
            String dbUrl = ConfigManager.getInstance().getProperties("db.url");
            System.out.println("Base de données stockée : " + dbUrl);

            StopRepository repository = new StopRepository();
            List<StopDto> dtos = repository.getAll();
            for (StopDto dto : dtos) {
                System.out.print("id:\t" + dto.getKey());
                System.out.print("name:\t" + dto.getName());
                System.out.print("line:\t" + dto.getId_line());
                System.out.print("order:\t" + dto.getId_order());
                System.out.println();
            }
        } catch (IOException ex) {
            System.out.println("Erreur IO " + ex.getMessage());
        } catch (RepositoryException ex) {
            System.out.println("Erreur Repository " + ex.getMessage());
        }
    }

    private DemoRepository() {

    }
}
