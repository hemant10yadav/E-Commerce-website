package com.e_com.Sevice;

import com.e_com.DAO.ProductImageDao;
import com.e_com.Entity.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageDao theProductImageDao;

    @Override
    public void saveImage(MultipartFile file) throws IOException {
        theProductImageDao.saveImage(file);
    }

    @Override
    public ProductImage getImage(int theId) {
        return this.theProductImageDao.getImage(theId);
    }
}
