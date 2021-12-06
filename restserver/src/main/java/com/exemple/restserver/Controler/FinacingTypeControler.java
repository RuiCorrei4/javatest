package com.exemple.restserver.Controler;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.exemple.restserver.Model.FinancingType;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinacingTypeControler {
    /**
     * 
     * @param financingtype
     * @return
     */
    @Valid
    @PostMapping("/PostFinancingValeu")
    public void FinanciamnetoValor(@RequestBody @Valid FinancingType financingtype) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("Config.json"));
            Map<String, Object> financing_presentage = new HashMap<>();
            financing_presentage.put("Interno", financingtype.getInterno());
            financing_presentage.put("Externo", financingtype.getExterno());
            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(financing_presentage));
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
