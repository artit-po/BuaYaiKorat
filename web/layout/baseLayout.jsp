<%-- 
    Document   : baseLayout
    Created on : Dec 12, 2016, 12:01:35 AM
    Author     : Artit Por
--%>

<%@page import="com.bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%UserBean user = null;
user = (UserBean)request.getSession().getAttribute("userLogin");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" ignore="true" /></title>
        <!--inport css-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/animate.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/font.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/li-scroller.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/slick.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/jquery.fancybox.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/theme.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/sweetalert.css">
    </head>
    <body>


        <%if (user != null) {%>

        <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
        <div class="container">
            <!--header-->
            <tiles:insert attribute="header"/>
            <!--main-container-part-->
            <section id="navArea">
                <tiles:insert attribute="menu"/>
            </section>
            <!--body-->
            <section id="contentSection">
                <tiles:insert attribute="content"/>
            </section>
            <!--end body-->
            <!--footer-->
            <footer id="footer">
                <tiles:insert attribute="footer"/>
            </footer>
            <!--end footer-->
            <!--end-main-container-part-->
        </div>
        <%} else {
        %>
        <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
        <div class="container">
            <!--header-->
            <tiles:insert attribute="header"/>
            <!--main-container-part-->
            <section id="navArea">
                <tiles:insert attribute="menu"/>
            </section>
            <!--body-->
            <section id="sliderSection">
                <tiles:insert attribute="body"/>
            </section>
            <section id="contentSection">
                <tiles:insert attribute="content"/>
            </section>
            <!--end body-->
            <!--footer-->
            <footer id="footer">
                <tiles:insert attribute="footer"/>
            </footer>
            <!--end footer-->
            <!--end-main-container-part-->

        </div>  
        <%}%>

    </body>

    <script src="<%=request.getContextPath()%>/assets/js/jquery.min.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/wow.min.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/slick.min.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/jquery.li-scroller.1.0.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/jquery.newsTicker.min.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/jquery.fancybox.pack.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/js/custom.js"></script>
     <script src="<%=request.getContextPath()%>/assets/js/sweetalert.min.js"></script>
</html>


