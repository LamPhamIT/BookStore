package com.shinn.dao.impl;

import com.shinn.dao.idao.IProductDAO;
import com.shinn.mapper.ProductMapper;
import com.shinn.model.ProductModel;
import com.shinn.paging.Pageble;

import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

    @Override
    public Long insert(ProductModel product) {
        String sql = "INSERT INTO Product(Title, Thumbnail, Description, Price, Discount, Remain_Quality, Category_ID, Created_Date) VALUES (?,?,?,?,?,?,?,?)";
        return insert(sql, product.getTitle(), product.getThumbnail(), product.getDescription(), product.getPrice(),
        product.getDiscount(), product.getRemainQuality(), product.getCategory().getId(), product.getCreatedDate());
    }

    @Override
    public ProductModel findOne(Long id) {
        String sql = "SELECT * FROM Product as p INNER JOIN Category as c ON p.Category_ID=c.Category_ID WHERE p.Product_ID=?";
        List<ProductModel> list = query(sql, new ProductMapper(), id);
        return list.isEmpty()? null : list.get(0);
    }

    @Override
    public List<ProductModel> findAll(Pageble paging) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Product as p INNER JOIN Category as c ON p.Category_ID=c.Category_ID ");
       if(paging != null) {
           if(paging.getSorter() != null) {
               if(paging.getSorter().getSortBy() != null && paging.getSorter().getSortName() != null) {
                   sql.append("ORDER BY " + paging.getSorter().getSortBy() + " " + paging.getSorter().getSortName()+" ");
               }
           }
           if(paging.getOffSet() != null && paging.getLimit() != null) {
               sql.append("LIMIT " + paging.getOffSet() +", " + paging.getLimit());
           }
       }
        return query(sql.toString(), new ProductMapper());
    }

    @Override
    public void update(ProductModel product) {
        String sql = "UPDATE Product SET title=?, thumbnail=?, description=?, price=?, discount=?, Remain_Quality=?, Category_ID=?,Modified_Date=?,Modified_By=? WHERE Product_ID=?";
        update(sql, product.getTitle(), product.getThumbnail(), product.getDescription(), product.getPrice(),product.getDiscount(), product.getRemainQuality(),
                product.getCategory().getId(),product.getModifiedDate(), product.getModifiedBy(), product.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Product WHERE Product_ID=?";
        update(sql, id);
    }

    @Override
    public int getTotalItem() {
        String sql = "SELECT COUNT(*) FROM Product";
        return count(sql);
    }

    @Override
    public List<ProductModel> findLatestProducts(int amount) {
        String sql = "SELECT * FROM Product ORDER BY Created_Date DESC LIMIT ?";
        return query(sql, new ProductMapper(), amount);
    }

    @Override
    public List<ProductModel> findSaleProducts(int amount) {
        String sql = "SELECT * FROM Product WHERE Discount <> 0 LIMIT ?";
        return query(sql, new ProductMapper(), amount);
    }

    @Override
    public List<ProductModel> findByCategoryID(Long categoryId) {
        String sql = "SELECT * FROM Product WHERE Category_ID=?";
        return query(sql, new ProductMapper(), categoryId);
    }

    @Override
    public List<ProductModel> find(String query) {
        String sql = "SELECT * FROM Product WHERE title LIKE '?' ";
        return query(sql, new ProductMapper(),query);
    }

    @Override
    public List<ProductModel> findByKeyword(String keyword) {
        String sql = "SELECT * FROM Product as p INNER JOIN Category as c ON p.Category_ID=c.Category_ID WHERE Title LIKE '%" + keyword + "%' OR Description LIKE '%" + keyword + "%'";
        return query(sql, new ProductMapper());
    }

    @Override
    public void updateNum(Long id, int num) {
        String sql = "UPDATE Product SET Remain_Quality=? WHERE Product_ID=?";
        update(sql, num, id);
    }
}
