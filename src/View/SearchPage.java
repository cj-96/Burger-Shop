/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import Model.OrderDetails;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author Chamindu
 */
public class SearchPage extends JFrame {
     private JLabel lblSearch; 
     
     private JButton btnBack;
     private JButton btnSearchBestCustomer; 
     private JButton btnSearchOrderDetails; 
     private JButton btnSearchCustomer; 
    
    public SearchPage(){

        setTitle("Place Order Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        getContentPane().setBackground(Color.WHITE );
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        
        lblSearch = new JLabel();
        lblSearch.setText("Search");
        lblSearch.setFont(new Font("",Font.PLAIN,40));
        lblSearch.setForeground(Color.white);
        lblSearch.setBounds(400,0,400,70);
            
        lblSearch.setVerticalAlignment(JLabel.CENTER);
        lblSearch.setHorizontalAlignment(JLabel.CENTER);
        lblSearch.setBackground(new Color(176, 51, 51));
        lblSearch.setOpaque(true);
        
        
        btnSearchBestCustomer=new JButton("Search Best Customer");
        btnSearchBestCustomer.setFont(new Font("",Font.PLAIN,15));
        btnSearchBestCustomer.setBounds(450, 150, 300, 40);
        btnSearchBestCustomer.setFocusable(false);
        btnSearchBestCustomer.addActionListener((ActionEvent evt) -> {
          
        }); 
        
        btnSearchOrderDetails=new JButton("Search Order Details");
        btnSearchOrderDetails.setFont(new Font("",Font.PLAIN,15));
        btnSearchOrderDetails.setBounds(450, 200, 300, 40);
        btnSearchOrderDetails.setFocusable(false);
        btnSearchOrderDetails.addActionListener(evt ->{
           new SearchOrderDetails();
        });
        
        btnSearchCustomer=new JButton("Seatch Customer");
        btnSearchCustomer.setFont(new Font("",Font.PLAIN,15));
        btnSearchCustomer.setBounds(450, 250, 300, 40);
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.addActionListener(evt ->{
            
        });
        
        btnBack=new JButton("Back");
        btnBack.setFont(new Font("",Font.PLAIN,15));
        btnBack.setBounds(650,400,100,30);
        btnBack.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
                
                dispose();   
           }
       });
        
        add(lblSearch);
        
        add(btnBack);
        add(btnSearchBestCustomer);
        add(btnSearchOrderDetails);
        add(btnSearchCustomer);
    }
}
