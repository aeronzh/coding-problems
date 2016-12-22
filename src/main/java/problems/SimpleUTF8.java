package problems;

public class SimpleUTF8 {
    private static void reverse(int start, int end, byte[] array) {
        byte tmp;
        int i = start;
        int j = end;
        while (i < j) {
            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    private static int prefix(byte b) {
        if ((b & 0xff) >> 7 == 0) {
            return 0; //0
        } else if ((b & 0xff) >> 6 == 2) {
            return 2; //10
        } else if ((b & 0xff) >> 5 == 6) {
            return 6;//110
        }
        return 0;
    }

    public static void main(String[] args) {
        //0XXXXXXX 0YYYYYYY 110XXXXX 10XXXXXX 1110XXXX 10XXXXXX 10XXXXXX
        byte[] str = new byte[]{(byte) 117, (byte) 127, (byte) 202, (byte) 128, (byte) 232, (byte) 136, (byte) 160};

        System.out.println("Input: ");
        for (byte b : str) {
            System.out.print(Integer.toBinaryString(b & 255 | 256).substring(1) + " ");
        }

        System.out.println("\nReversed:");

        // Reverse entire str
        reverse(0, str.length - 1, str);

        for (byte b : str) {
            System.out.print(Integer.toBinaryString(b & 255 | 256).substring(1) + " ");
        }

        int start = 0;
        int i = 0;
        while (i < str.length) {
            int prefix = prefix(str[i]);
            if (prefix == 0)
                i++;
            else {
                start = i;
                i++;
                int nextPrefix = prefix(str[i]);
                if (nextPrefix == 6) { // 110
                    reverse(start, i, str);

                } else {
                    reverse(start, i + 1, str);
                    i++;
                }
                i++;
            }
        }


        System.out.println("\nCorrected reversed:");
        for (byte b : str) {
            System.out.print(Integer.toBinaryString(b & 255 | 256).substring(1) + " ");
        }
    }
}
