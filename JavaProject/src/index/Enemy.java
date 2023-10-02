package index;

public  class Enemy {//敵人設定
    int hp;
    int power;
  

    public Enemy() {//初始設定讓怪物一開始都一樣再依樓層變強
        this.hp = 10;
        this.power = 2;   
    }
    void setpower(int power) {    	
    	this.power =  power;
    }
    void sethp(int hp) {    	
    	this.hp = hp;
    }
    
    int getpower() {    	
    	return power;
    }
    int gethp() {    	
    	return hp;
    }

    
}
