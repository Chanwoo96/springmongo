package com.multi.mongDB;

import java.util.Date;

public class MemoVO {
private String _id; //자동생성되는 고유아이디 
private String name; //작성자 이름
private String content;//작성 내용 
private String weather;//작성한 날의 날씨 
private Date date;//작성한 날짜
public String get_id() {
	return _id;
}
public void set_id(String _id) {
	this._id = _id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getWeather() {
	return weather;
}
public void setWeather(String weather) {
	this.weather = weather;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
} 

}
