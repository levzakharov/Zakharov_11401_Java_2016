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
                    <a href="/client" class="site_title"><i class="fa fa-paw"></i> <span>Barbershop</span></a>
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
                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i> Меню <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/client">Записаться</a>
                                    </li>
                                    <li><a href="/client/history">История</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /sidebar menu -->
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

<!-- Custom Theme Scripts -->
<script src="/resources/js/custom.js"></script>

<!-- jQuery Smart Wizard -->
<script>
    $(document).ready(function () {
        $('#wizard').smartWizard({
            onLeaveStep: leaveStepCallback,
            onFinish: onFinishCallback
        });

        $('#wizard_verticle').smartWizard({
            transitionEffect: 'slide'
        });

        $('.buttonNext').addClass('btn btn-success');
        $('.buttonPrevious').addClass('btn btn-primary');
        $('.buttonFinish').addClass('btn btn-default');

        function leaveStepCallback(objs, context) {
            if (context.fromStep == 1) {
                var value = document.querySelector('input[name = "barbershop-id"]:checked').value;
                $.ajax({
                    type: 'POST',
                    url: '/client/get_barbers',
                    data: {
                        'barbershop_id': value
                    },
                    dataType: "json",
                    success: function (data) {
                        $('#barbers').html("");
                        for (var i = 0; i < data.length; i++) {
                            $('#barbers').append(
                                    "<div class='radio'>" +
                                    "<label>" +
                                    "<input type='radio' name='barber-id' checked='checked' class='flat' value='" + data[i].id + "' >" +
                                    data[i].firstName + " " + data[i].lastName +
                                    "</label>" +
                                    "</div>"
                            )
                        }
                    }
                });
            }
            if (context.fromStep == 4) {
                var rdate = document.querySelector('input[name = "rdate"]').value;
                var barber_id = document.querySelector('input[name = "barber-id"]:checked').value;
                var re = /^\d{2}\.\d{2}\.\d{4}$/;
                if (rdate == '') {
                    alert('Пожалуйста, укажите дату');
                    return false;
                }
                if (!rdate.match(re)) {
                    alert('Неверный формат даты');
                    return false;
                }
                $.ajax({
                    type: 'POST',
                    url: '/client/get_time',
                    data: {
                        'rdate': rdate,
                        'barber_id': barber_id
                    },
                    dataType: "json",
                    success: function (data) {
                        $('#time').html("");
                        for (var i = 0; i < data.length; i++) {
                            $('#time').append($("<option></option>")
                                    .attr("value", data[i])
                                    .text(data[i]));
                        }
                    }
                });
            }
            return true;
        }

        function onFinishCallback(objs, context) {
            var barber_id = document.querySelector('input[name = "barber-id"]:checked').value;
            var attendance_id = document.querySelector('input[name = "attendance-id"]:checked').value;
            var rdate = document.getElementById('rdate').value;
            var hour = document.getElementById('time').value;

            var form = document.createElement('form');
            form.method = 'POST';
            form.action = '/client';

            var input_barber_id = document.createElement("input");
            input_barber_id.setAttribute("type", "hidden");
            input_barber_id.setAttribute("name", "barber_id");
            input_barber_id.setAttribute("value", barber_id);
            form.appendChild(input_barber_id);

            var input_attendance_id = document.createElement("input");
            input_attendance_id.setAttribute("type", "hidden");
            input_attendance_id.setAttribute("name", "attendance_id");
            input_attendance_id.setAttribute("value", attendance_id);
            form.appendChild(input_attendance_id);

            var input_date = document.createElement("input");
            input_date.setAttribute("type", "hidden");
            input_date.setAttribute("name", "rdate");
            input_date.setAttribute("value", rdate);
            form.appendChild(input_date);

            var input_hour = document.createElement("input");
            input_hour.setAttribute("type", "hidden");
            input_hour.setAttribute("name", "hour");
            input_hour.setAttribute("value", hour);
            form.appendChild(input_hour);

            form.submit();
        }
    });
</script>
<!-- /jQuery Smart Wizard -->

</body>
</html>
</#macro>