package com.batch.example.BootBatchExample.config;

import com.batch.example.BootBatchExample.model.Product;
import org.springframework.batch.item.ItemProcessor;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
    @Override
    public Product process(Product item) throws Exception {
        //We added try catch block as we were getting the error in parsing the first row of csv file
        //as in first row everything is String
        try{
            int discountPer = Integer.parseInt(item.getDiscount().trim());
            double originalPrice = Double.parseDouble(item.getPrice());
            double discount = (discountPer/100)*discountPer;
            double finalPrice = originalPrice-discount;
            item.setDiscountedPrice(String.valueOf(finalPrice));
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        return item;
    }
}
