package com.dongyeop.dbp_api.Controller;

import com.dongyeop.dbp_api.DTO.ProductDTO;
import com.dongyeop.dbp_api.Service.ProductService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ProductService productService;

    @GetMapping("/api")
    public ResponseEntity<?> getFoodSafetyData() {
        String url = "http://openapi.foodsafetykorea.go.kr/api/2d2fc9ac0b90436586de/C003/json/1/1000";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        List<ProductDTO> productInfos = new ArrayList<>();

        try {
            if (!isJSONValid(result)) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid JSON response from API");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(result);
            JsonNode rowNode = rootNode.path("C003").path("row");

            for (JsonNode node : rowNode) {
                String prdlstNm = node.path("PRDLST_NM").asText(); //품목명
                String ntkMthd = node.path("NTK_MTHD").asText(); //
                String primaryFnclty = node.path("PRIMARY_FNCLTY").asText();
                String pog_Daycnt = node.path("POG_DAYCNT").asText();
                String IFTKN_ATNT_MATR_CN = node.path("IFTKN_ATNT_MATR_CN").asText();
                String CSTDY_MTHD = node.path("CSTDY_MTHD").asText();
                String RAWMTRL_NM = node.path("RAWMTRL_NM").asText();
                productInfos.add(new ProductDTO(prdlstNm, ntkMthd, primaryFnclty, pog_Daycnt, IFTKN_ATNT_MATR_CN, CSTDY_MTHD, RAWMTRL_NM));
            }

            productService.saveProducts(productInfos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing data");
        }

        return ResponseEntity.ok(productInfos);
    }

    private boolean isJSONValid(String jsonInString) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonInString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
