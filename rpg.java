public class rpg {

    public static void main(String[] args){
        Wizard wizard = new Wizard("Merlin",100, 10,5);
        Warrior warrior = new Warrior("Ragnar",100,7,10);
        Archer archer = new Archer("Kapuishon", 100, 11, 7);

        System.out.println(wizard.getName() + "'s health: " + wizard.getHealth());
        System.out.println(warrior.getName()+"'s health: " + warrior.getHealth());
        System.out.println(archer.getName()+"'s health: " + archer.getHealth());
        System.out.println("Game is starting...");
        wizard.setHealth(warrior);
        System.out.println(warrior.getName()+" attacks " + wizard.getName() + ". Health updated: " + wizard.getHealth());

        archer.setHealth(wizard);
        System.out.println(wizard.getName()+" attacks " + archer.getName() + ". Health updated: " + archer.getHealth());

        warrior.setHealth(archer);
        System.out.println(archer.getName()+" attacks " + warrior.getName() + ". Health updated: " + warrior.getHealth());


    }
}


class Wizard {
    private String name;
    private int health;
    private int darkMagic;
    private int wizardArmor;

    public Wizard(String name, int health, int darkMagic, int wizardArmor){
        this.name = name;
        this.health = health;
        this.darkMagic = darkMagic;
        this.wizardArmor = wizardArmor;
    }

    public String getName() {
        return name;
    }

    public int getDarkMagic(){
        return darkMagic;
    }

    public void setHealth(Warrior attack) {
       health = health - (attack.getSword() - wizardArmor);
    }

    public void setHealth(Archer attack) {
       health = health - (attack.getBow() - wizardArmor);
    }


    public int getHealth() {
        return health;
    }

}

class Warrior {
    private String name;
    private int health;
    private int sword;
    private int metalArmor;

    public Warrior(String name, int health, int sword, int metalArmor){
        this.name = name;
        this.health = health;
        this.sword = sword;
        this.metalArmor = metalArmor;
    }

    public String getName() {
        return name;
    }

    public int getSword() {
        return sword;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(Wizard attack) {
       health = health - (attack.getDarkMagic() - metalArmor);
    }

    public void setHealth(Archer attack) {
       health = health - (attack.getBow() - metalArmor);
    }


}

class Archer {
    private String name;
    private int health;
    private int bow;
    private int leatherArmor;

    public Archer(String name, int health, int bow, int leatherArmor){
        this.name = name;
        this.health = health;
        this.bow = bow;
        this.leatherArmor = leatherArmor;
    }

    public String getName() {
        return name;
    }

    public int getBow() {
        return bow;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(Wizard attack) {
       health = health - (attack.getDarkMagic() - leatherArmor);
    }

    public void setHealth(Warrior attack) {
       health = health - (attack.getSword() - leatherArmor);
    }


}
