package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "inst")
public class Inst extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*机构名称**/
	@io.swagger.annotations.ApiModelProperty(value="机构名称",name="name")
	private String name;
	/*机构地址**/
	@io.swagger.annotations.ApiModelProperty(value="机构地址",name="address")
	private String address;
	/*地址图片**/
	@io.swagger.annotations.ApiModelProperty(value="地址图片",name="addressPic")
	private String addressPic;
	/*优惠信息**/
	@io.swagger.annotations.ApiModelProperty(value="优惠信息",name="discountInfo")
	private String discountInfo;
	/*电话**/
	@io.swagger.annotations.ApiModelProperty(value="电话",name="phone")
	private String phone;
	/*描述**/
	@io.swagger.annotations.ApiModelProperty(value="描述",name="discription")
	private String discription;
	/*省名称**/
	@io.swagger.annotations.ApiModelProperty(value="省名称",name="provinceName")
	private String provinceName;
	/*省id**/
	@io.swagger.annotations.ApiModelProperty(value="省id",name="provinceId")
	private String provinceId;
	/*城市id**/
	@io.swagger.annotations.ApiModelProperty(value="城市id",name="cityId")
	private String cityId;
	/*城市姓名**/
	@io.swagger.annotations.ApiModelProperty(value="城市姓名",name="cityName")
	private String cityName;
	/*地区名称**/
	@io.swagger.annotations.ApiModelProperty(value="地区名称",name="areaName")
	private String areaName;
	/*地区id**/
	@io.swagger.annotations.ApiModelProperty(value="地区id",name="areaId")
	private String areaId;
	/*[GTE][LTE]**/
	@io.swagger.annotations.ApiModelProperty(value="[GTE][LTE]",name="createTime")
	private Date createTime;
	@Transient
	private Date createTimeGte;
	@Transient
	private Date createTimeLte;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="createBy")
	private String createBy;
	/*[GTE][LTE]**/
	@io.swagger.annotations.ApiModelProperty(value="[GTE][LTE]",name="updateTime")
	private Date updateTime;
	@Transient
	private Date updateTimeGte;
	@Transient
	private Date updateTimeLte;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="updateBy")
	private String updateBy;
	public String  getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public String  getAddress() {
		return address;
	}
	public void setAddress(String _address) {
		address = _address;
	}
	public String  getAddressPic() {
		return addressPic;
	}
	public void setAddressPic(String _addressPic) {
		addressPic = _addressPic;
	}
	public String  getDiscountInfo() {
		return discountInfo;
	}
	public void setDiscountInfo(String _discountInfo) {
		discountInfo = _discountInfo;
	}
	public String  getPhone() {
		return phone;
	}
	public void setPhone(String _phone) {
		phone = _phone;
	}
	public String  getDiscription() {
		return discription;
	}
	public void setDiscription(String _discription) {
		discription = _discription;
	}
	public String  getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String _provinceName) {
		provinceName = _provinceName;
	}
	public String  getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String _provinceId) {
		provinceId = _provinceId;
	}
	public String  getCityId() {
		return cityId;
	}
	public void setCityId(String _cityId) {
		cityId = _cityId;
	}
	public String  getCityName() {
		return cityName;
	}
	public void setCityName(String _cityName) {
		cityName = _cityName;
	}
	public String  getAreaName() {
		return areaName;
	}
	public void setAreaName(String _areaName) {
		areaName = _areaName;
	}
	public String  getAreaId() {
		return areaId;
	}
	public void setAreaId(String _areaId) {
		areaId = _areaId;
	}
	public Date  getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date _createTime) {
		createTime = _createTime;
	}
	public Date getCreateTimeGte() {
		return createTimeGte;
	}
	public void setCreateTimeGte( Date _createTimeGte) {
		createTimeGte = _createTimeGte;
	}
	public Date getCreateTimeLte() {
		return createTimeLte;
	}
	public void setCreateTimeLte( Date _createTimeLte) {
		createTimeLte = _createTimeLte;
	}
	public String  getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String _createBy) {
		createBy = _createBy;
	}
	public Date  getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date _updateTime) {
		updateTime = _updateTime;
	}
	public Date getUpdateTimeGte() {
		return updateTimeGte;
	}
	public void setUpdateTimeGte( Date _updateTimeGte) {
		updateTimeGte = _updateTimeGte;
	}
	public Date getUpdateTimeLte() {
		return updateTimeLte;
	}
	public void setUpdateTimeLte( Date _updateTimeLte) {
		updateTimeLte = _updateTimeLte;
	}
	public String  getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String _updateBy) {
		updateBy = _updateBy;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,Name_ASC("`name` ASC"),Name_DESC("`name` DESC")
			,Address_ASC("`address` ASC"),Address_DESC("`address` DESC")
			,AddressPic_ASC("`addressPic` ASC"),AddressPic_DESC("`addressPic` DESC")
			,DiscountInfo_ASC("`discountInfo` ASC"),DiscountInfo_DESC("`discountInfo` DESC")
			,Phone_ASC("`phone` ASC"),Phone_DESC("`phone` DESC")
			,Discription_ASC("`discription` ASC"),Discription_DESC("`discription` DESC")
			,ProvinceName_ASC("`provinceName` ASC"),ProvinceName_DESC("`provinceName` DESC")
			,ProvinceId_ASC("`provinceId` ASC"),ProvinceId_DESC("`provinceId` DESC")
			,CityId_ASC("`cityId` ASC"),CityId_DESC("`cityId` DESC")
			,CityName_ASC("`cityName` ASC"),CityName_DESC("`cityName` DESC")
			,AreaName_ASC("`areaName` ASC"),AreaName_DESC("`areaName` DESC")
			,AreaId_ASC("`areaId` ASC"),AreaId_DESC("`areaId` DESC")
			,CreateTime_ASC("`createTime` ASC"),CreateTime_DESC("`createTime` DESC")
			,CreateBy_ASC("`createBy` ASC"),CreateBy_DESC("`createBy` DESC")
			,UpdateTime_ASC("`updateTime` ASC"),UpdateTime_DESC("`updateTime` DESC")
			,UpdateBy_ASC("`updateBy` ASC"),UpdateBy_DESC("`updateBy` DESC")
	;
		private String value;
		Field(String value){
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setCol(String value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return this.getValue();
		}
	}
	
	public void setSortColumns(Inst.Field... fields)
	{
		if (fields == null || fields.length == 0) {
			return;
		}
		for (int k = 0; k < fields.length; k++) {
			if (fields[k] == null) {
				return;
			}
		}
		StringBuilder sb = new StringBuilder(fields[0].toString());
		for (int k = 1; k < fields.length; k++) {
			sb.append(",");
			sb.append(fields[k].toString());
		}
		super.setSortColumns(sb.toString());
	}
	
	@Override
	public void setSortColumns(String sortColumns)
	{
		if (sortColumns == null || "".equals(sortColumns.trim())) {
			return;
		}
		if (sortColumns.contains(",")) {
			String[] cols = sortColumns.split(",");
			java.util.List<Field> fList = new java.util.ArrayList();
			for (int k = 0; k < cols.length; k++) {
				fList.add(Field.valueOf(cols[k]));
			}
			this.setSortColumns(fList.toArray(new Field[fList.size()]));
		} else {
			this.setSortColumns(Field.valueOf(sortColumns));
		}
	}
}
