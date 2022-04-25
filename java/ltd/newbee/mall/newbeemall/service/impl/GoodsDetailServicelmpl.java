package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.GoodsDetailMapper;
import ltd.newbee.mall.newbeemall.entity.GoodsDetail;
import ltd.newbee.mall.newbeemall.service.GoodsDetailService;
import ltd.newbee.mall.vo.NewBeeMailDetailVO;

@Service
public class GoodsDetailServicelmpl implements GoodsDetailService {
	
	@Resource
	GoodsDetailMapper goodsDetailMapper;

	
	@Override
	public List<NewBeeMailDetailVO>  getdetail(int goodsId){
		
		List<GoodsDetail> detail0=goodsDetailMapper.getdetail(goodsId);
		
		List<NewBeeMailDetailVO> detail2=new ArrayList<>();
		
		for(GoodsDetail detail00 : detail0) {
			NewBeeMailDetailVO cg =new NewBeeMailDetailVO();
			cg.setGoodsId(detail00.getGoodsId());
			cg.setSize(detail00.getSize1Name()+detail00.getSize1()+"*"+detail00.getSize2Name()+detail00.getSize2()+"*"+detail00.getSize3Name()+detail00.getSize3()+detail00.getSizeUnit());
			cg.setWrapSize(detail00.getWrapSize1Name()+detail00.getWrapSizeUnit()+"*"+detail00.getWrapSize2Name()+detail00.getWrapSize2()+"*"+detail00.getWrapSize3Name()+detail00.getWrapSize3()+detail00.getWrapSizeUnit());
			cg.setColor(detail00.getColor());
			cg.setMaterial(detail00.getMaterial());
			cg.setWarrantyYears(detail00.getWarrantyYears());
			
			detail2.add(cg);
		}
		
		
		return  detail2;
		
	}


	
	

}
