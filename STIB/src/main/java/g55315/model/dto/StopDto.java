package g55315.model.dto;

import java.util.List;

/**
 * class respresenting a stop on a line
 */
public class StopDto extends Dto<String> {
    private List<Integer> id_line;
    private int id_order;
    private int id_station;

    /**
     * a getter for the list of lines of this stop
     * @return the list of lines
     */
    public List<Integer> getId_line() {
        return id_line;
    }

    /**
     * a getter for the order of this stop
     * @return the order of the stop
     */
    public int getId_order() {
        return id_order;
    }

    /**
     * a getter for the id of this stop
     * @return
     */
    public int getId_station() {
        return id_station;
    }

    /**
     * adds a line to the stop
     * @param line the line to add
     */
    public void addLine(int line) {
        id_line.add(line);
    }

    @Override
    public String getKey() {
        return super.getKey();
    }




    /**
     * the constructor of this class
     * @param key the name of the stop
     * @param id_line the id of the line
     * @param id_order the order of the stop
     * @param id_station the id of the station
     */
    public StopDto(String key, List<Integer> id_line, int id_order, int id_station) {
        super(key);
        this.id_line = id_line;
        this.id_order = id_order;
        this.id_station = id_station;
    }
}
