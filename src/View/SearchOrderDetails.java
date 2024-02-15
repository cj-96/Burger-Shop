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
import javax.swing.JTextField;

/**
 *
 * @author Chamindu
 */
public class SearchOrderDetails extends JFrame{
    
    private JLabel lblSearchOrderDetails;
    
    private JLabel lblOrderId;  
    private JTextField txtOrderId;
    private JButton btnOrderId;
    private JButton btnBack;
    
    private JLabel lblCustomerId;
    private JLabel lblCustomerName;
    private JLabel lblOrderQty;
    private JLabel lblOrderStatus;
    private JLabel lblNetAmount;
    
    private String orderId;
    private JLabel lblError;
    
     public SearchOrderDetails(){
         
        setTitle("Search Order Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        getContentPane().setBackground(Color.WHITE );
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        
        lblSearchOrderDetails = new JLabel();
        lblSearchOrderDetails.setText("Place Order");
        lblSearchOrderDetails.setFont(new Font("",Font.PLAIN,40));
        lblSearchOrderDetails.setForeground(Color.white);
        lblSearchOrderDetails.setBounds(00,0,800,70);
            
        lblSearchOrderDetails.setVerticalAlignment(JLabel.CENTER);
        lblSearchOrderDetails.setHorizontalAlignment(JLabel.CENTER);
        lblSearchOrderDetails.setBackground(new Color(176, 51, 51));
        lblSearchOrderDetails.setOpaque(true); 
        
        
        lblOrderId = new JLabel();
        lblOrderId.setText("Order Id :      ");
        lblOrderId.setFont(new Font("",Font.PLAIN,15));
        lblOrderId.setBounds(50,100,150,70);
        
        lblError = new JLabel();
        lblError.setText("Order Id Invalid");
        lblError.setFont(new Font("",Font.PLAIN,15));
        lblError.setForeground(Color.red);
        lblError.setBounds(260,100,150,70);
        lblError.setVisible(false);
        
        txtOrderId=new JTextField("");
        txtOrderId.setFont(new Font("",Font.PLAIN,15));
        txtOrderId.setBounds(150,120,100,30);
        
        
        btnOrderId=new JButton("Search");
        btnOrderId.setFont(new Font("",Font.PLAIN,15));
        btnOrderId.setBounds(150,170,100,30);
        btnOrderId.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
                orderId = txtOrderId.getText();
               
                if(OrderController.isExist(orderId)){
                    
                    OrderController.getOrderDetail(orderId);
                    Object[] order = new Object [6];
                    order = OrderController.getOrderDetail(orderId);
                
                    lblError.setVisible(false);
                    lblCustomerId.setText("Customer Id :   "+order[1]);
                    lblCustomerName.setText("Customer Name :   "+order[2]);
                    lblOrderQty.setText("Order QTY :   "+order[3]);
                    lblNetAmount.setText("NET Amount :   "+order[4]);
                    lblOrderStatus.setText("Order Status :   "+order[5]);
                }else{
                    lblError.setVisible(true);
               }
           }
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
              
        lblCustomerId = new JLabel();
        lblCustomerId.setFont(new Font("",Font.PLAIN,15));
        lblCustomerId.setBounds(50,200,150,70);
       
        lblCustomerName = new JLabel();
        lblCustomerName.setFont(new Font("",Font.PLAIN,15));
        lblCustomerName.setBounds(50,250,150,70);
        
        lblOrderQty = new JLabel();
        lblOrderQty.setFont(new Font("",Font.PLAIN,15));
        lblOrderQty.setBounds(50,300,150,70);
        
        lblNetAmount = new JLabel();
        lblNetAmount.setFont(new Font("",Font.PLAIN,15));
        lblNetAmount.setBounds(50,350,150,70);
        
        lblOrderStatus = new JLabel();
        lblOrderStatus.setFont(new Font("",Font.PLAIN,15));
        lblOrderStatus.setBounds(50,400,150,70);
        
        add(lblCustomerId);
        add(lblCustomerName); 
        add(lblOrderQty);
        add(lblNetAmount);
        add(lblOrderStatus); 
        
        add(btnOrderId);
        add(lblError);
        add(lblOrderId); 
        add(txtOrderId);
        
        add(btnBack);
        
        add(lblSearchOrderDetails);
        
     }
}
