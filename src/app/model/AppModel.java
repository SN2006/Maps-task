package app.model;

import app.entity.Product;
import app.exception.NotFoundIdException;

import java.util.HashMap;
import java.util.Map;

public class AppModel {

    private Map<Integer, Product> getData(){
        Map<Integer, Product> productMap = new HashMap<>();
        productMap.put(1054, new Product("apple", 1.99, 34));
        productMap.put(1055, new Product("banana", 2.19, 23));
        productMap.put(1056, new Product("onion", 3.49, 45));
        productMap.put(1057, new Product("orange", 5.49, 12));
        return productMap;
    }

    public Map<Integer, Product> getProductsMap(){
        return getData();
    }

    public Product getProductById(int id) throws NotFoundIdException {
        Map<Integer, Product> data = getData();
        if (!data.containsKey(id)) throw new NotFoundIdException("Product with this id not found!");
        return data.get(id);
    }

}
