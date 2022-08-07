package api;

public abstract class Key  {
    private String key;

    protected Key(String key) { this.key = key;}

    public String getKey() {
        return key;
    }

    public String getNewKey() {return "my new key";}

}
