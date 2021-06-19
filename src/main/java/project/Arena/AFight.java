package project.Arena;

import project.Soliders.ISoliders;

public abstract class AFight implements IFight {

    public ISoliders soliderA;
    public ISoliders soliderB;
    @Override
    public void setSoliders(ISoliders soliderA, ISoliders soliderB){
        this.soliderA=soliderA;
        this.soliderB= soliderB;
    }
}
