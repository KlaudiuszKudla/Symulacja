package project.Army;

import project.Soliders.*;

import java.util.List;

public interface ICreateArmy {

    public Halberdier createHalberdier();
    public Shooter createShooter();
    public Mage createMage();
    public Knight createKnight();
    public List<ISoliders> createArmy();

}

