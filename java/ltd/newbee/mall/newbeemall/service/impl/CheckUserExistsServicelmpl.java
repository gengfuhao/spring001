package ltd.newbee.mall.newbeemall.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.UserMapper;
import ltd.newbee.mall.newbeemall.entity.MallUser;
import ltd.newbee.mall.newbeemall.service.CheckUserExistsService;
import ltd.newbee.mall.newbeemall.util.ResultGenerator;
import ltd.newbee.mall.vo.NewBeeMailUserVO;
import ltd.newbee.mall.vo.NewBeeMallGoodsDetailVO;
@Service
public class CheckUserExistsServicelmpl implements CheckUserExistsService {

	@Resource
	UserMapper userMapper;

	@Override
	public List<NewBeeMailUserVO> checkUserExists(Long userId) {
		

		
		List<MallUser> malluser =userMapper.checkUserExists(userId);
		
		List<NewBeeMailUserVO> vo=new ArrayList<>();
		
		for(MallUser gc : malluser) {
			
			NewBeeMailUserVO user =new NewBeeMailUserVO();
			user.setGoodsName(gc.getGoodsName());
			user.setAddress(gc.getAddress());
			user.setUserId(gc.getUserId());
			user.setGoodsId(gc.getGoodsId());
			user.setChecktime((Date) gc.getChecktime());
				vo.add(user);
			}
		return vo;
		}
		
}

