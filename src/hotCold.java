import java.util.Scanner;

public class hotCold {


    public static void main(String[] args) {
        final int MAX = 100;
        final int MIN = 1;
        int rnd = rnd(MAX, MIN);
        int previousValue = 0;
        System.out.println("Компьютер загадал число от 1 до 100, попробуйте его" +
                " угадать, " + "для выхода из программы введите любой символ " +
                "или число отличное от интервала [1; 100]");
        Scanner scanner = new Scanner(System.in);
        boolean result;
        String next;
        System.out.println(rnd);
        do {
            next = scanner.next();
            result = parse(next);
            if (result) {
                if (Integer.parseInt(next) == rnd) {
                    System.out.println(String.format("Вы угадали число, это %d поздравляем", rnd));
                    break;
                }
                int i = Integer.parseInt(next);
                if (Math.abs(previousValue - rnd) > Math.abs(i - rnd)) {
                    previousValue = i;
                    System.out.println("Горячо");
                } else {
                    previousValue = i;
                    System.out.println("Холодно");
                }
            }
        } while (result);
        scanner.close();
    }

    private static int rnd(int max, int min) {
        return (int) (Math.random() * ++max) + min;
    }

    private static boolean parse(String value) {
        try {
            int i = Integer.parseInt(value);
            return Math.max(0, i) == Math.min(i, 101);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}