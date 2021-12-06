package com.exemple.restserver.Controler;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.validation.Valid;

import com.exemple.restserver.Model.Financing;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancingControler {
    /**
     * 
     * @param financing
     * @return
     */
    @Valid
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/GetFinancingResult")
    public double finaciamento(@RequestBody @Valid Financing financing) {
        double[] data = new double[2];
        try {
            Reader reader = Files.newBufferedReader(Paths.get("Config.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode parser = objectMapper.readTree(reader);
            data[0] = parser.path("Interno").asDouble();
            data[1] = parser.path("Externo").asDouble();
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
            
        }
        return Math.round(financing.getB() * data[financing.getFinanciamneto()] / financing.getA());
    }
}