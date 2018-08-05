package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "project")
public class Project extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*项目名称**/
	@io.swagger.annotations.ApiModelProperty(value="项目名称",name="name")
	private String name;
	/*图片地址**/
	@io.swagger.annotations.ApiModelProperty(value="图片地址",name="pic")
	private String pic;
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
	/*项目描述**/
	@io.swagger.annotations.ApiModelProperty(value="项目描述",name="description")
	private String description;
	/*查看更多的链接**/
	@io.swagger.annotations.ApiModelProperty(value="查看更多的链接",name="moreLink")
	private String moreLink;
	/*排序**/
	@io.swagger.annotations.ApiModelProperty(value="排序",name="sortNum")
	private Integer sortNum;
	/*图标**/
	@io.swagger.annotations.ApiModelProperty(value="图标",name="ico")
	private String ico;
	public String  getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}
	public String  getPic() {
		return pic;
	}
	public void setPic(String _pic) {
		pic = _pic;
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
	public String  getDescription() {
		return description;
	}
	public void setDescription(String _description) {
		description = _description;
	}
	public String  getMoreLink() {
		return moreLink;
	}
	public void setMoreLink(String _moreLink) {
		moreLink = _moreLink;
	}
	public Integer  getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer _sortNum) {
		sortNum = _sortNum;
	}
	public String  getIco() {
		return ico;
	}
	public void setIco(String _ico) {
		ico = _ico;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,Name_ASC("`name` ASC"),Name_DESC("`name` DESC")
			,Pic_ASC("`pic` ASC"),Pic_DESC("`pic` DESC")
			,CreateTime_ASC("`createTime` ASC"),CreateTime_DESC("`createTime` DESC")
			,CreateBy_ASC("`createBy` ASC"),CreateBy_DESC("`createBy` DESC")
			,UpdateTime_ASC("`updateTime` ASC"),UpdateTime_DESC("`updateTime` DESC")
			,UpdateBy_ASC("`updateBy` ASC"),UpdateBy_DESC("`updateBy` DESC")
			,Description_ASC("`description` ASC"),Description_DESC("`description` DESC")
			,MoreLink_ASC("`moreLink` ASC"),MoreLink_DESC("`moreLink` DESC")
			,SortNum_ASC("`sortNum` ASC"),SortNum_DESC("`sortNum` DESC")
			,Ico_ASC("`ico` ASC"),Ico_DESC("`ico` DESC")
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
	
	public void setSortColumns(Project.Field... fields)
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
