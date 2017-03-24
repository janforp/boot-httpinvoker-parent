package com.janita.invoker.client.controller;

import com.janita.invoker.server.bean.Animal;
import com.janita.invoker.server.service.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Janita on 2017-03-24 16:43
 */
@RequestMapping("/client")
@RestController
public class ClientAnimalController {

    @Autowired
    private IAnimalService animalService;

    @GetMapping("/animal")
    public Animal getAnimal(Long animalId){
        return animalService.getAnimal(animalId);
    }
}
