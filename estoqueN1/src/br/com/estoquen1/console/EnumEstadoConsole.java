package br.com.estoquen1.console;


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
