package droids;

public class TankDroid extends Droid {

    public TankDroid(String name) {
        super(name, 150, 15); // health = 150, damage = 15
    }

    @Override
    public void attack(Droid opponent) {
        System.out.println(this.name + " атакує " + opponent.getName() + " на " + this.damage + " одиниць урону.");
        opponent.setHealth(opponent.getHealth() - this.damage);
    }
}
