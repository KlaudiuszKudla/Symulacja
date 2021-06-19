package project.Soliders;

import java.util.HashMap;
import java.util.Map;
public class SolidersAttack implements ISolidersAttack {


    Map<EAttackTypes, Double> attacks;

    public SolidersAttack (){

        attacks=new HashMap<>();
    }
    @Override
    public double getDamage(EAttackTypes type){

        Double damage = attacks.get(type);
        return (damage != null)? damage.doubleValue():0;

    }
    @Override
    public void setDamage(EAttackTypes type, double value){

        attacks.put(type, value);
    }
}
