package org.uni.beans;

import lombok.Getter;
import lombok.Setter;
import org.uni.mybatis.dao.MarqueMapper;
import org.uni.mybatis.dao.ModelMapper;
import org.uni.mybatis.dao.SaleMapper;
import org.uni.mybatis.dao.SalesmanMapper;
import org.uni.mybatis.model.Sale;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Model
public class SalesMyBatis {
    @Inject
    private SaleMapper saleMapper;

    @Inject
    private ModelMapper modelMapper;

    @Inject
    private SalesmanMapper salesmanMapper;

    @Inject
    private MarqueMapper marqueMapper;

    @Getter @Setter
    private Sale saleTmp = new Sale();

    @Inject
    DealershipPageBean dealershipPageBean;

    @Transactional
    public void createSale(Integer id) throws IOException {
        saleTmp.setDealershipId(id);
        saleTmp.setSaleDate(new Date());
        saleMapper.insert(saleTmp);
        saleTmp = new Sale();

        dealershipPageBean.reload(id);
    }

    public List<org.uni.mybatis.model.Model> getModelList(){
        return modelMapper.selectAll();
    }

    public List<org.uni.mybatis.model.Marque> getMarqueList(){
        return marqueMapper.selectAll();
    }

    public List<org.uni.mybatis.model.Salesman> getSalesmanList(){
        return salesmanMapper.selectAll();
    }

}
