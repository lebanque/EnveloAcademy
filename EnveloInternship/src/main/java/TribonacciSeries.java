import java.util.Scanner;

public class TribonacciSeries {


    // ostatni poprawnie wyświetlony element ciągu to 39, po nim nastąpi przekroczenie zakresu Integerów.
    static int calcTribonacci(int n)
    {
        if (n == 0 || n == 1 || n == 2)
            return 0;

        if (n == 3)
            return 1;
        else
            return calcTribonacci(n - 1) +
                    calcTribonacci(n - 2) +
                    calcTribonacci(n - 3);
    }

    static void printTribonacci(int n)
    {
            System.out.print(calcTribonacci(n));
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Który element ciągu Tribonacci'ego chcesz wyświetlić? (Wprowadź liczbę całkowitą, dodatnią): ");
        int n = sc.nextInt();
        sc.close();

        printTribonacci(n);
    }
}
