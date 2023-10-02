package index;

public class DemonKing extends Enemy {
    public DemonKing(int hp, int power) {
        super(hp, power);
    }

    @Override
    public void damage(Adventure adventure) {
        int damage = adventure.getPower();
        this.hp -= damage;
    }
}
