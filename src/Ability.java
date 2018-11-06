public class Ability {
    protected Unit owner;
    public State state;

    public Ability(Unit owner) {
        this.owner = owner;
    }

    public void counterAttack(Unit enemy) throws OutOfHitPointsException {
        this.owner.ensureIsAlive();
        enemy.takeDamage(this.owner.getDamage() / 2);
    }

    public void attack(Unit enemy) throws OutOfHitPointsException {
        this.owner.ensureIsAlive();
        enemy.takeDamage(this.owner.getDamage());
        enemy.counterAttack(this.owner);
    }


}
