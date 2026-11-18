/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mattress;

/**
 *
 * @author ngale
 */
import java.util.Arrays;

public class Product implements IProducts {
   private final String[] productNames;
   private final int[][] sales;

   public Product(String[] var1, int[][] var2) {
      if (var1 != null && var2 != null) {
         if (var1.length != var2.length) {
            throw new IllegalArgumentException("Each product must have a corresponding sales row");
         } else {
            this.productNames = (String[])Arrays.copyOf(var1, var1.length);
            this.sales = new int[var2.length][];

            for(int var3 = 0; var3 < var2.length; ++var3) {
               if (var2[var3] == null) {
                  throw new IllegalArgumentException("Sales rows must not be null");
               }

               if (this.productNames[var3] == null) {
                  throw new IllegalArgumentException("Product names must not be null");
               }

               this.sales[var3] = Arrays.copyOf(var2[var3], var2[var3].length);

               for(int var7 : this.sales[var3]) {
                  if (var7 < 0) {
                     throw new IllegalArgumentException("Sales values must not be negative");
                  }
               }
            }

         }
      } else {
         throw new IllegalArgumentException("Product names and sales must not be null");
      }
   }

   private int productTotal(int var1) {
      int var2 = 0;

      for(int var6 : this.sales[var1]) {
         var2 += var6;
      }

      return var2;
   }

   public int GetTotalProductsSold() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.sales.length; ++var2) {
         var1 += this.productTotal(var2);
      }

      return var1;
   }

   public double GetAverageProductSold() {
      int var1 = 0;

      for(int[] var5 : this.sales) {
         var1 += var5.length;
      }

      return var1 == 0 ? (double)0.0F : (double)this.GetTotalProductsSold() / (double)var1;
   }

   public String GetMostPopularProduct() {
      if (this.sales.length == 0) {
         return "N/A (0)";
      } else {
         int var1 = 0;

         for(int var2 = 1; var2 < this.sales.length; ++var2) {
            if (this.productTotal(var2) > this.productTotal(var1)) {
               var1 = var2;
            }
         }

         String var10000 = this.productNames[var1];
         return var10000 + " (" + this.productTotal(var1) + ")";
      }
   }
}
