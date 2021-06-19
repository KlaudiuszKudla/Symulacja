package project;

import project.Army.ArmyA;
import project.Army.ArmyB;
import project.Map.Mapa;
import project.Soliders.EUnitProperties;
import project.Soliders.ISoliders;

import java.util.*;


public class Simulation {

    public static void main(String [] args){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe Halabardzistow druzyny A");
        final int numOfHalbardiersA=scanner.nextInt();
        System.out.println("Podaj liczbe Rycerzy druzyny A");
        final int numOfKnightsA = scanner.nextInt();
        System.out.println("Podaj liczbe Magow druzyny A");
        final int numOfMagesA = scanner.nextInt();
        System.out.println("Podaj liczbe Lucznikow druzyny A");
        final int numOfShootersA = scanner.nextInt();
        System.out.println("Podaj liczbe Halabardzistow druzyny B");
        final int numOfHalbardiersB = scanner.nextInt();
        System.out.println("Podaj liczbe Rycerzy druzyny B");
        final int numOfKnightsB = scanner.nextInt();
        System.out.println("Podaj liczbe Magow druzyny B");
        final int numOfMagesB = scanner.nextInt();
        System.out.println("Podaj liczbe Lucznikow druzyny B");
        final int numOfShootersB = scanner.nextInt();
        System.out.println("Podaj ilosc kolumn tablicy ");
        final int Y_Size = scanner.nextInt();
        System.out.println("Podaj ilosc wierszy tablicy ");
        final int X_Size = scanner.nextInt();

        Mapa mapa = new Mapa(X_Size, Y_Size);
        Random rnd = new Random(1);
        List<ISoliders> solidersList = new ArrayList<>();
       List<ISoliders> militaryA = new ArrayList<>();

       ArmyA militaryAA = new ArmyA(numOfHalbardiersA, numOfKnightsA,numOfMagesA, numOfShootersA, mapa);
      militaryA.addAll(militaryAA.createArmy());

        List<ISoliders> militaryB = new ArrayList<>();
        solidersList.addAll(militaryA);
        solidersList.addAll(militaryB);

     ArmyB militaryBB = new ArmyB(numOfHalbardiersB, numOfKnightsB,numOfMagesB, numOfShootersB, mapa);
       militaryB.addAll(militaryBB.createArmy());

        for(int i = 0 ; i <militaryA.size(); i++){
            while(!mapa.settleSolider(militaryA.get(i), rnd.nextInt(mapa.getXSize()), rnd.nextInt(mapa.getYSize()) ) );

        }
        for(int i = 0 ; i <militaryB.size(); i++){
            while(!mapa.settleSolider(militaryB.get(i), rnd.nextInt(mapa.getXSize()), rnd.nextInt(mapa.getYSize()) ) );

        }



                while(mapa.howManyAOnTheMap()>0 && mapa.howManyBOnTheMap()>0){
                    for (int i = 0; i < militaryA.size(); i++) {

                        if (militaryA.get(i).getProperty(EUnitProperties.HP) != 0) {
                            System.out.println(mapa.toString());
                            System.out.println("Zostalo " +mapa.howManyAOnTheMap() +"zolnierzy druzyny A");
                            System.out.println("Zostalo " +mapa.howManyBOnTheMap() +"zolnierzy druzyny B");
                            militaryA.get(i).canAttack(militaryA.get(i).getNeighbours());
                        }

                    }
                    for (int i = 0; i < militaryB.size(); i++) {
                        if (militaryB.get(i).getProperty(EUnitProperties.HP) != 0) {
                            System.out.println(mapa.toString());
                            System.out.println("Zostalo " +mapa.howManyAOnTheMap() +"zolnierzy druzyny A");
                            System.out.println("Zostalo " +mapa.howManyBOnTheMap() +"zolnierzy druzyny B");
                            militaryB.get(i).canAttack(militaryB.get(i).getNeighbours());
                        }
                    }
                }

                     System.out.println(mapa.toString());

            if(mapa.howManyBOnTheMap() == 0){
                System.out.println("Wygrala armia A");
            }
            else if (mapa.howManyAOnTheMap()==0){
                System.out.println("Wygrala armia B");
            }

        }


    }




