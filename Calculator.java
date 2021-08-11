/*Calculator Project 
can't rlly take creds since I watched a guide but ayyyyy finally something not just on console
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener { //adds interface w method stubs to code
    JFrame frame; //used for making a GUI
    JTextField textfield;
    JButton[] numberButtons = new JButton[10]; //for numbers
    JButton[] functionButtons = new JButton[9]; //for functions
    JButton addButton, subButton, mulButton, divButton; //works w the numbers
    JButton decButton, eqButton, delButton, clrButton, negButton; //works w formatting
    JPanel panel; //adds panel inside the window

    Font myFont = new Font("Consolas", Font.BOLD, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator; //contains *,+,-,/, etc

    public Calculator() //constructor for class
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550); //sets the size of the window
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50); //sets dimensions of the display field for the numbers
        textfield.setFont(myFont);
        textfield.setEditable(false); //makes it so u can't type stuff directly into textbox
        
        addButton = new JButton("+"); //initializes function buttons
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton; //assigns functions to array
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = eqButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++)
        {
            functionButtons[i].addActionListener(this); //makes buttons clickable
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); //no border around box when mousing over
        }

        for (int i = 0; i < 10; i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.GRAY);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield); //must add text field to the frame to show up
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++)
        {
            if (e.getSource() == numberButtons[i]) //getSource says which button is doing it
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));

            }
        }
        if (e.getSource() == decButton) //maybe a switch is better?? idk i didnt wanna deviate from the guide much
        {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton)
        {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == eqButton)
        {
            num2 = Double.parseDouble(textfield.getText());
            switch(operator) {
                case '+':
                result = num1 + num2;
                break;
                case '-':
                result = num1 - num2;
                break;
                case '*':
                result = num1 * num2;
                break;
                case '/':
                result = num1 / num2;
                break;
            }

            textfield.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton)
        {
            textfield.setText("");
        }
        if (e.getSource() == delButton)
        {
            String string = textfield.getText();
            textfield.setText("");

            for (int i = 0; i < string.length()-1; i++)
            {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }

        if (e.getSource() == negButton)
        {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
        
    }
}