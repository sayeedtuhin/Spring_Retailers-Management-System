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
            var receivepayment = ${receivepayment};
            var customerinfoService = ${customerinfoService};
            var saleService = ${saleService};

            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                        $scope.receivepayment = receivepayment;
                        $scope.customerinfoService = customerinfoService;
                        $scope.saleService = saleService;
                        console.log($scope.saleService);
                    });
        </script>
    </head>
    <body ng-app="organocartpackage" ng-controller="ProductController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Receive Payment</span>
                    <a href="welcome">Admin</a>
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="newreceiveObject" action="receiveadd"
                                   enctype="multipart/form-data">
                            <c:if test="${check}">
                                <div class="form-group">

                                    <form:input class="form-control" Placeholder="receive Id"
                                                type="text" path="receiveid" required="true"></form:input>
                                </div>
                            </c:if>
                            <c:if test="${!check}">
                                <div class="form-group">
                                    <form:input class="form-control" Placeholder="receive Id"
                                                type="text" path="receiveid" readonly="true" required="true"></form:input>
                                </div>
                            </c:if>
                            
                             
                                <div class="form-group">
                                <form:input  class="form-control" value="{{sale.customerid}}" path="customerid"></form:input>
                                </div>
                                <div class="form-group">
                                <select class="form-control" ng-model="sale" ng-options="x.saleid  for x in saleService" required="true">
                                    <option value="">-- choose saleid --</option>
                                </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{sale.saleid}}" path="saleid"></form:hidden>
                                </div>
                                <div class="form-group">
                                <form:input type="number" class="form-control"
                                            Placeholder="bill-total " path="ammount" value="{{sale.billtotal}}" required="true" readonly="true"></form:input>
                                </div>
                                
                            
                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="date" placeholder="receive Date" required="true" id="date" ></form:input>

                                </div>
                                
                                <div class="form-group">
                                <form:input type="text" class="form-control"
                                            Placeholder="remarks " path="remarks" required="true"></form:input>
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
                            <a href="showsalarytpage"><button id="show" type="button" class="btn">Cancel</button></a>        
                        </form:form>
                    </div>
                    <!-- panel body end -->
                </div>
            </div>
            <!-- panel end -->
            <div class="panel animated fadeInUp delay-05s" id="panel-2">
                <div class="panel-heading">
                    <span class="lead">Payment List</span>
                </div>
                <p><input type="text" ng-model="test" class="form-control" placeholder="Search payment"></p>
                <!-- end panel2 heading -->
                <div class="panel-body">
                    <ul class="list-group">
                        <li class="list-group-item" height="45px"
                            ng-repeat="s in receivepayment| filter:test">
                            <table style="width: 100%">
                                <tr>
                                   
                                    <td>
                                        <ul>
                                            <li><span><b>receive Id: </b></span>{{s.receiveid}}</li>
                                            <li><span><b>Customer Id </b></span>{{s.customerid}}</li>
                                            <li><span><b>Sale Id </b></span>{{s.saleid}}</li>
                                            <li><span><b>Receive Date </b></span>{{s.date}}</li>
                                             <li><span><b>Ammount </b></span>{{s.ammount}}</li>
                                            <li><span><b>remarks: </b></span>{{s.remarks}}</li>
                                             <li><span><b>Status: </b></span>{{s.status}}</li>
                                            
                                        </ul>
                                    </td>
                                    <td><a href="editingreceive?getpid={{s.receiveid}}"><button id="editbuttons"
                                                                                                      type="submit" class="btn">Edit</button></a> <a
                                            href="removingreceive/{{s.receiveid}}"><button id="removebuttons"
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


        <!--<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>-->

        <!-- Include Date Range Picker -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

        <script>
                                                        $(document).ready(function () {
                                                            var date_input = $('input[name="date"]'); //our date input has the name "date"
                                                            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
                                                            date_input.datepicker({
                                                                format: 'yyyy/mm/dd',
                                                                container: container,
                                                                todayHighlight: true,
                                                                autoclose: true,
                                                            })
                                                        })
        </script>

        <!--     Form code begins 
            <form method="post">
              <div class="form-group">  Date input 
                <label class="control-label" for="date">Date</label>
                <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
              </div>
             </form>-->
    </body>
</html>
