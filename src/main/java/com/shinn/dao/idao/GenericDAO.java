package com.shinn.dao.idao;

import com.shinn.mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    <T> Long insert(String sql, Object... parameters);

    <T> void update(String sql, Object...parameters);
    <T> int count(String sql, Object...parameters);
}
