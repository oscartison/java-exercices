package g55315.model.repository;

import g55315.model.dto.FavoriteDto;
import g55315.model.jdbc.FavoriteDao;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;

import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FavoritesRepositoryTest {
    
     @Mock
    private FavoriteDao mock;
    
    public FavoritesRepositoryTest() {
    }

     @Test
    public void testGetExist() throws Exception {
        System.out.println("testGetExist");
        //Arrange
        FavoritesRepository repository = new FavoritesRepository(mock);
        //Action
        FavoriteDto result = repository.get("ecole");
        //Assert        

        Mockito.verify(mock, times(1)).select("ecole");
    }

    @Test
    public void testGetNotExist() throws Exception {
        System.out.println("testGetNotExist");
       //Arrange
        FavoritesRepository repository = new FavoritesRepository(mock);
        //Action
        FavoriteDto result = repository.get("fwwf");
        //Assert        

        Mockito.verify(mock, times(1)).select("fwwf");
    }

//     @Test
//    public void testGetIncorrectParameter() throws Exception {
//        System.out.println("testGetIncorrectParameter");
//        //Arrange
//        FavoritesRepository repository = new FavoritesRepository(mock);
//
//        Integer incorrect = null;
//        //Assert
//        assertThrows(RepositoryException.class, () -> {
//            //Action
//            repository.get(incorrect);
//        });
//        Mockito.verify(mock, times(1)).select(null);
//    }
//    

    @Test
    public void testRemove() throws Exception {
         System.out.println("testRemove");
        //Arrange
        FavoritesRepository repository = new FavoritesRepository(mock);
        //Action
         repository.remove("ecole");
        //Assert        

        Mockito.verify(mock, times(1)).delete("ecole");
    }
    
        @Test
    public void testInsert() throws Exception {
         System.out.println("testInsert");
        //Arrange
        FavoritesRepository repository = new FavoritesRepository(mock);
        
        FavoriteDto test = new FavoriteDto("bonjour","HEYSEL","ROGIER");
        //Action
         repository.add(test);
        //Assert        

        Mockito.verify(mock, times(1)).insert(test);
    }
    
    
    
}
