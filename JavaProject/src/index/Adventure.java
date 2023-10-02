package index;

public abstract class Adventure {// 角色抽象方法
	int hp;// 血量
	int power;// 攻擊力
	int dodge;//敏捷

	public abstract void skill();// 技能
	
	public abstract String skillIntroduce(); 

}
