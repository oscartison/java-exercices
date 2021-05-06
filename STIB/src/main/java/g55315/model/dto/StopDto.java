package g55315.model.dto;

public class StopDto extends Dto<Integer> {
    private int id_line;
    private int id_order;
    private String name;

    public int getId_line() {
        return id_line;
    }

    public int getId_order() {
        return id_order;
    }

    public String getName() {
        return name;
    }

    public StopDto(Integer key, int id_line, int id_order, String name) {
        super(key);
        this.id_line = id_line;
        this.id_order = id_order;
        this.name = name;
    }
}
