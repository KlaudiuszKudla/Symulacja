package project.Map;

import project.Soliders.ISoliders;

public interface IMap {

    /**
     * @param x - pozycja na mapie na osi x
     * @param y - pozycja na mapie na osi y
     * @return Solider- jednostka znajdujaca sie na podanych w argumencie koordynatach
     */
    public ISoliders getSolider(int x, int y);

    /**
     * @return x - ilosc kolumn mapy
     */
    public int getXSize();

    /**
     * @return ilosc wierszy mapy
     */
    public int getYSize();

    /**
     * Przeszukuje mape, jezeli znajdzie na niej zolnierza to zwraca jego pozycje
     *
     * @param solider
     * @return x-pozycja na osi x podanego zolnierza
     */
    public int getXSoliderPosition(ISoliders solider);

    /**
     * Przeszukuje mape, jezeli znajdzie na niej zolnierza to zwraca jego pozycje
     *
     * @param solider
     * @return y-pozycja na osi y podanego zolnierza
     */
    public int getYSoliderPosition(ISoliders solider);

    /**
     * sprawdzamy czy na danej w argumencie pozycji znajduje sie jakaś jednostka, jezeli tak to zwracamy false
     * Jezeli nie to usuwamy zolnierza z obecnej jednostki i przypisujemy do tej podanej w argumencie, zwracamy true
     *
     * @param solider
     * @param x-pozycja na osi x na ktorej chcemy osiedlic zolnierza
     * @param y-pozycja na osi y na ktorej chcemy osiedlic zolnierza
     * @return true- jezeli udalo sie osiedlic, false - nie
     */
    public boolean settleSolider(ISoliders solider, int x, int y);

    /**
     * Wyswietlanie obecnego stanu mapy
     *
     * @return mapa
     */
    public String toString();

    /**
     * Usuwamy zolnierza z obecnej pozycji
     *
     * @param solider
     */
    public void deleteFromTheMap(ISoliders solider);

    /**
     * Szukamy sojusznikow na mapie
     *
     * @return liczba sojusznikow na mapie
     */
    public int howManyAOnTheMap();

    /**
     * Szukamy sojusznikow na mapie
     *
     * @return liczba sojusznikow na mapie
     */
    public int howManyBOnTheMap();

}