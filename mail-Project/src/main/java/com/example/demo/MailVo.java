package com.example.demo;

import java.io.File;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MailVo {
	   private String id;//邮件id
	   private String from;//邮件发送人
	   private String to;//邮件接收人（多个邮箱则用逗号","隔开）
	   private String subject;//邮件主题
	   private String text;//邮件内容
	   private Date sentDate;//发送时间
	   private String cc;//抄送（多个邮箱则用逗号","隔开）
	   private String bcc;//密送（多个邮箱则用逗号","隔开）
	   private String status;//状态
	   private String error;//报错信息
	   @JsonIgnore
	   private File[] files;//邮件附件
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	   
	   
}
