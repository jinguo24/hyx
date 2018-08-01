package com.simple.domain.po;

import com.simple.common.crud.BaseModel;
import javax.persistence.*;
import java.util.*;
import java.math.*;
import javax.persistence.Transient;
import com.simple.annotation.HoldBegin;
import com.simple.annotation.HoldEnd;

@Table(name = "news")
public class News extends BaseModel {
	private static final long serialVersionUID = 1L;
	/*标题**/
	@io.swagger.annotations.ApiModelProperty(value="标题",name="title")
	private String title;
	/*发布时间**/
	@io.swagger.annotations.ApiModelProperty(value="发布时间",name="pushTime")
	private Date pushTime;
	/*缩略图**/
	@io.swagger.annotations.ApiModelProperty(value="缩略图",name="smallPicture")
	private String smallPicture;
	/*状态：0 待发布 1已发布**/
	@io.swagger.annotations.ApiModelProperty(value="状态：0 待发布 1已发布",name="status")
	private Integer status;
	/*缩略图名称**/
	@io.swagger.annotations.ApiModelProperty(value="缩略图名称",name="pictureName")
	private String pictureName;
	/*内容**/
	@io.swagger.annotations.ApiModelProperty(value="内容",name="content")
	private String content;
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
	/*类别 0：新闻 1.战略伙伴**/
	@io.swagger.annotations.ApiModelProperty(value="类别 0：新闻 1.战略伙伴",name="type")
	private Integer type;
	/*浏览数**/
	@io.swagger.annotations.ApiModelProperty(value="浏览数",name="queryCount")
	private Integer queryCount;
	/*描述**/
	@io.swagger.annotations.ApiModelProperty(value="描述",name="description")
	private String description;
	public String  getTitle() {
		return title;
	}
	public void setTitle(String _title) {
		title = _title;
	}
	public Date  getPushTime() {
		return pushTime;
	}
	public void setPushTime(Date _pushTime) {
		pushTime = _pushTime;
	}
	public String  getSmallPicture() {
		return smallPicture;
	}
	public void setSmallPicture(String _smallPicture) {
		smallPicture = _smallPicture;
	}
	public Integer  getStatus() {
		return status;
	}
	public void setStatus(Integer _status) {
		status = _status;
	}
	public String  getPictureName() {
		return pictureName;
	}
	public void setPictureName(String _pictureName) {
		pictureName = _pictureName;
	}
	public String  getContent() {
		return content;
	}
	public void setContent(String _content) {
		content = _content;
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
	public Integer  getType() {
		return type;
	}
	public void setType(Integer _type) {
		type = _type;
	}
	public Integer  getQueryCount() {
		return queryCount;
	}
	public void setQueryCount(Integer _queryCount) {
		queryCount = _queryCount;
	}
	public String  getDescription() {
		return description;
	}
	public void setDescription(String _description) {
		description = _description;
	}



	public static enum Field
	{
		Id_ASC("`id` ASC"),Id_DESC("`id` DESC")
			,Title_ASC("`title` ASC"),Title_DESC("`title` DESC")
			,PushTime_ASC("`pushTime` ASC"),PushTime_DESC("`pushTime` DESC")
			,SmallPicture_ASC("`smallPicture` ASC"),SmallPicture_DESC("`smallPicture` DESC")
			,Status_ASC("`status` ASC"),Status_DESC("`status` DESC")
			,PictureName_ASC("`pictureName` ASC"),PictureName_DESC("`pictureName` DESC")
			,Content_ASC("`content` ASC"),Content_DESC("`content` DESC")
			,CreateTime_ASC("`createTime` ASC"),CreateTime_DESC("`createTime` DESC")
			,CreateBy_ASC("`createBy` ASC"),CreateBy_DESC("`createBy` DESC")
			,UpdateTime_ASC("`updateTime` ASC"),UpdateTime_DESC("`updateTime` DESC")
			,UpdateBy_ASC("`updateBy` ASC"),UpdateBy_DESC("`updateBy` DESC")
			,Type_ASC("`type` ASC"),Type_DESC("`type` DESC")
			,QueryCount_ASC("`queryCount` ASC"),QueryCount_DESC("`queryCount` DESC")
			,Description_ASC("`description` ASC"),Description_DESC("`description` DESC")
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
	
	public void setSortColumns(News.Field... fields)
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
