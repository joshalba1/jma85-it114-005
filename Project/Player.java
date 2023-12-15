package Project;

public class Player {

    private boolean isReady = false;

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public boolean isReady() {
        return this.isReady;
    }

    private Character character;

    /**
     * Assigns a bi-directional relationship between Character and Player so if we have one we can find the other
     * @param character
     */
    

    public Character getCharacter(){
        return character;
    }

    public boolean hasCharacter(){
        return character != null;
    }
}