/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattress;

/**
 *
 * @author ngale
 */
public class PrintProduct {
   private final IProducts products;

   public PrintProduct(IProducts var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Products must not be null");
      } else {
         this.products = var1;
      }
   }

   public void PrintHeader() {
      System.out.println();
      System.out.println("PRODUCT SALES REPORT - 2026");
      System.out.println("**********************************");
   }

   public void PrintTotalProductSales() {
      System.out.println("TOTAL PRODUCT SALES: " + this.products.GetTotalProductsSold());
   }

   public void PrintAverageProductSales() {
      System.out.println("AVERAGE PRODUCT SALES: " + Math.round(this.products.GetAverageProductSold()));
   }

   public void PrintMostPopularProduct() {
      System.out.println("MOST POPULAR PRODUCT: " + this.products.GetMostPopularProduct());
   }
}
