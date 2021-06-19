package project.Map;

import project.Soliders.ISoliders;

public interface IMap {

    public ISoliders getSolider(int x, int y);
    public int getXSize();
    public int getYSize();
    public int getXSoliderPosition(ISoliders solider);
     public int getYSoliderPosition(ISoliders solider);
    public boolean settleSolider(ISoliders solider, int x, int y);
    public String toString();
    public void deleteFromTheMap(ISoliders solider);
    public int howManyAOnTheMap();
    public int howManyBOnTheMap();


}
