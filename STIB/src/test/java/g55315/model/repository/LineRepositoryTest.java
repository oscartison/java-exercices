/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g55315.model.repository;

import g55315.model.exception.RepositoryException;
import g55315.model.jdbc.LineDao;
import org.junit.Test;
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
public class LineRepositoryTest {
    
     @Mock
    private LineDao mock;
    
    public LineRepositoryTest() {
    }

   @org.junit.jupiter.api.Test
    public void testGetExist() throws Exception {
        System.out.println("testGetExist");
        //Arrange

        LineRepository repository = new LineRepository(mock);
        
        repository.get(6);

        Mockito.verify(mock, times(1)).select(6);
    }

    @org.junit.jupiter.api.Test
    public void testGetNotExist() throws Exception {
        System.out.println("testGetNotExist");
        //Arrange
        LineRepository repository = new LineRepository(mock);
        //Action
        repository.get(55);

        Mockito.verify(mock, times(1)).select(55);
    }

  @org.junit.jupiter.api.Test
    public void testGetIncorrectParameter() throws Exception {
        System.out.println("testGetIncorrectParameter");
        //Arrange
        LineRepository repository = new LineRepository(mock);
        Integer incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            repository.get(incorrect);
        });
        Mockito.verify(mock, times(1)).select(null);
    }


}
