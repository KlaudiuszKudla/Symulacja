package project.Arena;


import project.Soliders.ISoliders;


public interface IFight {
    public void setSoliders(ISoliders soliderA, ISoliders soliderB);
    public String performFight();

}
