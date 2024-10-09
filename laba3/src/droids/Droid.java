package droids;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;

    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void restoreHealth() {
        // Реалізуйте логіку для відновлення здоров'я дроїда, якщо потрібно
        this.health = 100; // Приклад: відновити здоров'я до 100
    }
}