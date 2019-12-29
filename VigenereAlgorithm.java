
public class VigenereAlgorithm {
	
	private static String plainText;
	private static String cipherText;
	private static long startTime;
	
	public VigenereAlgorithm(String pText, String cText){
		
		plainText = new String(pText);
		cipherText = new String(cText);
		
		plainText = plainText.toUpperCase();
		cipherText = cipherText.toUpperCase();
		
		
	}
	
	public String Decryption(String key){
					
		String pText = "";
		for (int i = 0, j = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            pText += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
			
		return pText;
	}
	

	
	
	
	
}
