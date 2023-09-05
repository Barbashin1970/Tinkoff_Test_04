package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] denominations = new int[m];
        for (int i = 0; i < m; i++) {
            denominations[i] = scanner.nextInt();
        }

        Arrays.sort(denominations);

        int count = 0;
        int sum = 0;
        int[] stolenDenominations = new int[2 * m];

        for (int i = m - 1; i >= 0; i--) {
            if (sum >= n) {
                break;
            }

            int currDenomination = denominations[i];
            int neededCount = (n - sum) / currDenomination;

            if (neededCount > 2) {
                neededCount = 2;
            }

            for (int j = 0; j < neededCount; j++) {
                stolenDenominations[count++] = currDenomination;
                sum += currDenomination;
            }
        }

        if (sum != n) {
            count = -1;
        }

        System.out.println(count);

        if (count != -1) {
            for (int i = 0; i < count; i++) {
                System.out.print(stolenDenominations[i] + " ");
            }
        }
    }
}
