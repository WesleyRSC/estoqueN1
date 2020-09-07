package br.com.estoquen1.console;

import br.com.estoquen1.crud.ProdutoDao;
import br.com.estoquen1.model.ColorEnum;
import br.com.estoquen1.model.Produto;
import br.com.estoquen1.model.SizeEnum;
import java.util.Arrays;
import java.util.Scanner;

public class EstadoConsoleUpdateProduct extends MaquinaEstadoConsole{

    public final String INVALID_VALUE_MSG = "Valor inválido, digite novamente.";

    @Override
    public boolean Executa() {
        boolean sair = false;
        System.out.println("");
        System.out.println("*** Atualizar Produto ***");
        Produto product = new Produto();
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o código do item:");
        
        String codeItem = scan.nextLine();
        if (ProdutoDao.getProductByItemCode(codeItem) != null) {
            product.setCodItem(codeItem);
        } else {
            System.out.println("Item não existe!");
            Estoque.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
            return sair;
        }
        
        //Local da compra do produto
        System.out.println("Digite o local da compra:");
        String localCompra = "";
        while(localCompra.isEmpty()) {
            localCompra = scan.nextLine();
            if (localCompra.isEmpty()) {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        product.setLocalCompra(localCompra);

        //Tipo do produto
        System.out.println("Digite o tipo do produto:");
        String tipo = "";
        while(tipo.isEmpty()) {
            tipo = scan.nextLine();
            if (tipo.isEmpty()) {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        product.setTipo(tipo);

        //Marca do produto
        System.out.println("Digite a marca do produto:");
        String marca = "";
        while(marca.isEmpty()) {
            marca = scan.nextLine();
            if (marca.isEmpty()) {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        product.setMarca(marca);

        //Características do produto
        System.out.println("Digite as caracteristicas:");
        String caracteristicas = "";
        while(caracteristicas.isEmpty()) {
            caracteristicas = scan.nextLine();
            if (caracteristicas.isEmpty()) {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        product.setCaracteristicas(caracteristicas);
        
        //Tamanho do produto
        boolean validSize = false;
        String size = "";
        System.out.println("Digite o tamanho:");
        System.out.println("Opções: " + Arrays.asList(SizeEnum.values()));
        while(!validSize) {
            size = scan.nextLine();

            if (product.verifySizeEnum(size.toUpperCase())) {
                validSize = true;
            } else {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        product.setTamanho(SizeEnum.valueOf(size.toUpperCase()));
        
        //Cor do produto
        boolean validColor = false;
        String color = "";
        System.out.println("Digite a cor predominante:");
        System.out.println("Opções: " + Arrays.asList(ColorEnum.values()));
        while(!validColor) {
            color = scan.nextLine();

            if (product.verifyColorEnum(color.toUpperCase())) {
                validColor = true;
            } else {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        product.setCor(ColorEnum.valueOf(color.toUpperCase()));
        
        //Valor da etiqueta do produto
        System.out.println("Digite o valor da etiqueta:");
        boolean validValorEtiqueta = false;
        String valorEtiqueta = "";
        while(!validValorEtiqueta) {
            valorEtiqueta = scan.nextLine();
            if (isFloat(valorEtiqueta)) {
                validValorEtiqueta = true;
            } else {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        product.setValorEtiqueta(Float.parseFloat(valorEtiqueta));
        
        //Valor pago pelo produto
        System.out.println("Digite o valor pago:");
        boolean validValorPago = false;
        String valorPago = "";
        while(!validValorPago) {
            valorPago = scan.nextLine();
            if (isFloat(valorPago)) {
                validValorPago = true;
            } else {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        float valor = Float.parseFloat(valorPago);
        product.setValorPago(valor);

        //Valor de margem de 100% do produto
        product.setValorMargem(valor * 2);
        
        //Valor de preço sugerido do produto
        System.out.println("Digite o valor do preço sugerido:");
        boolean validPreco = false;
        String preco = "";
        while(!validPreco) {
            preco = scan.nextLine();
            if (isFloat(preco)) {
                validPreco = true;
            } else {
                System.out.println(INVALID_VALUE_MSG);
            }
        }
        product.setPrecoSugerido(Float.parseFloat(preco));
        
        //Atualizando produto
        try {
            boolean success = ProdutoDao.updateProduct(product);
            
            if (success) {
                System.out.println("Produto atualizado com sucesso!");
            }
        } catch (Exception e) {
            Estoque.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        }
        
        Estoque.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        return sair;
    }
    
    public static boolean isFloat(String number) {
        try { 
            Float.parseFloat(number); 
            return true;
        }  
        catch (NumberFormatException e)  { 
            return false;
        } 
    }
}
