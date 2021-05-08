package g55315.model.dto;

/**
 * class representing a station
 */
public class StationDto extends Dto<String>{
    private int id;

    /**
     * a getter for the id of the station
     * @return the id of the station
     */
    public int getId() {
        return id;
    }

    /**
     * constructor for this class
     * @param key the name of the station
     * @param id the id of the station
     */
    public StationDto(String key, int id) {
        super(key);
        this.id = id;
    }
}
