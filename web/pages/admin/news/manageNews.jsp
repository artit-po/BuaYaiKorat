<%-- 
    Document   : manageNews
    Created on : Feb 16, 2017, 11:23:56 AM
    Author     : brass
--%>

<%@page import="java.util.*"%>
<%@page import="com.bean.NewsBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <%!
            List<NewsBean> list = new ArrayList<NewsBean>();

        %>
        <%  list = (List<NewsBean>) request.getSession().getAttribute("listnews");

            String msg = "";
            msg = (String) request.getAttribute("");
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>

 

        <section class="content">
            <!-- Info boxes -->
            <div class="row">
                <div class="col-md-12">

                    <form name="formnews" method="post" action="NewsbuataiAction.do">
                        <section class="content-header">
                            <h1>
                                จัดการข้อมูลข่าว
                            </h1>
                            <hr class="hrbrue">
                        </section>
                        <section class="content">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="box">
                                        <div class="box-header">
                                            <h3 class="box-title">ข้อมูลข่าว</h3>
                                        </div>

                                        <!--.box-header-->
                                        <div class="box-body">
                                            <div class="pull-right">
                                                <a  href="PageAction.do?todo=gotoinsertnews" class="btn btn-primary"><i class="glyphicon glyphicon-download"></i>เพิ่ม</a>
                                            </div>
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <table id="example1" class="table table-striped table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>ลำดับ
                                                                </th>
                                                                <th>ประเภทข่าว
                                                                </th>
                                                                <th >ชื่อข่าว
                                                                </th>
                                                                <th >วันที่เพิ่มข่าว
                                                                </th>
                                                                <th >แก้ไข
                                                                </th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                if (list != null && list.size() != 0) {
                                                                    for (int i = 0; i < list.size(); i++) {
                                                                        NewsBean bean = (NewsBean) list.get(i);
                                                            %>
                                                            <tr role="row" class="odd">
                                                                <td ><%=i + 1%></td>
                                                                <td ><%=bean.getType_N()%></td>
                                                                <td><%=bean.getName_N()%></td>
                                                                <td class="sorting_1"><%=bean.getTime_N()%></td>
                                                                <td><button class="btn btn-sm btn-danger" type="button" value="ลบ" onclick="callActionGotoDelete(<%=bean.getNews_id()%>)"><i class="fa fa-close"></i></button>
                                                                    <button class="btn btn-sm btn-success" type="submit" value="แก้ไข" onclick="callActionGotoEdit(<%=bean.getNews_id()%>)"><i class="glyphicon glyphicon-edit"></i></button></td>
                                                            </tr>
                                                            <%}%>
                                                            <%} else {%>
                                                        <strong style="color: red">ไม่พบข้อมูลสมาชิก</strong>        
                                                        <%}%>
                                                        </tbody>
                                                    </table>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <input type="hidden" name="todo"/>
                        <input type="hidden" name="news_id"/>
                    </form>
                </div>
            </div>

    </body>
    <script type="text/javascript">
        function callActionGotoDelete(news_id) {
            swal({
                title: "คุณ แน่ใจแล้วใช่หรือไม่ ?",
                text: "คุณแน่ใจแล้วใช่หรือไม่ที่จะลบข้อมูล!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "ใช่, ลบเลย!",
                cancelButtonText: "ไม่, ออกเลย!",
                closeOnConfirm: false,
                closeOnCancel: false
            },
                    function (isConfirm) {
                        document.formnews.news_id.value = news_id;
                        document.formnews.todo.value = 'delete';

                        if (isConfirm) {
                            document.formnews.submit();
                            swal("ลบ !", "คุณ ลบ สำเร็จแล้ว.", "success");
                        } else {
                            swal("ออก", "คุณไม่ลบแล้วใช่หรือไม่ :)", "error");
                        }
                    });
        }

        function callActionGotoDetle(news_id) {

            document.formnews.news_id.value = news_id;
            document.formnews.todo.value = 'Detle';
            document.formnews.submit();

        }
        function callActionGotoEdit(news_id) {
            document.formnews.news_id.value = news_id;
            document.formnews.todo.value = 'gotoEdit';
            document.formnews.submit();
        }
        function callActionGotosearch(select) {
            document.formnews.todo.value = select;
            document.formnews.submit();
        }



    </script>
    <div>
        <%
            if ("ok".equals(msg)) {
        %>
        <script >
            function check() {
                $(document).ready(function () {
                    swal({
                        title: "สำเร็จ",
                        text: "คุณลบข้อมูลสำเร็จ !",
                        type: "success",
                        confirmButtonText: "ตกลง!"
                    },
                            function () {
                                window.location.href = '';
                            });
                });
            }
        </script>

        <%} else if ("no".equals(msg)) {
        %>
        <script >
            function check() {
                swal({
                    title: "ไม่สำเร็จ",
                    text: "คุณลบข้อมูลไม่สำเร็จ !",
                    type: "error",
                    confirmButtonText: "ตกลง!"
                },
                        function () {
                            window.location.href = '';
                        });
            }
            ;

        </script>
        <%   }
        %>
    </div> 
</html>
