package ltd.newbee.mall.vo;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NewBeeMailUserVO implements Serializable {
	private Long userId;
	private Long goodsId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date checktime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Date getChecktime() {
		return checktime;
	}

	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}

	public boolean check(Long userId) {
		if (userId == 0) {
			return false;
		} else
			return true;
	}

	@Override
	public String toString() {
		return "NewBeeMailUserVO [goodsId=" + goodsId + ", checktime=" + checktime + "]";
	}

}
