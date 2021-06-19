package project.Soliders;


import project.Map.IMap;

public class Knight extends ASoliders  {

    public Knight(String name, IMap map){
        super(name, map);
        this.stats.put(EUnitProperties.HP, 300.0 );
        this.stats.put(EUnitProperties.ATTACKSPEED,2.0);
        this.attack.setDamage(EAttackTypes.PHYSICAL, 50.0);
        this.stats.put(EUnitProperties.MAGICRESIST, 20.0);
        this.stats.put(EUnitProperties.ARMOR, 30.0);
    }

    @Override
    public void acceptAttack(ISolidersAttack attack){

        Double pDmg = attack.getDamage(EAttackTypes.PHYSICAL);
        Double mDmg = attack.getDamage(EAttackTypes.MAGICAL);
        Double currHP = this.stats.get(EUnitProperties.HP);
        Double armor = this.stats.get(EUnitProperties.ARMOR);
        Double magicResist = this.stats.get(EUnitProperties.MAGICRESIST);


        if(pDmg > 0) {
            currHP = currHP-pDmg+armor;
        }
        this.stats.put(EUnitProperties.HP, currHP<0? 0: currHP);
         if(mDmg >0) {
        currHP = currHP - mDmg + magicResist;
       }
          this.stats.put(EUnitProperties.HP, currHP<0? 0:currHP);
    }

    }



