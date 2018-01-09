<%-- 
    Document   : addlanguage
    Created on : 9 Nov, 2017, 2:29:37 PM
    Author     : ss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/smart-forms.css">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/smart-themes/blue.css">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/css/font-awesome.min.css">


        <!--[if lte IE 9]>
            <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>    
            <script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
        <![endif]-->    

        <!--[if lte IE 8]>
            <link type="text/css" rel="stylesheet" href="css/smart-forms-ie8.css">
        <![endif]-->

    </head>
    <body >

        <div class="smart-wrap">
            <div class="smart-forms smart-container wrap-2">

                <div class="form-header header-blue">
                    <h4><i class="fa fa-pencil-square"></i>Add Book</h4>
                    <div style="position: absolute;top:5px;right:5px;width: 100px;"><a href="<%=request.getContextPath()%>/book/initSearch.htm" class="button btn-primary block pushed expand"> Search </a></div>

                </div><!-- end .form-header section -->

                <form:form method="post" action="${action}"  commandName="bookdao">
                    <form:hidden path="id" />
                    <div class="form-body theme-blue">

                        <label for="names" class="field-label">Book Name</label>
                        <div class="frm-row">

                            <div class="section colm colm4">
                                <label class="field prepend-icon">
                                    <form:input path="name" id="name" class="gui-input" placeholder="Book Name"/>

                                    <span class="field-icon"><i class="fa fa-language"></i></span>  
                                </label>
                            </div><!-- end section -->
                            <div class="section colm colm4">
                                <label class="field prepend-icon">
                                    <form:input path="publisher" id="publisher" class="gui-input" placeholder="Publisher"/>

                                    <span class="field-icon"><i class="fa fa-language"></i></span>  
                                </label>
                            </div><!-- end section -->
                            <div class="section colm colm4">
                                <label class="field prepend-icon">
                                    <form:input path="isbn" id="isbn" class="gui-input" placeholder="ISBN"/>

                                    <span class="field-icon"><i class="fa fa-language"></i></span>  
                                </label>
                            </div><!-- end section -->


                        </div><!-- end frm-row section -->



                    </div><!-- end .form-body section -->
                    <div class="form-footer">
                        <c:if test = "${mode == 'add'}">
                            <button type="submit" class="button btn-blue">Submit</button>
                        </c:if>
                        <c:if test = "${mode=='update'}">
                            <button type="submit" class="button btn-blue">Update</button>
                        </c:if>
                        <button type="reset" class="button btn-blue">Cancel</button>
                    </div><!-- end .form-footer section -->
                </form:form>

            </div><!-- end .smart-forms section -->
        </div><!-- end .smart-wrap section -->
    </body>

</html>
