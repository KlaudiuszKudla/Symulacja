package project.Army;

import project.Map.IMap;
import project.Soliders.ISoliders;
import java.util.LinkedList;
import java.util.List;

public abstract  class AArmy implements ICreateArmy {

protected int numOfHalbardiers;
protected int numOfKnights;
protected int numOfMages;
protected int numOfShooters;
protected IMap mapa;

public AArmy(int numOfHalbardiers, int numOfKnights, int numOfMages, int numOfShooters, IMap mapa){

    this.numOfHalbardiers=numOfHalbardiers;
    this.numOfKnights=numOfKnights;
    this.numOfMages=numOfMages;
    this.numOfShooters=numOfShooters;
    this.mapa=mapa;

}

@Override
public List<ISoliders> createArmy(){
    List<ISoliders> army = new LinkedList<>();
    for(int i=0 ;i<numOfShooters; i++){
        army.add(createShooter());
    }
    for(int i=0 ;i<numOfHalbardiers; i++){
        army.add(createHalberdier());
    }
    for(int i=0 ;i<numOfMages; i++){
        army.add(createMage());
    }
    for(int i=0 ;i<numOfKnights; i++){
        army.add(createKnight());
    }

    return army;
}

}
