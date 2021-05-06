package g55315.model.jdbc;


import g55315.model.dto.StopDto;
import g55315.model.repository.Dao;
import g55315.model.exception.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jlc
 */
public class StopDao implements Dao<Integer, StopDto> {

    private Connection connexion;

    private StopDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();

    }

    public static StopDao getInstance() throws RepositoryException {
        return StopDaoHolder.getInstance();
    }


    @Override
    public List<StopDto> selectAll() throws RepositoryException {
        String sql = "SELECT id_line, id_station, id_order, name FROM STOPS "
                + "JOIN STATIONS s ON id_station = id ";
        List<StopDto> dtos = new ArrayList<>();
        try (Statement stmt = connexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StopDto stop = new StopDto(rs.getInt(2), rs.getInt(1), rs.getInt(3), rs.getString(4));
                dtos.add(stop);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }



    @Override
    public List<StopDto> select(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id_line, id_station, id_order, name FROM STOPS "
                + "JOIN STATIONS s ON id_station = id " +
                " WHERE id_line=? "
                + "ORDER BY id_order";
        List<StopDto> dtos = new ArrayList<>();
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, key);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dtos.add(new StopDto(rs.getInt(2), rs.getInt(1), rs.getInt(3), rs.getString(4)));

            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }


    private static class StopDaoHolder {

        private static StopDao getInstance() throws RepositoryException {
            return new StopDao();
        }
    }
}
