/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoquen1.console;

import java.util.Scanner;

/**
 *
 * @author Nescara
 */
public class EstadoConsoleMenuPrincipal extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        System.out.println("*** Menu Principal");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Inserir Produto");
        System.out.println("1 - Atualizar Produto");
        System.out.println("3 - Deletar Produto");
        int opcao = scan.nextInt();
        switch (opcao)
        {
            case 0:
                Estoque.estadoConsole = EnumEstadoConsole.INSERT_PRODUCT.getEstadoMaquina();
                break;
            case 1:
                Estoque.estadoConsole = EnumEstadoConsole.UPDATE_PRODUCT.getEstadoMaquina();
                break;
            case 2:
                Estoque.estadoConsole = EnumEstadoConsole.DELETE_PRODUCT.getEstadoMaquina();
                break;
        }
        return false;
    }
}
