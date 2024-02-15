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
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 *
 * @author Chamindu
 */
public class PlaceOrderPage extends JFrame {
    
    private JLabel lblPlaceOrder;
    
    private JLabel lblOrderId;
    private JLabel lblCustomerId;
    private JLabel lblOrderQty;
    private JLabel lblOrderStatus;
    private JLabel lblError;
    
    private JTextField txtCustomerId;
    private JTextField txtOrderQty;
    
    private JButton btnPlaceOrder;
    private JButton btnHomePage;
    private JButton btnCancel;
    
    private JLabel lblAmount;
    private JLabel lblNetAmount;
    
    private int qty;
    private double amount;
    private String orderId;
    private String customerId;
    
    public PlaceOrderPage(){
        
        
        
        setTitle("Place Order Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        getContentPane().setBackground(Color.WHITE );
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        
        lblPlaceOrder = new JLabel();
        lblPlaceOrder.setText("Place Order");
        lblPlaceOrder.setFont(new Font("",Font.PLAIN,40));
        lblPlaceOrder.setForeground(Color.white);
        lblPlaceOrder.setBounds(00,0,800,70);
            
        lblPlaceOrder.setVerticalAlignment(JLabel.CENTER);
        lblPlaceOrder.setHorizontalAlignment(JLabel.CENTER);
        lblPlaceOrder.setBackground(new Color(176, 51, 51));
        lblPlaceOrder.setOpaque(true);
        
        
        orderId = OrderController.generateOrderId();
        lblOrderId = new JLabel();
        lblOrderId.setText("Order Id :      "+orderId);
        lblOrderId.setFont(new Font("",Font.PLAIN,15));
        lblOrderId.setBounds(50,150,150,70);
        
        lblCustomerId = new JLabel();
        lblCustomerId.setText("Customer Id :   ");
        lblCustomerId.setFont(new Font("",Font.PLAIN,15));
        lblCustomerId.setBounds(50,200,150,70);
       
        lblOrderQty = new JLabel();
        lblOrderQty.setText("Order QTY :   ");
        lblOrderQty.setFont(new Font("",Font.PLAIN,15));
        lblOrderQty.setBounds(50,300,150,70);
        
        lblOrderStatus = new JLabel();
        lblOrderStatus.setText("Order Status :   ");
        lblOrderStatus.setFont(new Font("",Font.PLAIN,15));
        lblOrderStatus.setBounds(50,350,150,70);
        
        lblNetAmount = new JLabel();
        lblNetAmount.setText("NET Amount :   ");
        lblNetAmount.setFont(new Font("",Font.PLAIN,15));
        lblNetAmount.setBounds(450,350,150,40);
        
        
        lblAmount = new JLabel();
        lblAmount.setText("0.00");
        lblAmount.setFont(new Font("",Font.PLAIN,15));
        lblAmount.setBounds(600,350,150,40);
        lblAmount.setForeground(Color.red);
        
        customerId = OrderController.generateCustomerId();
        txtCustomerId=new JTextField(customerId);
        txtCustomerId.setEditable(false);
        txtCustomerId.setFont(new Font("",Font.PLAIN,15));
        txtCustomerId.setBounds(150,220,150,30);
        
        txtOrderQty=new JTextField(10);
        txtOrderQty.setFont(new Font("",Font.PLAIN,15));
        txtOrderQty.setBounds(150,320,150,30); 
        txtOrderQty.getDocument().addDocumentListener(new DocumentListener() {
        @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
          
            }
          
        });
        
        lblError = new JLabel();
        lblError.setText("QTY value must be atleast 1");
        lblError.setFont(new Font("",Font.PLAIN,15));
        lblError.setBounds(150,350,200,30);
        lblError.setForeground(Color.red);
        lblError.setVisible(false);
        
        btnPlaceOrder=new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("",Font.PLAIN,15));
        btnPlaceOrder.setBackground(new Color(11,218,81));
        btnPlaceOrder.setBounds(450, 150, 300, 40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(qty > 0){
                    OrderDetails order = new OrderDetails(orderId,customerId,"Chaminud",1,qty,amount);
                    OrderController.add(order);
                    new PlaceOrderPage();
                    dispose();
                }else{
                    lblError.setVisible(true);
                }
            }
            
        });
                
                
        btnHomePage=new JButton("Back To Home Page");
        btnHomePage.setFont(new Font("",Font.PLAIN,15));
        btnHomePage.setBounds(450, 200, 300, 40);
        btnHomePage.setFocusable(false);
        btnHomePage.addActionListener(evt ->{
           this.dispose();
        });
        
        btnCancel=new JButton("Cancel");
        btnCancel.setFont(new Font("",Font.PLAIN,15));
        btnCancel.setBounds(450, 250, 300, 40);
        btnCancel.setFocusable(false);
        btnCancel.addActionListener(evt ->{
            
        });
        
        
     
        
    
        
        add(lblPlaceOrder);
        
        add(lblOrderId);
        add(lblCustomerId);
        add(lblOrderQty);
        add(lblOrderStatus);
        add(lblError);
        
        add(txtCustomerId);
        add(txtOrderQty);
        
        add(txtCustomerId);
        
        add(btnPlaceOrder);
        add(btnHomePage);
        add(btnCancel);
        
        add(lblNetAmount);
        add(lblAmount);
    }
        public void updateLabel() { 
  
            try {
                this.qty = parseInt(txtOrderQty.getText());
                this.amount = qty*500;
                String formattedAmount = String.format("%.2f", amount);
                lblAmount.setText(formattedAmount);
            } catch (NumberFormatException e) {

                lblAmount.setText("0.00");
            }
            
        }
}
