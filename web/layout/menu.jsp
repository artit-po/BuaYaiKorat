
<%@page import="com.bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% UserBean user = null;
user = (UserBean)request.getSession().getAttribute("userLogin");
%>
<!--  <section id="navArea">-->
<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav main_nav">
           
            <!--AdminManagement-->
            <%if (user !=null){ %>
             <li><a href="PageAction.do?todo=todomanagementUser"><strong>จัดการพนักงาน</strong></a></li>
              <li><a href="PageAction.do?todo=todomanagementNews"><strong>จัดการข่าว</strong></a></li>
              <li><a href="AuthenAuthorizeAction.do?todo=logout"><strong>ออกจากระบบ</strong></a></li>
            <%}else{%>
              <!--<li class="active"><a href="#"><span class="fa fa-home desktop-home"></span><span class="mobile-show">Home</span></a></li>-->
            <li><a href="WelcomePageAction.do?todo=welcome"><strong>หน้าแรก</strong></a></li>
            <li><a href="PageAction.do?todo=gotoContact"><strong>ขั้นตอนการติดต่อราชการ</strong></a></li>
            <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><strong>รู้จักเรา</strong></a>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#">ประวัติ</a></li>
                    <li><a href="#">โครงสร้างองค์กร</a></li>
                    <li><a href="#">ผังบุคลากร</a></li>
                    <li><a href="#">วิสัยทัศน์</a></li>
                </ul>
            </li>
            <li><a href="pages/login.html"><strong>ติดต่อเรา</strong></a></li>
            <li><a href="pages/404.html"><strong>มุมมองเจ้าหน้าที่</strong></a></li>
            
              <%}%>
                </ul>
    </div>
</nav>
<!--</section>-->
