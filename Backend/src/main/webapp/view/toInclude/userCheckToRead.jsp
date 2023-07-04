<%@page import="model.User"%>
<%@include file="const.jsp" %>
<%
    Cookie[] cookee = request.getCookies();
    if(cookee == null){
        response.sendRedirect(request.getContextPath() + "/dangnhap");
    }
    else{
        Boolean loggedIn = false;
        for(Cookie c:cookee){
            if(c.getName().equals("user")){
                if(c.getValue() != null || !c.getValue().equals("")){
                    loggedIn = true;
                }
            }
        }
        if(!loggedIn){
            response.sendRedirect(request.getContextPath() + "/dangnhap");
        }
    }

%>