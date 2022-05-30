package util.string;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Util class for SHA256 algorithm
 *
 * @author Ziyao Wang
 * @version 1.5
 */
public class MessageSHA256 {
	/**
	 * encode SHA256
	 * @param input String
	 * @return String
	 */
	public String encode(String input) {
		MessageDigest digest;
		byte[] encodedHash = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encodedHash != null? bytesToHex(encodedHash) : null;
	}

	/**
	 * bytes to hex
	 * @param hash byte[]
	 * @return String
	 */
	private String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for (byte b : hash) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}