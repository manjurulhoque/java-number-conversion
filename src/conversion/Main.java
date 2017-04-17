package conversion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldInput;
	String position;
	JLabel labelHexa;
	JLabel labelOctal;
	JLabel labelBinary;
	JLabel labelDecimal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Number Conversion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldInput = new JTextField();
		textFieldInput.setBounds(81, 42, 215, 20);
		contentPane.add(textFieldInput);
		textFieldInput.setColumns(10);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				position = comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setBounds(81, 89, 116, 20);
		comboBox.addItem("Decimal");
		comboBox.addItem("Binary");
		comboBox.addItem("Octal");
		comboBox.addItem("Hexa");
		contentPane.add(comboBox);

		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value = textFieldInput.getText().toString();
				// JOptionPane.showMessageDialog(btnConvert, position);
				if (value.trim().equals("")) {
					JOptionPane.showMessageDialog(btnConvert, "Field can not be empty");
				} else {
					switch (position) {
					case "Decimal":
						if(!value.matches(".*[A-Z].*")){
							labelDecimal.setText(value);
							labelBinary.setText(Long.toBinaryString(Long.valueOf(value)) + "");
							labelOctal.setText(""+Long.parseLong(value, 8));
							labelHexa.setText(Long.parseLong(value, 16) + "");
						}
						else {
							JOptionPane.showMessageDialog(btnConvert, "Something wrong");
						}
						break;
					case "Binary":
						if(!value.matches(".*[2-9].*")){
							labelDecimal.setText(Integer.toString(Integer.parseInt(value,2)));
							labelBinary.setText(value);
							long l = Long.parseLong(value, 2);
							labelOctal.setText("" + Long.toOctalString(l));
							labelHexa.setText(Long.toHexString(Long.parseLong(value, 2)) + "");
						}
						else {
							JOptionPane.showMessageDialog(btnConvert, "Something wrong");
						}
						break;
					case "Octa":
						if(!value.matches(".*[8-9].*")){
							labelDecimal.setText("" + Long.parseLong(value, 8));
							labelBinary.setText("" + Long.toBinaryString(Long.parseLong(value, 8)));
							labelOctal.setText(value);
							labelHexa.setText("" + Long.toHexString(Long.parseLong(value, 8)));
						}
						else {
							JOptionPane.showMessageDialog(btnConvert, "Something wrong");
						}
						break;
					case "Hexa":
						if(!value.matches(".*[G-Z].*")){
							labelDecimal.setText("" +  Long.parseLong(value, 16));
							labelBinary.setText("" + Long.toBinaryString(Long.parseLong(value, 16)));
							labelOctal.setText("" + Long.toOctalString(Long.parseLong(value, 16)));
							labelHexa.setText(value);
						}
						else {
							JOptionPane.showMessageDialog(btnConvert, "Something wrong");
						}
						break;
					}
				}
			}
		});
		btnConvert.setBounds(207, 88, 89, 23);
		contentPane.add(btnConvert);

		JLabel lblDecimal = new JLabel("Decimal");
		lblDecimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDecimal.setBounds(81, 173, 64, 14);
		contentPane.add(lblDecimal);

		JLabel lblBinary = new JLabel("Binary");
		lblBinary.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBinary.setBounds(81, 223, 64, 14);
		contentPane.add(lblBinary);

		JLabel lblOctal = new JLabel("Octal");
		lblOctal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOctal.setBounds(81, 278, 64, 14);
		contentPane.add(lblOctal);

		JLabel lblHex = new JLabel("Hex");
		lblHex.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHex.setBounds(81, 328, 64, 14);
		contentPane.add(lblHex);

		labelHexa = new JLabel("");
		labelHexa.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelHexa.setBounds(201, 328, 83, 14);
		contentPane.add(labelHexa);

		labelOctal = new JLabel("");
		labelOctal.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelOctal.setBounds(201, 278, 83, 14);
		contentPane.add(labelOctal);

		labelBinary = new JLabel("");
		labelBinary.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelBinary.setBounds(201, 223, 83, 14);
		contentPane.add(labelBinary);

		labelDecimal = new JLabel("");
		labelDecimal.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDecimal.setBounds(201, 173, 83, 14);
		contentPane.add(labelDecimal);
	}

}
