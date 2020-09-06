/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoquen1.console;

import br.com.estoquen1.crud.ProdutoDao;
import br.com.estoquen1.model.Produto;
import java.util.Scanner;

/**
 *
 * @author Nescara
 */
public class EstadoConsoleGetProduct extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        boolean sair = false;

        System.out.println("*** Buscar Produto ***");
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o código do item:");
        String codeItem = scan.nextLine();
        
        Produto product = ProdutoDao.getProductByItemCode(codeItem);
        if (product != null) {
            System.out.println("Código: " + product.getCodItem());
            System.out.println("Data de Entrada: " + product.getDataEntrada());
            System.out.println("Local da Compra: " + product.getLocalCompra());
            System.out.println("Tipo: " + product.getTipo());
            System.out.println("Marca: " + product.getMarca());
            System.out.println("Características: " + product.getCaracteristicas());
            System.out.println("Tamanho" + product.getTamanho());
            System.out.println("Cor predominante: " + product.getCor());
            System.out.println("Valor da Etiqueta: R$" + product.getValorEtiqueta());
            System.out.println("Valor Pago: R$" + product.getValorPago());
            System.out.println("Valor de Margem: R$" + product.getValorMargem());
            System.out.println("Preço: R$" + product.getPreco());
        } else {
            System.out.println("Item não existe!");
        }

        Estoque.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        return sair;
    }
}
