package battle;

import droids.Droid;

public class OneOnOneBattle extends Battle {
    private Droid droid1;
    private Droid droid2;

    public OneOnOneBattle(Droid droid1, Droid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
    }

    @Override
    public void startBattle() {
        System.out.println("Бій між " + droid1.getName() + " та " + droid2.getName() + " починається!");

        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.attack(droid2);
            if (droid2.isAlive()) {
                droid2.attack(droid1);
            }

            System.out.println(droid1.getName() + " здоров'я: " + droid1.getHealth());
            System.out.println(droid2.getName() + " здоров'я: " + droid2.getHealth());
        }

        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " виграв!");
        } else {
            System.out.println(droid2.getName() + " виграв!");
        }
    }
}
