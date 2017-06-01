 <%@ page language="java" import="java.util.*, java.sql.*" pageEncoding="gb2312"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告与评论</title>
<style>
body{margin:0;background-image:url(miaov.jpg);}
.box{width:600px;height:200px;background:blue;margin:60px auto;position:relative;}
#textarea{ border: medium none;font-size: 14px;height: 70px;line-height: 124%;padding: 0;width: 475px;overflow:hidden;resize: none;position:absolute;left:62px; top:55px;outline: none;}
.button{width:100px;height:30px;background:url(button.gif) 0 0 no-repeat;position:absolute;left:442px;top:135px;}
.button:hover{background-position:0 -30px;}
.button:active{background-position:0 -60px;}
.topic{position:absolute;left:72px;top:136px;height:26px;line-height:26px;text-decoration:none;color:#fff;font-size:12px;background:url(topic.gif) no-repeat 0 7px;padding-left:14px;}

</style>
</head>
<body>  
<div class="box">
	<textarea id="textarea" accesskey="1" tabindex="1" style="font-family: Tahoma,宋体;"></textarea>
	<a href="http://www.miaov.com" class="button"></a>
	<a href="###" class="topic" onclick="inTopic('textarea','妙味课堂')">话题</a>
</div>

</body>
</html>