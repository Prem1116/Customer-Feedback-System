package com.feedbacksystem.app;

import com.feedbacksystem.model.Customer;
import com.feedbacksystem.model.Feedback;
import com.feedbacksystem.model.Product;
import com.feedbacksystem.service.CustomerService;
import com.feedbacksystem.service.FeedbackService;
import com.feedbacksystem.service.ProductService;
import com.feedbacksystem.util.LoggerUtil;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        CustomerService cs = new CustomerService();
        FeedbackService fs = new FeedbackService();
        ProductService ps = new ProductService();
        Scanner sc = new Scanner(System.in);

        LoggerUtil.logger.info("=== Welcome to Customer Feedback System ===");

        while (true) {
            System.out.println("\n====== MAIN MENU ======");
            System.out.println();
            System.out.println("1. Customer Operations");
            System.out.println("2. Product Operations");
            System.out.println("3. Feedback Operations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {

                // ========== CUSTOMER MENU ==========
                case 1:
                    System.out.println("\n--- Customer Menu ---");
                    System.out.println();
                    System.out.println("1. Add Customer");
                    System.out.println("2. Update Customer");
                    System.out.println("3. Delete Customer");
                    System.out.println("4. View All Customers");
                    System.out.print("Enter choice: ");
                    int cChoice = sc.nextInt();
                    sc.nextLine();

                    switch (cChoice) {
                        case 1:
                            Customer c = new Customer();
                            System.out.print("Enter Name: ");
                            c.setName(sc.nextLine());
                            System.out.print("Enter Email: ");
                            c.setEmail(sc.nextLine());
                            System.out.print("Enter Phone Number: ");
                            c.setPhone(sc.nextLine());
                            System.out.print("Enter Gender: ");
                            c.setGender(sc.nextLine());
                            cs.registerCustomer(c);
                            break;

                        case 2:
                            System.out.print("Enter Customer ID to update: ");
                            int cid = sc.nextInt();
                            sc.nextLine();
                            Customer updateC = new Customer();
                            updateC.setCustomerId(cid);
                            System.out.print("Enter New Name: ");
                            updateC.setName(sc.nextLine());
                            System.out.print("Enter New Email: ");
                            updateC.setEmail(sc.nextLine());
                            System.out.print("Enter New Phone: ");
                            updateC.setPhone(sc.nextLine());
                            System.out.print("Enter New Gender: ");
                            updateC.setGender(sc.nextLine());
                            cs.updateCustomer(updateC);
                            break;

                        case 3:
                            System.out.print("Enter Customer ID to delete: ");
                            int deleteCid = sc.nextInt();
                            cs.deleteCustomer(deleteCid);
                            break;

                        case 4:
                            List<Customer> customers = cs.getAllCustomers();
                            System.out.println("\n--- Customer List ---");
                            for (Customer cust : customers) {
                                System.out.println(cust);
                            }
                            break;

                        default:
                            System.out.println("Invalid option!");
                    }
                    break;


                // ========== PRODUCT MENU ==========
                case 2:
                    System.out.println("\n--- Product Menu ---");
                    System.out.println();
                    System.out.println("1. Add Product");
                    System.out.println("2. Update Product");
                    System.out.println("3. Delete Product");
                    System.out.println("4. View All Products");
                    System.out.print("Enter choice: ");
                    int pChoice = sc.nextInt();
                    sc.nextLine();

                    switch (pChoice) {
                        case 1:
                            Product p = new Product();
                            System.out.print("Enter Product Name: ");
                            p.setName(sc.nextLine());
                            System.out.print("Enter Description: ");
                            p.setDescription(sc.nextLine());
                            System.out.print("Enter Price: ");
                            p.setPrice(sc.nextDouble());
                            ps.addProduct(p);
                            break;

                        case 2:
                            System.out.print("Enter Product ID to update: ");
                            int pid = sc.nextInt();
                            sc.nextLine();
                            Product updateP = new Product();
                            updateP.setProductId(pid);
                            System.out.print("Enter New Product Name: ");
                            updateP.setName(sc.nextLine());
                            System.out.print("Enter New Description: ");
                            updateP.setDescription(sc.nextLine());
                            System.out.print("Enter New Price: ");
                            updateP.setPrice(sc.nextDouble());
                            ps.updateProduct(updateP);
                            break;

                        case 3:
                            System.out.print("Enter Product ID to delete: ");
                            int deletePid = sc.nextInt();
                            ps.deleteProduct(deletePid);
                            break;

                        case 4:
                            List<Product> products = ps.getAllProducts();
                            System.out.println("\n--- Product List ---");
                            for (Product prod : products) {
                                System.out.println(prod);
                            }
                            break;

                        default:
                            System.out.println("Invalid option!");
                    }
                    break;


                // ========== FEEDBACK MENU ==========
                case 3:
                    System.out.println("\n--- Feedback Menu ---");
                    System.out.println("1. Add Feedback");
                    System.out.println("2. Update Feedback");
                    System.out.println("3. Delete Feedback");
                    System.out.println("4. View All Feedback");
                    System.out.print("Enter choice: ");
                    int fChoice = sc.nextInt();
                    sc.nextLine();

                    switch (fChoice) {
                        case 1:
                            Feedback f = new Feedback();
                            System.out.print("Enter Customer ID: ");
                            f.setCustomerId(sc.nextInt());
                            System.out.print("Enter Product ID: ");
                            f.setProductId(sc.nextInt());
                            sc.nextLine();
                            System.out.print("Enter Feedback Message: ");
                            f.setMessage(sc.nextLine());
                            System.out.print("Enter Rating (1–5): ");
                            f.setRating(sc.nextInt());
                            fs.addFeedback(f);
                            break;

                        case 2:
                            System.out.print("Enter Feedback ID to update: ");
                            int fid = sc.nextInt();
                            sc.nextLine();
                            Feedback updateF = new Feedback();
                            updateF.setFeedbackId(fid);
                            System.out.print("Enter New Message: ");
                            updateF.setMessage(sc.nextLine());
                            System.out.print("Enter New Rating (1–5): ");
                            updateF.setRating(sc.nextInt());
                            fs.updateFeedback(updateF);
                            break;

                        case 3:
                            System.out.print("Enter Feedback ID to delete: ");
                            int deleteFid = sc.nextInt();
                            fs.deleteFeedback(deleteFid);
                            break;

                        case 4:
                            List<Feedback> feedbacks = fs.getAllFeedback();
                            System.out.println("\n--- Feedback List ---");
                            for (Feedback fb : feedbacks) {
                                System.out.println(fb);
                            }
                            break;

                        default:
                            System.out.println("Invalid option!");
                    }
                    break;


                // ========== EXIT ==========
                case 4:
                    LoggerUtil.logger.info("Exiting application...");
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
