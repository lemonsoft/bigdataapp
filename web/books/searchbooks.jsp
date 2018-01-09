<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="/WEB-INF/displaytag.tld" prefix="display" %>
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
            <div class="smart-forms smart-container wrap-full">

                <div class="form-header header-blue">
                    <h4><i class="fa fa-pencil-square"></i>Search Book</h4>
                    <div style="position: absolute;top:5px;right:5px;width: 100px;"><a href="<%=request.getContextPath()%>/book/init.htm" class="button btn-primary block pushed expand"> ADD </a></div>

                </div><!-- end .form-header section -->

                <form:form method="post" action="search.io"  commandName="bookdao">
                    <div class="form-body theme-blue">

                       

                    <div class="frm-row">
                        <display:table name="records" class="table table-bordered" requestURI="initSearch.io" decorator="com.app.controller.SrcDecorator" pagesize="5">
                            <display:column property="id" title="Book ID" />
                            <display:column property="name" title="Book" sortable="true"/>
                            <display:column property="publisher" title="publisher" sortable="true"/>
                            <display:column property="isbn" title="ISBN" sortable="true"/>
                            <display:column property="actions" title="Actions"/>
                        </display:table>

                    </div>
                </form:form>

            </div><!-- end .smart-forms section -->
        </div><!-- end .smart-wrap section -->
    </body>

</html>
