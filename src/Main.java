import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private static JLabel jlabel;
    private static JLabel celsLabel;
    private static JLabel fahrLabel;
    private static JButton clear;
    private static JButton calculate;
    private static JTextField celsius;
    private static JTextField  fahrenheit;

    public static float calculatorCelsius(float fahr){
        return (((fahr - 32) *5)/9);
    }
    public static float calculatorFahrenheit(float cels){
        return (((cels * 9/5) +32));
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Celsius Fahrenheit Calculator");
        frame.setSize(500, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlabel = new JLabel("Celsius Fahrenheit Calculator");
        jlabel.setBounds(100, 1, 200, 100);

        celsLabel = new JLabel("Celsius");
        celsLabel.setBounds(100, 120, 200, 100);

        fahrLabel = new JLabel("Fahrenheit");
        fahrLabel.setBounds(100, 30, 200, 100);

        clear = new JButton("clear");
        clear.setBounds(350, 100, 100, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                celsius.setText("");
                fahrenheit.setText("");
            }
        });

        calculate = new JButton("calculate");
        calculate.setBounds(350, 200, 100, 50);

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String celsString = celsius.getText();
                String fahrString = fahrenheit.getText();

                try {
                    if(celsString.equals("")){
                        float fahrValue = Float.parseFloat(fahrString);
                        float fahrConvertedValue = calculatorFahrenheit(fahrValue);
                        String fahrStringValue = String.format("%.2f", fahrConvertedValue);
                        celsius.setText(fahrStringValue);
                    }

                    else if(fahrString.equals("")) {
                        float celsValue = Float.parseFloat(celsString);
                        float celsConvertedValue = calculatorCelsius(celsValue);
                        String celsStringValue = String.format("%.2f", celsConvertedValue);
                        fahrenheit.setText(celsStringValue);
                    }
                    else {
                        String st = "Please make sure you only fill one box before calculating";
                        JOptionPane.showMessageDialog(null, st);
                    }
                } catch(NumberFormatException f){
                    String st = "Enter a number. Not a string dumbass.";
                    JOptionPane.showMessageDialog(null, st);
                }
            }
        });

        celsius = new JTextField();
        celsius.setBounds(100, 100, 200, 50);

        fahrenheit = new JTextField();
        fahrenheit.setBounds(100, 200, 200, 50);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);

        contentPane.add(clear);
        contentPane.add(calculate);
        contentPane.add(jlabel);
        contentPane.add(celsius);
        contentPane.add(fahrenheit);
        contentPane.add(celsLabel);
        contentPane.add(fahrLabel);

        contentPane.repaint();
        frame.repaint();
    }
}
