package com.CurdExample.demo.Controller;

import com.CurdExample.demo.Service.CrudService;
import com.CurdExample.demo.entity.CrudEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1")
@RestController
public class CrudController {


    @Autowired
    private CrudService crudService;

    @PostMapping("/save")
    public ResponseEntity<?> AddCrud(@RequestBody CrudEntity crudEntity) {
        CrudEntity crudEntity1 = crudService.AddCrud(crudEntity);
        return new ResponseEntity<>(crudEntity1, HttpStatus.OK);
    }

    @GetMapping("allCrud")
    public ResponseEntity<?> getAll() {
        List<CrudEntity> Allcrud = crudService.GetAll();
        return new ResponseEntity<>(Allcrud, HttpStatus.OK);
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<?> GetById(@PathVariable String id) {
        CrudEntity crudId = crudService.GetById(id);
        return new ResponseEntity<>(crudId, HttpStatus.OK);
    }

    //if we are using request param like the below so the postman url is http://localhost:8085/v1/byName and inside form data we have to pass inside key = name and value = mohit then when we hit it will fetch the data
    //no difference between path variable and request param only one difference is for url is like when we use path variable the data which we paas is available inside the url like /mohit and if we use Request param then the data is ?mohit
    // when we talk about security in it so in both the cases security is not available because user know by url what is the data is passed and if he change the data from url our code will also change accordingly so for that we have to write the code accordingly like user not able to change the data by url like just changing the name in url.
    @GetMapping("/byName")
    public ResponseEntity<?> GetByName(@RequestParam String name) {
        CrudEntity crudName = crudService.GetByName(name);
        return new ResponseEntity<>(crudName, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCrud(@PathVariable String id, @RequestBody CrudEntity crudEntity) {
            CrudEntity updatedCrudEntity = crudService.UpdateCrud(id, crudEntity);
            return new ResponseEntity<>(updatedCrudEntity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCrud(@PathVariable String id){
        crudService.DeleteCrud(id);
        return new ResponseEntity<>("Data deleted successfully",HttpStatus.OK);
    }
}
