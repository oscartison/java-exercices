package g55315.model.dto;

/**
 * class representing the favorite trajects
 */
public class FavoriteDto extends Dto<Integer> {
    private String origin;
    private String destination;


    /**
     * getter for the destination
     * @return destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * a getter for the origin
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * a constructor for the class
     * @param key the id of this favorite
     * @param origin the origin station
     * @param destination the destination station
     */
    public FavoriteDto(Integer key, String origin, String destination) {
        super(key);
        this.destination = destination;
        this.origin = origin;
    }
}
