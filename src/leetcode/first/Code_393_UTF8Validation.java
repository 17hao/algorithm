package leetcode.first;

/**
 * utf-8 validation
 *
 * @since 2021-1-6 Wednesday
 * @update 2021-1-7 Thursday
 */
public class Code_393_UTF8Validation {
    public boolean validUtf8(int[] data) {
        if (data.length == 0)
            return false;

        for (int i = 0; i < data.length; i++) {
            String b = intToByte(data[i]);
            if (b.startsWith("0")) {
                continue;
            } else {
                int res = checkMultiBytesData(data, i);
                if (res == -1) {
                    return false;
                } else {
                    i = res;
                }
            }
        }
        return true;
    }

    // return end index of utf-8 bytes
    private int checkMultiBytesData(int[] data, int start) {
        int lenOfBytes = 0;
        String firstByte = intToByte(data[start]);
        for (int i = 0; i < firstByte.length(); i++) {
            if (firstByte.charAt(i) == '0') {
                break;
            }
            lenOfBytes++;
        }
        if (lenOfBytes < 2 || lenOfBytes > 4) {
            return -1;
        }
        int i = 1;
        while (i < lenOfBytes) {
            if (start + i >= data.length) {
                return -1;
            }
            String b = intToByte(data[start + i++]);
            if (!b.startsWith("10")) {
                return -1;
            }
        }
        return start + i - 1;
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
        // int[] data = { 240, 162, 138, 147, 145 };
        int[] data = { 250, 145, 145, 145, 145 };
        // int[] data = { 197, 130, 1 };
        System.out.println(c.validUtf8(data));
    }
}
