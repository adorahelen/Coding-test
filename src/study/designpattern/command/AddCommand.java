package study.designpattern.command;

import java.util.Scanner;

public class AddCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자1: ");
        int num1 = scanner.nextInt(); // 숫자 하나를 입력 받는다

        System.out.print("숫자2: ");
        int num2 = scanner.nextInt(); // 두번째 숫자 하나를 입력 빋는다

        System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
        // 두 개를 더하고 난 다음, 출력한다.
    }
}