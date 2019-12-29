import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu extends JFrame {

	private JTextField PlainT;
	private JTextField CipherT;
	private JButton Enter;
	private JLabel PlainTLabel;
	private JLabel CipherTLabel;
	private JLabel AttentionLabel;
	private JLabel ClickWhenReady;
	private JLabel MainLabel;
	private JFrame Frame;

	private static String PlainText;
	private static String CipherText;
	private static String alphabetM;
	private static String Key;

	private static String DecryptedText;

	private static ArrayList ListofKeys;

	private static long startTime;

	public Menu() {

		PlainText = "";
		CipherText = "";
		Key = "";
		DecryptedText = "";
		alphabetM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		ArrayList<String> ListofKeys = new ArrayList<String>();

		Frame = new JFrame();

		MainLabel = new JLabel();

		PlainTLabel = new JLabel("PlainText: ");
		PlainTLabel.setForeground(Color.BLACK);
		PlainTLabel.setBounds(100, 200, 100, 20);

		CipherTLabel = new JLabel("CipherText: ");
		CipherTLabel.setForeground(Color.BLACK);
		CipherTLabel.setBounds(100, 300, 100, 20);

		AttentionLabel = new JLabel(
				"Key length is preset to be 6.\n Also, all letters will be considered as capital letters.");
		AttentionLabel.setForeground(Color.BLACK);
		AttentionLabel.setBounds(50, 100, 500, 20);

		ClickWhenReady = new JLabel("Click GO after you entered the texts");
		ClickWhenReady.setForeground(Color.BLACK);
		ClickWhenReady.setBounds(100, 400, 300, 20);

		Enter = new JButton("GO");
		Enter.setBounds(500, 400, 100, 30);

		PlainT = new JTextField("");
		PlainT.setBounds(200, 200, 400, 30);
		CipherT = new JTextField("");
		CipherT.setBounds(200, 300, 400, 30);

		MainLabel.setOpaque(true);
		MainLabel.setLayout(null);

		MainLabel.add(AttentionLabel);
		MainLabel.add(PlainTLabel);
		MainLabel.add(PlainT);
		MainLabel.add(CipherTLabel);
		MainLabel.add(CipherT);
		MainLabel.add(ClickWhenReady);
		MainLabel.add(Enter);

		ButtonListener Listener = new ButtonListener();
		Enter.addActionListener(Listener);

		Frame.add(MainLabel);
		Frame.setSize(825, 570);
		Frame.setVisible(true);

		MainLabel.setOpaque(true);

		Frame.setTitle("Vigenere Algorithm Brute-Force Attack");
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(Enter)) {
				setPlainText(getPlainT().getText().toString());
				setCipherText(getCipherT().getText().toString());
			}
			VigenereAlgorithm Vigenere = new VigenereAlgorithm(PlainText, getCipherText());
		    startTime = System.nanoTime();
			while (PlainText != DecryptedText) {
				for(int i = 0; i < 7; i++){
					Key = Key + randomCharacter(alphabetM);
				}
				try{
					if(ListofKeys.contains(Key)){
					
					}
					else{
						ListofKeys.add(Key);
						DecryptedText = Vigenere.Decryption(Key);
						if (DecryptedText.equals(PlainText)) {
							System.out.println("Decryption Completed. The key is: " + Key);
							long duration = System.nanoTime() - startTime;
							System.out.println("Time: " + ((double)duration / 1000000000.0) + " seconds");
							break;
						}
					}
				}
				catch(NullPointerException e1){
					
				}
				
				
			}
		}
	}

	public static String randomCharacter(String chars) {
		int n = chars.length();
		int r = (int) (n * Math.random());
		return chars.substring(r, r + 1);

	}

	public String getPlainText() {
		return PlainText;
	}

	public void setPlainText(String plainText) {
		Menu.PlainText = plainText;
	}

	public String getCipherText() {
		return CipherText;
	}

	public void setCipherText(String cipherText) {
		Menu.CipherText = cipherText;
	}

	public JTextField getPlainT() {
		return PlainT;
	}

	public void setPlainT(JTextField plainT) {
		PlainT = plainT;
	}

	public JTextField getCipherT() {
		return CipherT;
	}

	public void setCipherT(JTextField cipherT) {
		CipherT = cipherT;
	}

}
