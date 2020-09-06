/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoquen1.console;

/**
 *
 * @author Nescara
 */
public class EstadoConsoleInsertProduct extends MaquinaEstadoConsole{

    @Override
    public boolean Executa() {
        System.out.println("Interface -> Inserir Produto");
        Estoque.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        return false;
    }
    
}
