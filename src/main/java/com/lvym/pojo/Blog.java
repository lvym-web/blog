package com.lvym.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "t_blog")
public class Blog {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;
	private String firstPicture; //收图
	private String flag; //标记
	private Integer views;//浏览次数
	private boolean appreciation;//赞赏
	private boolean shareStatement;//版权开启
	private boolean commentable;//评论
	private boolean published;//发布
	private boolean recommend;//推荐
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;//创建时间
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;//更新时间
	@ManyToOne
	private Type type;
	@ManyToMany(cascade = {CascadeType.PERSIST})// 级联新增
	private List<Tag> tags=new ArrayList<>();
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "blog")
	private List<Comment> comments=new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFirstPicture() {
		return firstPicture;
	}
	public void setFirstPicture(String firstPicture) {
		this.firstPicture = firstPicture;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public boolean isAppreciation() {
		return appreciation;
	}
	public void setAppreciation(boolean appreciation) {
		this.appreciation = appreciation;
	}
	public boolean isShareStatement() {
		return shareStatement;
	}
	public void setShareStatement(boolean shareStatement) {
		this.shareStatement = shareStatement;
	}
	public boolean isCommentable() {
		return commentable;
	}
	public void setCommentable(boolean commentable) {
		this.commentable = commentable;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public boolean isRecommend() {
		return recommend;
	}
	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", firstPicture=" + firstPicture
				+ ", flag=" + flag + ", views=" + views + ", appreciation=" + appreciation + ", shareStatement="
				+ shareStatement + ", commentable=" + commentable + ", published=" + published + ", recommend="
				+ recommend + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

}
