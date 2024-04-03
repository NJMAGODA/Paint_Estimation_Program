/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paint;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Future CEO
 */
public class Paint extends JFrame{

    private final JLabel lengthLabel;
    private final JLabel widthLabel;
    private final JLabel heightLabel;
    private final JLabel wallAreaLabel;
    private final JLabel tinsNeededLabel;
    private final JLabel totalCostLabel;
    private final JLabel vatLabel;
    private final JLabel changeLabel;
    private final JTextField lengthField;
    private final JTextField widthField;
    private final JTextField heightField;
    private final JButton calculateButton;
    
    
    public Paint(){
        setTitle("Paint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new FlowLayout());
        
        lengthLabel = new JLabel("Length:");
        widthLabel = new JLabel("Width:");
        heightLabel = new JLabel("Height:");
        wallAreaLabel = new JLabel ("Wall Area:");
        tinsNeededLabel = new JLabel ("Tins Needed:");
        totalCostLabel = new JLabel ("Total Cost:");
        vatLabel = new JLabel ("VAT:");
        changeLabel = new JLabel ("Change");
        
         lengthField = new JTextField(10);
         widthField = new JTextField (10);
         heightField = new JTextField (10);
         
         calculateButton = new JButton("Calculate");
         calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
              
            }
           
        });
         add(lengthLabel);
         add(lengthField);
         add(widthLabel);
         add(widthField);
         add(heightLabel);
         add(heightField);
         add(calculateButton);
         add(wallAreaLabel);
         add(wallAreaLabel);
         add(tinsNeededLabel);
         add(totalCostLabel);
         add(vatLabel);
         add(changeLabel);
        
    }
    
    private void calculate(){
        double length = Double.parseDouble(lengthField.getText());
        double width = Double.parseDouble(widthField.getText());
        double height = Double.parseDouble(heightField.getText());
        
        double wallArea = calculateWallArea(length, width, height );
        double tinsNeeded = calculateTinsNeeded(wallArea);
        double totalCost = calculateTotalCost(tinsNeeded);
        double vat = calculateVAT(totalCost);
        
        wallAreaLabel.setText("Wall Area: " + wallArea + "sq.meters");
        tinsNeededLabel.setText("Tins Needed: " + tinsNeeded);
        totalCostLabel.setText("Total cost: R" + totalCost);
        vatLabel.setText("VAT: R" + vat);
    }
    
    
    private double calculateTinsNeeded(double wallArea ){
        double  tinsNeeded = Math.ceil(wallArea / 10);
        return tinsNeeded;
      
    }
   
    
    private double calculateTotalCost(double tinsNeeded){
        double totalCost = tinsNeeded * 30;
        return totalCost;
    }

    private double calculateVAT(double totalCost){
        double vat = totalCost * 0.15;//Assuming a vat rate of 15%
        return vat;
    }
    
    private double calculateWallArea(double length, double width, double height) {
        double wallArea = 2 * (length * height + width * height);
        return wallArea;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               new Paint().setVisible(true);
               
           } 
        });
                

    }

}
