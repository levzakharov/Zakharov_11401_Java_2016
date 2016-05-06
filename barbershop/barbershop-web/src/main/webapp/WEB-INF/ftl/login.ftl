<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">

    <title>Войти</title>

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

<body style="background:#F7F7F7;">
<div class="">
    <div id="wrapper">
        <div id="login" class=" form">
            <section class="login_content">
                <form action="/login/process" method="post">
                    <h1>Вход</h1>
                    <div>
                        <input name="login" type="text" class="form-control" placeholder="login" required=""/>
                    </div>
                    <div>
                        <input name="password" type="password" class="form-control" placeholder="Пароль" required=""/>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-success">Войти</button>
                    </div>
                    <div class="clearfix"></div>
                    <div class="separator">
                        <p class="change_link"> Не зарегистрированы?
                            <a href="/registration" class="to_register"> Зарегистрироваться </a>
                        </p>
                        <div class="clearfix"></div>
                        <br/>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>

</html>
