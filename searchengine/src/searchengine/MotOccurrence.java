package searchengine;

public class MotOccurrence<mot, occurrence> {
	public mot key;
	public occurrence value;

    public MotOccurrence(mot key, occurrence value) {
        this.key = key;
        this.value = value;
    }
    public mot getKey() {
        return key;
    }

    public occurrence getValue() {
        return value;
    }
    public void setKey(mot key) {
        // Setter for the 'key' attribute
        this.key = key;
    }

    public void setValue(occurrence value) {
        // Setter for the 'value' attribute
        this.value = value;
    }
}
