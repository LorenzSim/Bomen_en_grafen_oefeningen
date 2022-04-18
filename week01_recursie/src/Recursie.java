import java.util.ArrayList;
import java.util.List;

public class Recursie {

    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if(getal <= 0) throw new IllegalArgumentException();
        if(getal < 3) return 1;
        return fibonacci(getal - 1) + fibonacci(getal - 2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        int res = Math.abs(getal);
        if (res < 10) return res;
        return res % 10 + somVanCijfers(res / 10);
    }

    // Oefening 3: keer een string om

    public static String keerOm(String s) {
        if(s == null) throw new IllegalArgumentException();
        if(s.length() <= 1) return s;
        return s.charAt(s.length()-1) + keerOm(s.substring(0, s.length()-1));
    }

    //oefening 4: countX

    public static int countX(String s) {
        if(s==null) throw new IllegalArgumentException();
        if(s.length() == 0) return 0;
        int c = s.startsWith("x") ? 1 : 0;
        return c + countX(s.substring(1));
    }

    //oefening 5 : countHi

    public static int countHi(String s) {
        if(s == null) throw new IllegalArgumentException();
        if(s.length() <= 1) return 0;
        int c = s.startsWith("hi") ? 1 : 0;
        return c + countHi(s.substring(1));
    }

    // oefening 6

    public static String changeXY(String s) {
        if(s == null) throw new IllegalArgumentException();
        if(s.length()==0) return s;
        if(s.startsWith("x")) return "y" + changeXY(s.substring(1));
        return s.charAt(0) + changeXY(s.substring(1));
    }

    // oefening 7

    public static String changePi(String s) {
        if(s == null) throw new IllegalArgumentException();
        if(s.length() <= 1) return s;
        if(s.startsWith("pi")) return "3.14" + changePi(s.substring(2));
        return s.charAt(0) + changePi(s.substring(1));
    }

    // oefening 8:

    public static int tweelog(int getal) {
        if(getal <= 0) throw new IllegalArgumentException();
        if(getal == 1) return 0;
        if(getal == 2) return 1;
        return 1 + tweelog(getal / 2);
    }

    // oefening 9;

    public static double findMaximum(List<Double> lijst) {
        if(lijst == null) throw new IllegalArgumentException();
        if(lijst.size() == 1) return lijst.get(0);
        double restMax = findMaximum(lijst.subList(1, lijst.size()));
        if(lijst.get(0) > restMax) return lijst.get(0);
        return restMax;
    }

    // oefening 10;

    public static ArrayList<String> findSubstrings(String string) {
        if(string == null) throw new IllegalArgumentException();
        if(string.length() == 0) return new ArrayList<>() {{ add(""); }};

        if(string.length() == 1) return new ArrayList<>() {{ add(string); }};
        var res = findSubstrings(string.substring(1));
        return new ArrayList<>(){
            {
                add(string);
                for(String r : res){
                    add(r);
                }
            }
        };

    }

    /* oefening 11; */

    public static int aantalKaarten(int n){
        if(n <= 0) throw new IllegalArgumentException();
        if(n == 1) return 2;
        return n * 3 + aantalKaarten(n - 1) - 1;
    }
}
