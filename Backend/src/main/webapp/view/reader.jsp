<%@page import="model.Truyen"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileInputStream"%>
<% 
        response.setContentType("application/pdf");
        ServletOutputStream sos = response.getOutputStream();
        
        
        Truyen t = (Truyen)request.getSession().getAttribute("truyen");
        String[] path = {"C:\\Users\\suckm\\OneDrive\\Desktop\\TestDataBTLWeb\\","D:\\Hentai Heaven Data\\Comic\\"};
        //Lay file truyen trong folder
        FileInputStream fin = new FileInputStream(path[0]+ t.getId() + ".pdf");
        
        //Tra ve bufer
        byte [] buf = new byte[4096];
        int read;
        while((read = fin.read(buf)) != -1)
        {
            sos.write(buf, 0, read);
        }

        fin.close();
        sos.flush();
        sos.close();
        
%>
