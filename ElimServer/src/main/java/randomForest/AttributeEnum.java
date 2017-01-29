package randomForest;

/**
 * Created by blou on 29/01/17.
 */
public enum AttributeEnum {
    DAY_NAME("day_name"),
    POCKET_TIME("pocket_time"),
    CALLING_TIME("calling_time"),
    NOT_IN_USE_TIME("not_in_use_time"),
    IN_USE_TIME("in_use_time");

    private String txt;
    AttributeEnum(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return this.txt;
    }
}
