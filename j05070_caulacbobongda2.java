import java.util.*;

public class j05070_caulacbobongda2 {  

    static class Club {
        String code, name;
        Long price;

        public Club(String code, String name, long price){
            this.code = code;
            this.name = name;
            this.price = price;
        }
    }

    static class Match {
        Club o;
        String code;
        Long total;
        public Match(Club o, String code, long sl){
            this.code = code;
            this.o = o;
            this.total = o.price*sl;
        }

        @Override 
        public String toString(){
            return code + " " + o.name + " " + total;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Club> a = new ArrayList<>();
        ArrayList<Match> b= new ArrayList<>();
        for(int i=0;i<n;i++){
            sc.nextLine();
            a.add(new Club(sc.nextLine(), sc.nextLine(), sc.nextLong()));
        }
        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            String code = sc.next();
            String match_code = code.substring(1,3);
            int ind = 0;
            for(int j=0;j<n;j++){
                if(a.get(j).code.compareTo(match_code) == 0){
                    ind = j;
                    break;
                }
            }
            b.add(new Match(a.get(ind), code, sc.nextLong()));
        }
        b.sort((Match x, Match y) -> {
            if(x.total.compareTo(y.total) == 0) return x.o.name.compareTo(y.o.name);
            return y.total.compareTo(x.total);
        });
        b.forEach(e -> System.out.println(e));
        sc.close();
    }
}
