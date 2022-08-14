package Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame  {
     private  JFrame frame;
     private JMenuBar menuBar;
     private JMenu file;
     private JMenuItem exit, saveFile;
     private JLabel label_principal,label_duration,label_annualInterestRate,label_monthlyPayment,
    label_totalPayment,label_totalInterest;
     private JSpinner spinnerPrincipal,spinnerDuration,spinnerAnnualInterestRate;
     private JTextField textFieldMonthlyPayment,textFieldTotalPayment,textFieldTotalInterestRate;
     private JButton btnCalculator;
     public Main() {
         frame = new JFrame("Loan Calculator");
         frame.setSize(320, 320);
         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         frame.setLayout(new GridBagLayout());
         frame.setResizable(false);
         Font font = new Font(Font.SERIF,Font.BOLD,18);
//-----------------------------------------Make Menubar-----------------------------------------------------------------
         menuBar = new JMenuBar();
         frame.setJMenuBar(menuBar);
         file = new JMenu("File");
         menuBar.add(file);
         saveFile = new JMenuItem("Save File as .....");
         file.add(saveFile);
         exit = new JMenuItem("Exit");
         exitAction(exit);
         file.add(exit);
         btnCalculator = new JButton("Calculate");
         btnAction(btnCalculator);
//-----------------------------------------Make label-----------------------------------------------------------------
         label_principal = new JLabel("Loan principal Amount");
         label_principal.setFont(font);
         label_duration = new JLabel("Duration (Months)");
         label_duration.setFont(font);
         label_annualInterestRate = new JLabel("Annual Interest Rate");
         label_annualInterestRate.setFont(font);
         label_monthlyPayment = new JLabel("Monthly Payment");
         label_monthlyPayment.setFont(font);
         label_totalPayment = new JLabel("Total Payment");
         label_totalPayment.setFont(font);
         label_totalInterest = new JLabel("Total Interest");
         label_totalInterest.setFont(font);

//-----------------------------------------Make Spinner-----------------------------------------------------------------
         spinnerDuration = new JSpinner();
         spinnerDuration.setModel(new SpinnerNumberModel(36,3,240,1));
         spinnerPrincipal = new JSpinner();
         spinnerPrincipal.setModel(new SpinnerNumberModel(1000.0d,0.0d,null,1.0d));
         spinnerAnnualInterestRate = new JSpinner();
         spinnerAnnualInterestRate.setModel(new SpinnerNumberModel(20.0d,0.0d,100.0d,0.1d));
//-----------------------------------------Make TextField-----------------------------------------------------------------
         textFieldMonthlyPayment = new JTextField();
         textFieldMonthlyPayment.setEditable(false);
         textFieldTotalPayment = new JTextField();
         textFieldTotalPayment.setEditable(false);
         textFieldTotalInterestRate = new JTextField();
         textFieldTotalInterestRate.setEditable(false);
//-----------------------------------------add Item -----------------------------------------------------------------
        addItem(frame,label_principal,0,0,1,1,
                GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,label_duration,0,1,1,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,label_annualInterestRate,0,2,1,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,label_monthlyPayment,0,3,1,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,label_totalPayment,0,4,1,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,label_totalInterest,0,5,1,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);

         addItem(frame,spinnerPrincipal,1,0,2,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,spinnerDuration,1,1,2,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,spinnerAnnualInterestRate,1,2,2,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);

         addItem(frame,textFieldMonthlyPayment,1,3,2,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,textFieldTotalPayment,1,4,2,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);
         addItem(frame,textFieldTotalInterestRate,1,5,2,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);

         addItem(frame,btnCalculator,1,6,1,1,
                 GridBagConstraints.BOTH,GridBagConstraints.CENTER);

//-----------------------------------------add Start -----------------------------------------------------------------

         frame.setVisible(true);
     }
  private void addItem(JFrame frame, JComponent component,int x , int y ,int width, int height,int fill,int align){
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.gridx=x;
         gbc.gridy=y;
         gbc.gridwidth=width;
         gbc.gridheight=height;
         gbc.insets= new Insets(5,5,5,5);
         gbc.fill=fill;
         gbc.anchor=align;
         frame.add(component,gbc);
  }


//--------------------------------------MenuAciton----------------------------------------------------
       private void exitAction(JMenuItem exit) {
         exit.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     System.exit(0);
                 }
             });
         }



    public static void main(String[] args) {
        new Main();
    }

private Loan loan = new Loan(1000.0,36,20.0);
//Action button
    private void btnAction(JButton btnCalculator){
        this.btnCalculator=btnCalculator;
        btnCalculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        loan.setPrincipal((double)spinnerPrincipal.getValue());
        loan.setDuration((int)spinnerDuration.getValue());
        loan.setAnnualInterestRate((double) spinnerAnnualInterestRate.getValue());
        double m = loan.getMonthlyPayment();
        textFieldMonthlyPayment.setText(String.format("%f",m));
        double b = loan.getTotalPayment();
        textFieldTotalPayment.setText(String.format("%f",b));
        double t = b-m;
        textFieldTotalInterestRate.setText(String.format("%f",t));

            }
        });
    }



}
