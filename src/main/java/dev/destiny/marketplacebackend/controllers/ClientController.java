package dev.destiny.marketplacebackend.controllers;

import dev.destiny.marketplacebackend.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/profile")
    public String clientProfile() {
        return "Welcome to the Client Profile";
    }

    @PostMapping("/buy_goods")
    public ResponseEntity<String> buyGoods(@RequestBody BuyRequest buyrequest){
        String res = goodsService.reduce_goods_quantity(buyrequest.goodsId, buyrequest.quantity);
        if (res == null){
            return ResponseEntity.status(404).body("no goods with such id");
        }
        return ResponseEntity.ok(res);
    }

    record  BuyRequest(Integer goodsId, Integer quantity){}
}
