/**
 * Created by mengwliu on 10/20/17
 * 157. Read N Characters Given Read4
 */
public class p157 {
    int read4(char[] buf) {
        return 0;
    }
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        char[] tmp = new char[4];
        boolean eof = false;

        while (index < n && !eof) {
            int num = read4(tmp);
            if (num != 4) eof = true;
            for (int i = 0; i < Math.min(num, n - index); i++) buf[index+i] = tmp[i];
            index += num;

        }
        return index;
    }
}
