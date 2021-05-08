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

    public FavoriteDaoTest() {
        fav = new FavoriteDto(6, "SCHUMAN", "DELACROIX");
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
        List<FavoriteDto> result = instance.select(6);
        //Assert
        assertEquals(expected, result.get(0));
    }

        @Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        //Arrange
        //Action
        List<FavoriteDto> result = instance.select(22);
        //Assert
        assertEquals(result.size(),0);
    }

       @Test
    public void testSelectIncorrectParameter() throws Exception {
        System.out.println("testSelectIncorrectParameter");
        //Arrange
        Integer incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            instance.select(incorrect);
        });
    }

    @Test
    public void testDeleteExist() throws Exception {
        System.out.println("TestDelete");
        instance.delete(7);
        
        List<FavoriteDto> result = instance.select(7);
        //Assert
        assertEquals(result.size(),0);
    }

    @Test
    public void testDeleteFalseParam() throws Exception {
        System.out.println("TestDelete");
       Integer incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            instance.delete(incorrect);
        });
    }
    
     @Test
    public void testSelectAll() throws Exception {
        System.out.println("testSelectAll");
        //Arrange
        List<FavoriteDto> expected = new ArrayList<>();
        expected.add(fav);
        //Action
        List<FavoriteDto> result = instance.selectAll();
        //Assert
        assertEquals(expected, result);
    }
    
     @Test
    public void testInsert() throws Exception {
        System.out.println("testSelectAll");
        
        int sizeBefore = instance.selectAll().size();
        //Arrange
        instance.insert(new FavoriteDto(0,"HEYSEL","HEYSEL"));
        
        int sizeAfter = instance.selectAll().size();
        //Assert
        assertNotEquals(sizeBefore, sizeAfter);
    }
    
    
    
}
