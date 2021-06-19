package project.Arena;

import project.Soliders.EUnitProperties;
import project.Soliders.ISoliders;

public class FightSimple extends AFight {
    @Override
    public String performFight() {
        ISoliders A;
        ISoliders B;
        String killed=null;
        Double ASpeed = soliderA.getProperty(EUnitProperties.ATTACKSPEED);
        Double BSpeed = soliderB.getProperty(EUnitProperties.ATTACKSPEED);
        if (BSpeed > ASpeed) {
            B = soliderA;
            A = soliderB;
        } else {
            A = soliderA;
            B = soliderB;
        }
        do {
            B.acceptAttack(A.getAttack());
            A.acceptAttack(B.getAttack());
        } while (A.getProperty(EUnitProperties.HP) > 0 && B.getProperty(EUnitProperties.HP) > 0);
        if (A.getProperty(EUnitProperties.HP) == 0) {

            killed=A.getName();
            A.getMap().deleteFromTheMap(A);

        }
        else if (B.getProperty(EUnitProperties.HP) == 0) {
            killed=B.getName();
            B.getMap().deleteFromTheMap(B);

        }
        return killed;
    }
}
