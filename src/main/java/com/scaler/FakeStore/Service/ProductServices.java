package com.scaler.FakeStore.Service;


import com.scaler.FakeStore.Exception.ProductException;
import com.scaler.FakeStore.Model.Product;
import com.scaler.FakeStore.DTO.FakeStoreDTO;
import com.scaler.FakeStore.Projection.getDesCriptionTitlePriceImage;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices  implements ProductDeclaration{

    private final RestTemplate restTemplate;

    ProductServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product ConvertFakeStroretoProduct(FakeStoreDTO fakeStoreDTO){

        Product product = new Product();

        product.setTitle(fakeStoreDTO.getTitle());
        product.setPrice(fakeStoreDTO.getPrice());
        product.setDescription(fakeStoreDTO.getDescription());
        product.setImage(fakeStoreDTO.getImage());

        return product;
    }


    @Override
    public Product findProductById(Long id) throws ProductException {

        FakeStoreDTO fakeStoreDTO =restTemplate.getForObject
                ("https://fakestoreapi.com/products/"+id, FakeStoreDTO.class);

        if(fakeStoreDTO==null){
            throw new ProductException(id,"Product not found");
        }

        Product product = ConvertFakeStroretoProduct(fakeStoreDTO);



        return product;
    }

    @Override
    public Page<Product> findallProducts(int page, int size) {
        return null;
    }


    public List<Product> findallProducts() {


        FakeStoreDTO[] fakeStoreDTOs = restTemplate.getForObject
                ("https://fakestoreapi.com/products", FakeStoreDTO[].class);

        List<Product> products = new ArrayList<>() ;

        for (FakeStoreDTO fakeStoreDTO : fakeStoreDTOs) {
             products.add(ConvertFakeStroretoProduct(fakeStoreDTO));

        }
        return products;
    }

    @Override
    public Product updateProduct(Product product,Long id) {

        FakeStoreDTO fakeStoreDTO = new FakeStoreDTO();

        fakeStoreDTO.setTitle(product.getTitle());
        fakeStoreDTO.setPrice(product.getPrice());
        fakeStoreDTO.setDescription(product.getDescription());
        fakeStoreDTO.setImage(product.getImage());


        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreDTO, FakeStoreDTO.class);
        HttpMessageConverterExtractor<FakeStoreDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreDTO.class,
                        restTemplate.getMessageConverters());
        FakeStoreDTO response =
                restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return ConvertFakeStroretoProduct(response);
    }

    @Override
    public boolean deleteProduct(Long id) {

        if(id !=0){
            restTemplate.delete("https://fakestoreapi.com/products/"+id);
            return true;
        }
        return false;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> findProductsByCategory(Long id) {
        return List.of();
    }

    @Override
    public List<getDesCriptionTitlePriceImage> findBydescriptiontitleprice(Long id) {
        return List.of();
    }

    public int triggeringexception(){
        int i = 1/0;
        return i;
    }


}
