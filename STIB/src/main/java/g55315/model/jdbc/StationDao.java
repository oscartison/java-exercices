package g55315.model.jdbc;

import g55315.model.dto.StationDto;
import g55315.model.dto.StopDto;
import g55315.model.exception.RepositoryException;
import g55315.model.repository.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationDao implements Dao<String, StationDto> {

    private Connection connexion;

    private StationDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();

    }

    public static StationDao getInstance() throws RepositoryException {
        return StationDao.StationDaoHolder.getInstance();
    }


    @Override
    public List<StationDto> selectAll() throws RepositoryException {
        String sql = "SELECT id,name FROM STATIONS";
        List<StationDto> dtos = new ArrayList<>();
        try (Statement stmt = connexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StationDto stat = new StationDto(rs.getString(2), rs.getInt(1));
                dtos.add(stat);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }



    @Override
    public List<StationDto> select(String key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id,name FROM STATIONS WHERE name = ?";
        List<StationDto> dtos = new ArrayList<>();
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, key);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                StationDto stat = new StationDto(rs.getString(2), rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }


    private static class StationDaoHolder {

        private static StationDao getInstance() throws RepositoryException {
            return new StationDao();
        }
    }
}
