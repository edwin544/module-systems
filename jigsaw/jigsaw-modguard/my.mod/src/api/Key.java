package api;

public abstract class Key  {
    private byte[] key;

    protected Key(byte[] key) { this.key = key;}

    public byte[] getKey() {
        return key;
    }

    public String getNewKey() {return "my new key";}

}
