package cc.airson.im.server.rest.tools;

import org.apache.commons.codec.binary.Hex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    //public static final  String HASH_ALGORITHM   = "SHA-1";
    //public static final  int    HASH_INTERATIONS = 1024;
    private static final int SALT_SIZE = 8;

    public static String md5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        String md5 = new BigInteger(1, md.digest()).toString(16);
        return fillMD5(md5);
    }

    public static String md5(String username, String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(username.getBytes());
        md.update(password.getBytes());
        String md5 = new BigInteger(1, md.digest()).toString(16);
        return fillMD5(md5);
    }

    // BigInteger会把0省略掉，需补全至32位，重写一个方法将16位数转换为32位数 将16位数转为32位
    public static String fillMD5(String md5) {
        return md5.length() == 32 ? md5 : fillMD5("0" + md5);
    }

    /**
     * 明文字串: C[0..N];
     * 加密字串: S[0..N];
     * 加密算法：S[0] = C[0] xor 0xEE;  S[N] = C[N] xor S[N-1];
     * 解密算法： C[0] = S[0] xor 0xEE;  C[N] = S[N] xor S[N-1];
     */
    public static String decryptPassword(String encrypt_passwd) {
        String decrypt_passwd = "";
        if (encrypt_passwd != null && !encrypt_passwd.equals("")) {
            int[] tmpNum = new int[encrypt_passwd.length() / 2];
            tmpNum[0] = (Integer.valueOf(encrypt_passwd.substring(0, 2), 16)) ^ 0xEE;
            decrypt_passwd += (char) tmpNum[0];
            for (int i = 1; i < encrypt_passwd.length() / 2; i++) {
                tmpNum[i] = (Integer.valueOf(encrypt_passwd.substring(i * 2, i * 2 + 2), 16)) ^ (Integer.valueOf(encrypt_passwd.substring((i - 1) * 2, (i - 1) * 2 + 2), 16));
                decrypt_passwd += (char) tmpNum[i];
            }
        }
        return decrypt_passwd;
    }

    /**
     * 明文字串: C[0..N];
     * 加密字串: S[0..N];
     * 加密算法：S[0] = C[0] xor 0xEE;  S[N] = C[N] xor S[N-1];
     * 解密算法： C[0] = S[0] xor 0xEE;  C[N] = S[N] xor S[N-1];
     */
    public static String encryptPassword(String pswd) {
        String tmp_passwd = pswd;
        String encrypt_passwd = "";
        if (tmp_passwd != null && !tmp_passwd.equals("")) {
            int[] tmpNum = new int[tmp_passwd.length()];
            tmpNum[0] = tmp_passwd.charAt(0) ^ 0xEE;
            encrypt_passwd += String.format("%02x", tmpNum[0]);
            for (int i = 1; i < tmp_passwd.length(); i++) {
                tmpNum[i] = tmp_passwd.charAt(i) ^ tmpNum[i - 1];
                encrypt_passwd += String.format("%02x", tmpNum[i]);
            }
        }
        return encrypt_passwd;
    }

    /**
     * 获取一个文件的md5值(可处理大文件)
     *
     * @return md5 value
     */
    public static String getFileMD5(File file) {
        FileInputStream fileInputStream = null;
        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                MD5.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(MD5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
