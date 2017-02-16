package randomForest;

/**
 * Created by blou on 16/02/17.
 */
public enum KindOfUserEnum {
    IDLE_USER("idle_user"),
    POCKET_USER("pocket_user"),
    CALLER("caller"),
    PLAYER("player");

    private String txt;
    KindOfUserEnum(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return this.txt;
    }
}
