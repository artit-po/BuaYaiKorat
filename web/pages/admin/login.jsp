
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/login-style.css">

<title>เข้าสู่ระบบ</title>
<style>
    body{
        background-color: #B0BEC5;
    }
    /*bootstrap class override for login page only*/

</style>

<div class="container" >  
    <div class="col-lg-4 col-md-3 col-sm-2"></div>
    <div class="col-lg-4 col-md-6 col-sm-8">
        <div class="logo">

        </div>
        <div class="row loginbox">                    
            <div class="col-lg-12">
                <span class="singtext" >Sign in </span>   
            </div>

            <div class="col-lg-12 col-md-12 col-sm-12">
                <input class="form-control" type="text" placeholder="Please enter your user name" > 
            </div>
            <div class="col-lg-12  col-md-12 col-sm-12">
                <input class="form-control" type="password" placeholder="Please enter password" >
            </div>
            <div class="col-lg-12  col-md-12 col-sm-12">
                <a href="#" class="btn  submitButton">Submit </a> 
            </div>                     

        </div>
        <div class="row forGotPassword">
            <a href="#" >Forgot Username / Password? </a> 
        </div>
        <br>                
        <br>
        <footer  class="footer">                
            <a href='#'>Artit of RMU</a> | 
            <a href='#'>SmartIT</a> | 
            <a href='#'>Contact us</a> | 
            <a href='#'>Feedback</a> 
            <p >©2017 Login Templates By Artit </p>                 
        </footer> <!--footer Section ends-->

    </div>
    <div class="col-lg-4 col-md-3 col-sm-2"></div>
</div>
