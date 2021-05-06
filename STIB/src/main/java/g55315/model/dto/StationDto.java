package g55315.model.dto;

public class StationDto extends Dto<String>{
    private int id;

    public int getId() {
        return id;
    }

    public StationDto(String key, int id) {
        super(key);
        this.id = id;
    }
}
