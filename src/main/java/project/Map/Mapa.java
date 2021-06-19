package project.Map;


import project.Soliders.ISoliders;



public class Mapa implements IMap{

    private final int x;
    private final int y;
    private ISoliders [][] soliders;

    public Mapa(int x, int y){

        this.x=x; //ilość wierszy
        this.y=y; // ilość kolumn
        soliders = new ISoliders[x][y];
    }
    @Override
    public String toString() { // Wyświetlanie aktualnego stanu mapy
        StringBuffer buffor = new StringBuffer();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (soliders[i][j] == null) {
                    buffor.append("[  ]");
                } else {
                    buffor.append(soliders[i][j].getName());
                }

            }
            buffor.append("\n");
        }
        return buffor.toString();
    }
    @Override
    public ISoliders getSolider(int x, int y){ // Po podaniu koordynat zwraca nam żołnierza
        return soliders[x][y];
    }

    @Override
    public int getXSize() {//zwraca ilość wierszy mapy
        return x;
    }
    @Override
    public int getYSize() { // zwraca ilość kolumn mapy
        return y;
    }

    @Override
    public int getXSoliderPosition(ISoliders solider) { // Zwraca numer wiersza na którym znajduje się jednostka
            Integer soliderX = null ;
            for(int i = 0 ; i<soliders.length ; i++){
                for(int j=0; j<soliders[i].length; j++){
                    if( solider == soliders[i][j]){
                    soliderX=i;}
                }
            }
            if(soliderX== null) {
                return -1;
            }
            else {
                return soliderX.intValue();
            }
    }
    @Override
    public int getYSoliderPosition(ISoliders solider) { // Zwraca numer kolumny na którym znajduje się jednostka
        Integer soliderY = null;
        for(int i = 0 ; i<soliders.length ; i++){
            for(int j=0; j<soliders[i].length; j++){
                if( solider == soliders[i][j]){
                soliderY=j;}
            }
        }
        if(soliderY== null) {
            return -1;
        }
        else {
            return soliderY.intValue();
        }
    }


    @Override
    public boolean settleSolider(ISoliders solider, int x, int y) {

       int settledX = getXSoliderPosition(solider);
       int settledY = getYSoliderPosition(solider);
        if (soliders [x][y] != null ){
            return false;
        }
        if(settledX >=0 || settledY>=0) {
            soliders[settledX][settledY] = null;
        }
        solider.setMap(this);
        soliders[x][y]= solider;
         return true;

    }
    @Override
    public void deleteFromTheMap(ISoliders solider){
       int x =   getXSoliderPosition(solider);
       int y = getYSoliderPosition(solider);
       soliders[x][y]=null;
    }


    @Override
    public int howManyAOnTheMap() {
        int x = 0;
        for (int i = 0; i < soliders.length; i++) {
            for(int j=0; j<soliders[i].length; j++){
                if((soliders[i][j] != null) && (soliders[i][j].getFirstCharofTheName() =='A')){
                    x++;
                }
            }
        }
                return x;
    }
    @Override
    public int howManyBOnTheMap() {
        int x = 0;
        for (int i = 0; i < soliders.length; i++) {
            for(int j=0; j<soliders[i].length; j++){
                if((soliders[i][j] != null) && (soliders[i][j].getFirstCharofTheName() == 'B')){
                    x++;
                }
            }
        }
        return x;
    }
}
