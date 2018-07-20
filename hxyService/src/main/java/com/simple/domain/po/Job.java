package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "job")
public class Job extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*标题**/
	@io.swagger.annotations.ApiModelProperty(value="标题",name="title")
	private String title;
	/*标签，用逗号隔开**/
	@io.swagger.annotations.ApiModelProperty(value="标签，用逗号隔开",name="tags")
	private String tags;
	/*公司名称**/
	@io.swagger.annotations.ApiModelProperty(value="公司名称",name="companyName")
	private String companyName;
	/*图片url**/
	@io.swagger.annotations.ApiModelProperty(value="图片url",name="picUrl")
	private String picUrl;
	/*职位描述**/
	@io.swagger.annotations.ApiModelProperty(value="职位描述",name="jobDesc")
	private String jobDesc;
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
	public String  getTitle() {
		return title;
	}
	public void setTitle(String _title) {
		title = _title;
	}
	public String  getTags() {
		return tags;
	}
	public void setTags(String _tags) {
		tags = _tags;
	}
	public String  getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String _companyName) {
		companyName = _companyName;
	}
	public String  getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String _picUrl) {
		picUrl = _picUrl;
	}
	public String  getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String _jobDesc) {
		jobDesc = _jobDesc;
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
			,Title_ASC("`title` ASC"),Title_DESC("`title` DESC")
			,Tags_ASC("`tags` ASC"),Tags_DESC("`tags` DESC")
			,CompanyName_ASC("`companyName` ASC"),CompanyName_DESC("`companyName` DESC")
			,PicUrl_ASC("`picUrl` ASC"),PicUrl_DESC("`picUrl` DESC")
			,JobDesc_ASC("`jobDesc` ASC"),JobDesc_DESC("`jobDesc` DESC")
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
	
	public void setSortColumns(Job.Field... fields)
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
