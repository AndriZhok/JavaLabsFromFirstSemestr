package droids;

public class BattleDroid extends Droid {

    public BattleDroid(String name) {
        super(name, 100, 20); // health = 100, damage = 20
    }

    @Override
    public void attack(Droid opponent) {
        System.out.println(this.name + " атакує " + opponent.getName() + " на " + this.damage + " одиниць урону.");
        opponent.setHealth(opponent.getHealth() - this.damage);
    }
}
