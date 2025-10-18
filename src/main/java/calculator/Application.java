package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

class Game {
    String stringForCalculating;
    String delimiter;
    int tokenCount = 0;
    int[] num;
    int result = 0;

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

    void extractNumber() {
        StringTokenizer st = new StringTokenizer(stringForCalculating, delimiter);
        tokenCount = st.countTokens();
        num = new int[tokenCount];

        int i = 0;
        while (st.hasMoreTokens()) {
            num[i++] = Integer.parseInt(st.nextToken());
        }
    }

    void Calculate() {
        for (int i = 0; i < tokenCount; i++) {
            if (num[i] < 0) {
                throw new IllegalArgumentException();
            }
            result += num[i];
        }
    }

    void printResult() {
        System.out.print("결과 : " + result);
    }

    void run() {
        getValue();
        extractDelimiter();
        extractNumber();
        Calculate();
        printResult();
    }
}

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}