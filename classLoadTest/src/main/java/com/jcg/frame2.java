package com.jcg;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  // Using AWT event classes and listener interfaces

public class frame2 extends JFrame{
   
      final JFrame window = new JFrame("Smoke");
      window.setVisible(true);
      window.setSize(700,500);
      window.setResizable(false);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
    public frame2{
      
      final JPanel panel = new JPanel();
      panel.setLayout(null);
      window.add(panel);
            
      JButton View = new JButton("View");
      JButton Quit = new JButton("Quit");
      JButton Launch = new JButton("Launch");
      JButton Sort = new JButton("Sort");
      View.setBounds(200,430,100,30);
      Quit.setBounds(550,430,100,30);
      Launch.setBounds(400,430,100,30);
      Sort.setBounds(50,430,100,30);
      panel.add(View);
      panel.add(Quit);
      panel.add(Launch);
      panel.add(Sort);
      
      JTextArea display = new JTextArea();
      display.setEditable(false);
      rows = rd.readFile(fileName, 10);
      info = re.getRecords(rows);
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < info.length-5; i++){
         for(int j = 0; j < info[0].length; j++){
            sb.append(info[i][j] + "\t");
         }
         sb.append("\n");
      }
      display.append("     |Name|" + "\t|FileName|" + "\t|Difficulty|" + "\t|Date Created|" + "\t|Rating|" + "\t|Created By|" + "\n");
      display.append(sb.toString());
      JScrollPane scrollPane = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scrollPane.setBounds(100, 120, 500, 160);
      panel.add(scrollPane);       
      
      JTextField field = new JTextField();
      field.setEditable(true);      
      field.setBounds(250,350,100,30);
      panel.add(field);
      
      Sort.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            window.dispose();// close the current fram
            sortFrame();// open the frame used for sorting
         }
      });// end Sort ActionListener
      
      Launch.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            game2();
         }
      });// end Launch ActionListener
           
       Quit.addActionListener(new ActionListener()
       {      
          public void actionPerformed(ActionEvent e)
          {
             System.exit(0);
          }
      });// end Quit ActionListener
   }// end frame2
}