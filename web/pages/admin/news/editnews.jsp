<%-- 
    Document   : editnews
    Created on : Feb 16, 2017, 4:35:17 PM
    Author     : brass
--%>

<%@page import="com.bean.NewsBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    NewsBean bean = null;
    bean = (NewsBean) request.getSession().getAttribute("editnews");
    String msg = "";
    msg = (String) request.getAttribute("secess");
%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body onload="Success()">

        <h2 align="center">แก้ไขข้อมูลข่าว</h2>

        <br>
        <!--box-->
        <section class="content">
            <div class="col-md-8 col-md-offset-2">
                <div class="row">
                    <div class="box box-info">
                        <form class="form-horizontal" name="editform" action="NewsbuataiAction.do" method="post"  enctype="multipart/form-data">

                            <div class="box-body">
                                <input type="hidden" name="todo" value="editnews">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">ประเภทข่าว <span class="star">*</span></label>  
                                    <div class="col-md-6 inputGroupContainer">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-tags"></i></span>
                                            <select name="type_N" class="form-control" required="">
                                                <option value="<%=bean.getType_N()%>"><%=bean.getType_N()%></option>
                                                <option value="ข่าวการเมือง">ข่าวการเมือง</option>
                                                <option value="ข่าวกรมขนส่ง">ข่าวกรมขนส่ง</option>
                                                <option value="ข่าวทั่วไป">ข่าวทั่วไป</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">ชื่อข่าว <span class="star">*</span></label>  
                                    <div class="col-md-6 inputGroupContainer">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-tags"></i></span>
                                            <input  name="name_N" value="<%=bean.getName_N()%>" class="form-control"  type="text" required="">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">ไฟล์ <span class="star">*</span></label>  
                                    <div class="col-md-6 inputGroupContainer">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                            <input value="<%=bean.getFile_N()%>"  name="file_N" class="form-control"  type="file" required="">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-4 control-label">วันที่ลงข่าว <span class="star">*</span></label>  
                                    <div class="col-md-6 inputGroupContainer">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                                            <input value="<%=bean.getTime_N()%>"  name="time_N" class="form-control"  type="date"  required="">
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <!--button-->
                                <div align="center">
                                    <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-download-alt"></span> บันทึก</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <button type="reset" class="btn btn-danger">ยกเลิก</button>
                                </div>
                            </div>
                        </form>


                    </div>
                    <!-- /.box-footer-->
                </div>
            </div>
        </section>

        <div class="col-sm-2"></div>
    </body>
    <div>
        <%
            if ("ok".equals(msg)) {
        %>
        <script >
            function Success() {
                $(document).ready(function () {
                    swal({
                        title: "สำเร็จ",
                        text: "ดีใจด้วย คุณเพิ่มข้อมูลสำเร็จ !",
                        type: "success"
                    },
                            function () {
                                    window.location.href = 'PageAction.do?todo=todomanagementNews';
                            });
                });
            }
        </script>

        <%} else if ("no".equals(msg)) {
        %>
        <script >
            function Success() {
                swal({
                    title: "ไม่สำเร็จ",
                    text: "คุณเพิ่มข้อมูลไม่สำเร็จ ลองใหม่อีกครั้ง!",
                    type: "error"
                },
                        function () {
//                                window.location.href = '';
                        });
            }
            ;

        </script>
        <%   }
        %>
    </div>
</html>