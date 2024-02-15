/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Chamindu
 */
public class HomePage extends JFrame {
    
    private JButton btnPlaceOrder;
    private JButton btnSearch;
    private JButton btnViewOrder;
    private JButton btnUpdateOrder;
    private JButton btnExit;
    
    private JLabel lblHome;
    
    public HomePage(){
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        getContentPane().setBackground(Color.WHITE );
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        
        
        
        btnPlaceOrder=new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("",Font.PLAIN,15));
        btnPlaceOrder.setBounds(450, 150, 300, 40);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt ->{
            new PlaceOrderPage();
        });
        
        btnSearch=new JButton("Search");
        btnSearch.setFont(new Font("",Font.PLAIN,15));
        btnSearch.setBounds(450, 200, 300, 40);
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(evt ->{
            new SearchPage();
        });
        
        btnViewOrder=new JButton("View Orders");
        btnViewOrder.setFont(new Font("",Font.PLAIN,15));
        btnViewOrder.setBounds(450, 250, 300, 40);
        btnViewOrder.setFocusable(false);
        btnViewOrder.addActionListener(evt ->{
            
        });
        
        btnUpdateOrder=new JButton("Update order");
        btnUpdateOrder.setFont(new Font("",Font.PLAIN,15));
        btnUpdateOrder.setBounds(450, 300, 300, 40);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.addActionListener(evt ->{
            
        });
        
        btnExit=new JButton("EXIT");
        btnExit.setFont(new Font("",Font.PLAIN,15));
        btnExit.setBounds(550, 370, 100, 40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt ->{
            System.exit(0);
        });
        
        lblHome = new JLabel();
        lblHome.setText("Home Page");
        lblHome.setFont(new Font("",Font.PLAIN,40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(400,0,400,70);
        
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(176, 51, 51));
        lblHome.setOpaque(true);
        
        
        add(lblHome);
        
        add(btnPlaceOrder);
        add(btnSearch);
        add(btnViewOrder);
        add(btnUpdateOrder);
        add(btnExit);
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../images/cover.png")));
        
	}


}
