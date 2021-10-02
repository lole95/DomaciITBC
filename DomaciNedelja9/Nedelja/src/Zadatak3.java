import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Project Nedelja, Package PACKAGE_NAME, Class Zadatak3, Created by Milovan 2.10.2021.
 */
public class Zadatak3 {
    public static void main(String[] args) {
        System.out.println(molekul("COO(S2O(O2H)2)4C3OOHHeLi13Ar"));

    }

    public static String molekul(String hemija){
        TreeMap<String, Integer > map = new TreeMap<>();
        String result = "";
        String temp = "";
        hemija = removeBrackets(hemija);
        for (int i = 0; i < hemija.length(); i++) {
            if (Character.isDigit(hemija.charAt(i))){
                StringBuilder number = new StringBuilder();
                number.append(hemija.charAt(i));
                for (int j = i + 1; j < hemija.length(); j++) {
                    if (Character.isDigit(hemija.charAt(j))) {
                        number.append(hemija.charAt(j));
                        i++;
                    }
                    else{
                        break;
                    }
                }
                int x = Integer.parseInt(number.toString());
                if (map.containsKey(temp)){
                    map.put(temp, map.get(temp) + x);
                }
                else {
                    map.put(temp, x);
                }
                temp = "";
            }
            else {
                temp += hemija.charAt(i);
                if (i == hemija.length() - 1 || Character.isUpperCase(hemija.charAt(i+1))){
                    if (map.containsKey(temp)){
                        map.put(temp, map.get(temp) + 1);
                    }
                    else {
                        map.put(temp, 1);
                    }
                    temp = "";
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            result = result.concat(entry.getKey()).concat(entry.getValue().toString());
        }
        return result;
    }

    public static String removeBrackets(String hem){
        TreeMap<String, Integer > map = new TreeMap<>();
        StringBuilder sb = new StringBuilder(hem);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '('){
                stack.push(i);
            }
            else if (sb.charAt(i) == ')'){
                int x = 1;
                if (Character.isDigit(sb.charAt(i+1))){
                    x = Character.getNumericValue(sb.charAt(i+1));
                }
                int openBracket = stack.pop();
                String betweenBracker = sb.substring(openBracket + 1, i);
//                System.out.println("between brackets : " + betweenBracker);
                sb.replace(openBracket, i + 2, betweenBracker.repeat(x));
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

}

