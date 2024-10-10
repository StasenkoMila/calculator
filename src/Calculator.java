    import java.util.*;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Calculator {

        private static int result;
        private static String [] inputArray;
        private final static Integer [] arabicNumerals = {1,2,3,4,5,6,7,8,9,10};
        private final static String [] romanArray = new String[]{ "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        static {

            map.put(1000, "M");
            map.put(900, "CM");
            map.put(500, "D");
            map.put(400, "CD");
            map.put(100, "C");
            map.put(90, "XC");
            map.put(50, "L");
            map.put(40, "XL");
            map.put(10, "X");
            map.put(9, "IX");
            map.put(5, "V");
            map.put(4, "IV");
            map.put(1, "I");

        }


        public static void main(String[] args) {
            ArrayList<Integer> aNum = new ArrayList<>(List.of(arabicNumerals));
            ArrayList<String> rNum = new ArrayList<>(List.of(romanArray));
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            inputArray = input.split(" ");


            try {
                if (rNum.contains(inputArray[0]) && rNum.contains(String.valueOf(inputArray[2]))) {
                    String num1 = inputArray[0];
                    String num2 = inputArray[2];
                    int converted1 = Integer.parseInt(convert(num1));
                    int converted2 = Integer.parseInt(convert(num2));
                    System.out.println(toRoman(calculate(converted1, converted2)));
                }
                 else if (aNum.contains(Integer.parseInt(inputArray[0])) && aNum.contains(Integer.parseInt(inputArray[2]))) {
                    int num1 = Integer.parseInt(inputArray[0]);
                    int num2 = Integer.parseInt(inputArray[2]);
                    System.out.println(calculate(num1, num2));
                }
            } catch (Exception e){
                System.out.println("Ошибка!");
            }

        }


            public final static String convert(String num){
                for (String s : romanArray) {
                    if (num.equals(s)) {
                        switch (s) {
                            case "I":
                                num = "1";
                                break;
                            case "II":
                                num = "2";
                                break;
                            case "III":
                                num = "3";
                                break;
                            case "IV":
                                num = "4";
                                break;
                            case "V":
                                num = "5";
                                break;
                            case "VI":
                                num = "6";
                                break;
                            case "VII":
                                num = "7";
                                break;
                            case "VIII":
                                num = "8";
                                break;
                            case "IX":
                                num = "9";
                                break;
                            case "X":
                                num = "10";
                                break;
                            default:
                                break;
                        }
                    }
                }
            return num;
        }

        public final static int calculate(int num1, int num2){
            switch (inputArray[1]){
                case "+" :
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/" :
                    result = num1 / num2;
                    break;
                default: break;
            }
            return result;
        }
        public final static String toRoman(int number) {
            int l =  map.floorKey(number);
            if ( number == l ) {
                return map.get(number);
            }
            return map.get(l) + toRoman(number-l);
        }
    }