<%@page import="test.login.dao.LoginDao"%>
<%@page import="test.login.dto.LoginDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//폼전송되는 비밀번호를 읽어온다.
	String pwd=request.getParameter("pwd");
	String newPwd=request.getParameter("newPwd");
	//세션 영역에서 아이디 읽어오기
	String id=(String)session.getAttribute("id");
	//UsersDto 객체를 생성해서 담는다.
	LoginDto dto=new LoginDto();
	dto.setPwd(pwd);
	dto.setNewPwd(newPwd);
	dto.setId(id);
	//UsersDao 객체를 이용해서 수정반영하고 성공 여부를 리턴 받는다.
	boolean isSuccess=LoginDao.getInstance().updatePwd(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/private/pwd_update.jsp</title>
</head>
<body>
<%if(isSuccess){ %>
	<script>
		alert("비밀 번호를 수정했습니다.");
		location.href="${pageContext.request.contextPath }/login/private/info.jsp";
	</script>
<%}else{ %>
	<script>
		alert("현재 비밀번호가 일치 하지 않습니다.");
		location.href="${pageContext.request.contextPath }/login/private/pwd_updateform.jsp";
	</script>
<%} %>
</body>
</html>