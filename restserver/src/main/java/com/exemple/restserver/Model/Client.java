package com.exemple.restserver.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Client {

    @NotEmpty
    @Size(min = 2)
    private final String Name;

    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{9})")
    private final String Cellphone;

    @NotNull
    private final Double Financing;

    @NotNull
    @Min(12)
    @Max(60)
    private final Integer A;

    public Client(String name, String cellphone, Double financing, Integer a) {
        this.Name = name;
        this.Cellphone = cellphone;
        this.Financing = financing;
        this.A = a;
    }

    public Integer getA() {
        return A;
    }

    public Double getFinancing() {
        return Financing;
    }

    public String getCellphone() {
        return Cellphone;
    }

    public String getName() {
        return Name;
    }

}
