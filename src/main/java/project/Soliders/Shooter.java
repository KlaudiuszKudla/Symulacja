package project.Soliders;

import project.Map.IMap;

public class Shooter extends ASoliders {


    public Shooter(String name, IMap map) {
        super(name, map);
        this.stats.put(EUnitProperties.HP, 220.0);
        this.stats.put(EUnitProperties.ATTACKSPEED, 4.0);
        this.attack.setDamage(EAttackTypes.PHYSICAL, 70);
    }

    @Override
    public void acceptAttack(ISolidersAttack attack) {

        Double pDmg = attack.getDamage(EAttackTypes.PHYSICAL);
        Double mDmg = attack.getDamage(EAttackTypes.MAGICAL);
        Double currHP = this.stats.get(EUnitProperties.HP);

        if(pDmg >0) {
            currHP -= pDmg;
        }
        this.stats.put(EUnitProperties.HP, currHP<0? 0: currHP);
        if(mDmg >0) {
            currHP-= mDmg;
        }
        this.stats.put(EUnitProperties.HP, currHP<0? 0:currHP);
    }
    }



