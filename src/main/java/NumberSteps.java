import java.util.Scanner;

/**
 * Created by robert on 10/16/2015.
 */
public class NumberSteps {

        public static void main(String[] args){

            NumberSteps work = new NumberSteps();
            work.begin();

        }

        void begin(){
            Scanner scan1 = new Scanner(System.in);
            int cases = scan1.nextInt();
            int[] xVals = new int[cases];
            int[] yVals = new int[cases];

            for ( int i = 0; i < cases; i++){
                xVals[i] = scan1.nextInt();
                yVals[i] = scan1.nextInt();
            }

            for (int i = 0; i < cases; i++){
                printNum(xVals[i], yVals[i]);
            }
            scan1.close();
        }


        static boolean validCoords(int x, int y){

            if ((x < 0) | (y<0)) return false;
            else if ((bothEven(x,y)|bothOdd(x,y)) && (groupOne(x,y)|groupTwo(x,y))) return true;
            else return true;

        }

        static void printNum(int x, int y){
            if ((calcNumber(x,y)) != -1) System.out.println(calcNumber(x,y));

            if ((calcNumber(x,y)) == -1) System.out.println("No Number");
        }

        static int calcNumber(int x, int y){
            if (!(bothOdd(x,y)) && !(bothEven(x,y))) return -1;

            else if (bothEven(x,y) && validCoords(x,y)){
                if (groupOne(x,y)){
                    return (y*2);
                }
                else if (groupTwo(x,y)) return ((y*2)+2);
            }

            else if (bothOdd(x,y) && validCoords(x,y)){
                if (groupOne(x,y)){
                    return ((y*2)-1);
                }
                else if (groupTwo(x,y)) return ((y*2)+1);
            }

            else if (!validCoords(x,y)) return -1;

            return -1;

        }

        static boolean bothOdd(int x, int y){
            if (((x%2)!= 0) && ((y%2) != 0)) return true;
            else return false;
        }

        static boolean bothEven(int x, int y){
            if ((x%2 == 0) && (y%2 ==0)) return true;
            else return false;
        }

        static boolean groupOne(int x, int y){
            if (x == y) return true;
            else return false;
        }

        static boolean groupTwo(int x, int y){
            if (x == y+2) return true;
            else return false;
        }


}
