<%-- 
    Document   : index
    Created on : Nov 25, 2018, 12:57:12 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png"/>
        <!-- Author Meta -->
        <meta name="author" content="colorlib"/>
        <!-- Meta Description -->
        <meta name="description" content=""/>
        <!-- Meta Keyword -->
        <meta name="keywords" content=""/>
        <!-- meta character set -->
        <meta charset="UTF-8"/>
        <!-- Site Title -->
        <title>Education</title>

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"/> 
        <!--
        CSS
        ============================================= -->
        <link rel="stylesheet" href="resources/plugin/css/linearicons.css"/>
        <link rel="stylesheet" href="resources/plugin/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="resources/plugin/css/bootstrap.css"/>
        <link rel="stylesheet" href="resources/plugin/css/magnific-popup.css"/>
        <link rel="stylesheet" href="resources/plugin/css/nice-select.css"/>							
        <link rel="stylesheet" href="resources/plugin/css/animate.min.css"/>
        <link rel="stylesheet" href="resources/plugin/css/owl.carousel.css"/>			
        <link rel="stylesheet" href="resources/plugin/css/jquery-ui.css"/>			
        <link rel="stylesheet" href="resources/plugin/css/main.css"/>
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}

            /* Full-width input fields */
            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            /* Set a style for all buttons */
            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            /* Center the image and position the close button */
            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
                position: relative;
            }

            img.avatar {
                width: 40%;
                border-radius: 50%;
            }

            .container {
                padding: 16px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                padding-top: 60px;
            }

            /* Modal Content/Box */
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                border: 1px solid #888;
                width: 35%; /* Could be more or less, depending on screen size */
            }

            /* The Close Button (x) */
            .close {
                position: absolute;
                right: 25px;
                top: 0;
                color: #000;
                font-size: 35px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }

            /* Add Zoom Animation */
            .animate {
                -webkit-animation: animatezoom 0.6s;
                animation: animatezoom 0.6s
            }

            @-webkit-keyframes animatezoom {
                from {-webkit-transform: scale(0)} 
                to {-webkit-transform: scale(1)}
            }

            @keyframes animatezoom {
                from {transform: scale(0)} 
                to {transform: scale(1)}
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
        <header id="header" >
            <div class="header-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-sm-6 col-8 header-top-left no-padding">
                            <ul>
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-behance"></i></a></li>
                            </ul>			
                        </div>
                        <div class="col-lg-6 col-sm-6 col-4 header-top-right no-padding">
                            <a href="tel:+953 012 3654 896"><span class="lnr lnr-phone-handset"></span> <span class="text">+953 012 3654 896</span></a>
                            <a href="mailto:support@colorlib.com"><span class="lnr lnr-envelope"></span> <span class="text">support@colorlib.com</span></a>			
                        </div>
                    </div>			  					
                </div>
            </div>
            <div class="container main-menu">
                <div class="row align-items-center justify-content-between d-flex">
                    <div id="logo">
                        <a href="index.html"><img src="img/aaslogo.png" alt="" title="" /></a>
                    </div>
                    <nav id="nav-menu-container">
                        <ul class="nav-menu">
                            <li><a href="">Home</a></li>
                            <li><a href="">About</a></li>
                            <li><a href="">Courses</a></li>
                            <li><a href="">Events</a></li>
                            <li><a href="">Gallery</a></li>


                            <li><a href="">Contact</a></li>

                            <li> <a href="login">Login</a></li>

                            

                           



                        </ul>
                    </nav><!-- #nav-menu-container -->		    		
                </div>
            </div>
        </header><!-- #header -->

<br/><br/><br/>
        <section class="search-course-area relative">
            <div class="overlay overlay-bg"></div>
            <div class="container">
                <div class="row justify-content-between align-items-center">
                    <div class="col-lg-6 col-md-6 search-course-left">
                        <h1 class="text-white">
                            Get reduced fee <br/>
                            during this Summer!
                        </h1>
                        <p>
                            inappropriate behavior is often laughed off as “boys will be boys,” women face higher conduct standards especially in the workplace. That’s why it’s crucial that, as women, our behavior on the job is beyond reproach.
                        </p>
                        <div class="row details-content">
                            <div class="col single-detials">
                                <span class="lnr lnr-graduation-hat"></span>
                                <a href="#"><h4>Expert Instructors</h4></a>		
                                <p>
                                    Usage of the Internet is becoming more common due to rapid advancement of technology and power.
                                </p>						
                            </div>
                            <div class="col single-detials">
                                <span class="lnr lnr-license"></span>
                                <a href="#"><h4>Certification</h4></a>		
                                <p>
                                    Usage of the Internet is becoming more common due to rapid advancement of technology and power.
                                </p>						
                            </div>								
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 search-course-right section-gap">
                       
                           		
                            <f:view class="form-wrap" >
                                <h:form>
                                    <h:panelGrid columns="6" border="1">
                                        <f:facet name="header"/>
                                        <h:panelGrid columns="2" border="1" cellpadding="5" cellspacing="1">
                                            <h:outputLabel value="user name :"/>
                                            <h:inputText  value=""/>
                                            <h:outputLabel value="password : "/>
                                            <h:inputText value=""/>
                                            <h:outputLabel value="Fullname : "/>
                                            <h:inputText value=""/>
                                            <h:outputLabel value=" address : "/>
                                            <h:inputText value=""/>
                                            <f:facet name="footer">
                                                <h:outputLabel value="" id="mss"/>
                                                <h:commandButton  id="but1" action="" value="Registration">
                                                    
                                                </h:commandButton>

                                            </f:facet>


                                        </h:panelGrid>

                                    </h:panelGrid>
                                </h:form>
                            </f:view>
                            									
                            
                        
                    </div>
                </div>
            </div>	
        </section>

        <footer class="footer-area section-gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>Top Products</h4>
                            <ul>
                                <li><a href="#">Managed Website</a></li>
                                <li><a href="#">Manage Reputation</a></li>
                                <li><a href="#">Power Tools</a></li>
                                <li><a href="#">Marketing Service</a></li>
                            </ul>								
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>Quick links</h4>
                            <ul>
                                <li><a href="#">Jobs</a></li>
                                <li><a href="#">Brand Assets</a></li>
                                <li><a href="#">Investor Relations</a></li>
                                <li><a href="#">Terms of Service</a></li>
                            </ul>								
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>Features</h4>
                            <ul>
                                <li><a href="#">Jobs</a></li>
                                <li><a href="#">Brand Assets</a></li>
                                <li><a href="#">Investor Relations</a></li>
                                <li><a href="#">Terms of Service</a></li>
                            </ul>								
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>Resources</h4>
                            <ul>
                                <li><a href="#">Guides</a></li>
                                <li><a href="#">Research</a></li>
                                <li><a href="#">Experts</a></li>
                                <li><a href="#">Agencies</a></li>
                            </ul>								
                        </div>
                    </div>																		
                    <div class="col-lg-4  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>Newsletter</h4>
                            <p>Stay update with our latest</p>
                            <div class="" id="mc_embed_signup">
                                <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="EMAIL" placeholder="Enter Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email Address '" required="" />
                                        <div class="input-group-btn">
                                            <button class="btn btn-default" type="submit">
                                                <span class="lnr lnr-arrow-right"></span>
                                            </button>    
                                        </div>
                                        <div class="info"></div>  
                                    </div>
                                </form> 
                            </div>
                        </div>
                    </div>											
                </div>
                <div class="footer-bottom row align-items-center justify-content-between">
                    <p class="footer-text m-0 col-lg-6 col-md-12"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> &amp; distributed by <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    <div class="col-lg-6 col-sm-12 footer-social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-dribbble"></i></a>
                        <a href="#"><i class="fa fa-behance"></i></a>
                    </div>
                </div>						
            </div>
        </footer>	
        <!-- End footer Area -->	


        <script src="resources/plugin/js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="resources/plugin/js/vendor/bootstrap.min.js"></script>			
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
        <script src="resources/plugin/js/easing.min.js"></script>			
        <script src="resources/plugin/js/hoverIntent.js"></script>
        <script src="resources/plugin/js/superfish.min.js"></script>	
        <script src="resources/plugin/js/jquery.ajaxchimp.min.js"></script>
        <script src="resources/plugin/js/jquery.magnific-popup.min.js"></script>	
        <script src="resources/plugin/js/jquery.tabs.min.js"></script>						
        <script src="js/jquery.nice-select.min.js"></script>	
        <script src="resources/plugin/js/owl.carousel.min.js"></script>									
        <script src="resources/plugin/js/mail-script.js"></script>	
        <script src="resources/plugin/js/main.js"></script>	 
    </body>
</html>


