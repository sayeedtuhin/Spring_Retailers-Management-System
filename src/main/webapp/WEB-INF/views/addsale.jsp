<%-- 
    Document   : addproduct
    Created on : Nov 25, 2018, 5:18:28 PM
    Author     : User
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Admin - Add Sale</title>
        <link href="resources/dashboard/img/logo.ico" rel="shortcut icon" />
        <!-- Bootstrap core CSS-->
        <link href="resources/dashboard/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="resources/dashboard/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="resources/dashboard/datatables/dataTablesbootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="resources/dashboard/cssnew/sb-admin.css" rel="stylesheet">
        <script src="resources/dashboard/js/angular.js"></script>

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
//                        $scope.cars = {
//                            0: {supplierId: "1", supplierName: "TCLD", supplierAddress: "Dhaka", supplierPhone: "017654321"},
//                            1: {supplierId: "2", supplierName: "IBM", supplierAddress: "Dhaka", supplierPhone: "01765432"}
//                        }
                    });
        </script>
    </head>
    <body id="page-top" ng-app="organocartpackage" ng-controller="ProductController">
        <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

            <a class="navbar-brand mr-1" href="admin">Retailers Management</a>

            <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
                <i class="fas fa-bars"></i>
            </button>

            <!-- Navbar Search -->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="button">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </form>

            <!-- Navbar -->
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-bell fa-fw"></i>
                        <span class="badge badge-danger">9+</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown no-arrow mx-1">
                    <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-envelope fa-fw"></i>
                        <span class="badge badge-danger">7</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-circle fa-fw"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="#">Hello ${sessionScope.UserLoggedIn}</a>
                        <a class="dropdown-item" href="<%=request.getContextPath()%>">Home</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
                    </div>
                </li>
            </ul>

        </nav>

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="welcome">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Vendor</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                         
                        <a class="dropdown-item" href="showingvendorinfo2">View Vendor</a>
                        <a class="dropdown-item" href="showingvendorinfo">Add Vendor</a>
                        
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Product</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        
                        <a class="dropdown-item" href="showproduct">View Product</a>
                        <a class="dropdown-item" href="showingcategorypage">Add Product</a>
                        
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Purchase</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        
                        <a class="dropdown-item" href="showcartpage">Purchase Product</a>
                        <a class="dropdown-item" href="viewShowpurchase">Purchase Details</a>
                        
                    </div>
                </li>
                
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Payment</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        
                        <a class="dropdown-item" href="showvendorpaytpage">Add Payment</a>
                        <a class="dropdown-item" href="showvendorpaytpage2">View Payment</a>
                        
                    </div>
                </li>
                
                
                 <li class="nav-item">
                    <a class="nav-link" href="showstock">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Stock</span></a>
                </li>
                
                
                
                
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Customer</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                         
                        <a class="dropdown-item" href="showingCustomerinfo2">View Customer</a>
                        <a class="dropdown-item" href="showingCustomerinfo">Customer Registration</a>
                        
                    </div>
                </li>
                
                
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Sale</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        
                         <a class="dropdown-item" href="showcartpage1">Sale Product</a>
                       <a class="dropdown-item" href="viewShowsale">Sale Details</a>
                        
                    </div>
                </li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Receive-Payment</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        
                        <a class="dropdown-item" href="showreceivepaytpage">Add Receive</a>
                        <a class="dropdown-item" href="showreceivepaytpage2">View Receive</a>
                        
                    </div>
                </li>
                
                
                
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Employee</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        
                        <a class="dropdown-item" href="showingEmployeeinfo2">View Employee</a>
                        <a class="dropdown-item" href="showingEmployeeinfo">Employee Registration</a>
                        
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Emp-Salary</span>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                        
                        <a class="dropdown-item" href="showsalarytpage2">View Salary</a>
                        <a class="dropdown-item" href="showsalarytpage">Add Salary</a>
                        
                    </div>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="tables.html">
                        <i class="fas fa-fw fa-table"></i>
                        <span>Tables</span></a>
                </li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid"
             style="width: 90%; margin-top: 10px; margin-bottom: 10px">

            <div class="panel animated fadeInDown delay-05s" id="panel-1">
                <div class="panel-heading">
                    <span class="lead">Managing Sale</span>
                    
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
                                  Sale</form:button>
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
        
                <!-- /.content-wrapper -->

            </div>
            <!-- /#wrapper -->

            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>

            <!-- Logout Modal-->
            <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <a class="btn btn-primary" href="logout">Logout</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="resources/dashboard/jquery/jquery.min.js"></script>
        <script src="resources/dashboard/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/dashboard/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="resources/dashboard/chart/Chartmin.js"></script>
        <script src="resources/dashboard/datatables/jquerydataTables.js"></script>
        <script src="resources/dashboard/datatables/dataTablesbootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/dashboard/jsnew/sb-adminmin.js"></script>

        <!-- Demo scripts for this page-->
        <script src="resources/dashboard/jsnew/demo/datatablesdemo.js"></script>
        <script src="resources/dashboard/jsnew/demo/chartareademo.js"></script>

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
            <!--<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>-->

            <!-- Include Date Range Picker -->
            

            <!--     Form code begins 
                <form method="post">
                  <div class="form-group">  Date input 
                    <label class="control-label" for="date">Date</label>
                    <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
                  </div>
                 </form>-->
    </body>
</html>
