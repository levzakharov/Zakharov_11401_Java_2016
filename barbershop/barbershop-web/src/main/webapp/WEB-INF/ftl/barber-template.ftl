<#macro main title="Main">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title}</title>

    <!-- Bootstrap -->
    <link href="/resources/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/resources/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="/resources/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- jVectorMap -->
    <link href="/resources/css/maps/jquery-jvectormap-2.0.3.css" rel="stylesheet"/>

    <!-- Custom Theme Style -->
    <link href="/resources/css/custom.css" rel="stylesheet">

</head>
<body class="nav-md">

<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="/barber" class="site_title"><i class="fa fa-paw"></i> <span>Barbershop</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile">
                    <div class="profile_pic">
                        <img src="/resources/images/img.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Welcome,</span>
                        <h2>${user.firstName} ${user.lastName}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">

            <div class="nav_menu">
                <nav class="" role="navigation">
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>

                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                <img src="/resources/images/img.jpg" alt="">${user.firstName} ${user.lastName}
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">
                            <#--<li>-->
                            <#--<a href="/client/settings">-->
                            <#--<span>Settings</span>-->
                            <#--</a>-->
                            <#--</li>-->
                                <li><a href="/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>

        </div>
        <!-- /top navigation -->


        <!-- page content -->
        <div class="right_col" role="main">
            <@content/>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <#include "footer.ftl"/>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="/resources/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/resources/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/resources/vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="/resources/vendors/Chart.js/dist/Chart.min.js"></script>
<!-- gauge.js -->
<script src="/resources/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="/resources/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="/resources/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="/resources/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="/resources/vendors/Flot/jquery.flot.js"></script>
<script src="/resources/vendors/Flot/jquery.flot.pie.js"></script>
<script src="/resources/vendors/Flot/jquery.flot.time.js"></script>
<script src="/resources/vendors/Flot/jquery.flot.stack.js"></script>
<script src="/resources/vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="/resources/js/flot/jquery.flot.orderBars.js"></script>
<script src="/resources/js/flot/date.js"></script>
<script src="/resources/js/flot/jquery.flot.spline.js"></script>
<script src="/resources/js/flot/curvedLines.js"></script>
<!-- jVectorMap -->
<script src="/resources/js/maps/jquery-jvectormap-2.0.3.min.js"></script>
<!-- jQuery Smart Wizard -->
<script src="/resources/vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="/resources/js/moment/moment.min.js"></script>
<script src="/resources/js/datepicker/daterangepicker.js"></script>
<!-- Datatables -->
<script src="/resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="/resources/js/custom.js"></script>

<!-- Datatables -->
<script>
    $(document).ready(function() {
        $('#datatable').dataTable();
    });
</script>
<!-- /Datatables -->

</body>
</html>
</#macro>