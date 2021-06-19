package project.Arena;


import project.Soliders.ISoliders;


public interface IFight {
    /**
     * Przypisujemy zolnierzy do walki
     * @param soliderA
     * @param soliderB
     */
    public void setSoliders(ISoliders soliderA, ISoliders soliderB);

    /**
     * Decyduje o pierwszenstwie ataku ze wzgledu na predkosc ataku zolnierzy
     * Przeprowadza walke dopoki ktorys z zolnierzy nie zginie
     * @return Imie zabitego zolnierza
     */
    public String performFight();

}