import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

    public class zadRozkladNaSumy {
        static int[] components;
        static List<List<Integer>> result = new ArrayList<>();
        static StringBuilder sb = new StringBuilder();

        public static void decompose(int x){
            populateComponents(x);
            combinationSum(x, new ArrayList<>());
            printResult(x);
        }
        private static void combinationSum(int number, List<Integer> currResult){

            //AtomicInteger sum = new AtomicInteger();
            int sum=0;

            //currResult.forEach(sum::addAndGet);
            for(int i : currResult) {
                sum+=i;
            }

            if(sum < number){
                for(int i : components){
                    if(sum+i <= number){
                        List<Integer> newResult = new ArrayList<>(currResult);
                        newResult.add(i);
                        combinationSum(number, newResult);
                    }
                }
            }
            if(sum == number){
                result.add(currResult);
            }
        }
        private static void populateComponents(int x){
            if(components == null || components.length < x-1){
                components = new int[x-1];
                for(int i = 1; i < x ; i++){
                    components[i - 1] = i;
                }
            }
        }
        private static void printResult(int x){
            for(List<Integer> list: result) {
                sb.append(x);
                sb.append(" = ");
                list.forEach(e->{
                    sb.append(e);
                    sb.append(" + ");
                });
                int end = sb.length()-1;
                sb.delete(end-2,end);
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
