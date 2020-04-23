public class Primes {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) //проверка чисел на то, простые ли они
            if (IsPrime(i))
                System.out.println(i);
    }
    public static boolean IsPrime(int n) { //функция, которая определяет является ли число простым
        boolean ok = true;
        for (int i = 2; i < n; i++)
            if (n % i == 0) ok = false;
        return ok;
    }
}
