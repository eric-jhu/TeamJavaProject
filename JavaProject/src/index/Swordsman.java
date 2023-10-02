package index;


public class Swordsman extends Adventure {
	public Swordsman(int hp, int power) {
		super(hp, power);
	}

	@Override
	public void attack(Enemy enemy) {
		dodge = Math.random();
		dodge *= 101;
		int damage = enemy.getPower();
		if (dodge >= 80)
			this.hp -= 0;
		else
			this.hp -= damage;
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		
	}
}


