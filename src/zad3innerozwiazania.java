import java.util.ArrayList;
import java.util.List;

public class zad3innerozwiazania {

    static List<Integer> decompositionList = new ArrayList<>();

    public static void main(String[] args) {

    }

        //## rozwiazanie1

    public static void decomposition2(int x) {
        if (x == 0 && decompositionList.size() != 1) {
            System.out.println(decompositionList);
        } else if (x > 0) {
            for (int i = 1; i <= x; i++) {
                decompositionList.add(i);
//                System.out.println(decompositionList);
//                System.out.println("Wywołanie rekurencyjne dla x: " + x + ", i: " + i);
                decomposition2(x - i);
                decompositionList.remove(decompositionList.size() - 1);
            }
        }

        //## rozwiazanie2

//        void decomposition(int x) {
//            if (x < 0) {
//                throw new IllegalArgumentException("x<0");
//            }
//            if (x == 0) {
//                System.out.println(Arrays.stream(tab).limit(index)
//                        .boxed().collect(Collectors.toList()));
//            }
//            for (int i = 1; i <= x; i++) {
//                tab[index] = i;
//                index++;
//                decomposition(x - i);
//                index--;
//            }


        //### rozwiazanie3

//        public static void decomposition(int n) {
//            String sequence = "= "+n;
//            decomposition(n, n + " = ",sequence);
//        }
//
//        public static void decomposition(int n, String suffix,String sequence ) {
//
//            if (n == 0)  {
//                if (suffix.contains(sequence)){
//                    return;
//                }
//                System.out.println(suffix.substring(0, suffix.length()-2));
//                return;
//            }
//            for (int i = 1; i <= n; i++) {
//                decomposition(n-i,suffix + i + " + ",sequence);
//            }
//        }
    }
}