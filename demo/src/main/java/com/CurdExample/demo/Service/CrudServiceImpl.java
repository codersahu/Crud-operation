package com.CurdExample.demo.Service;

import com.CurdExample.demo.Repository.CrudRepo;
import com.CurdExample.demo.entity.CrudEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    private CrudRepo crudRepo;

    @Override
    public CrudEntity AddCrud(CrudEntity crudEntity) {
        CrudEntity crudEntity1 = new CrudEntity();
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        crudEntity1.setId(uuidString);
        crudEntity1.setName(crudEntity.getName());
        crudEntity1.setCity(crudEntity.getCity());
        return crudRepo.save(crudEntity1);
    }

    @Override
    public List<CrudEntity> GetAll() {
        List<CrudEntity> all = crudRepo.findAll();
        return all;
    }

    @Override
    public CrudEntity GetById(String id) {
        Optional<CrudEntity> byId = crudRepo.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new NoSuchElementException("Id not found");
        }
    }

    @Override
    public CrudEntity GetByName(String name) {
        CrudEntity byName = crudRepo.findByName(name);
        return byName;
    }

    @Override
    public CrudEntity UpdateCrud(String id, CrudEntity crudEntity) {
        CrudEntity updatedCrudUser = crudRepo.findById(id).get();
        updatedCrudUser.setName(crudEntity.getName());
        updatedCrudUser.setCity(crudEntity.getCity());
        CrudEntity save = crudRepo.save(updatedCrudUser);
        return save;
    }

    @Override
    public void DeleteCrud(String id) {
        crudRepo.deleteById(id);
    }
}

