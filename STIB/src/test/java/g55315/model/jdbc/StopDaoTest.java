/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.model.jdbc;

import g55315.model.config.ConfigManager;
import g55315.model.dto.StationDto;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author Oscar
 */
public class StopDaoTest {
    
   private StopDao instance;
        private StopDto stop;


    public StopDaoTest() {
        try {
            ConfigManager.getInstance().load();
            instance = StopDao.getInstance();
        } catch (RepositoryException | IOException ex) {
            org.junit.jupiter.api.Assertions.fail("Erreur de connection à la base de données de test", ex);
        }
        List<Integer> lines = new ArrayList<>();
        lines.add(6);
        stop = new StopDto("HEYSEL",lines,2,8824);
    }


    @Test
    public void testSelectExist() throws Exception {
        System.out.println("testSelectExist");
        //Arrange
        List<StopDto> expected = new ArrayList<>();
        expected.add(stop);
        //Action
        List<StopDto> result = instance.select("HEYSEL");
        //Assert
        assertEquals(expected, result);
    }

        @Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");

        //Action
        List<StopDto> result = instance.select("BUBU");
        //Assert
        assertEquals(0, result.size());
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
    public void testSelectAll() throws Exception {
        System.out.println("testSelectAll");
        //Arrange
        int expected = 60;

        //Action
        int result = instance.selectAll().size();
        //Assert
        assertEquals(expected, result);
    }
    
}
