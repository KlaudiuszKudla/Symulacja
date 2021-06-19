package project.Soliders;


import java.util.*;

import project.Arena.FightSimple;
import project.Map.IMap;


public abstract class ASoliders implements ISoliders {

    protected Random rnd;
    protected long seed = 0;
    protected Map<EUnitProperties, Double> stats;
    protected ISolidersAttack attack;
    protected String name;
    protected IMap map;


    public ASoliders(String name, IMap map) {

        stats = new HashMap<>();
        attack = new SolidersAttack();
        this.name = name;
        this.map = map;
        rnd = new Random(seed);

    }


    @Override
    public ISolidersAttack getAttack() {
        return attack;
    } // zwraca atak jednostki

    @Override
    public double getProperty(EUnitProperties property) { //zwraca wartość podanych atrybutów
        Double value = stats.get(property);
        if (value != null)
            return value;
        return 0;
    }

    @Override
    public String getName() {
        return name;
    } //zwraca imie

    @Override
    public IMap getMap() { //zwraca mape
        return map;
    } //zwraca jednoste na mapie


    @Override
    public void setMap(IMap map) {
        this.map = map;
    } //ustawia jednostke na mapie

    @Override
    public void move() { //przemieszcza jednostke
        do {
            int x = rnd.nextInt(map.getXSize()); //losuje pozycje na osi x
            int y = rnd.nextInt(map.getYSize()); //losuje pozycje na osi y
            if (map.getSolider(x, y) == null) {  //jeżeli pozycja jest wolna osiedla go na niej
                map.settleSolider(this, x, y);
                break;
            }
        } while (true);
    }

    @Override
    public List<ISoliders> getNeighbours() { // zwraca liste sąsiadów
        List<ISoliders> neighbours = new ArrayList<>();
        int a = map.getXSoliderPosition(this); // a-pozycja x nasze
        int b = map.getYSoliderPosition(this);
        if (((a + 1) < map.getXSize()) && (map.getSolider(a + 1, b) != null)) {
            neighbours.add(map.getSolider(a + 1, b));
        }
        if (((a - 1) >= 0) && (map.getSolider(a - 1, b) != null)) {
            neighbours.add(map.getSolider(a - 1, b));
        }
        if (((b + 1) < map.getYSize()) && (map.getSolider(a, b + 1) != null)) {
            neighbours.add(map.getSolider(a, b + 1));
        }
        if (((b - 1) >= 0) && (map.getSolider(a, b - 1) != null)) {
            neighbours.add(map.getSolider(a, b - 1));
        }
        return neighbours;

    }

    @Override
    public void canAttack(List<ISoliders> neighbours) { // jeśli sąsiad należy do przeciwnej drużyny atakuje go
        int a = getEnemyNeighboursSize(neighbours);
        if (a == 0) {
            this.move();
            return;
        }
        Random random = new Random();
        FightSimple fight = new FightSimple();
        for (int i = 0; i < neighbours.size(); i++) {
            if (this.getProperty(EUnitProperties.HP) > 0) {
                int j = random.nextInt(neighbours.size());
                if (this.getFirstCharofTheName() != neighbours.get(j).getFirstCharofTheName()) {
                    fight.setSoliders(this, neighbours.get(j));
                    System.out.println(fight.performFight() + "Has been killed");
                    neighbours.remove(neighbours.get(j));
                }
            }

        }
    }

    @Override
    public char getFirstCharofTheName() {
        char a = name.charAt(1);
        return a;
    }

    @Override
    public int getEnemyNeighboursSize(List<ISoliders> neighbours) {
        int a = 0;
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).getFirstCharofTheName() != this.getFirstCharofTheName()) {
                a++;
            }
        }
            return a;

    }
}












