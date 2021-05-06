package atl.grade.dto;

/**
 *
 * @author jlc
 */
public class GradeDto extends Dto<Integer> {

    private int value;
    private String lesson;

    public GradeDto(Integer key, int value,String lesson) {

        super(key);
        this.lesson = lesson;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getLesson() {
        return lesson;
    }

}
