package com.newthread.service;

import com.newthread.Data;
import com.newthread.domain.Catalog;
import com.newthread.mapper.CatalogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CatalogServiceImpl implements CatalogService {

    @Resource
    private CatalogMapper catalogMapper;

    @Override
    public List<Catalog> getAllCatalog() {
        Object object = Data.getData();
        System.out.println(object);
        return catalogMapper.selectAll();
    }
}
