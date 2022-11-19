package com.example.CorrecaoProvaUmSpringBoot.utils;

import com.example.CorrecaoProvaUmSpringBoot.entity.Cliente;

//SE tivesse calculo na questão -
public class Calculo {

    public Cliente calc(Cliente cliente){
        if (cliente.getReceita() > 1000000000.00){
            Double valorIdeal = cliente.getReceita() - 99999999.9;
            cliente.setReceitaTotal(valorIdeal);
            return cliente;
        }else{
            Double cincoPorcento = (cliente.getReceita() * 0.05);
            cliente.setReceitaTotal(cliente.getReceita() - cincoPorcento);
            return cliente;


        }
    }
}
