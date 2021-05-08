package g55315.model.dto;

import java.util.List;

/**
 * class representing the lines from a metro system
 */
public class LineDto extends Dto<Integer>{
    private List<StopDto> stops;

    /**
     * getter for the stops on this line
     * @return the stops
     */
    public List<StopDto> getStops() {
        return stops;
    }

    /**
     * adds a stop to a line
     * @param stop the new stop
     */
    public void addStop(StopDto stop) {
        stops.add(stop);
    }

    /**
     * a constructor
     * @param key the number of the line
     * @param stops a list of stops on this line
     */
    public LineDto(Integer key, List<StopDto> stops) {
        super(key);
        this.stops = stops;
    }
}
