/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.model.repository;

import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.StopDao;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Oscar
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StopRepositoryTest {
    
     @Mock
    private StopDao mock;
    
    public StopRepositoryTest() {
    }

   @org.junit.jupiter.api.Test
    public void testGetExist() throws Exception {
        System.out.println("testGetExist");
        //Arrange

        StopRepository repository = new StopRepository(mock);
        
        repository.get("HEYSEL");

        Mockito.verify(mock, times(1)).select("HEYSEL");
    }

    @org.junit.jupiter.api.Test
    public void testGetNotExist() throws Exception {
        System.out.println("testGetNotExist");
        //Arrange
        StopRepository repository = new StopRepository(mock);
        //Action
        repository.get("ASFAS");

        Mockito.verify(mock, times(1)).select("ASFAS");
    }

  @org.junit.jupiter.api.Test
    public void testGetIncorrectParameter() throws Exception {
        System.out.println("testGetIncorrectParameter");
        //Arrange
        StopRepository repository = new StopRepository(mock);
        String incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            repository.get(incorrect);
        });
        Mockito.verify(mock, times(1)).select(incorrect);
    }
}