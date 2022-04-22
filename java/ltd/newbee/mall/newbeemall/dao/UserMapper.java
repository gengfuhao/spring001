package ltd.newbee.mall.newbeemall.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ltd.newbee.mall.newbeemall.entity.MallUser;

import ltd.newbee.mall.newbeemall.entity.MallUser;

public interface UserMapper {
	List<MallUser> checkUserExists(Long userId);

	}










 