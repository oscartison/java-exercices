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
public class StopDao implements Dao<String, StopDto> {

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
                boolean found = false;
                for (StopDto stop : dtos) {
                    if (stop.getKey().equals(rs.getString(4))) {
                        found = true;
                        stop.addLine(rs.getInt(1));
                        break;
                    }
                }
                if (!found) {
                    List<Integer> lines = new ArrayList<>();
                    lines.add(rs.getInt(1));
                    StopDto stop = new StopDto(rs.getString(4),lines, rs.getInt(3), rs.getInt(2));
                    dtos.add(stop);
                }
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }



    @Override
    public StopDto select(String key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé donnée en paramètre");
        }
        String sql = "SELECT id_line, id_station, id_order, name FROM STOPS "
                + "JOIN STATIONS s ON id_station = id " +
                " WHERE name=? "
                + "ORDER BY id_order";
        StopDto stop = null;
        try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, key);
            ResultSet rs = pstmt.executeQuery();


                List<Integer> lines = new ArrayList<>();

                if (rs.next()) {
                    lines.add(rs.getInt(1));
                    stop = new StopDto(rs.getString(4), lines, rs.getInt(3), rs.getInt(2));

                }
                while (rs.next()) {
                   stop.addLine(rs.getInt(1));
                }


        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return stop;
    }

    @Override
    public String insert(StopDto item) throws RepositoryException {
        return null;
    }

    @Override
    public void delete(String key) throws RepositoryException {

    }

    @Override
    public void update(StopDto item) throws RepositoryException {

    }


    private static class StopDaoHolder {

        private static StopDao getInstance() throws RepositoryException {
            return new StopDao();
        }
    }
}
