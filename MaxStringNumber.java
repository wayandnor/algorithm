/*
 * 华为OD面试第3题
 */

public class MaxStringNumber {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String numberStr = sc.nextLine();
        String numberStr = "00000123";
        int strLen = numberStr.length();

        // 作为计数器使用
        int[] counter = new int[10];
        for (int i = 0; i < strLen; i++) {
            int digit = numberStr.charAt(i) - '0';
            counter[digit] = counter[digit] + 1;
        }

        int[] constructCounter = new int[10];

        StringBuilder builder = new StringBuilder();

        int pre = numberStr.charAt(0) - '0';

        for (int i = 1; i < strLen; i++) {
            int digit = numberStr.charAt(i) - '0';
            // 如果前面已经满了2个，那么该位直接丢弃
            if (constructCounter[digit] == 2) {
                continue;
            }

            if (counter[pre] > 2 && digit >= pre) {
                counter[pre] = counter[pre] - 1;
                pre = digit;
                continue;
            }

            builder.append(pre);
            constructCounter[pre] = constructCounter[pre] + 1;
            pre = digit;
        }
        if (constructCounter[pre] < 2) {
            builder.append(pre);
        }
        String str = builder.toString();
        int len = str.length();
        int zeroIndex = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != '0') {
                zeroIndex = i;
                break;
            } else {
                zeroIndex++;
            }
        }

        if (zeroIndex == len) {
            str = "0";
        } else {
            str = str.substring(zeroIndex);
        }

        System.out.println(str);
    }
}
