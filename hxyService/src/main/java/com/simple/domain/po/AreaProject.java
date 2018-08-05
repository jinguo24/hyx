package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "areaProject")
public class AreaProject extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*省id**/
	@io.swagger.annotations.ApiModelProperty(value="省id",name="proviceId")
	private String proviceId;
	/*市id**/
	@io.swagger.annotations.ApiModelProperty(value="市id",name="cityId")
	private String cityId;
	/*地区id**/
	@io.swagger.annotations.ApiModelProperty(value="地区id",name="areaId")
	private String areaId;
	/*省名称**/
	@io.swagger.annotations.ApiModelProperty(value="省名称",name="proviceName")
	private String proviceName;
	/*市名称**/
	@io.swagger.annotations.ApiModelProperty(value="市名称",name="cityName")
	private String cityName;
	/*区名称**/
	@io.swagger.annotations.ApiModelProperty(value="区名称",name="areaName")
	private String areaName;
	/*项目ids, 多个用逗号隔开**/
	@io.swagger.annotations.ApiModelProperty(value="项目ids, 多个用逗号隔开",name="projectId")
	private String projectId;
	/*项目名称，多个用逗号隔开**/
	@io.swagger.annotations.ApiModelProperty(value="项目名称，多个用逗号隔开",name="projectName")
	private String projectName;
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
	/*电话**/
	@io.swagger.annotations.ApiModelProperty(value="电话",name="phone")
	private String phone;
	public String  getProviceId() {
		return proviceId;
	}
	public void setProviceId(String _proviceId) {
		proviceId = _proviceId;
	}
	public String  getCityId() {
		return cityId;
	}
	public void setCityId(String _cityId) {
		cityId = _cityId;
	}
	public String  getAreaId() {
		return areaId;
	}
	public void setAreaId(String _areaId) {
		areaId = _areaId;
	}
	public String  getProviceName() {
		return proviceName;
	}
	public void setProviceName(String _proviceName) {
		proviceName = _proviceName;
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
	public String  getProjectId() {
		return projectId;
	}
	public void setProjectId(String _projectId) {
		projectId = _projectId;
	}
	public String  getProjectName() {
		return projectName;
	}
	public void setProjectName(String _projectName) {
		projectName = _projectName;
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
	public String  getPhone() {
		return phone;
	}
	public void setPhone(String _phone) {
		phone = _phone;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,ProviceId_ASC("`proviceId` ASC"),ProviceId_DESC("`proviceId` DESC")
			,CityId_ASC("`cityId` ASC"),CityId_DESC("`cityId` DESC")
			,AreaId_ASC("`areaId` ASC"),AreaId_DESC("`areaId` DESC")
			,ProviceName_ASC("`proviceName` ASC"),ProviceName_DESC("`proviceName` DESC")
			,CityName_ASC("`cityName` ASC"),CityName_DESC("`cityName` DESC")
			,AreaName_ASC("`areaName` ASC"),AreaName_DESC("`areaName` DESC")
			,ProjectId_ASC("`projectId` ASC"),ProjectId_DESC("`projectId` DESC")
			,ProjectName_ASC("`projectName` ASC"),ProjectName_DESC("`projectName` DESC")
			,CreateTime_ASC("`createTime` ASC"),CreateTime_DESC("`createTime` DESC")
			,CreateBy_ASC("`createBy` ASC"),CreateBy_DESC("`createBy` DESC")
			,UpdateTime_ASC("`updateTime` ASC"),UpdateTime_DESC("`updateTime` DESC")
			,UpdateBy_ASC("`updateBy` ASC"),UpdateBy_DESC("`updateBy` DESC")
			,Phone_ASC("`phone` ASC"),Phone_DESC("`phone` DESC")
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
	
	public void setSortColumns(AreaProject.Field... fields)
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
