package ltd.newbee.mall.vo;

public class NewBeeMailDetailVO {
	private Long goodsId;
	private String color;
	private String size;
	private String WrapSize;
	private String material;
	private Integer warrantyYears;
	
	

	public String getWrapSize() {
		return WrapSize;
	}

	public void setWrapSize(String wrapSize) {
		WrapSize = wrapSize;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getWarrantyYears() {
		return warrantyYears;
	}

	public void setWarrantyYears(Integer warrantyYears) {
		this.warrantyYears = warrantyYears;
	}

	@Override
	public String toString() {
		return "NewBeeMailDetailVO [goodsId=" + goodsId + ", color=" + color + ", size=" + size + ", WrapSize="
				+ WrapSize + ", material=" + material + ", warrantyYears=" + warrantyYears + "年"+"]";
	}

	

}
