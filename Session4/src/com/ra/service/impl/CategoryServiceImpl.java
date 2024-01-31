package com.ra.service.impl;

import com.ra.entity.Category;
import com.ra.service.CategoryService;
import com.ra.util.MySQLConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        List<Category> result = new ArrayList<>();
        Connection conn = null;
        try {
            // B1. Tạo kết nối
            conn = MySQLConnect.open();
            // B2. Tạo đối tượng thực thi câu truy vấn
            String query = "SELECT * FROM categories";
            PreparedStatement ps = conn.prepareStatement(query);
            // B3. Thực thi câu truy vấn
            ResultSet rs = ps.executeQuery();
            // B4. Xử lý ResultSet
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setKeyword(rs.getString("keyword"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getBoolean("status"));

                result.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            MySQLConnect.close(conn);
        }
        return result;
    }

    @Override
    public List<Category> findByName(String name) {
        List<Category> result = new ArrayList<>();
        Connection conn = null;
        try {
            // B1. Tạo kết nối
            conn = MySQLConnect.open();
            // B2. Tạo đối tượng thực thi câu truy vấn
            String query = "SELECT * FROM categories WHERE name like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            // B2.1: Truyền tham số nếu có
            ps.setString(1, "%"+name+"%");
            // B3. Thực thi câu truy vấn
            ResultSet rs = ps.executeQuery();
            // B4. Xử lý ResultSet
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setKeyword(rs.getString("keyword"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getBoolean("status"));

                result.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            MySQLConnect.close(conn);
        }
        return result;
    }

    @Override
    public Category insert(Category category) {
        Connection conn = null;
        try {
            // B1. Tạo kết nối
            conn = MySQLConnect.open();
            // B2. Tạo đối tượng thực thi câu truy vấn
            String query = "INSERT INTO categories(name,keyword,description,status) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            // B2.1: Truyền tham số nếu có
            ps.setString(1, category.getName());
            ps.setString(2, category.getKeyword());
            ps.setString(3, category.getDescription());
            ps.setBoolean(4, category.isStatus());
            // B3. Thực thi câu truy vấn
            int result = ps.executeUpdate();
            if (result > 0) {
                try (ResultSet generateKeys = ps.getGeneratedKeys()) {
                    while (generateKeys.next()) {
                        category.setId(generateKeys.getInt(1));
                    }
                }
            }
            return category;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            MySQLConnect.close(conn);
        }
        return null;
    }
}
