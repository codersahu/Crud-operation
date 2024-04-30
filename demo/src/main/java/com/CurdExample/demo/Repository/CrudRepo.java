package com.CurdExample.demo.Repository;

import com.CurdExample.demo.entity.CrudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepo extends JpaRepository<CrudEntity,String> {

    public CrudEntity findByName(String name);
}
