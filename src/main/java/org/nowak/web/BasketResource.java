package org.nowak.web;

import org.nowak.model.Basket;
import org.nowak.repository.BasketRepository;
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
@RequestMapping("/baskets")
public class BasketResource {

    private static final Logger logger = getLogger(BasketResource.class);

    @Autowired
    private BasketRepository basketRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void addBasket(@RequestBody Basket basket) {
        logger.info("Persisting basket: ", basket.getMaterial());
        basketRepository.save(basket);
    }
}
