import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SearchMethod {
    public static int  fib(int  n)
    {
        return (int) ((Math.pow((1+Math.sqrt(5))/2,n)-Math.pow((1-Math.sqrt(5))/2,n))/Math.sqrt(5));
    }
    public static void  add_el(ArrayList<Integer> input)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a value: ");
        input.add(in.nextInt());
        Collections.sort(input);
        System.out.print(input.toString());
    }
    public static void  remove_el(ArrayList<Integer> input)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number: ");
        input.remove(in.nextInt()-1);
        System.out.print(input.toString());
    }
    public static int  fib_search(ArrayList<Integer> input, int key) {
        int  curFibKey=0;
        int  sKey=0;
        int  curFib = 0;
        int res=0;
        boolean fibFind=true;
        while (fibFind)
        {
            curFib = fib(curFibKey)+sKey;
            if(curFib>input.size())
            {
                sKey+=fib(curFibKey-1);
                curFibKey=0;
            }
            else{
                if ((input.get(curFib)>key)||(input.get(curFib)<0))
                {

                    sKey+=fib(curFibKey-1);
                    curFibKey=0;
                }
                else if (input.get(curFib)==key)
                {
                    res=curFib;
                    fibFind=false;
                }
                else
                {
                    curFibKey++;
                }
            }

        }
        return res+1;
    }
    public static void find(ArrayList<Integer> input)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter a value to find the number: ");
        int key = in.nextInt();
        long start = System.nanoTime();
        int res = input.indexOf(key);
        long end = System.nanoTime();
        if (res!=-1)
        {
            res ++;
            long time = end-start;
            System.out.println("Number of " + key + " = " + res);
            System.out.println( "Execution time (Built-in method) = " + time + " ns");
            start = System.nanoTime();
            int index = fib_search(input,key);
            end = System.nanoTime();
            time = end-start;
            System.out.println( "Execution time (Fibonacci method) = " + time + " ns");
        }
        else
        {
            System.out.println("Error: This value does not exist");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Array size: ");
        int x = in.nextInt();
        ArrayList <Integer> mass = new ArrayList<>();
        for (int i = 0; i < x; i++)
        {
            mass.add((int)(Math.random()*100));
        }
        Collections.sort(mass);
        System.out.println("\nThe generated data: ");
        System.out.println(mass.toString());
        System.out.println("\nInfo: \nend - exit\nadd - add element\nremove – remove element \nfind - find element");
        System.out.print("\nEnter the command -> ");
        boolean exit = true;
        String command = in.nextLine();
        while (exit)
        {
            command = in.nextLine();
            switch (command)
            {
                case "add":
                    add_el(mass);
                    break;
                case "remove":
                    remove_el(mass);
                    break;
                case "find":
                    find(mass);
                    break;
                case "end":
                    exit = false;
                    break;
                default:
                    System.out.println("Error: Unknown command, please check the info");
                    break;
            }
            if(exit)
                System.out.print("\nEnter the command -> ");
        }
        in.close();
    }
}
