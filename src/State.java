public class State {
    private String title;
    private int hitPoints;
    private int hitPointsLimit;
    private int damage;

    public State(String title, int hitPoints, int damage) {
        this.title = title;
        this.hitPoints = hitPoints;
        this.hitPointsLimit = hitPoints;
        this.damage = damage;
    }

    public void ensureIsAlive() throws OutOfHitPointsException {
        if (this.hitPoints == 0) {
            throw new OutOfHitPointsException();
        }
    }

    public String getTitle() {
        return this.title;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public int getHitPointsLimit() {
        return this.hitPointsLimit;
    }

    public int getDamage() {
        return this.damage;
    }

    public void addHitPoints(int hp) throws OutOfHitPointsException {
        this.ensureIsAlive();

        int total = this.hitPoints + hp;
        if ( total > this.hitPointsLimit ) {
            this.hitPoints = this.hitPointsLimit;
            return;
        }
        this.hitPoints = total;
    }

    public void _takeDamage(int dmg) throws OutOfHitPointsException {
        this.ensureIsAlive();

        if ( dmg > this.hitPoints ) {
            this.hitPoints = 0;
            return;
        }
        this.hitPoints -= dmg;
    }

    public void takeDamage(int dmg) throws OutOfHitPointsException {
        this._takeDamage(dmg);
    }

    public void takeMagicDamage(int dmg) throws OutOfHitPointsException {
        this._takeDamage(dmg);
    }
}

