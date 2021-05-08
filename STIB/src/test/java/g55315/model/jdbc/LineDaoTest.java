/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.model.jdbc;

import g55315.model.config.ConfigManager;
import g55315.model.exception.RepositoryException;
import java.io.IOException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author Oscar
 */
public class LineDaoTest {

    private LineDao instance;


    public LineDaoTest() {
        try {
            ConfigManager.getInstance().load();
            instance = LineDao.getInstance();
        } catch (RepositoryException | IOException ex) {
            org.junit.jupiter.api.Assertions.fail("Erreur de connection à la base de données de test", ex);
        }
    }


    @Test
    public void testSelectExist() throws Exception {
        System.out.println("testSelectExist");
        //Arrange
        int expected = 21;
        //Action
        int result = instance.select(1).get(0).getStops().size();
        //Assert
        assertEquals(expected, result);
    }

        @Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        //Arrange
        int expected = 0;
        //Action
        int result = instance.select(55).size();
        //Assert
        assertEquals(expected, result);
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
    public void testSelectAll() throws Exception {
        System.out.println("testSelectAll");
        //Arrange
        int expected = 4;

        //Action
        int result = instance.selectAll().size();
        //Assert
        assertEquals(expected, result);
    }
    
}
    