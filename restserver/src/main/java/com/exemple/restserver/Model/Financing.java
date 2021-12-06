package com.exemple.restserver.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.exemple.restserver.CustomAnotatins.Multiplo;


//import com.exemple.restserver.CustomAnotatins.Multiplo;
@Multiplo
public class Financing {
    // validação de multiplo de 12
    // validação de maximo de 48 para finaciamento interno 

    @NotNull
    @Min(12)
    @Max(60)
    private final Integer A; // Quantidade de meses 
    @Min(0)
    @NotNull
    private final double B; // Valor do vaicolo
    // financiamenot interno =0 exteno =1
    @Min(0)
    @Max(1)
    @NotNull
    private final Integer Financiamneto; //Tipo de finaciamento 

    public Financing(Integer A, Double B, Integer Financiamneto){
        this.A = A;
        this.B = B;
        this.Financiamneto = Financiamneto;
    }
    public Integer getA() {
        return A;
    }
    public double getB() {
        return B;
    }
    public Integer getFinanciamneto() {
        return Financiamneto;
    }
}
