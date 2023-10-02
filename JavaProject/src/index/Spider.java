package index;


public class Spider extends Enemy {
    public Spider(int hp, int power) {
        super(hp, power);
    }

    @Override
    public void damage(Adventure s) {
        int damage = s.getPower();
        this.hp -= damage;
    }
}
