package com.exemple.restserver.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FinancingType {
    @Min(1)
    @NotNull
    private final double Interno;
    @Min(1)
    @NotNull
    private final double Externo;

    public FinancingType(double interno, double externo) {
        this.Interno = interno;
        this.Externo = externo;
    }

    public double getExterno() {
        return Externo;
    }

    public double getInterno() {
        return Interno;
    }

}
