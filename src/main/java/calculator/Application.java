package calculator;

import camp.nextstep.edu.missionutils.Console;

class Game {
    String stringForCalculating;
    String delimiter;

    void getValue() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        stringForCalculating = Console.readLine();
    }

    void extractDelimiter() {
        String defaultDelimiter = ",:";
        char firstChar = stringForCalculating.charAt(0);

        if (firstChar == '/') {
            int idx = stringForCalculating.indexOf("\\n");
            delimiter = defaultDelimiter.concat(stringForCalculating.substring(2, idx));
            stringForCalculating = stringForCalculating.substring(idx + 2);
        } else {
            delimiter = defaultDelimiter;
        }
    }

    void run() {
        getValue();
        extractDelimiter();
    }
}

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}