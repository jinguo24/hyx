package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "dataInfo")
public class DataInfo extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*名称**/
	@io.swagger.annotations.ApiModelProperty(value="名称",name="name")
	private String name;
	/*分类**/
	@io.swagger.annotations.ApiModelProperty(value="分类",name="type")
	private String type;
	/*真实下载次数**/
	@io.swagger.annotations.ApiModelProperty(value="真实下载次数",name="realDownloadCount")
	private Integer realDownloadCount;
	/*基础下载次数**/
	@io.swagger.annotations.ApiModelProperty(value="基础下载次数",name="baseDownloadCount")
	private Integer baseDownloadCount;
	/*是否可见 0不可见 1可见**/
	@io.swagger.annotations.ApiModelProperty(value="是否可见 0不可见 1可见",name="visable")
	private Integer visable;
	/*附件名称**/
	@io.swagger.annotations.ApiModelProperty(value="附件名称",name="fileName")
	private String fileName;
	/*附件路径**/
	@io.swagger.annotations.ApiModelProperty(value="附件路径",name="filePath")
	private String filePath;
	/*附件描述**/
	@io.swagger.annotations.ApiModelProperty(value="附件描述",name="fileDesc")
	private String fileDesc;
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
	public String  getType() {
		return type;
	}
	public void setType(String _type) {
		type = _type;
	}
	public Integer  getRealDownloadCount() {
		return realDownloadCount;
	}
	public void setRealDownloadCount(Integer _realDownloadCount) {
		realDownloadCount = _realDownloadCount;
	}
	public Integer  getBaseDownloadCount() {
		return baseDownloadCount;
	}
	public void setBaseDownloadCount(Integer _baseDownloadCount) {
		baseDownloadCount = _baseDownloadCount;
	}
	public Integer  getVisable() {
		return visable;
	}
	public void setVisable(Integer _visable) {
		visable = _visable;
	}
	public String  getFileName() {
		return fileName;
	}
	public void setFileName(String _fileName) {
		fileName = _fileName;
	}
	public String  getFilePath() {
		return filePath;
	}
	public void setFilePath(String _filePath) {
		filePath = _filePath;
	}
	public String  getFileDesc() {
		return fileDesc;
	}
	public void setFileDesc(String _fileDesc) {
		fileDesc = _fileDesc;
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
			,Type_ASC("`type` ASC"),Type_DESC("`type` DESC")
			,RealDownloadCount_ASC("`realDownloadCount` ASC"),RealDownloadCount_DESC("`realDownloadCount` DESC")
			,BaseDownloadCount_ASC("`baseDownloadCount` ASC"),BaseDownloadCount_DESC("`baseDownloadCount` DESC")
			,Visable_ASC("`visable` ASC"),Visable_DESC("`visable` DESC")
			,FileName_ASC("`fileName` ASC"),FileName_DESC("`fileName` DESC")
			,FilePath_ASC("`filePath` ASC"),FilePath_DESC("`filePath` DESC")
			,FileDesc_ASC("`fileDesc` ASC"),FileDesc_DESC("`fileDesc` DESC")
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
	
	public void setSortColumns(DataInfo.Field... fields)
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
