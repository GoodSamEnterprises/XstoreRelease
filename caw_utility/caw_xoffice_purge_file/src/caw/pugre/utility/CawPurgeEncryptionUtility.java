package caw.pugre.utility;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

public class CawPurgeEncryptionUtility {
	private static final String SECRETKEYSPEC = "AES";
	private static final String CIPHER_AES_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";
	final static Logger logger = Logger.getLogger(CawPurgeEncryptionUtility.class);
	final static byte[] keyBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b,
			0x0c, 0x0d, 0x0e, 0x0f };
	private static volatile CawPurgeEncryptionUtility INSTANCE = null;

	public static CawPurgeEncryptionUtility getInstance() {

		if (INSTANCE == null) {
			synchronized (CawPurgeEncryptionUtility.class) {
				if (INSTANCE == null) {
					INSTANCE = new CawPurgeEncryptionUtility();
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * Encrypt a string with AES algorithm.
	 *
	 * @param encryptedData is a string
	 * @return the encrypted string
	 */
	public String encrypt(String data) throws Exception {

		Cipher cipher = Cipher.getInstance(CIPHER_AES_ECB_PKCS5_PADDING);
		SecretKeySpec key = new SecretKeySpec(keyBytes, SECRETKEYSPEC);
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] cipherText = cipher.doFinal(data.getBytes());
		String encodedTxt = Base64.encodeBase64URLSafeString(cipherText);

		return encodedTxt;
	}

	/**
	 * Decrypt a string with AES algorithm.
	 *
	 * @param encryptedData is a string
	 * @return the decrypted string
	 */
	public String decrypt(String encryptedData) throws Exception {
		Cipher cipher = Cipher.getInstance(CIPHER_AES_ECB_PKCS5_PADDING);
		SecretKeySpec key = new SecretKeySpec(keyBytes, SECRETKEYSPEC);
		cipher.init(Cipher.DECRYPT_MODE, key);
		String decodeStr = URLDecoder.decode(encryptedData, StandardCharsets.UTF_8.toString());

		byte[] base64decodedTokenArr = Base64.decodeBase64(decodeStr.getBytes());
		byte[] decryptedPassword = cipher.doFinal(base64decodedTokenArr);
		String decodeTxt = new String(decryptedPassword);

		return decodeTxt;
	}
}
