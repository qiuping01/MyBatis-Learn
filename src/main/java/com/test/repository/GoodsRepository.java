package com.test.repository;

import com.test.entity.Goods;

public interface GoodsRepository {
    public Goods getById(Integer id);
}
