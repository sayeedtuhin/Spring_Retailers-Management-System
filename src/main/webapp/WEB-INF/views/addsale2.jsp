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
            var customerlist = ${customerlist};
            var productlist = ${products};
            var cartproductlist = ${itemsincartt};
           

            angular.module('organocartpackage', []).controller('ProductController',
                    function ($scope) {
                        $scope.customerlist = customerlist;
                        $scope.productt = productlist;
                        $scope.citems = cartproductlist;
                        
                        console.log($scope.citems);
                    });
        </script>
    </head>
    <body ng-app="organocartpackage" ng-controller="ProductController">
        <jsp:include page="header.jsp" />
        <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Managing Purchase</span>
                    <h1>${UserLoggedIn}</h1>
                    <a href="welcome">Admin</a>
                    <a href="login">Please Login</a>
<!--                    
                </div>
                <!-- end panel heading -->
                <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="newsaleObject" action="addtocartt"
                                   enctype="multipart/form-data">







                            

                                



                               <div class="form-group">
                                    <select class="form-control" ng-model="sSproductid" ng-options="x.productname for x in productt" required="true">
                                        <option value="">-- Product Type --</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                <form:hidden  class="form-control" value="{{sSproductid.productid}}" path="productid"></form:hidden>
                                </div>
                                
                                 

                                <div class="form-group">
                                <form:input type="number" class="form-control"  path="quantity" placeholder="quantity" required="true"></form:input>
                                </div>
                                <div class="form-group">
                                <form:input type="number" class="form-control"  path="price" placeholder="price" required="true"></form:input>
                                </div>

                            <c:if test="${check}">
                                <form:button id="editbuttons" type="submit" class="btn">Add
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


            <div class="container" style="min-height: 400px;">
                <h3 style="text-align: center; color: #689f38"
                    style=" border-radius: 5px">Cart Page</h3>

                <c:if test="${cartempty}">
                    <div class="jumbotron container h4 animated fadeInDown delay-05s" id="jumbotrondiv" align="center">
                        There are No items in the cart<br>
                        <br>
                        <br> 
                        <a href="buyproductpage" type="button" id="continuebutton"
                           class="btn"><span class="glyphicon glyphicon-shopping-cart"></span>
                            Buy Products</a>
                    </div>
                </c:if>
                <c:if test="${!cartempty}">
                    <table class="table table-striped table-responsive animated fadeInDown delay-05s">
                        <thead>
                            <tr scope="row">
<!--                                <th style="width: 10%">Product</th>-->
                                <th style="width: 10%">Product Name</th>
                                <th style="width: 15%">Quantity</th>
                                <th style="width: 7%">Total Price</th>
                                <th style="width: 7%">Payable Amount</th>
                                <th style="width: 10%"></th>
                            </tr>
                        </thead>

                        <tbody ng-repeat="items in citems">
                            <tr scope="row" style="margin: 10px">

                                <td class="h4">{{items.pname}}</td>
                                <td><div class="input-group">
                                        <span class="input-group-btn"> <a
                                                href="editquantityy?getproductid={{items.pid}}&value=decrease"
                                                id="minusbutton" type="button" class="btn"> <span
                                                    class="glyphicon glyphicon-minus"></span>
                                            </a>
                                        </span> <input type="text" id="quantity"
                                                       class="form-control input-number" value="{{items.qty}}"
                                                       readonly="readonly" onfocus="this.blur()"> <span class="input-group-btn">
                                            <a
                                                href="editquantityy?getproductid={{items.pid}}&value=increase"
                                                id="plusbutton" type="button" class="btn"> <span
                                                    class="glyphicon glyphicon-plus"></span>
                                            </a>
                                        </span>
                                    </div></td>
                                <td>Tk.{{items.price}}</td>
                                <td>Tk.{{items.total}}</td>
                                <td><a href="removeproductitemm?pid={{items.pid}}"
                                       id="removebtn" class="btn btn-outline-danger"> <span
                                            class="glyphicon glyphicon-remove"></span> Remove
                                    </a></td>
                            </tr>
                        </tbody>

                        <tfoot>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <div class="pull-left">
                                <h4>
                                    <b>Grand Total</b>
                                </h4>
                            </div>
                        </td>
                        <td><h4 class="pull-left">
                                <b>Tk.${sessionScope.grandtotal2}</b>
                            </h4>
                        </td>
                        <td></td>
                        </tfoot>
                    </table>
<!--                    <div class="pull-right" style="display: inline-block">
                        <a href="buyproductpage" type="button" id="continuebutton"
                           class="btn"><span
                                class="glyphicon glyphicon-shopping-cart"></span> Continue shopping</a>
                        <a href="billingaddresspage" class="btn" id="checkoutbutton"><span
                                class="glyphicon glyphicon-tasks"></span> Proceed To Order </a>	
                    </div>-->
                </c:if>
            </div>


            <div class="panel-body">
                    <div class="formcontainer ">

                        <form:form commandName="newsaleObject" action="addsaleshow"
                                   enctype="multipart/form-data">







                            <div class="form-group">
                                <select class="form-control" ng-model="customerid" ng-options="x.customerid as x.customername for x in customerlist" required="true">
                                    <option value="">-- Cutomer Name --</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <form:hidden  class="form-control" value="{{customerid}}" path="customerid"></form:hidden>
                                </div>

                                
                                 <div class="form-group">
                                <form:input type="number" class="form-control"  path="billtotal" placeholder="Total-bill" required="true" value="${sessionScope.grandtotal2}" readonly="true" ></form:input>
                                </div>

                                <div class="form-group">
                                <form:input type="text" class="form-control"  path="saledate" placeholder="Sale Date" required="true" ></form:input>
                                </div>
                                



                               

                                

                            <c:if test="${check}">
                                <form:button id="editbuttons" type="submit"  name="Add" class="btn">Confirm
                                   </form:button>
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
        </div>

        <jsp:include page="footer.jsp" />

        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>


        <script>
                                        $(document).ready(function () {
                                            var date_input = $('input[name="saledate"]'); //our date input has the name "date"
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
