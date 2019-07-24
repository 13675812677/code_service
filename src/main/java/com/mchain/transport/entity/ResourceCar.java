package com.mchain.transport.entity;
import java.io.Serializable;

public class ResourceCar  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
//GENERATE_START	        
	/**
	 * 主键id
	 */
	private String carId;	
	/**
	 * 车辆编号
	 */
	private String carNo;	
	/**
	 * 车牌号
	 */
	private String plateNum;	
	/**
	 * 冷藏车类型
	 */
	private Integer carType;	
	/**
	 * 状态
	 */
	private Integer status;	
	/**
	 * 备注
	 */
	private String carDesc;	
	/**
	 *ResourceCar
	 */
	private String dataType = "ResourceCar";

	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public Integer getCarType() {
		return carType;
	}
	public void setCarType(Integer carType) {
		this.carType = carType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCarDesc() {
		return carDesc;
	}
	public void setCarDesc(String carDesc) {
		this.carDesc = carDesc;
	}
    public String getDataType() {
    	return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
//GENERATE_END
}
