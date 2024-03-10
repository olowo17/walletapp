package com.interswitch.wallet.application;

import com.interswitch.wallet.dto.Cart;
import com.interswitch.wallet.model.Product;
import com.interswitch.wallet.service.WalletService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        WalletService walletService = new WalletService();

        boolean exit = false;
        String userInput;

        System.out.println("Welcome to WalletApp!");

        do {
            System.out.println("Main Menu:");
            System.out.println("1. Upload new Product");
            System.out.println("2. Restock Product");
            System.out.println("3. View Product Details");
            System.out.println("4. Register Customer");
            System.out.println("5. Fund Wallet");
            System.out.println("6. Add Product to Cart");
            System.out.println("7. Checkout to pay");
            System.out.println("8. View available Products");
            System.out.println("9. Show cart");
            System.out.println("10. Display Customer by Id");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            userInput = scanner.next();

            switch (userInput) {
                case "1":
                    System.out.println("Add Product:");
                    System.out.println("Enter product name: ");
                    String name = scanner.next();

                    System.out.println("Enter product description: ");
                    String description = scanner.next();

                    System.out.println("Enter product unit price: ");
                    Double unitPrice = scanner.nextDouble();

                    System.out.println("Enter product quantity: ");
                    int quantityInStock = scanner.nextInt();

                    Product product = new Product(name, description, unitPrice, quantityInStock);
                    List<Product> products = new ArrayList<>();
                    products.add(product);
                    walletService.populateProductCatalog(products);

                    System.out.println("Product added successfully!");
                    break;

                case "2":
                    System.out.println("Restock Product:");
                    LinkedList<Product> stock = walletService.getProductCatalog();
                    stock.forEach(s-> System.out.println(s));
                    System.out.println("Enter product id to restock: ");
                    int productId = scanner.nextInt();
                    System.out.println("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();

                    walletService.restockProduct(productId, productQuantity);
                    System.out.println("Product restocked successfully!");
                    break;

                case "3":
                    System.out.println("filter Product by Id:");
                    System.out.println("Enter product id: ");
                    int productIdToView = scanner.nextInt();
                    System.out.println("Product details: " + walletService.getProductById(productIdToView));
                    break;

                case "4":
                    System.out.println("Register Customer:");
                    System.out.println("Enter your name: ");
                    String customerName = scanner.next();

                    System.out.println("Enter your phone number: ");
                    String customerPhoneNumber = scanner.next();

                    System.out.println("Enter your address: ");
                    String customerAddress = scanner.next();

                    String walletId = walletService.registerCustomer(customerName, customerPhoneNumber, customerAddress);
                    System.out.println("Hello " + customerName + "! Thank you for signing up. Your wallet ID is: " + walletId);
                    System.out.println(walletService.getCustomerByWallet(walletId).toString());
                    break;

                case "5":
                    System.out.println("Fund Wallet:");
                    System.out.println("Enter your wallet ID: ");
                    String walletIdToFund = scanner.next();
                    System.out.println("Enter the amount you wish to fund your wallet with: ");
                    double walletAmount = scanner.nextDouble();
                    walletService.fundCustomerWallet(walletIdToFund, walletAmount);
                    System.out.println("Your wallet has been funded with " + walletAmount);
                    break;

                case "6":
                    System.out.println("Add Product to Cart:");
                    System.out.println("Enter the product ID you wish to add to your cart: ");
                    int cartProductId = scanner.nextInt();
                    System.out.println("Enter the quantity of the product: ");
                    int cartProductQuantity = scanner.nextInt();
                    walletService.addProductToCart(cartProductId, cartProductQuantity);
                    System.out.println("Product added to your cart successfully!");
                    break;

                case "7":
                    System.out.println("Checkout:");
                    System.out.println("Enter your wallet ID: ");
                    String checkoutWalletId = scanner.next();
                    List <Cart> myCartItems =walletService.checkOutProduct(checkoutWalletId);
                    System.out.println("Checkout details");
                    myCartItems.forEach(item-> System.out.println(item));
                    break;

                case "8":
                    System.out.println("View all products:");
                   LinkedList<Product> details= walletService.getProductCatalog();
//                   details.forEach(System.out::println);
                    details.forEach(System.out::println);
//                    System.out.println("All products: " + walletService.getProductCatalog());
                    break;

                case "9":
                    System.out.println("Display Products in cart:");
                    List<Cart> productInCart=  walletService.getMyProductCart();
                   productInCart.forEach(p-> System.out.println(p));
                    break;

                case "10":
                    System.out.println("Enter wallet Id to see customer details");
                    String walletID = scanner.next();
                    System.out.println(walletService.getCustomerByWallet(walletID));
                    break;

                case "0":
                    System.out.println("Thank you for using WalletApp. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!exit);
    }
}
