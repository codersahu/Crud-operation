package com.CurdExample.demo.Service;

import com.CurdExample.demo.entity.CrudEntity;

import java.util.List;

public interface CrudService {

    public CrudEntity AddCrud(CrudEntity crudEntity);
    public List<CrudEntity> GetAll();
    public CrudEntity GetById(String id);
    public CrudEntity GetByName(String name);
    public CrudEntity UpdateCrud(String id, CrudEntity crudEntity);
    public void DeleteCrud(String id);
}
