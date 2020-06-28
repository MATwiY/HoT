class Samolot{
    public Integer model;
    public String defense;
    //public String[] tekst;

    Samolot(Integer m, String d){
        this.model = m;
        this.defense = d;
        //tekst = new String[model];
    }

    public void drawPlane(){
        if(this.defense.equals("N")){
            defenseOFF();
        }
        else if(this.defense.equals("Y")){
            defenseON();
        }else{
            System.out.print("klops");
        }
    }

    public void defenseOFF(){
        String line = "";
        String[] tekst = new String[model];
        for(int i = 0; i < model; ++i){

            for(int j = 0; j <= i; ++j){
                line = line.concat("*");
            }

            for(int j = i; j < model - 1; ++j){
                line = line.concat(" ");
            }

            for(int j = 0; j < model; ++j){
                if(j==0){
                    tekst[i] = line;
                }else{
                    tekst[i] += line;
                }
            }
            line = "";
        }

        for(int i = 0; i < model * 2 - 1; ++i){
            if(i < model){
                System.out.println(tekst[i]);
            }else{
                System.out.println(tekst[(model * 2 - 1) - (i + 1)]);
            }
        }
    }

    public void defenseON(){
        String line = "";
        String[] tekst = new String[model*2];
        String[][] table = new String[model * 2][model * model];
        String znak = "";

        for(int i = 0; i < model * 2 - 1; ++i){

            if(i < model - 1){
                znak = "\\";
            }
            else if(i == model - 1){
                znak = "*";
            }
            else{
                znak = "/";
            }

            if(i <= model-1){

                for(int k = 0; k < model; ++k){

                    for(int j = 0; j <= i; ++j){
                        if(j == i){
                            if(line.equals("")) {
                                line = line.concat(">");
                            }else{
                                if(k + 1 == model && i == model-1){
                                    line = line.concat(">");
                                }else {
                                    line = line.concat(znak);
                                }
                            }
                        }
                        else {
                            if(line.equals("")) {
                                line = line.concat(">");
                            }else{
                                line = line.concat("*");
                            }
                        }
                    }

                    for(int j = i; j < model - 1; ++j){
                        line = line.concat(" ");
                    }
                }
            }
            else{
                for(int k = 0; k < model; ++k){

                    for(int j = i; j <= model * 2 - 2; ++j){
                        if(j == model * 2 - 2){
                            if(line.equals("")) {
                                line = line.concat(">");
                            }else{
                                line = line.concat(znak);
                            }
                        }
                        else {
                            if(line.equals("")) {
                                line = line.concat(">");
                            }else{
                                line = line.concat("*");
                            }
                        }
                    }

                    for(int j = i; j > model-1 ; --j){
                        line = line.concat(" ");
                    }
                }
            }

            for(int j = 0; j < model; ++j){
                tekst[i] = line;
            }
            line ="";
        }
        for(int i = 0; i < model * 2 - 1; ++i){
            System.out.println(tekst[i]);
        }

    }
}

public class Kosmolot {

    public static void main(String[] args) {

        try{
            Samolot plane = new Samolot(Integer.parseInt(args[0]), args[1]);
            plane.drawPlane();
        }catch (Exception e){
            System.out.println("klops");
        }
    }
}
