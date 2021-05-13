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

    
    
}
