package g55315.model.dto;

/**
 * class representing the favorite trajects
 */
public class FavoriteDto extends Dto<Integer> {
    public String name;
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
     * getter for the name of the favorite
     * @return the name of the favorite
     */
    public String getName() {
        return name;
    }

    /**
     * a constructor for the class
     * @param key the id of this favorite
     * @param origin the origin station
     * @param destination the destination station
     */
    public FavoriteDto(int key, String name, String origin, String destination) {
        super(key);
        this.name = name;
        this.destination = destination;
        this.origin = origin;
    }
}
