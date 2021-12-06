package com.exemple.restserver.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Client {
    @NotNull
    @Size(min = 2)
    private final String Name;
    @NotNull
    @Pattern(regexp="(^$|[0-9]{9})")
    private final String Cellphone;

    public Client(String name, String cellphone) {
        Name = name;
        Cellphone = cellphone;
    }

    public String getCellphone() {
        return Cellphone;
    }

    public String getName() {
        return Name;
    }

}
