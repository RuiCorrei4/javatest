package com.exemple.restserver.Controler;

import java.io.BufferedWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;

import javax.validation.Valid;

import com.exemple.restserver.Model.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientControler {
    /**
     * 
     */
    @Valid
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/SaveClientFinancing")
    public void SaveClient(@RequestBody @Valid Client client){
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("Client.json"));
            Map<String, Object> clientFileMap = new HashMap<>();
            clientFileMap.put("Nome", client.getName());
            clientFileMap.put("Telefone", client.getCellphone());
            clientFileMap.put("Valor Mensal", client.getFinancing());
            clientFileMap.put("Numero de meses", client.getA());
            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(clientFileMap));
            writer.close();
            System.out.println("i am hear");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
