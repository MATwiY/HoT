import java.time.Duration;
import java.time.Instant;

class Teleskop {

    public Integer size;
    public String orientacja;
    int x;
    int y;
    int X;
    int Y;
    int counter;
    String[][] tablica;

    Teleskop(Integer size, String orientacja){
        this.size = size;
        this.orientacja = orientacja;

        counter = 0;
    }

    public void Print(){

        if(orientacja.equals("W") || orientacja.equals("E")){
            x = 3 + this.size;
            y = 2 + this.size;
        }
        if(orientacja.equals("N") || orientacja.equals("S")){
            x = 2 + this.size;
            y = 3 + this.size;
        }

        tablica = new String[x][y];

        for(int i = 0; i < x; ++i){
            for(int j = 0; j < y; ++j){
                tablica[i][j] = "*";
            }
        }

        switch (orientacja) {
            case "W":
                X = 1;
                Y = 0;
                create();
                break;
            case "N":
                X = 0;
                Y = y - 2;
                create();
                break;
            case "S":
                X = x - 1;
                Y = 1;
                create();
                break;
            case "E":
                X = x - 2;
                Y = y - 1;
                create();
                break;
            default:
                System.out.print("klops");
                break;
        }

        P();
        System.out.println(counter);
    }

    public int create(){

        for(int i = X; i < x; ++i){

            if(i + 1 == x ){ // 7
                break;
            }

            for(int j = Y; j < y; ++j){

                //poziomo
                if(j + 1 < y) {
                    if (tablica[i][j + 1].equals(" ")) {
                        break;
                    } else {
                        if (j != y - 1) {
                            if (!tablica[i][j].equals(" ")) {
                                ++counter;
                            }
                            tablica[i][j] = " ";
                        }
                    }
                    Y = j;
                }
            }

            X = i;
            if(i + 2 < x){
                if(tablica[i + 2][Y].equals(" ")){
                    if(Y - 2 >= 0){
                        if(tablica[i][Y - 2].equals(" ")){
                            return 0;
                        }
                        else{
                            break;
                        }
                    }
                    if(Y + 2 < y){
                        if(tablica[i][Y + 2].equals(" ")){
                            return 0;
                        }
                    }
                    //return 0;
                }
                else if(tablica[i + 2][Y].equals("*")){
                    tablica[i][Y] = " ";
                }
            }
        }

        for(int i = X; i > 0; --i){

            for(int j = Y; j > 0; --j){

                //poziomo
                if(j - 1 >= 0){
                    if(tablica[i][j-1].equals(" ")){
                        break;
                    } else {
                        if (!tablica[i][j].equals(" ")) {
                            ++counter;
                        }
                        tablica[i][j] = " ";
                    }
                }
                Y = j;
            }

            X = i;
            //pionowo
            if(i - 2 >= 1){
                if(tablica[i - 2][Y].equals(" ")){
                    if(i + 1 == x -1 ){
                        return 0;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        if(Y + 2 < y) {
            if (tablica[X][Y + 2].equals("*")) {
                if(Y + 2 != y - 1) {
                    create();
                }
                if(tablica[X][Y + 1].equals("*")){
                    create();
                }
            }
        }
        if(X + 2 < x) {
            if (tablica[X + 2][Y].equals("*")) {
                if (X + 2 < x - 2) {
                    create();
                }
            }
        }
        return 0;
    }

    public void P(){
        for(int i = 0; i < x; ++i){
            for(int j = 0; j < y; ++j){
                System.out.print(tablica[i][j]);
            }
            System.out.println();
        }
        //System.out.println("X: " + this.X);System.out.println("Y: " + this.Y);
    }
}

public class Galaktyka {

    public static void main(String[] args) {
        try{
            /*Instant start = Instant.now();*/

            String s = args[0];
            int l = s.length();
            String orientacja = s.substring(l-1, l);
            String rozmiar = s.substring(0, l-1);

            Teleskop teleskop = new Teleskop(Integer.parseInt(rozmiar), orientacja);
            teleskop.Print();

            /*Instant finish = Instant.now();
            long time = Duration.between(start, finish).getSeconds();
            System.out.println(time + "s");*/

        }catch (Exception e){
            System.out.print("klops " + e);
        }
    }
}
