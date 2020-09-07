package br.com.estoquen1.console;

import br.com.estoquen1.crud.ProdutoDao;
import java.util.Scanner;

public class EstadoConsoleDeleteProduct extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        boolean sair = false;
        System.out.println("");
        System.out.println("*** Deletar Produto ***");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o código do item a ser deletado:");

        try {
            boolean success = ProdutoDao.deleteProduct(scan.nextLine());
            
            if (success) {
                System.out.println("Produto deletado com sucesso!");
            }
        } catch (Exception e) {
            Estoque.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        }
        
        Estoque.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        return sair;
    }
}
