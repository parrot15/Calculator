import static java.lang.System.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;

	private JButton powerTwo = new JButton("x^2");
	private JButton powerThree = new JButton("x^3");
	private JButton powerY = new JButton("x^y");
	private JButton tenToPower = new JButton("10^x");
	private JButton squareRoot = new JButton("√x");

	private JButton log10 = new JButton("log(x)");
	private JButton ln = new JButton("ln(x)");

	private JButton sin = new JButton("sin(x)");
	private JButton cos = new JButton("cos(x)");
	private JButton tan = new JButton("tan(x)");
	private JButton sinh = new JButton("sinh(x)");
	private JButton cosh = new JButton("cosh(x)");
	private JButton tanh = new JButton("tanh(x)");
	private JButton pi = new JButton("π");

	private JButton eulersNum = new JButton("e");
	private JButton inverse = new JButton("1÷x");
	private JButton factorial = new JButton("x!");
	private JButton round = new JButton("round(x)");

	private JRadioButton degrees = new JRadioButton("deg");
	private JRadioButton radians = new JRadioButton("rad");

	private JButton absoluteValue = new JButton("|");
	private JButton clear = new JButton("AC");
	private JButton leftParen = new JButton("(");
	private JButton rightParen = new JButton(")");

	private JButton seven = new JButton("7");
	private JButton eight = new JButton("8");
	private JButton nine = new JButton("9");
	private JButton four = new JButton("4");
	private JButton five = new JButton("5");
	private JButton six = new JButton("6");
	private JButton one = new JButton("1");
	private JButton two = new JButton("2");
	private JButton three = new JButton("3");
	private JButton zero = new JButton("0");
	private JButton decimal = new JButton(".");

	private JButton random = new JButton("rand");
	private JButton modulus = new JButton("%");
	private JButton divide = new JButton("÷");
	private JButton multiply = new JButton("×");
	private JButton subtract = new JButton("-");
	private JButton add = new JButton("+");
	private JButton equals = new JButton("=");

	private JTextField display = new JTextField();
	private String result = "";

	public Calculator() {
		setTitle("Calculator");
		setBackground(Color.lightGray);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel basePanel = new JPanel();
		basePanel.setPreferredSize(new Dimension(490, 360));
		basePanel.setBackground(Color.lightGray);
		basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));

		JPanel displayPanel = new JPanel();
		displayPanel.setBackground(Color.white);
		displayPanel.setPreferredSize(new Dimension(490, 70));
		displayPanel.setLayout(new BorderLayout());

		display.setFont(new Font("Courier", Font.PLAIN, 20));
		display.addActionListener(this);
		display.addKeyListener(this);
		displayPanel.add(display);

		basePanel.add(displayPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		buttonPanel.setPreferredSize(new Dimension(490, 290));
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		JPanel operationPanel2 = new JPanel();
		operationPanel2.setBackground(new Color(235, 235, 235));
		operationPanel2.setPreferredSize(new Dimension(210, 290));
		operationPanel2.setLayout(new GridLayout(0, 3));

		powerTwo.addActionListener(this);
		operationPanel2.add(powerTwo);

		powerThree.addActionListener(this);
		operationPanel2.add(powerThree);

		powerY.addActionListener(this);
		operationPanel2.add(powerY);

		tenToPower.addActionListener(this);
		operationPanel2.add(tenToPower);

		squareRoot.addActionListener(this);
		operationPanel2.add(squareRoot);

		log10.addActionListener(this);
		operationPanel2.add(log10);

		ln.addActionListener(this);
		operationPanel2.add(ln);

		sin.addActionListener(this);
		operationPanel2.add(sin);

		cos.addActionListener(this);
		operationPanel2.add(cos);

		tan.addActionListener(this);
		operationPanel2.add(tan);

		sinh.addActionListener(this);
		operationPanel2.add(sinh);

		cosh.addActionListener(this);
		operationPanel2.add(cosh);

		tanh.addActionListener(this);
		operationPanel2.add(tanh);

		pi.addActionListener(this);
		operationPanel2.add(pi);

		eulersNum.addActionListener(this);
		operationPanel2.add(eulersNum);

		inverse.addActionListener(this);
		operationPanel2.add(inverse);

		factorial.addActionListener(this);
		operationPanel2.add(factorial);

		round.addActionListener(this);
		operationPanel2.add(round);

		buttonPanel.add(operationPanel2);

		JPanel numberPanel = new JPanel();
		numberPanel.setBackground(Color.white);
		numberPanel.setPreferredSize(new Dimension(210, 290));
		numberPanel.setLayout(new GridLayout(0, 3));

		ButtonGroup angleMeasures = new ButtonGroup();
		angleMeasures.add(degrees);
		angleMeasures.add(radians);

		degrees.setBackground(new Color(235, 235, 235));
		degrees.setOpaque(true);
		degrees.addActionListener(this);
		numberPanel.add(degrees);
		degrees.setSelected(true);

		radians.setBackground(new Color(235, 235, 235));
		radians.setOpaque(true);
		radians.addActionListener(this);
		numberPanel.add(radians);

		absoluteValue.setBackground(new Color(235, 235, 235));
		absoluteValue.setOpaque(true);
		absoluteValue.addActionListener(this);
		numberPanel.add(absoluteValue);

		clear.setBackground(new Color(235, 235, 235));
		clear.setOpaque(true);
		clear.addActionListener(this);
		numberPanel.add(clear);

		leftParen.setBackground(new Color(235, 235, 235));
		leftParen.setOpaque(true);
		leftParen.addActionListener(this);
		numberPanel.add(leftParen);

		rightParen.setBackground(new Color(235, 235, 235));
		rightParen.setOpaque(true);
		rightParen.addActionListener(this);
		numberPanel.add(rightParen);

		seven.addActionListener(this);
		numberPanel.add(seven);

		eight.addActionListener(this);
		numberPanel.add(eight);

		nine.addActionListener(this);
		numberPanel.add(nine);

		four.addActionListener(this);
		numberPanel.add(four);

		five.addActionListener(this);
		numberPanel.add(five);

		six.addActionListener(this);
		numberPanel.add(six);

		one.addActionListener(this);
		numberPanel.add(one);

		two.addActionListener(this);
		numberPanel.add(two);

		three.addActionListener(this);
		numberPanel.add(three);

		zero.setPreferredSize(new Dimension(100, 100));
		zero.addActionListener(this);
		numberPanel.add(zero);

		decimal.addActionListener(this);
		numberPanel.add(decimal);

		random.addActionListener(this);
		numberPanel.add(random);

		buttonPanel.add(numberPanel);

		JPanel operationPanel1 = new JPanel();
		operationPanel1.setBackground(new Color(235, 235, 235));
		operationPanel1.setPreferredSize(new Dimension(70, 290));
		operationPanel1.setLayout(new GridLayout(0, 1));

		modulus.addActionListener(this);
		operationPanel1.add(modulus);

		divide.addActionListener(this);
		operationPanel1.add(divide);

		multiply.addActionListener(this);
		operationPanel1.add(multiply);

		subtract.addActionListener(this);
		operationPanel1.add(subtract);

		add.addActionListener(this);
		operationPanel1.add(add);

		equals.setBackground(new Color(130, 180, 255));
		equals.setOpaque(true);
		equals.addActionListener(this);
		operationPanel1.add(equals);

		buttonPanel.add(operationPanel1);

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		basePanel.add(buttonPanel);

		getContentPane().add(basePanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Calculator();
			}
		});
	}

	public static BigDecimal compute(final String str, final boolean isDegNotRad) {
		return BigDecimal.valueOf(new Object() {
			int pos = -1, ch;

			void nextChar() {
				ch = (++pos < str.length()) ? str.charAt(pos) : -1;
			}

			boolean eat(int charToEat) {
				while (ch == ' ') {
					nextChar();
				}
				if (ch == charToEat) {
					nextChar();
					return true;
				}
				return false;
			}

			double parse() {
				nextChar();
				double x = parseExpression();
				if (pos < str.length()) {
					throw new RuntimeException("Unexpected: " + (char) ch);
				}
				return x; // the answer that gets returned
			}

			double parseExpression() {
				double x = parseTerm();
				for (;;) {
					if (eat('+')) { // addition
						x += parseTerm();
					} else if (eat('-')) { // subtraction
						x -= parseTerm();
					} else {
						return x;
					}
				}
			}

			double parseTerm() {
				double x = parsePow();
				for (;;) {
					if (eat('×') || eat('*')) { // multiplication
						x *= parsePow();
					} else if (eat('÷') || eat('/')) { // division
						x /= parsePow();
					} else if (eat('%')) { // modulus
						x %= parsePow();
					} else {
						return x;
					}
				}
			}

			double parsePow() {
				double x = parseFactorial();
				for (;;) {
					if (eat('^')) {
						x = Math.pow(x, parseFactorial());
					} else {
						return x;
					}
				}
			}
			
			double parseFactor() {
				if (eat('+')) { // unary plus
					return parseFactorial();
				}
				if (eat('-')) { // unary minus
					return -parseFactorial();
				}
				double x;
				int startPos = this.pos;
				if (eat('(')) { // parentheses
					x = parseExpression();
					eat(')');
				} else if (eat('|')) { // absolute value
					x = Math.abs(parseExpression());
					eat('|');
				} else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
					while ((ch >= '0' && ch <= '9') || ch == '.') {
						nextChar();
					}
					x = Double.parseDouble(str.substring(startPos, this.pos));
				} else if (ch >= 'a' && ch <= 'z' || ch == '√') { // functions
					while (ch >= 'a' && ch <= 'z' || ch == '√') {
						nextChar();
					}
					String func = str.substring(startPos, this.pos);
					if (str.substring(this.pos, this.pos + 1).equals("|")) {
						throw new RuntimeException("Unexpected: |");
					}
					x = parseFactorial();
					if (func.equals("√") || func.equals("sqrt")) {
						x = Math.sqrt(x);
					} else if (func.equals("log")) {
						x = Math.log10(x);
					} else if (func.equals("ln")) {
						x = Math.log(x);
					} else if (func.equals("sin")) {
						if (isDegNotRad) {
							x = Math.sin(Math.toRadians(x));
						} else {
							x = Math.sin(x);
						}
					} else if (func.equals("cos")) {
						if (isDegNotRad) {
							x = Math.cos(Math.toRadians(x));
						} else {
							x = Math.cos(x);
						}
					} else if (func.equals("tan")) {
						if (isDegNotRad) {
							x = Math.tan(Math.toRadians(x));
						} else {
							x = Math.tan(x);
						}
					} else if (func.equals("sinh")) {
						if (isDegNotRad) {
							x = Math.sinh(Math.toRadians(x));
						} else {
							x = Math.sinh(x);
						}
					} else if (func.equals("cosh")) {
						if (isDegNotRad) {
							x = Math.cosh(Math.toRadians(x));
						} else {
							x = Math.cosh(x);
						}
					} else if (func.equals("tanh")) {
						if (isDegNotRad) {
							x = Math.tanh(Math.toRadians(x));
						} else {
							x = Math.tanh(x);
						}
					} else if (func.equals("round")) {
						x = Math.round(x);
					} else {
						throw new RuntimeException("Unknown function: " + func);
					}
				} else {
					throw new RuntimeException("Unexpected: " + (char) ch);
				}
				return x;
			}

			double parseFactorial() { // factorial
				double x = parseConstants();
				for (;;) {
					if (eat('!')) {
						if (x == Math.floor(x)) { // if the user wants to find factorial of integer
							BigInteger fact = BigInteger.valueOf(1);
							for (int i = 1; i <= x; i++) {
								fact = fact.multiply(BigInteger.valueOf(i));
							}
							x = fact.doubleValue();
						} else { // if the user wants to find factorial of decimal
							x = Math.sqrt(2 * Math.PI * x) * Math.pow(x / Math.E, x) * (1 + (1 / (12 * x)));
						}
					} else {
						return x;
					}
				}
			}

			double parseConstants() { // constants
				if (eat('π') || (eat('p') && eat('i'))) {
					return Math.PI;
				} else if (eat('e')) {
					return Math.E;
				} else {
					return parseFactor();
				}
			}
		}.parse());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		result = display.getText();
		if (e.getSource().equals(zero)) {
			out.println("zero");
			result += "0";
			display.setText(result);
		} else if (e.getSource().equals(one)) {
			out.println("one");
			result += "1";
			display.setText(result);
		} else if (e.getSource().equals(two)) {
			out.println("two");
			result += "2";
			display.setText(result);
		} else if (e.getSource().equals(three)) {
			out.println("three");
			result += "3";
			display.setText(result);
		} else if (e.getSource().equals(four)) {
			out.println("four");
			result += "4";
			display.setText(result);
		} else if (e.getSource().equals(five)) {
			out.println("five");
			result += "5";
			display.setText(result);
		} else if (e.getSource().equals(six)) {
			out.println("six");
			result += "6";
			display.setText(result);
		} else if (e.getSource().equals(seven)) {
			out.println("seven");
			result += "7";
			display.setText(result);
		} else if (e.getSource().equals(eight)) {
			out.println("eight");
			result += "8";
			display.setText(result);
		} else if (e.getSource().equals(nine)) {
			out.println("nine");
			result += "9";
			display.setText(result);
		} else if (e.getSource().equals(decimal)) {
			out.println("decimal");
			result += ".";
			display.setText(result);
		} else if (e.getSource().equals(random)) {
			out.println("random");
			result += (new Random()).nextInt(10);
			display.setText(result);
		} else if (e.getSource().equals(absoluteValue)) {
			out.println("absolute value");
			result += "|";
			display.setText(result);
		} else if (e.getSource().equals(clear)) {
			out.println("clear");
			result = "";
			display.setText(result);
		} else if (e.getSource().equals(leftParen)) {
			out.println("left paren");
			result += "(";
			display.setText(result);
		} else if (e.getSource().equals(rightParen)) {
			out.println("right paren");
			result += ")";
			display.setText(result);
		} else if (e.getSource().equals(add)) {
			out.println("add");
			result += "+";
			display.setText(result);
		} else if (e.getSource().equals(subtract)) {
			out.println("subtract");
			result += "-";
			display.setText(result);
		} else if (e.getSource().equals(multiply)) {
			out.println("multiply");
			result += "×";
			display.setText(result);
		} else if (e.getSource().equals(divide)) {
			out.println("divide");
			result += "÷";
			display.setText(result);
		} else if (e.getSource().equals(modulus)) {
			out.println("modulus");
			result += "%";
			display.setText(result);
		} else if (e.getSource().equals(powerTwo)) {
			out.println("power of two");
			result += "^2";
			display.setText(result);
		} else if (e.getSource().equals(powerThree)) {
			out.println("power of three");
			result += "^3";
			display.setText(result);
		} else if (e.getSource().equals(powerY)) {
			out.println("x to power of y");
			result += "^";
			display.setText(result);
		} else if (e.getSource().equals(tenToPower)) {
			out.println("ten to power of x");
			result += "10^";
			display.setText(result);
		} else if (e.getSource().equals(squareRoot)) {
			out.println("square root");
			result += "√";
			display.setText(result);
		} else if (e.getSource().equals(log10)) {
			out.println("log base 10");
			result += "log";
			display.setText(result);
		} else if (e.getSource().equals(ln)) {
			out.println("natural log");
			result += "ln";
			display.setText(result);
		} else if (e.getSource().equals(sin)) {
			out.println("sin x");
			result += "sin";
			display.setText(result);
		} else if (e.getSource().equals(cos)) {
			out.println("cos x");
			result += "cos";
			display.setText(result);
		} else if (e.getSource().equals(tan)) {
			out.println("tan x");
			result += "tan";
			display.setText(result);
		} else if (e.getSource().equals(sinh)) {
			out.println("sinh x");
			result += "sinh";
			display.setText(result);
		} else if (e.getSource().equals(cosh)) {
			out.println("cosh x");
			result += "cosh";
			display.setText(result);
		} else if (e.getSource().equals(tanh)) {
			out.println("tanh x");
			result += "tanh";
			display.setText(result);
		} else if (e.getSource().equals(pi)) {
			out.println("pi");
			result += "π";
			display.setText(result);
		} else if (e.getSource().equals(eulersNum)) {
			out.println("euler");
			result += "e";
			display.setText(result);
		} else if (e.getSource().equals(inverse)) {
			out.println("inverse");
			result += "1÷x";
			display.setText(result);
		} else if (e.getSource().equals(factorial)) {
			out.println("factorial");
			result += "!";
			display.setText(result);
		} else if (e.getSource().equals(round)) {
			out.println("round");
			result += "round";
			display.setText(result);
		} else if (e.getSource().equals(equals)) {
			try {
				if (degrees.isSelected()) {
					out.println("degrees equals");
					result = "" + compute(display.getText(), true);
				} else if (radians.isSelected()) {
					out.println("radians equals");
					result = "" + compute(display.getText(), false);
				}
				display.setText((Double.parseDouble(result) == Math.floor(Double.parseDouble(result)) && 
						!result.contains("E")) ? result.substring(0, result.length() - 2) : result);
			} catch (RuntimeException ex) {
				display.setText("");
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			equals.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}