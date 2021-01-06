package leetcode.first;

/**
 * utf-8 validation
 *
 * @since 2020-1-6 Wednesday
 */
public class Code_393_UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data.length == 0)
            return false;
        String firstByte = intToByte(data[0]);
        System.out.println(firstByte);
        int lenOfBit1 = 0;
        if (firstByte.charAt(0) == '0' && data.length != 1) {
            if (data.length != 1) {
                return false;
            } else {
                return true;
            }
        }
        for (int i = 0; i < firstByte.length(); i++) {
            if (firstByte.charAt(i) == '0') {
                break;
            }
            lenOfBit1++;
        }
        System.out.println("len: " + lenOfBit1);
        if (lenOfBit1 < 2 || data.length < lenOfBit1) {
            return false;
        }
        for (int i = 1; i < lenOfBit1; i++) {
            String b = intToByte(data[i]);
            System.out.println(b);
            if (!b.startsWith("10")) {
                return false;
            }
        }
        return true;
    }

    private String intToByte(int i) {
        StringBuilder res = new StringBuilder();
        while (i > 0) {
            int tmp = i % 2;
            res.append(tmp);
            i = i / 2;
        }
        while (res.length() < 8) {
            res.append(0);
        }
        return res.reverse().substring(0, 8);
    }

    public static void main(String[] args) {
        Code_393_UTF8Validation c = new Code_393_UTF8Validation();
        int[] data = { 197, 130, 1 };
        System.out.println(c.validUtf8(data));
    }
}
