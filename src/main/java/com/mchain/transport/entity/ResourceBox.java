package com.mchain.transport.entity;
import java.io.Serializable;

public class ResourceBox  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
//GENERATE_START	        
	/**
	 * 主键id
	 */
	private String boxId;	
	/**
	 * 编号
	 */
	private String boxNo;	
	/**
	 * 箱子体积
	 */
	private String boxVolume;	
	/**
	 * 箱子状态
	 */
	private Integer boxStatus;	
	/**
	 *ResourceBox
	 */
	private String dataType = "ResourceBox";

	public String getBoxId() {
		return boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public String getBoxNo() {
		return boxNo;
	}
	public void setBoxNo(String boxNo) {
		this.boxNo = boxNo;
	}
	public String getBoxVolume() {
		return boxVolume;
	}
	public void setBoxVolume(String boxVolume) {
		this.boxVolume = boxVolume;
	}
	public Integer getBoxStatus() {
		return boxStatus;
	}
	public void setBoxStatus(Integer boxStatus) {
		this.boxStatus = boxStatus;
	}
    public String getDataType() {
    	return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
//GENERATE_END
}
