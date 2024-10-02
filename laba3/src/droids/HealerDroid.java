package droids;

public class HealerDroid extends Droid {

    public HealerDroid(String name) {
        super(name, 80, 10); // health = 80, damage = 10
    }

    public void heal(Droid ally) {
        System.out.println(this.name + " зцілює " + ally.getName() + " на 15 одиниць здоров'я.");
        ally.setHealth(ally.getHealth() + 15);
    }

    @Override
    public void attack(Droid opponent) {
        System.out.println(this.name + " атакує " + opponent.getName() + " на " + this.damage + " одиниць урону.");
        opponent.setHealth(opponent.getHealth() - this.damage);
    }
}
