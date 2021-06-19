package project.Soliders;

import project.Map.IMap;

import java.util.List;

public interface ISoliders {


    /**
     *
     * @return atak - atak zolnierza
     */
    public ISolidersAttack getAttack();

    /**
     * Przyjmuje atak przeciwnika
     * Pobiera swoje i przeciwnika statystyki
     * Decyduje jak przyjac atak
     * Zmienia wartosc zycia po walce
     * @param attack
     */
    public void acceptAttack(ISolidersAttack attack);

    /**
     *
     * @param property
     * @return
     * @return double - parametr
     */
    public double getProperty(EUnitProperties property);

    /**
     *
     * @return String - Imie
     */
    public String getName();

    /**
     *
     * Jezeli na polach (gora, dol, prawo, lewo) znajduje sie jednostka dodaje do listy
     * @return Soliders - lista sasiadow
     */
    public List<ISoliders> getNeighbours();

    /**
     *Jezeli wszyscy sasiedzi naleza do tej samej druzyny to zmienia pozycje
     * Wybiera losowo przeciwnika, jezeli jest wrogiem atakuje go
     * przeprowadza walke, wyswietla imie zabitej jednostki i usuwa ja z mapy
     * @param solider - lista sasiadow
     */

    public void canAttack(List<ISoliders> solider);

    /**
     *
     * @return char - pierwsza litera imienia jednostki
     */
    public char getFirstCharofTheName();

    /**
     * pobiera liste sasiadow i zwraca ilosc zolnierzy nalezacych do armi przeciwnej
     * @param neighbours - lista sasiadow
     * @return int - ilosc sasiadujacych przeciwnikow
     */
    public int getEnemyNeighboursSize(List<ISoliders> neighbours);

    /**
     *
     * @return IMap - mapa na ktorej znajduje sie jednostka
     */
    public IMap getMap();

    /**
     * Ustawia jednostke na mapie podanej jako argument
     * @param map
     */
    public void setMap(IMap map);

    /**
     * Losuje pozycje na osi x,y dopoki wylosowana pozycja nie bedzie wolna
     * jezeli znajdzie wolna pozycje to osiedla sie
     *
     */
    public void move();

}