package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.example.productorderservice.product.ProductSteps.상품조회요청;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductApiTest extends ApiTest {

    @Test
    void 상품등록() {
        final AddProductRequest request = ProductSteps.상품등록요청_생성();

        //API 요청
        final ExtractableResponse<Response> response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());

        Long productId = 1L;

        ExtractableResponse<Response> response = 상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }

}
