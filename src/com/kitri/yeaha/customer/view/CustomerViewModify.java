package com.kitri.yeaha.customer.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomerViewModify extends JFrame {

   public JPanel modifyP;
   public JPanel pInfo;
   public JTextField inputIdTF2;
   public JTextField inputPwTF2;
   public JTextField inputParentTF2;
   public JTextField inputChildTF2;
   public JTextField inputBirthTF2;
   public JTextField inputPhoneTf2;
   public JButton cancelB2;
   public JButton okB2;
   public JButton withdrawalB;
   public JLabel customermainL;
   public CustomerViewJoin join;

   /**
    * Launch the application.
    */
   // public static void main(String[] args) {
   // EventQueue.invokeLater(new Runnable() {
   // public void run() {
   // try {
   // CustomerViewJoin frame = new CustomerViewJoin();
   // frame.setVisible(true);
   // } catch (Exception e) {
   // e.printStackTrace();
   // }
   // }
   // });
   // }

   /**
    * Create the frame.
    */
   public CustomerViewModify() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 415, 560);
      modifyP = new JPanel();
      modifyP.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(modifyP);
      modifyP.setLayout(null);

      customermainL = new JLabel("YEAH-HA KIDS");
      customermainL.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 23));
      customermainL.setForeground(new Color(0, 51, 255));
      customermainL.setHorizontalAlignment(SwingConstants.CENTER);
      customermainL.setBounds(82, 15, 233, 45);
      modifyP.add(customermainL);

      pInfo = new JPanel();
      pInfo.setBounds(20, 72, 355, 366);
      pInfo.setLayout(new GridLayout(12, 1));
      modifyP.add(pInfo);

      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
      lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      lblNewLabel.setBounds(12, 85, 57, 15);
      pInfo.add(lblNewLabel);

      inputIdTF2 = new JTextField();
      inputIdTF2.setText("");
      inputIdTF2.setEditable(false);
      inputIdTF2.setBounds(12, 102, 274, 21);
      inputIdTF2.setColumns(10);
      pInfo.add(inputIdTF2);

      JLabel label = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
      label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      label.setBounds(12, 130, 57, 15);
      pInfo.add(label);

      inputPwTF2 = new JTextField();
      inputPwTF2.setColumns(10);
      inputPwTF2.setBounds(12, 148, 274, 21);
      pInfo.add(inputPwTF2);

      JLabel label_1 = new JLabel("\uBCF4\uD638\uC790 \uC774\uB984");
      label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      label_1.setBounds(12, 172, 69, 15);
      pInfo.add(label_1);

      inputParentTF2 = new JTextField();
      inputParentTF2.setText("");
      inputParentTF2.setColumns(10);
      inputParentTF2.setBounds(12, 190, 274, 21);
      pInfo.add(inputParentTF2);

      JLabel label_2 = new JLabel("\uC544\uC774 \uC774\uB984");
      label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      label_2.setBounds(12, 216, 57, 15);
      pInfo.add(label_2);

      inputChildTF2 = new JTextField();
      inputChildTF2.setText("");
      inputChildTF2.setColumns(10);
      inputChildTF2.setBounds(12, 234, 274, 21);
      pInfo.add(inputChildTF2);

      JLabel label_3 = new JLabel("\uC544\uC774 \uC0DD\uB144\uC6D4\uC77C");
      label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      label_3.setBounds(12, 257, 88, 15);
      pInfo.add(label_3);

      inputBirthTF2 = new JTextField();
      inputBirthTF2.setText("");
//      inputBirthTF2.setEditable(false);
      inputBirthTF2.setColumns(10);
      inputBirthTF2.setBounds(12, 275, 274, 21);
      pInfo.add(inputBirthTF2);

      JLabel label_4 = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
      label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
      label_4.setBounds(12, 303, 69, 15);
      pInfo.add(label_4);

      inputPhoneTf2 = new JTextField();
      inputPhoneTf2.setText("");
      inputPhoneTf2.setColumns(10);
      inputPhoneTf2.setBounds(12, 321, 274, 21);
      pInfo.add(inputPhoneTf2);

      okB2 = new JButton("\uD655\uC778");
      okB2.setBackground(SystemColor.textHighlight);
      okB2.setBounds(51, 450, 123, 28);
      modifyP.add(okB2);

      cancelB2 = new JButton("\uCDE8\uC18C");
      cancelB2.setBackground(SystemColor.textHighlight);
      cancelB2.setBounds(212, 450, 123, 28);
      modifyP.add(cancelB2);

      withdrawalB = new JButton("\uD68C\uC6D0\uD0C8\uD1F4");
      withdrawalB.setBounds(273, 488, 100, 20);
      modifyP.add(withdrawalB);

      join = new CustomerViewJoin();
   }

}