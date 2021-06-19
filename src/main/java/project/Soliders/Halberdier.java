package project.Soliders;

import project.Map.IMap;

public class Halberdier extends ASoliders{

    public Halberdier(String name, IMap map){
        super(name, map);
    this.stats.put(EUnitProperties.HP, 200.0);
    this.attack.setDamage(EAttackTypes.PHYSICAL, 80.0);
    this.stats.put(EUnitProperties.ARMOR, 20.0);
    this.stats.put(EUnitProperties.ATTACKSPEED, 1.0);



    }

    @Override
    public void acceptAttack(ISolidersAttack attack){

        Double pDmg = attack.getDamage(EAttackTypes.PHYSICAL);
        Double mDmg = attack.getDamage(EAttackTypes.MAGICAL);
        Double currHP = this.stats.get(EUnitProperties.HP);
        Double armor = this.stats.get(EUnitProperties.ARMOR);


        if(pDmg >0) {
            currHP = currHP - pDmg + armor;
        }
        this.stats.put(EUnitProperties.HP, currHP<0? 0: currHP);
        if(mDmg >0) {
            currHP= currHP - mDmg;
        }
        this.stats.put(EUnitProperties.HP, currHP<0? 0:currHP);
    }


    }











