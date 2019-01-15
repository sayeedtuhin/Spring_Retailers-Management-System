<%-- 
    Document   : addproduct
    Created on : Nov 25, 2018, 5:18:28 PM
    Author     : User
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">

            .panel>.panel-heading {
                color: #558b2f;
                background-color: #aed581;
                border-color: #aed581;
            }
            .panel>.panel-body
            {
                background-color: #f1f8e9;
                border-color: #aed581;
            }

            .form-control:FOCUS
            {
                border: 2px thin #9ccc65;
                border-radius: 5px;
            }
            .list-group-item {
                overflow: hidden;
            }
            #removebuttons
            {
                color: #ffffff;
                background-color: #e57373;
            }
            #removebuttons:HOVER {
                color: #ffffff;
                background-color: #e53935;
            }
            #editbuttons{
                color: #ffffff;
                background: linear-gradient(to bottom, #aed581 50%, #9ccc65 50%);	
            }
            #editbuttons:HOVER {
                color: #ffffff;
                background: linear-gradient(to bottom, #9ccc65 50%, #8bc34a 50%);	
            }
        </style>
        <script src="resources/js/angular.js"></script>

        <script>
            var empattendlist = ${empattendlist};
            var empinfoList = ${empinfoList};


            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                        $scope.empattendlist = empattendlist;
                        $scope.empinfoList = empinfoList;
                        // $scope.clo = cl;
                        console.log($scope.slo);
                    });
        </script>
    </head>
    <body ng-app="organocartpackage" ng-controller="ProductController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Monthly Attendence</span>

                    <a href="welcome">Admin</a>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="newAttendObject" action="addAttends"
                                   enctype="multipart/form-data">
                            <c:if test="${check}">
                                <div class="form-group">

                                    <form:input class="form-control" Placeholder="empattendid"
                                                type="text" path="empattendid" required="true"></form:input>
                                    </div>
                            </c:if>
                            <c:if test="${!check}">
                                <div class="form-group">
                                    <form:input class="form-control" Placeholder="empattendid"
                                                type="text" path="empattendid" readonly="true" required="true"></form:input>
                                    </div>
                            </c:if>






                            <div class="form-group">
                                <select class="form-control" ng-model="selectedattend" ng-options="x.empname for x in empinfoList">
                                     <option value="">-- employee name --</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{selectedattend.empid}}" path="empid"></form:hidden>
                                </div>



                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="attenddate" placeholder="attenddate" required="true" name="pdate"></form:input>
                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="arivaltime" placeholder="Arrival/hh:min:sec" required="true" ></form:input>
                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="departuretime" placeholder="Departure/hh:min:sec" required="true" ></form:input>
                                </div>

                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="overtime" placeholder="OverTime/hour" required="true" ></form:input>
                                </div>
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="offday" placeholder="Off Day" required="true" ></form:input>
                                </div>
                                
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="enddate" placeholder="End Date" required="true" name="pdates"></form:input>
                                </div>

                            <c:if test="${check}">
                                <form:button id="editbuttons" type="submit" name="Add" class="btn">Add
                                    Details</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </c:if>
                            <c:if test="${!check}">
                                <form:button id="editbuttons" type="submit" name="Edit" class="btn">Edit
                                    Details</form:button>
                                <form:button id="removebuttons" type="reset" class="btn">Reset
                                    Details</form:button>
                            </c:if>
                        </form:form>
                    </div>
                    <!-- panel body end -->
                </div>
            </div>
            <!-- panel end -->
            <div class="panel animated fadeInUp delay-05s" id="panel-2">
                <div class="panel-heading">
                    <span class="lead">Products List</span>
                </div>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="e in empattendlist">
                            <table style="width: 100%">
                                <tr>
                                    <td><img style="width:125px ;height:150px" src="resources/pimage/{{product.productid}}.jpg" />
                                    </td>
                                    <td>
                                        <ul>
                                            <li><span><b>Empattend Id: </b></span>{{e.empattendid}}</li>
                                            <li><span><b>Employee id </b></span>{{e.empid}}</li>

                                            <li><span><b>Attend Date: </b></span>{{e.attenddate}}</li>
                                            <li><span><b>End Date: </b></span>{{e.enddate}}</li>
                                            <li><span><b>Arrival Time: </b></span>{{e.arivaltime}}</li>
                                            <li><span><b>Departure Time: </b></span>{{e.departuretime}}</li>
                                            <li><span><b>Over Time: </b></span>{{e.overtime}}</li>
                                             <li><span><b>Off Day: </b></span>{{e.offday}}</li>
                                        </ul>
                                    </td>
                                    <td><a href="editingAttend?getpid={{e.empattendid}}"><button id="editbuttons"
                                                                                                  type="submit" class="btn">Edit</button></a> <a
                                            href="removingAttend/{{e.empattendid}}"><button id="removebuttons"
                                                                                         type="button" class="btn">Remove</button></a></td>
                                </tr>
                            </table>
                        </li>
                    </ul>
                </div>
                <!-- panel2 body end -->
            </div>
            <!-- panel2 end -->
        </div>

        <jsp:include page="footer.jsp" />
        
        
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <script>
                                                        $(document).ready(function () {
                                                            var date_input = $('input[name="attenddate"]'); //our date input has the name "date"
                                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                                            date_input.datepicker({
                                                                format: 'yyyy/mm/dd',
                                                                container: container,
                                                                todayHighlight: true,
                                                                autoclose: true,
                                                            })
                                                        })
        </script>
        
        
        <script>
                                                        $(document).ready(function () {
                                                            var date_inputt = $('input[name="enddate"]'); //our date input has the name "date"
                                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                                            date_input.datepicker({
                                                                format: 'yyyy/mm/dd',
                                                                container: container,
                                                                todayHighlight: true,
                                                                autoclose: true,
                                                            })
                                                        })
        </script>
        
        
        
    </body>
</html>
