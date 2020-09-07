package br.com.estoquen1.console;

public class Estoque {
    public static MaquinaEstadoConsole estadoConsole;

    public static void main(String[] args) {
        estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
        Boolean saida = false;
        while (!saida) {
            saida = estadoConsole.Executa();
        }
    }
    
}
