//package com.interswitch.wallet.application;
//
//import com.interswitch.wallet.model.Product;
//import com.interswitch.wallet.service.WalletService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        WalletService walletService = new WalletService();
//        RegistrationPage register = new RegistrationPage();
//        ProductCatalogPage productCatalogPage = new ProductCatalogPage();
//        Scanner userInput = new Scanner(System.in);
//
//        try {
//            while (true) {
//                System.out.println("Choose an option:");
//                System.out.println("To Create a new customer Enter 1");
//                System.out.println("To Display all customers Enter 2");
//                System.out.println("To Display available products Enter 3");
//                System.out.println("To Exit enter 0");
//                int response = Integer.parseInt(userInput.nextLine());
//                switch (response) {
//                    case 1:
//                        System.out.println("Enter customer name:");
//                        String name = userInput.nextLine();
//
//                        System.out.println("Enter Customer Phone number: ");
//                        String phoneNumber = userInput.nextLine();
//
//                        System.out.println("Enter customer address: ");
//                        String address = userInput.nextLine();
//
//                        walletService.registerCustomer(name, phoneNumber, address);
//                        System.out.println("Customer details inserted successfully");
//                        break;
//
//                    case 2:
//                        System.out.println("Enter wallet Id to see all customers");
//                        String customerID = userInput.nextLine();
//                        walletService.getCustomerByWallet(customerID);
//                        break;
//
//                    case 3:
//                        System.out.println(walletService.getProductCatalog());
//                        System.out.println("Enter an option to continue");
//                        System.out.println("Enter 5 to buy product or 6 to exist");
//                        int buyProduct = Integer.parseInt(userInput.nextLine());
//                        switch (buyProduct) {
//                            case 6:
//                                System.out.println("Thanks for stopping by.");
//                                System.exit(0);
//                                break;
//                            case 5:
//                                try{
//                                    while (true){
//                                        System.out.println("Enter 8 keep shopping or 7 to checkout");
//                                        int res = userInput.nextInt();
//                                        switch (res) {
//                                            case 7:
//                                                System.out.println("Enter wallet id to checkout");
//                                                String walletId = userInput.nextLine();
//                                                walletService.checkOutProduct(walletId);
//                                                break; // Added break statement to exit the inner switch case
//                                            case 8:
//                                                System.out.println("Enter product ID");
//                                                int pID = userInput.nextInt();
//                                                System.out.println("Enter quantity");
//                                                int qty = userInput.nextInt();
//                                                walletService.addProductToCart(pID, qty);
//                                                break;
//
//                                            default:
//                                                System.out.println("invalid input");
//                                        }
//                                    }
//                                }catch (Exception e) {
//                                    System.out.println("An error occurred: " + e.getMessage());
//                                    e.printStackTrace();
//                                }
//                        }
//                    case 0:
//                        System.out.println("Exiting...");
//                        System.exit(0);
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Try again.");
//                        break;
//                }
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid input. Please enter a number.");
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//            e.printStackTrace();
//        }
//
////        Add Product to database
//        try {
//            while (true) {
//                System.out.println("To Add new product Enter 1");
//                System.out.println("To Exit enter 0");
//                int response = Integer.parseInt(userInput.nextLine());
//
//                switch (response){
//                    case 1:
//                        System.out.println("Enter Product Name");
//                        String productName = userInput.nextLine();
//                        System.out.println("Enter product description");
//                        String productDescription = userInput.nextLine();
//                        System.out.println("Unit Price");
//                        Double unitPrice = Double.valueOf(userInput.nextLine());
//                        System.out.println("Quantity");
//                        int quantity = Integer.parseInt(userInput.nextLine());
//
//
//
//                        Product product = new Product(productName, productDescription, unitPrice, quantity);
//                        List<Product> products = new ArrayList<>();
//                        products.add(product);
//                        walletService.populateProductCatalog(products);
//                        System.out.println("Product added successfully");
//                        break;
//                    case 0:
//                        System.out.println("Exiting...");
//                        System.exit(0);
//                        break;
//                    default:
//                        System.out.println("Invalid choice. Try again.");
//                        break;
//                }
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid input. Please enter a number.");
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//            e.printStackTrace();
//        }
//
//
//
//    }
//}
