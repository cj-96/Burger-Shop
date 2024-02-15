/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.OrderList;
import Model.OrderDetails;
import javax.swing.text.View;

/**
 *
 * @author Chamindu
 */
public class OrderController {
    public static OrderList list  = new OrderList();
	
    
    
	// generate order Id
    public static String generateOrderId() {
            if (list.size()==0){
                    return "O001";
            }
            String lastOrderId = list.get(list.size()-1).getOrderId();
            int number = Integer.parseInt(lastOrderId.split("O")[1]); //1
            number++;//2
            return String.format("O%03d",number); //printf("",) //B0002
    }
    public static String generateCustomerId() {
            if (list.size()==0){
                    return "C001";
            }
            String lastOrderId = list.get(list.size()-1).getCustomerId();
            int number = Integer.parseInt(lastOrderId.split("C")[1]); //1
            number++;//2
            return String.format("C%03d",number); //printf("",) //B0002
    }

    // validation Customer ID
    public static boolean validationcustomerId(String customerId) {
    if (customerId.length() == 10) {
        if (customerId.startsWith("0")) {
            try {
                int i = Integer.parseInt(customerId);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }
    return false;
}

// view orders details
    public static String viewOrderDetails(int i){
            String line = String.format("%1s%-10s%-15s%-15s%-10d%8.2f", " ", list.get(i).getOrderId(), list.get(i).getCustomerId(),
                                                                    list.get(i).getCustomerName(), list.get(i).getOrderQTY(), list.get(i).getOrderValue());
            return line;
    }

    //searching for customer ID
    public static String isExistCustomer(String data){
            String name="";
            for(int i=0 ; i < list.size() ; i++){
                    if(data.equals(list.get(i).getCustomerId())){
                            name=list.get(i).getCustomerName();
                            break;
                    }
            }
            return name;
    }
     public static boolean isExist(String data){
            
            for(int i=0 ; i < list.size() ; i++){
                    if(data.equals(list.get(i).getOrderId())){
                            return true;
                    }
            }
            return false;
    }

    //add order
    public static void add(OrderDetails data){
            list.add(data);

    }

    public static OrderDetails[] toArray(){
            return list.toArray();
    }

//	public static OrderDetails[] addUniqueValuesToArray(OrderDetails[] orderArray){
//		OrderDetails[] sortOrderArray = new OrderDetails[0];
//		for (int i = 0; i < orderArray.length; i++) {
//			boolean isExist = false;
//			for (int j = 0; j < sortOrderArray.length; j++) {
//                if (sortOrderArray[j].getCustomerId().equals(orderArray[i].getCustomerId())) {
//                    if (orderArray[i].getOrderStatus()!=View.CANCEL){
//						sortOrderArray[j].setOrderValue(sortOrderArray[j].getOrderValue()+orderArray[i].getOrderValue());
//					}
//                    isExist = true;
//                }
//            }
//            if (!isExist) {
//				OrderDetails[] tempSortOrderArray = new OrderDetails[sortOrderArray.length+1];
//                for (int j = 0; j < sortOrderArray.length; j++) {
//					tempSortOrderArray[j]=new OrderDetails(
//						sortOrderArray[j].getOrderId(),
//						sortOrderArray[j].getCustomerId(),
//						sortOrderArray[j].getCustomerName(),
//						sortOrderArray[j].getOrderStatus(),
//						sortOrderArray[j].getOrderQTY(),
//						sortOrderArray[j].getOrderValue()
//					);
//                }
//                tempSortOrderArray[tempSortOrderArray.length-1]= new OrderDetails(
//					orderArray[i].getOrderId(),
//					orderArray[i].getCustomerId(),
//					orderArray[i].getCustomerName(),
//					orderArray[i].getOrderStatus(),
//					orderArray[i].getOrderQTY(),
//					orderArray[i].getOrderValue()	
//                );
//                sortOrderArray=tempSortOrderArray;
//            }
//        }
//        return sortOrderArray;
//	}

    public static OrderDetails[] sortArray(OrderDetails[] sortOrderArray){
            for (int i = 1; i < sortOrderArray.length; i++) {
        for (int j = 0; j < i; j++) {
            if (sortOrderArray[j].getOrderValue() < sortOrderArray[i].getOrderValue()) {
                                    String temp = sortOrderArray[j].getCustomerId();
                                    sortOrderArray[j].setCustomerId(sortOrderArray[i].getCustomerId());
                                    sortOrderArray[i].setCustomerId(temp);

                                    temp = sortOrderArray[j].getCustomerName();
                                    sortOrderArray[j].setCustomerName(sortOrderArray[i].getCustomerName());
                                    sortOrderArray[i].setCustomerName(temp);

                                    double tempd = sortOrderArray[j].getOrderValue();
                                    sortOrderArray[j].setOrderValue(sortOrderArray[i].getOrderValue());
                                    sortOrderArray[i].setOrderValue(tempd);
                            }
                    }
            }
            return sortOrderArray;
    }

	public static Object [] getOrderDetail(String orderId){
		
                
                Object [] tempOrder = new Object[6];
		for (int i = 0; i < list.size() ; i++) {
			if (orderId.equals(list.get(i).getOrderId())) {
				String status = "";
                                switch (list.get(i).getOrderStatus()) {
					case 0:
						status = "Cancel";
						break;
                                        case 1:
						status = "Preparing";
						break;
					case 2:
						status = "Delivered";
						break;
				}
                            
                            tempOrder[0] = list.get(i).getOrderId();
                            tempOrder[1] = list.get(i).getCustomerId();
                            tempOrder[2] = list.get(i).getCustomerName();
                            tempOrder[3] = list.get(i).getOrderQTY();
                            tempOrder[4] = list.get(i).getOrderValue();
                            tempOrder[5] = status;
                           
                            break;
                        }
		}
		return tempOrder;
	}

    public static OrderDetails getOrder(int index){
            return list.get(index);
    }

    //size of linked list
    public static int size(){
            return list.size();
    }
    
    

    

  
}
