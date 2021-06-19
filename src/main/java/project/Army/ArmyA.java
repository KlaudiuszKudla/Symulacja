package project.Army;

import project.Map.IMap;
import project.Soliders.*;

public class ArmyA extends AArmy {

    public ArmyA(int numOfHalbardiers, int numOfKnights, int numOfMages, int numOfShooters, IMap mapa) {
        super(numOfHalbardiers, numOfKnights, numOfMages, numOfShooters, mapa);

    }

    @Override
    public Halberdier createHalberdier() {
        return new Halberdier("[AH]", mapa);
    }

    @Override
    public Shooter createShooter() {
        return new Shooter("[AS]", mapa);
    }

    @Override
    public Mage createMage() {
        return new Mage("[AM]", mapa);
    }

    @Override
    public Knight createKnight() {
        return new Knight("[AK]",mapa);
    }


}
