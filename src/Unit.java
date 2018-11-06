public class Unit {
    protected State state;
    protected Ability ability;
    protected boolean isUndead;
    public String title;
    public int damage;
    public int hitPoints;
    public int hitPointsLimit;

    public Unit(String title, int hitPoints, int damage) {
        this.title = title;
        this.hitPoints = hitPoints;
        this.hitPointsLimit = hitPoints;
        this.damage = damage;
        this.isUndead = false;
    }

    public void ensureIsAlive() throws OutOfHitPointsException {
        this.state.ensureIsAlive();
    }
    public String toString () {
        return "Unit name is: " + this.title + ", damage is: " + this.damage + ", hitPoints: " + this.hitPoints + " !";
    }
}
