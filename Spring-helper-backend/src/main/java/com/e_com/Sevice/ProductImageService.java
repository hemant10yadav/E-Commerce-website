package com.e_com.Sevice;

import com.e_com.Entity.ProductImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductImageService {

    public void saveImage(MultipartFile file) throws IOException;

    public ProductImage getImage(int theId);

}
