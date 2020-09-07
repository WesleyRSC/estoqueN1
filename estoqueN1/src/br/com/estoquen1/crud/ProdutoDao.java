package br.com.estoquen1.crud;

import com.google.gson.Gson;
import br.com.estoquen1.model.Produto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class ProdutoDao {
    
    public static final String productPath = "products_stock.txt";
    
    public static Map<String, Produto> getAllProduct() {
        try {
            //Checking file
            if (createProductFile()) {
                //Reading file
                String content = new String(Files.readAllBytes(Paths.get(productPath)));
                
                //Preparing product map (CodeItem to Product)
                Map<String, Produto> productMap = new HashMap<>();
                if (!content.isEmpty()) {
                    //Converting JSON content into a Product list
                    Gson gson = new Gson();
                    Produto[] products = gson.fromJson(content, Produto[].class);

                    for (Produto product : products) {
                        productMap.put(product.getCodItem(), product);
                    }
                }
                return productMap;
            } else {
                return null;
            }
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler arquivo de estoque de produtos.");
            return null;
        }
    }
    
    public static boolean createProductFile() {
        try {
            //Creating file if it doesn't already exist
            File myObj = new File(productPath);
            myObj.createNewFile();
            return true;
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao verificar arquivo de estoque de produtos.");
            return false;
        }
    }
    
    public static Produto getProductByItemCode(String itemCode) {
        Map<String, Produto> productMap = getAllProduct();
        //Get product by item code key
        return productMap.get(itemCode);
    }
    
    public static boolean insertProduct(Produto product) {
        Map<String, Produto> productMap = getAllProduct();
        //Checking if the key (item code) already exists
        if (!productMap.containsKey(product.getCodItem())) {
            //Creating item into product map
            productMap.put(product.getCodItem(), product);
            
            try {
                Gson gson = new Gson();
                //Converting object to JSON and writing to the file
                FileWriter myWriter = new FileWriter(productPath);
                myWriter.write(gson.toJson(productMap.values()));
                myWriter.close();
                return true;
            } catch (IOException e) {
                System.out.println("Erro ao inserir produto.");
                return false;
            }
        } else {
            System.out.println("Códido do item já cadastrado!");
            return false;
        }
    }
    
    public static boolean updateProduct(Produto product) {
        Map<String, Produto> productMap = getAllProduct();
        //Checking if the key (item code) already exists
        if (productMap.containsKey(product.getCodItem())) {
            
            //Keeping entry date
            product.setDataEntrada(productMap.get(product.getCodItem()).getDataEntrada());
            
            //Overwriting item into product map
            productMap.put(product.getCodItem(), product);
            
            try {
                Gson gson = new Gson();
                //Converting object to JSON and writing to the file
                FileWriter myWriter = new FileWriter(productPath);
                myWriter.write(gson.toJson(productMap.values()));
                myWriter.close();
                return true;
            } catch (IOException e) {
                System.out.println("Erro ao atualizar produto.");
                return false;
            }
        } else {
            System.out.println("Códido do item não encontrado!");
            return false;
        }   
    }
    
    public static boolean deleteProduct(String itemCode) {
        Map<String, Produto> productMap = getAllProduct();
        //Checking if the key (item code) already exists
        if (productMap.containsKey(itemCode)) {
            //Removing product from map
            productMap.remove(itemCode);
            
            try {
                Gson gson = new Gson();
                //Converting object to JSON and writing to the file
                FileWriter myWriter = new FileWriter(productPath);
                myWriter.write(gson.toJson(productMap.values()));
                myWriter.close();
                return true;
            } catch (IOException e) {
                System.out.println("Erro ao deletar produto.");
                return false;
            }
        } else {
            System.out.println("Códido do item não encontrado!");
            return false;
        } 
    }
    
}
