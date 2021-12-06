package com.exemple.restserver.Controler;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.validation.Valid;

import com.exemple.restserver.Model.Financing;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancingControler {
    /**
     * 
     * @param financing
     * @return
     */
    @Valid
    @GetMapping("/GetFinancingResult")
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
        }
        if (financing.getA() > 48 && financing.getFinanciamneto() == 0) {
            return -2;
        }
        return Math.round(financing.getB() * data[financing.getFinanciamneto()] / financing.getA());
    }
}