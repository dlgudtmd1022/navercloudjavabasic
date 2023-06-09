package poly.inheri;

public class Warrior {

	private String id;
	private int hp;
	private int atk;
	private int def;
	private int exp;
	
	public Warrior(String id) {
		this.id = id;
		this.hp = 20;
		this.atk = 5;
		this.def = 5;
		this.exp = 0;		
	}
	public void showStatus() {
		System.out.println("아이디 : " + id);
		System.out.println("체력 : " + hp);
		System.out.println("공격력 : " + atk);
		System.out.println("방어력 : " + def);
		System.out.println("경험치 : " + exp);
		System.out.println("-----------------------");
	}
	
	// 파라미터로 모든 몬스터의 부모인 Monster를 선언하면
	// 다향성 원리에 의해서 상속받은 모든 몬스터가 대입 가능합니다.
	public void hunt(Monster monster) {
		// 죽은 몬스터는 교전 불가 및 종료
		if(monster.isInactive()) {
			showMonsterAlreahyDeadMessage(monster.getName());
			return;
			}
		// 죽은 몬스터가 다음공격에 죽으면 플레이어에게 경험치 부여
		if(monster.isInactiveAfterNextAttacked(this.atk)) {			
			gainMonsterExp(monster.getExp());			
			showMonterNowDeadMessage(monster.getName());	
			monster.setAfterAttackedHp(this.atk);
			}
		// 몬스터가 다음 공격에 죽지 않으면 반격해 플레리어 체력 차감	
		else{			
			setHpAfterMonsterAttack(monster.getAtk());
			showMonsterCounterAttackMessage(monster.getName());
			monster.setAfterAttackedHp(this.atk);			
		}
}
	
		
//	public void hunt(Monster monster) {
//		// 죽은 몬스터는 교전 불가 및 종료
//		if(monster.getHp() <= 0) {
//			System.out.println("이 몬스터는 이미 죽어서 교전할 수 없습니다.");
//		}
//		if(monster.getHp() - this.atk <= 0) {
//		// 몬스터가 다음공격에 죽으면 플레이어에게 경험치 부여
//			monster.setHp(monster.getHp() - (this.atk - monster.getDef()));
//			System.out.println("몬스터가 죽었습니다.");
//			this.exp += monster.getExp();
//		} else {
//		// 몬스터가 다음 공격에 죽지는 않으면 반격해 플레이어 체력 차감
//			monster.setHp(monster.getHp() - (this.atk - monster.getDef()));
//			this.hp -= monster.getAtk();
//			System.out.println("몬스터가 반격했습니다.");
//		}
//	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
		
	}
	
	// 그냥 Warrior 내부에서 적어도 되지만 코드 흐름을
	// 메서드 호출로만 제어하기 위해 분리.
	public void gainMonsterExp(int monsterExp) {
		this.exp += monsterExp;
	}
	
	// 상단 Warrior 체력을 차감하는 로직을 메서드로 분리 및 재정의
	public void setHpAfterMonsterAttack(int monsterAtk) {				
		if(monsterAtk == 0 || monsterAtk - this.def <= 0) { 
			this.hp--;
	}else {
		this.hp -= monsterAtk - this.def;
	}
		
}		
	
	public void showMonsterAlreahyDeadMessage(String monstername) {
		System.out.println("이 " + monstername + "은(는) 이미 죽었습니다.");
	}
	
	public void showMonterNowDeadMessage(String monstername) {
		System.out.println(monstername + "를(을) 잡았습니다.");
	}
	
	public void showMonsterCounterAttackMessage(String monstername) {
		System.out.println(monstername + "가(이) 죽지않고 공격했습니다.");
	}
	
	








}
