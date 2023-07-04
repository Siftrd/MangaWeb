<%@page import="model.User"%>
<%    
    User us = (User) session.getAttribute("user");
    if (us == null || us.getType() != ADMIN) {
        response.sendRedirect(request.getContextPath() + "/home");
    }

%>