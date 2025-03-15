package dev.destiny.marketplacebackend.controllers;

import dev.destiny.marketplacebackend.model.Business;
import dev.destiny.marketplacebackend.model.Goods;
import dev.destiny.marketplacebackend.services.BusinessService;
import dev.destiny.marketplacebackend.services.GoodsService;
import dev.destiny.marketplacebackend.services.MPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business")
public class BusinessOwnerController {
    @Autowired
    MPUserService userService;
    @Autowired
    BusinessService businessService;
    @Autowired
    GoodsService goodsService;

    @GetMapping("/profile")
    public String businessProfile() {
        return "Welcome to the Admin Dashboard";
    }

    @PostMapping("/start_new_business")
    public ResponseEntity<String> startNew(@RequestBody BusinessReq req){
        var owner = userService.findUserById(req.id);
        if(owner.isPresent()){
            Business business = new Business();
            business.setName(req.name);
            business.setOwner(owner.get());
            businessService.create_new_business(business);
            return ResponseEntity.status(201).body("business successfully created");
        }else{
            return ResponseEntity.status(404).body("business owner was not found, register or login as a business owner");
        }
    }

    @PostMapping("/increase_stock")
    public ResponseEntity<String> inreaseStock(@RequestBody StockUpReq request){
        var goods = goodsService.findGoodsById(request.stockId);
        if (goods.isPresent()){
            goodsService.increase_goods_quantity(request.stockId, request.quantity);
            return ResponseEntity.ok(String.format("successfully increased qty of %s by %d",goods.get().getName(),request.quantity));
        }
        return ResponseEntity.status(404).body("goods with such id not found");
    }

    @PostMapping("/add_new_goods_collection")
    public ResponseEntity<String> addNewGoods(@RequestBody AddGoodsReq  request){
        Goods goods = new Goods();
        goods.setQuantity(request.quantity);
        goods.setUnit_price(request.unit_price);
        goods.setName(request.name);
        var res = goodsService.add_new_goods(request.businessId, goods);
        if (res != null){
            return ResponseEntity.ok("goods sucessfully added");
        }
        return ResponseEntity.status(404).body("business id not correct");
    }

    record    BusinessReq(String name, Integer id){}
    record  AddGoodsReq(Integer businessId, String name, Integer unit_price, Integer quantity){}
    record  StockUpReq(Integer stockId, Integer quantity){}

}
