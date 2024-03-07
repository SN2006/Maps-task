package app.controller;

import app.entity.Product;
import app.exception.NotFoundIdException;
import app.model.AppModel;
import app.view.AppView;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AppController {

    private final AppView view = new AppView();
    private final AppModel model = new AppModel();

    public void runApp(){
        view.getOutput(handleData());
    }

    private String handleData(){
        String selectedAction = view.selectAction();
        switch (selectedAction){
            case "1" -> {
                return getAllProducts();
            }
            case "2" -> {
                return getProductById();
            }
            default -> {
                return "You have chosen a non-existent option!";
            }
        }
    }

    private String getAllProducts(){
        Map<Integer, Product> productMap = model.getProductsMap();
        StringBuilder builderResult = new StringBuilder();
        AtomicInteger counter = new AtomicInteger();
        productMap.forEach((id, product) ->{
            builderResult.append(String.format("%d) id: %d, %s"
                    , counter.incrementAndGet(), id, product.toString()
            ));
            if (counter.get() != productMap.size()) builderResult.append("\n");
        });
        return builderResult.toString();
    }

    private String getProductById(){
        try {
            int productId = Integer.parseInt(view.getId());
            Product product = model.getProductById(productId);
            return String.format("id: %d, %s", productId, product);
        }catch (NumberFormatException e){
            return "You have entered invalid data!";
        }catch (NotFoundIdException e){
            return e.getMessage();
        }catch (Exception e){
            return "Something went wrong: " + e.getMessage();
        }
    }

}
