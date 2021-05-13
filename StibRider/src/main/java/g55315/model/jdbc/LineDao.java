package g55315.model.jdbc;

import g55315.model.dto.LineDto;
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
    public class LineDao implements Dao<Integer, LineDto> {

        private Connection connexion;

        private LineDao() throws RepositoryException {
            connexion = DBManager.getInstance().getConnection();

        }

        public static LineDao getInstance() throws RepositoryException {
            return LineDao.LineDaoHolder.getInstance();
        }


        @Override
        public List<LineDto> selectAll() throws RepositoryException {
            String sql = "SELECT id_line, id_station, id_order, name FROM STOPS "
                    + "JOIN STATIONS s ON id_station = id ";
            List<LineDto> lines = new ArrayList<>();
            try (Statement stmt = connexion.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    boolean found = false;
                    for (LineDto line : lines) {
                        if (line.getKey().equals(rs.getInt(1))) {
                            found = true;
                            List<Integer> line_id = new ArrayList<>();
                            line_id.add(rs.getInt(1));
                            line.addStop(new StopDto(rs.getString(4), line_id, rs.getInt(3), rs.getInt(2)));
                            break;
                        }
                    }
                    if (!found) {
                        List<Integer> line_id = new ArrayList<>();
                        line_id.add(rs.getInt(1));
                        List<StopDto> stops = new ArrayList<>();
                        stops.add(new StopDto(rs.getString(4), line_id, rs.getInt(3), rs.getInt(2)));
                        lines.add(new LineDto(rs.getInt(1),stops));
                    }
                }
            } catch (SQLException e) {
                throw new RepositoryException(e);
            }
            return lines;
        }



        @Override
        public LineDto select(Integer key) throws RepositoryException {
            if (key == null) {
                throw new RepositoryException("Aucune clé donnée en paramètre");
            }
            String sql = "SELECT id_line, id_station, id_order, name FROM STOPS "
                    + "JOIN STATIONS s ON id_station = id " +
                    " WHERE id_line=? "
                    + "ORDER BY id_order";

            LineDto line = null;
            try (PreparedStatement pstmt = connexion.prepareStatement(sql)) {
                pstmt.setInt(1, key);
                ResultSet rs = pstmt.executeQuery();
                List<StopDto> stops = new ArrayList<>();

                if(rs.next()){
                    List<Integer> line_id = new ArrayList<>();
                    line_id.add(rs.getInt(1));
                    StopDto stop =new StopDto(rs.getString(4), line_id, rs.getInt(3), rs.getInt(2));
                    stops.add(stop);
                    line = new LineDto(rs.getInt(1),stops);
                }
                while (rs.next()) {
                    List<Integer> line_id = new ArrayList<>();
                    line_id.add(rs.getInt(1));
                    StopDto stop =new StopDto(rs.getString(4), line_id, rs.getInt(3), rs.getInt(2));
                    line.addStop(stop);
                    }

            } catch (SQLException e) {
                throw new RepositoryException(e);
            }
            return line;
        }

        @Override
        public Integer insert(LineDto item) throws RepositoryException {
            return null;
        }

        @Override
        public void delete(Integer key) throws RepositoryException {

        }

        @Override
        public void update(LineDto item) throws RepositoryException {

        }


        private static class LineDaoHolder {

            private static LineDao getInstance() throws RepositoryException {
                return new LineDao();
            }
        }
    }

