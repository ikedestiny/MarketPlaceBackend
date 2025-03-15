package dev.destiny.marketplacebackend.services;

import dev.destiny.marketplacebackend.model.Goods;
import dev.destiny.marketplacebackend.repository.BusinessRepository;
import dev.destiny.marketplacebackend.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoodsService {
    @Autowired
    GoodsRepository goods_repo;
    @Autowired
    BusinessRepository businessRepository;

    public Goods add_new_goods(Integer busines_id,Goods goods){
        var business = businessRepository.findById(busines_id);
        business.ifPresent(goods::setBusiness);
       return  business.isEmpty() ? null : goods_repo.save(goods);
    }

    public String increase_goods_quantity(Integer goods_id, Integer qty_to_add) {
        if (qty_to_add == null || qty_to_add <= 0) {
            return "Invalid quantity to add";
        }

        Optional<Goods> goods = goods_repo.findById(goods_id);
        if (goods.isPresent()) {
            Goods good = goods.get();
            good.setQuantity(good.getQuantity() + qty_to_add);
            goods_repo.save(good);
            return "Successfully increased your " + good.getName() + " collection";
        } else {
            return "No such good";
        }
    }

    public String reduce_goods_quantity(Integer goods_id, Integer qty_to_red){
        if (qty_to_red == null || qty_to_red <= 0) {
            return "Invalid quantity to add";
        }
        Optional<Goods> goods = goods_repo.findById(goods_id);
        if (goods.isPresent()) {
            Goods good = goods.get();
            if (good.getQuantity() < qty_to_red){
                return "not enough goods, available now "+ good.getQuantity();
            }
            good.setQuantity(good.getQuantity() - qty_to_red);
            goods_repo.save(good);
            return "Successfully reduced your " + good.getName() + " collection";
        } else {
            return null;
        }
    }

    public Optional<Goods> findGoodsById(Integer id){
        return goods_repo.findById(id);
    }

}
