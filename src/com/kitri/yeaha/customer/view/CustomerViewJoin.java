package com.kitri.yeaha.customer.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomerViewJoin extends JFrame {

   public JPanel contentPane;
   public JPanel pInfo;
   public JTextField inputIdTF;
   public JTextField inputPwTF;
   public JTextField inputParentTF;
   public JTextField inputChildTF;
   public JTextField inputBirthTF;
   public JTextField inputPhoneTF;
   public JLabel customerMainL;
   public JLabel lblNewLabel;
   public JLabel label;
   public JLabel label_1;
   public JLabel label_2;
   public JLabel label_3;
   public JLabel label_4;
   public JButton okB;
   public JButton cancelB;

   public CustomerViewMain join;
   public JButton duplicateB;

   /**
    * Launch the application.
    */
   // public static void main(String[] args) {
   // EventQueue.invokeLater(new Runnable() {
   // public void run() {
   // try {
   // CustomerViewJoin frame = new CustomerViewJoin();
   // frame.setVisible(false);
   // } catch (Exception e) {
   // e.printStackTrace();
   // }
   // }
   // });
   // }

   /**
    * Create the frame.
    */
   public CustomerViewJoin() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 415, 560);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      JLabel customerMainL = new JLabel("YEAH-HA KIDS");
      customerMainL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
      customerMainL.setForeground(new Color(0, 51, 255));
      customerMainL.setHorizontalAlignment(SwingConstants.CENTER);
      customerMainL.setBounds(82, 15, 233, 45);
      contentPane.add(customerMainL);

      pInfo = new JPanel();
      pInfo.setBounds(20, 72, 355, 366);
      pInfo.setLayout(new GridLayout(12, 1));
      contentPane.add(pInfo);

      lblNewLabel = new JLabel("\uC544\uC774\uB514");
      lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      pInfo.add(lblNewLabel);
      
      JPanel panel = new JPanel();
      pInfo.add(panel);
      panel.setLayout(new BorderLayout(0, 0));
      
            inputIdTF = new JTextField();
            panel.add(inputIdTF, BorderLayout.CENTER);
            inputIdTF.setColumns(10);
            
            duplicateB = new JButton("\uC911\uBCF5 \uCCB4\uD06C");
            panel.add(duplicateB, BorderLayout.EAST);

      label = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
      label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      pInfo.add(label);

      inputPwTF = new JTextField();
      inputPwTF.setColumns(10);
      pInfo.add(inputPwTF);

      label_1 = new JLabel("\uBCF4\uD638\uC790 \uC774\uB984");
      label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      pInfo.add(label_1);

      inputParentTF = new JTextField();
      inputParentTF.setColumns(10);
      pInfo.add(inputParentTF);

      label_2 = new JLabel("\uC544\uC774 \uC774\uB984");
      label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      pInfo.add(label_2);

      inputChildTF = new JTextField();
      inputChildTF.setColumns(10);
      pInfo.add(inputChildTF);

      label_3 = new JLabel("\uC544\uC774 \uC0DD\uB144\uC6D4\uC77C");
      label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      pInfo.add(label_3);

      inputBirthTF = new JTextField();
      inputBirthTF.setColumns(10);
      pInfo.add(inputBirthTF);

      label_4 = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
      label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      pInfo.add(label_4);

      inputPhoneTF = new JTextField();
      inputPhoneTF.setColumns(10);
      pInfo.add(inputPhoneTF);

      okB = new JButton("\uD655\uC778");
      okB.setBackground(SystemColor.textHighlight);
      okB.setBounds(51, 455, 123, 28);
      contentPane.add(okB);

      cancelB = new JButton("\uCDE8\uC18C");
      cancelB.setBackground(SystemColor.textHighlight);
      cancelB.setBounds(212, 455, 123, 28);
      contentPane.add(cancelB);

   }
}