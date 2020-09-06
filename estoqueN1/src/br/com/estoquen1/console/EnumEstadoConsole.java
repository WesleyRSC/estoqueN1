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
public enum  EnumEstadoConsole {
    
    MENU_PRINCIPAL (new EstadoConsoleMenuPrincipal()),
    INSERT_PRODUCT (new EstadoConsoleInsertProduct()),
    UPDATE_PRODUCT (new EstadoConsoleUpdateProduct()),
    DELETE_PRODUCT (new EstadoConsoleDeleteProduct()),
    GET_PRODUCT (new EstadoConsoleGetProduct());
 
    private final MaquinaEstadoConsole estadoMaquina;
    
    EnumEstadoConsole(MaquinaEstadoConsole estadoMaquina) {
        this.estadoMaquina = estadoMaquina;
    }
 
    public MaquinaEstadoConsole getEstadoMaquina() {
        return estadoMaquina;
    }
}
