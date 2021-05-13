package g55315.model.jdbc;

import g55315.model.dto.FavoriteDto;
import g55315.model.repository.Dao;
import g55315.model.exception.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jlc
 */
public class FavoriteDao implements Dao<Integer, FavoriteDto> {

    private Connection connexion;

    private FavoriteDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();

    }

    public static FavoriteDao getInstance() throws RepositoryException {
        return FavoriteDao.FavoriteDaoHolder.getInstance();
    }


    @Override
    public List<FavoriteDto> selectAll() throws RepositoryException {
        String sql = "SELECT id,nom,origin, destination FROM FAVORITES ";
        List<FavoriteDto> favos = new ArrayList<>();
        try (Statement stmt = connexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                FavoriteDto traject = new FavoriteDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                favos.add(traject);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return favos;
    }



    @Override
    public FavoriteDto select(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id,nom, origin, destination FROM FAVORITES " +
                "WHERE id = ?";

        FavoriteDto favo = null;
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, key);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                    favo = new FavoriteDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return favo;
    }

    @Override
    public Integer insert(FavoriteDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucune élément donné en paramètre");
        }
        int id = 0;
        String sql = "INSERT INTO FAVORITES(origin,destination,nom) values(?, ?,? )";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, item.getOrigin());
            pstmt.setString(2, item.getDestination());
            pstmt.setString(3,item.getName());
            pstmt.executeUpdate();

            ResultSet result = pstmt.getGeneratedKeys();

            while (result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return id;
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "DELETE FROM FAVORITES WHERE id = ?";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, key);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void update(FavoriteDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucune élément donné en paramètre");
        }
        String sql = "UPDATE FAVORITES SET origin=?, destination = ?, nom = ? where id=? ";
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, item.getOrigin());
            pstmt.setString(2, item.getDestination());
            pstmt.setString(3, item.getName());
            pstmt.setInt(4,item.getKey());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }


    private static class FavoriteDaoHolder {

        private static FavoriteDao getInstance() throws RepositoryException {
            return new FavoriteDao();
        }
    }
}

