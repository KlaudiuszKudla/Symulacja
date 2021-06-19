package project.Army;
import project.Soliders.*;
import project.Soliders.ISoliders;

import java.util.List;

public interface ICreateArmy {

    /**
     * Tworzymy Halabardziste
     * @return Halberdier
     */
    public Halberdier createHalberdier();

    /**
     * Tworzymy Strzelca
     * @return Shooter
     */
    public Shooter createShooter();

    /**
     * Tworzymy Maga
     * @return Shooter
     */
    public Mage createMage();

    /**
     * Tworzymy Rycerza
     * @return Knight
     */
    public Knight createKnight();

    /**
     * Tworzymy armie
     * @return lista stworzonych zolnierzy
     */
    public List<ISoliders> createArmy();

}
