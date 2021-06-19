package project.Soliders;

public interface ISolidersAttack {

    /**
     *Pobiera wartosc ataku
     * @param type - typ ataku
     * @return double- wartosc ataku
     */
    public double getDamage(EAttackTypes type);

    /**
     * Ustawia wartosc ataku jednostki do podanego typu
     * @param type - typ ataku
     * @param value- wartosc ataku
     */
    public void setDamage(EAttackTypes type, double value);



}