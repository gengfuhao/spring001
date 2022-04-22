package ltd.newbee.mall.newbeemall.service;

import java.util.List;

import ltd.newbee.mall.newbeemall.entity.MallUser;
import ltd.newbee.mall.vo.NewBeeMailUserVO;

public interface CheckUserExistsService {
	List<NewBeeMailUserVO> checkUserExists(Long userId);

}