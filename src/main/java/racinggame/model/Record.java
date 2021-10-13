package racinggame.model;

public class Record {

    private static String MOVED_RANGE = "-";

    private String value;

    public Record() {
        this.value = "";
    }

    public void update() {
        this.value += MOVED_RANGE;
    }

    public String getValue() {
        return this.value;
    }

    public int getSize() {
        return this.value.length();
    }

}
