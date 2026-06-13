package com.xpto.ProjetoERP.Utilitarios;

public class GeradorIdMovimentacao {
    private static int contador;

    public static int gerarId(){
        return contador++;
    }

}
