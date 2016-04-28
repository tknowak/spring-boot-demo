package org.nowak.web;

import org.nowak.model.Fruit;
import org.nowak.repository.FruitRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/fruits")
public class FruitResource {

    private static final Logger logger = getLogger(FruitResource.class);

    @Autowired
    private FruitRepository fruitRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Fruit> getAllFruit() {
        return fruitRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void addFruit(@RequestBody Fruit fruit) {
        logger.info("Persisting fruit: ", fruit.getName());
        fruitRepository.save(fruit);
    }
}
