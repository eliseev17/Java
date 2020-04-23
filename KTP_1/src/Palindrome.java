import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("Input word:"); //ввод слова
        String n = scan.next(); //считывание слова
        if(n.equals(reverseString(n))) //проверка на то равна ли строка отображенной
            System.out.println("Palindrome");
        else
            System.out.println("Is not palindrome");
    }
    public static String reverseString(String s1) { //функция для создания инфертированной строки
        String s2 = "";
        for(int i = 0; i < s1.length(); i++){
            s2 += s1.charAt(s1.length()-i-1);
        }
        return s2;
    }
}