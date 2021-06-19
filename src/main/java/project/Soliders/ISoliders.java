package project.Soliders;

import project.Map.IMap;

import java.util.List;

public interface ISoliders {


    public ISolidersAttack getAttack();
    public void acceptAttack(ISolidersAttack attack);

    /**
     *
     * @param property
     * @return
     */
    public double getProperty(EUnitProperties property);
    public String getName();
    public List<ISoliders> getNeighbours();
    public void canAttack(List<ISoliders> solider);
    public char getFirstCharofTheName();
    public int getEnemyNeighboursSize(List<ISoliders> neighbours);
    public IMap getMap();
    public void setMap(IMap map);
    public void move();

}
