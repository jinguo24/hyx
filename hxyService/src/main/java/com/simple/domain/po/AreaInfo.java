package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "areaInfo")
public class AreaInfo extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*地区名称**/
	@io.swagger.annotations.ApiModelProperty(value="地区名称",name="areaName")
	private String areaName;
	/*描述**/
	@io.swagger.annotations.ApiModelProperty(value="描述",name="areaDesc")
	private String areaDesc;
	/*排序**/
	@io.swagger.annotations.ApiModelProperty(value="排序",name="sortNum")
	private Integer sortNum;
	/*0 无效 1有效**/
	@io.swagger.annotations.ApiModelProperty(value="0 无效 1有效",name="status")
	private Integer status;
	/***/
	@io.swagger.annotations.ApiModelProperty(value="",name="parentId")
	private String parentId;
	/*0 否 1是**/
	@io.swagger.annotations.ApiModelProperty(value="0 否 1是",name="isBlank")
	private Integer isBlank;
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
	public String  getAreaName() {
		return areaName;
	}
	public void setAreaName(String _areaName) {
		areaName = _areaName;
	}
	public String  getAreaDesc() {
		return areaDesc;
	}
	public void setAreaDesc(String _areaDesc) {
		areaDesc = _areaDesc;
	}
	public Integer  getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer _sortNum) {
		sortNum = _sortNum;
	}
	public Integer  getStatus() {
		return status;
	}
	public void setStatus(Integer _status) {
		status = _status;
	}
	public String  getParentId() {
		return parentId;
	}
	public void setParentId(String _parentId) {
		parentId = _parentId;
	}
	public Integer  getIsBlank() {
		return isBlank;
	}
	public void setIsBlank(Integer _isBlank) {
		isBlank = _isBlank;
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
			,AreaName_ASC("`areaName` ASC"),AreaName_DESC("`areaName` DESC")
			,AreaDesc_ASC("`areaDesc` ASC"),AreaDesc_DESC("`areaDesc` DESC")
			,SortNum_ASC("`sortNum` ASC"),SortNum_DESC("`sortNum` DESC")
			,Status_ASC("`status` ASC"),Status_DESC("`status` DESC")
			,ParentId_ASC("`parentId` ASC"),ParentId_DESC("`parentId` DESC")
			,IsBlank_ASC("`isBlank` ASC"),IsBlank_DESC("`isBlank` DESC")
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
	
	public void setSortColumns(AreaInfo.Field... fields)
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
