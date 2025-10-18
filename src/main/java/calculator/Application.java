package calculator;

import camp.nextstep.edu.missionutils.Console;

class Game {
    String stringForCalculating;

    void getValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        stringForCalculating = Console.readLine();
    }

    void run() {
        getValue();
    }
}

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}