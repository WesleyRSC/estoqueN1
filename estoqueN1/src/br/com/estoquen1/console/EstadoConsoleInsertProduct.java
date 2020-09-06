/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoquen1.console;

import br.com.estoquen1.model.ColorEnum;
import br.com.estoquen1.model.Produto;
import br.com.estoquen1.model.SizeEnum;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Nescara
 */
public class EstadoConsoleInsertProduct extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        boolean sair = false;
        
        
        System.out.println("*** Inserir Produto ***");
        Produto product = new Produto();
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o código do item:");
        product.setCodItem(scan.nextLine());
        
        System.out.println("Digite o local da compra:");
        product.setLocalCompra(scan.nextLine());
        
        System.out.println("Digite o tipo do produto:");
        product.setTipo(scan.nextLine());
        
        System.out.println("Digite a marca do produto:");
        product.setMarca(scan.nextLine());
        
        System.out.println("Digite as caracteristicas:");
        product.setCaracteristicas(scan.nextLine());
        
        boolean validSize = false;
        String size = "";
        System.out.println("Digite o tamanho:");
        System.out.println("Opções: " + Arrays.asList(SizeEnum.values()));
        while(!validSize) {
            size = scan.nextLine();

            if (product.verifySizeEnum(size.toUpperCase())) {
                validSize = true;
            } else {
                System.out.println("Valor inválido, digite novamente.");
            }
        }
        product.setTamanho(SizeEnum.valueOf(size.toUpperCase()));
        
        boolean validColor = false;
        String color = "";
        System.out.println("Digite a cor predominante:");
        System.out.println("Opções: " + Arrays.asList(ColorEnum.values()));
        while(!validColor) {
            color = scan.nextLine();

            if (product.verifyColorEnum(color.toUpperCase())) {
                validColor = true;
            } else {
                System.out.println("Valor inválido, digite novamente.");
            }
        }
        product.setCor(ColorEnum.valueOf(color.toUpperCase()));
        
        
        System.out.println("Digite o valor da etiqueta:");
        boolean validValorEtiqueta = false;
        String valorEtiqueta = "";
        while(!validValorEtiqueta) {
            valorEtiqueta = scan.nextLine();
            if (isFloat(valorEtiqueta)) {
                validValorEtiqueta = true;
            } else {
                System.out.println("Valor inválido, digite novamente.");
            }
        }
        product.setValorEtiqueta(Float.parseFloat(valorEtiqueta));
        
        System.out.println("Digite o valor pago:");
        boolean validValorPago = false;
        String valorPago = "";
        while(!validValorPago) {
            valorPago = scan.nextLine();
            if (isFloat(valorPago)) {
                validValorPago = true;
            } else {
                System.out.println("Valor inválido, digite novamente.");
            }
        }
        product.setValorPago(Float.parseFloat(valorPago));

        System.out.println("Digite o valor de margem:");
        boolean validValorMargem = false;
        String valorMargem = "";
        while(!validValorMargem) {
            valorMargem = scan.nextLine();
            if (isFloat(valorMargem)) {
                validValorMargem = true;
            } else {
                System.out.println("Valor inválido, digite novamente.");
            }
        }
        product.setValorMargem(Float.parseFloat(valorMargem));
        
        System.out.println("Digite o valor do preço:");
        boolean validPreco = false;
        String preco = "";
        while(!validPreco) {
            preco = scan.nextLine();
            if (isFloat(preco)) {
                validPreco = true;
            } else {
                System.out.println("Valor inválido, digite novamente.");
            }
        }
        product.setValorMargem(Float.parseFloat(preco));
        
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();
        product.setDataEntrada(df.format(dateobj));
        
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
