<%-- 
    Document   : adduser
    Created on : Feb 16, 2017, 4:37:23 PM
    Author     : brass
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String msg = "";
    msg = (String) request.getAttribute("registerStatus");
%>

<!DOCTYPE html>
<body onload="Success()">
    <!-- Main content -->
    <section class="content">
        <!-- Info boxes -->
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" role="form" name="registerForm" id="registerForm" action="UserAction.do" method="post" autocomplete="on" enctype="multipart/form-data">
                    <!--<div align="center">-->
                    <div class="box box-solid" >
                        <br>
                        <strong class="text-center"> <h3>สมัครสมาชิก</h3></strong>
                        <div class="box-body">
                            <div class="row">
                                <fieldset class="col-md-8 col-md-offset-2">
                                    <div class="form-group">
                                        <div class="panel panel-info">
                                            <div class="panel-heading">
                                                <h4> :: ข้อมูลส่วนตัว ::</h4>
                                            </div>
                                            <div class="panel-body">
                                                <!-- select -->
                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="fname">ชื่อ <span class="require" style="color:red;">*</span></label>
                                                    <div class="col-md-6 ">
                                                        <input class="form-control" type="text" name="fname" placeholder="ชื่อ" required="true">
                                                    </div></div>
                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="lname">นามสกุล <span class="require" style="color:red;">*</span></label>
                                                    <div class="col-md-6 ">
                                                        <input class="form-control" type="text" name="lname" placeholder="นามสกุล" required="true">
                                                    </div></div>
                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="classyear">ตำแหน่ง <span class="require" style="color:red;">*</span></label>
                                                    <div class="col-md-8 col-lg-4">
                                                        <input class="form-control" type="number" name="classyear" placeholder="วันเดือนปีเกิด" required="true">
                                                    </div></div>
                                           
                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="phone">เบอร์โทร <span class="require" style="color:red;">*</span></label>
                                                    <div class="col-md-6">
                                                        <input class="form-control" type="text" name="phone" maxlength="10" minlength="9" placeholder="เบอร์โทร" required="true">
                                                    </div></div>
                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="email">อีเมล์ <span class="require" style="color:red;">*</span></label>
                                                    <div class="col-md-6 ">
                                                        <input class="form-control" type="text" name="email" placeholder="อีเมล์" required="true">
                                                    </div></div>

                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="address">ที่อยู่ </label>
                                                    <div class="col-md-6">
                                                        <textarea class="form-control" name="address" placeholder="285/33 ซอยจรัญสนิทวงศ์31 ถนนจรัญสนิทวงศ์" required="true"></textarea>
                                                    </div></div>
                                              
                                            </div>
                                        </div>
                                        
<!--                                        <div class="panel panel-danger">
                                            <div class="panel-heading">
                                                <h4>ข้อมูลเข้าสู่ระบบ ::</h4>
                                            </div>
                                            <div class="panel-body">
                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="username">ชื่อใช้เข้าสู่ระบบ <span class="require" style="color:red;">*</span></label>
                                                    
                                                    <div class="col-lg-4">
                                                        ใช้รหัสประจำตัวนักศึกษา
                                                    </div>
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="password">รหัสผ่าน <span class="require" style="color:red;">*</span></label>
                                                    <div class="col-md-4">
                                                        <input  class="form-control"type="password" name="password" id="pass1" placeholder="รหัสผ่าน" minlength="6" maxlength="13" required="true">
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <small>กรุณากรอกตัวอักษร A-Z หรือตัวเลข0-9 อย่างน้อย 6 ตัว</small>
                                                    </div>
                                                </div>
                                                <div class="form-group col-md-12">
                                                    <label class="col-md-4 control-label" for="cpassword">ยืนยันรหัสผ่าน <span class="require" style="color:red;">*</span></label>
                                                    <div class="col-md-4">
                                                        <input  class="form-control"type="password" name="cpassword" id="pass2" placeholder="ยืนยันรหัสผ่าน" minlength="6" maxlength="13" required="true"><br>
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <span>กรุณากรอกตัวอักษร A-Z หรือตัวเลข0-9 อย่างน้อย 6 ตัว</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>-->
                                    </div>
                                    <input type="hidden" name="todo" />
                                    <input type="hidden" name="role" value="2"/>
                                    <input type="hidden" name="status" value="1"/>
                                    <div align="center">
                                        <button name="submit" id="submit" type="submit" onclick="insert('save')" class="btn btn-primary"><span class="glyphicon glyphicon-save"></span>บันทึก</button>
                                        <button name="reset" type="reset" class="btn btn-danger" ><span class="glyphicon glyphicon-refresh"></span>ยกเลิก</button>
                                    </div>
                                </fieldset>
                            </div> 
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section><!-- /.content -->
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
                    text: "คุณทำรายการสำเร็จ",
                    type: "success",
                    confirmButtonText: "ตกลง!"
                },
                        function () {
                            window.location.href = 'PageAction.do?todo=gotoPageLoginAdmin';
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
                text: "คุณทำรายการไม่สำเร็จ !",
                type: "error",
                confirmButtonText: "ตกลง!"
            },
                    function () {
                        window.location.href = 'PageAction.do?todo=gotoPageAdddataUser';
                    });
        }
        ;

    </script>
    <%   }
    %>
</div>



<script type="text/javascript">
    function insert(select) {
        document.registerForm.todo.value = select;
        var pass1 = document.getElementById("pass1")
                , pass2 = document.getElementById("pass2");

        function validatePassword() {
            if (pass1.value != pass2.value) {
                pass2.setCustomValidity("รหัสผ่านไม่ตรงกัน");
            } else {
                pass2.setCustomValidity('');
                document.registerForm.submit();
            }
        }

        pass1.onchange = validatePassword;
        pass2.onkeyup = validatePassword;
    }

</script>
