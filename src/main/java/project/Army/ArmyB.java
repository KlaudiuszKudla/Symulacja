package project.Army;

import project.Map.IMap;
import project.Soliders.*;

public class ArmyB extends AArmy {


    public ArmyB(int numOfHalbardiers, int numOfKnights, int numOfMages, int numOfShooters, IMap mapa) {

        super(numOfHalbardiers, numOfKnights, numOfMages, numOfShooters, mapa);
    }

    @Override
    public Halberdier createHalberdier() {
        return new Halberdier("[BH]", mapa);
    }

    @Override
    public Shooter createShooter() {
        return new Shooter("[BS]", mapa);
    }

    @Override
    public Mage createMage() {
        return new Mage("[BM]", mapa);
    }

    @Override
    public Knight createKnight() {
        return new Knight("[BK]", mapa);
    }


}


