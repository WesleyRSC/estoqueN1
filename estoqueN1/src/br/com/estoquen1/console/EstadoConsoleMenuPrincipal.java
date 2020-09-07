package br.com.estoquen1.console;

import java.util.Scanner;

public class EstadoConsoleMenuPrincipal extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        System.out.println("");
        System.out.println("*** Menu Principal");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Inserir Produto");
        System.out.println("1 - Atualizar Produto");
        System.out.println("2 - Deletar Produto");
        System.out.println("3 - Buscar Produto");
        System.out.println("4 - Sair");
        
        String opcao = scan.nextLine();
        switch (opcao)
        {
            case "0":
                Estoque.estadoConsole = EnumEstadoConsole.INSERT_PRODUCT.getEstadoMaquina();
                break;
            case "1":
                Estoque.estadoConsole = EnumEstadoConsole.UPDATE_PRODUCT.getEstadoMaquina();
                break;
            case "2":
                Estoque.estadoConsole = EnumEstadoConsole.DELETE_PRODUCT.getEstadoMaquina();
                break;
            case "3":
                Estoque.estadoConsole = EnumEstadoConsole.GET_PRODUCT.getEstadoMaquina();
                break;
            case "4":
                return true;
            default:
                System.out.println("Opção inválida!");
        }
        return false;
    }
    
}
