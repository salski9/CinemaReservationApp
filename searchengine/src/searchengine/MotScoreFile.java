package searchengine;

public class MotScoreFile<filePath, mot , score> {
	public filePath key;
	public mot value1;
	public score value2;

    public MotScoreFile(filePath key, mot value1, score value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2 ;
    }

    public filePath getKey() {
        return key;
    }

    public mot getValue1() {
        return value1;
    }
    public score getValue2() {
        return value2;
    }
    public void setKey(filePath key) {
        // Setter for the 'key' attribute
        this.key = key;
    }

    public void setValue1(mot value1) {
        // Setter for the 'value' attribute
        this.value1 = value1;
    }
    public void setValue2(score value2) {
        // Setter for the 'value' attribute
        this.value2 = value2;
    }


}
