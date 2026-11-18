/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



/**
 *
 * @author ngale
 */
import mattress.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private Product createProduct() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };
        return new Product(names, sales);
    }

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, createProduct().GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, createProduct().GetAverageProductSold(), 0.001);
    }
}
