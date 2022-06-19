package com.e_com.DAO;

import com.e_com.Entity.ProductImage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.*;

@Repository
@Transactional
public class ProductImageDaoImpl implements ProductImageDao {

    @Autowired
    private SessionFactory theSessionFactory;

    @Override
    public void saveImage(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(requireNonNull(file.getOriginalFilename()));
        ProductImage theProductImage = new ProductImage(fileName,file.getContentType(),file.getBytes());
        Session currSession = theSessionFactory.getCurrentSession();
        currSession.save(theProductImage);
    }

    @Override
    public ProductImage getImage(int theId) {
        return null;
    }
}
