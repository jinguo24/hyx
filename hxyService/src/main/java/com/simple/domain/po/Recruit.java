package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "recruit")
public class Recruit extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*职位名称**/
	@io.swagger.annotations.ApiModelProperty(value="职位名称",name="name")
	private String name;
	/*薪资**/
	@io.swagger.annotations.ApiModelProperty(value="薪资",name="salary")
	private String salary;
	/*职位描述**/
	@io.swagger.annotations.ApiModelProperty(value="职位描述",name="jobDesc")
	private String jobDesc;
	/*待遇**/
	@io.swagger.annotations.ApiModelProperty(value="待遇",name="treatment")
	private String treatment;
	/*标签**/
	@io.swagger.annotations.ApiModelProperty(value="标签",name="tag")
	private String tag;
	/*发布时间**/
	@io.swagger.annotations.ApiModelProperty(value="发布时间",name="pushTime")
	private Date pushTime;
	/*发布状态0：未发布 1：已发布**/
	@io.swagger.annotations.ApiModelProperty(value="发布状态0：未发布 1：已发布",name="pushStatus")
	private Integer pushStatus;
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
	public String  getSalary() {
		return salary;
	}
	public void setSalary(String _salary) {
		salary = _salary;
	}
	public String  getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String _jobDesc) {
		jobDesc = _jobDesc;
	}
	public String  getTreatment() {
		return treatment;
	}
	public void setTreatment(String _treatment) {
		treatment = _treatment;
	}
	public String  getTag() {
		return tag;
	}
	public void setTag(String _tag) {
		tag = _tag;
	}
	public Date  getPushTime() {
		return pushTime;
	}
	public void setPushTime(Date _pushTime) {
		pushTime = _pushTime;
	}
	public Integer  getPushStatus() {
		return pushStatus;
	}
	public void setPushStatus(Integer _pushStatus) {
		pushStatus = _pushStatus;
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
			,Salary_ASC("`salary` ASC"),Salary_DESC("`salary` DESC")
			,JobDesc_ASC("`jobDesc` ASC"),JobDesc_DESC("`jobDesc` DESC")
			,Treatment_ASC("`treatment` ASC"),Treatment_DESC("`treatment` DESC")
			,Tag_ASC("`tag` ASC"),Tag_DESC("`tag` DESC")
			,PushTime_ASC("`pushTime` ASC"),PushTime_DESC("`pushTime` DESC")
			,PushStatus_ASC("`pushStatus` ASC"),PushStatus_DESC("`pushStatus` DESC")
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
	
	public void setSortColumns(Recruit.Field... fields)
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
