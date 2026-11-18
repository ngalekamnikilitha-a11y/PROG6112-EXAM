/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mattress;

/**
 *
 * @author ngale
 */
import java.util.Scanner;

public class Mattress {
   

   public static void main(String[] var0) {
      String[] var1 = new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
      byte var2 = 3;
      int[][] var3 = new int[var1.length][var2];
      var var4 = new Scanner(System.in);

      try {
         for(int var5 = 0; var5 < var1.length; ++var5) {
            for(int var6 = 0; var6 < var2; ++var6) {
               System.out.print("Enter number of sales for month " + (var6 + 1) + " for " + var1[var5] + " mattress: ");

               while(!var4.hasNextInt()) {
                  System.out.println("Please enter a whole number.");
                  var4.next();
                  System.out.print("Enter number of sales for month " + (var6 + 1) + " for " + var1[var5] + " mattress: ");
               }

               var3[var5][var6] = var4.nextInt();
               if (var3[var5][var6] < 0) {
                  System.out.println("Sales cannot be negative.");
                  --var6;
               }
            }

            System.out.println();
         }
      } catch (Throwable var8) {
         try {
            var4.close();
         } catch (Throwable var7) {
            var8.addSuppressed(var7);
         }

         throw var8;
      }

      var4.close();
      Product var9 = new Product(var1, var3);
      PrintProduct var10 = new PrintProduct(var9);
      var10.PrintHeader();
      var10.PrintTotalProductSales();
      var10.PrintAverageProductSales();
      var10.PrintMostPopularProduct();
   }
}
