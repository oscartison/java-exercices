package g55315.model.jdbc;

import org.junit.Test;

import g55315.model.config.ConfigManager;
import g55315.model.exception.RepositoryException;
import g55315.model.dto.FavoriteDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Oscar
 */
public class FavoriteDaoTest {

    private FavoriteDao instance;

    private FavoriteDto fav;
    private FavoriteDto test;
    

    public FavoriteDaoTest() {
        
        fav = new FavoriteDto("ecole", "BELGICA", "HEYSEL");
        test = new FavoriteDto("Test","ROGIER","HEYSEL");
        try {
            ConfigManager.getInstance().load();
            instance = FavoriteDao.getInstance();
        } catch (RepositoryException | IOException ex) {
            org.junit.jupiter.api.Assertions.fail("Erreur de connection à la base de données de test", ex);
        }
    }


    @Test
    public void testSelectExist() throws Exception {
        System.out.println("testSelectExist");
        //Arrange
        FavoriteDto expected = fav;
        //Action
        FavoriteDto result = instance.select("ecole");
        //Assert
        assertEquals(expected, result);
    }

        @Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        //Arrange
        //Action
        FavoriteDto result = instance.select("fefe");
        //Assert
        assertEquals(result,null);
    }

       @Test
    public void testSelectIncorrectParameter() throws Exception {
        System.out.println("testSelectIncorrectParameter");
        //Arrange
        String incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            instance.select(incorrect);
        });
    }



    @Test
    public void testDeleteFalseParam() throws Exception {
        System.out.println("TestDelete");
       String incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            instance.delete(incorrect);
        });
    }
    


    
    
    
}
