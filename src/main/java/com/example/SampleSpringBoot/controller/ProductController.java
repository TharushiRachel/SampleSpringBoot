package com.example.SampleSpringBoot.controller;

import com.example.SampleSpringBoot.dto.request.ProductCreateRequest;
import com.example.SampleSpringBoot.dto.request.ProductUpdateRequest;
import com.example.SampleSpringBoot.dto.response.ProductCreateResponse;
import com.example.SampleSpringBoot.dto.response.ProductSuggestionResponse;
import com.example.SampleSpringBoot.dto.response.ProductUpdateResponse;
import com.example.SampleSpringBoot.dto.response.ProductViewResponse;
import com.example.SampleSpringBoot.entity.Product;
import com.example.SampleSpringBoot.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired(required = true)
    private ModelMapper modelMapper;

    @PostMapping("${app.endpoint.productCreate}")
    @CrossOrigin
    public ResponseEntity<Object> saveProduct(@Validated @RequestBody ProductCreateRequest request) throws Exception{
        Product product = modelMapper.map(request, Product.class);
        Product saveProduct = productService.save(product);
        ProductCreateResponse productCreateResponse = modelMapper.map(saveProduct, ProductCreateResponse.class);
        return new ResponseEntity<>(productCreateResponse, HttpStatus.CREATED);
    }

    @GetMapping("${app.endpoint.productViewById}")
    @CrossOrigin
    public ResponseEntity<ProductViewResponse> viewProduct(@PathVariable String id){
        Product product = productService.findProductById((id));
        ProductViewResponse productViewResponse = modelMapper.map(product, ProductViewResponse.class);
        return new ResponseEntity<>(productViewResponse, HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.productListView}")
    @CrossOrigin
    public ResponseEntity<List<ProductSuggestionResponse>> viewAllProducts(){
        List<Product> productList = productService.getProductList();
        List<ProductSuggestionResponse> productSuggestionResponses = productList.stream().map(product -> modelMapper.map(product, ProductSuggestionResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(productSuggestionResponses, HttpStatus.OK);
    }

    @DeleteMapping("${app.endpoint.productDeleteById}")
    @CrossOrigin
    public void deleteProduct(@PathVariable("id")String id){
        productService.deleteProduct(id);
    }

    @PutMapping("${app.endpoint.productUpdateById}")
    @CrossOrigin
    public ResponseEntity<ProductUpdateResponse> updateProduct(@PathVariable String id, @Validated @RequestBody ProductUpdateRequest request) throws Exception{
        Product product = modelMapper.map(request, Product.class);
        product.setId(id);
        Product updateProduct = productService.update(product);
        ProductUpdateResponse productUpdateResponse = modelMapper.map(updateProduct, ProductUpdateResponse.class);
        return new ResponseEntity<>(productUpdateResponse, HttpStatus.OK);
    }
}
