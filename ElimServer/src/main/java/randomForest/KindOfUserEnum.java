package randomForest;

/**
 * Created by blou on 16/02/17.
 */
public enum KindOfUserEnum {
    IDLE_USER("idle_user"),//niu en majorité
    POCKET_USER("pocket_user"),//pocket
    CALLER("caller"),//iu+calling
    PLAYER("player"),//iu
    EQUILIBRATE("equilibrate_user");

    private String txt;
    KindOfUserEnum(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return this.txt;
    }
}
