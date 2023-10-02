package index;

public class mage extends Adventure {//魔法師
	
	
	mage(){//初始化建構子 
		this.hp = 100;
		this.power = 10;
	}
	
	
//	@Override
//	public void attack(Enemy enemy) {
//		dodge = Math.random();
//		dodge *= 101;
//		int damage = enemy.getPower();
//
//		if (dodge >= 80)
//			this.hp -= 0;
//		else
//			this.hp -= damage;
//	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String skillIntroduce() {
		// TODO Auto-generated method stub
		String skillIntroducestr = "敏捷的刺客，總是靠速度取勝";
		
		return skillIntroducestr;
	}
}
