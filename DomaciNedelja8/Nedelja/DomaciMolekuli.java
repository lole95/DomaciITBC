package mape;

import java.util.Map;
import java.util.TreeMap;

/**
 * Project Nedelja8, Package mape, Class DomaciMolekuli, Created by Milovan 26.9.2021.
 */
public class DomaciMolekuli {
    public static String molekul(String hemija){
        TreeMap<String, Integer > map = new TreeMap<>();
        String result = "";
        String temp = "";
        for (int i = 0; i < hemija.length(); i++) {

            if (Character.isDigit(hemija.charAt(i))){
                int x = Character.getNumericValue(hemija.charAt(i));
                if (map.containsKey(temp)){
                    map.put(temp, map.get(temp) + x);
                }
                else {
                    map.put(temp, x);
                }
                temp = "";
            }
            else if (hemija.charAt(i) == '('){
                StringBuilder sb = new StringBuilder();
                for (int j = i + 1; j < hemija.length(); j++) {
                    if (hemija.charAt(j) == ')'){
                        int times = Character.getNumericValue(hemija.charAt(j + 1));
                        String s = sb.toString();
                        for (int k = 0; k < s.length(); k++) {
                            if (Character.isDigit(s.charAt(k))){
                                int x = Character.getNumericValue(s.charAt(k));
                                if (map.containsKey(temp)){
                                    map.put(temp, map.get(temp) + x*times);
                                }
                                else {
                                    map.put(temp, x*times);
                                }
                                temp = "";
                            }
                            else {
                                temp += s.charAt(k);
                                if (k == s.length() - 1 || Character.isUpperCase(s.charAt(k+1))){
                                    if (map.containsKey(temp)){
                                        map.put(temp, map.get(temp) + times);
                                    }
                                    else {
                                        map.put(temp, times);
                                    }
                                    temp = "";
                                }
                            }
                        }
                        i += s.length() + 2;
                        break;
                    }
                    sb.append(hemija.charAt(j));
                }
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

    public static void main(String[] args) {
        System.out.println(molekul("Al2(SO4)3"));
    }
}

