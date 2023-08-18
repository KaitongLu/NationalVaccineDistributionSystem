/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.Customer;

import java.util.ArrayList;

/**
 *
 * @author zwei
 */
public class CustomerCatalog {

    ArrayList<Customer> customerList;

    public CustomerCatalog() {
        customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public Customer addCustomer() {
        Customer cus = new Customer();
        customerList.add(cus);
        return cus;
    }
}
