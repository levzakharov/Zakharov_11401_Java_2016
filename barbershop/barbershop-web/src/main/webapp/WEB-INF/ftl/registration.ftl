<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
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
                <@form.form action="/registration" modelAttribute="registration-form" method="post">
                    <h1>Регистрация</h1>
                    <div>
                        <@form.input path="login" id="input-login" placeholder="Логин" required="required" cssClass="form-control col-md-7 col-xs-12" />
                        <@form.errors path="login" cssClass="alert"/>
                    </div>
                    <div>
                        <@form.password path="password" id="password" placeholder="Пароль" class="form-control" />
                        <@form.errors path="password" cssClass="alert"/>
                    </div>
                    <div>
                        <@form.input path="firstName" id="first-name" placeholder="Имя" required="required" cssClass="form-control col-md-7 col-xs-12" />
                        <@form.errors path="firstName" cssClass="alert"/>
                    </div>
                    <div>
                        <@form.input path="lastName" id="last-name" placeholder="Фамилия" cssClass="form-control col-md-7 col-xs-12" />
                        <@form.errors path="lastName" cssClass="alert"/>
                    </div>
                    <div>
                        <@form.select path="gender" id="gender" class="form-control">
                            <@form.option value="M">Мужской</@form.option>
                            <@form.option value="F">Женский</@form.option>
                        </@form.select>
                    </div>
                    <br/>
                    <div>
                        <@form.input path="birthdate" id="birthday" cssClass="date-picker form-control col-md-7 col-xs-12" required="required" placeholder="DD.MM.YYYY" />
                        <@form.errors path="birthdate" cssClass="alert"/>
                    </div>

                    <div>
                        <button type="submit" class="btn btn-success">Зарегистрироваться</button>
                    </div>
                    <div class="clearfix"></div>
                    <div class="separator">
                        <p class="change_link"> Зарегистрированы?
                            <a href="/login"> Войти </a>
                        </p>
                        <div class="clearfix"></div>
                        <br/>
                    </div>
                </@form.form>
            </section>
        </div>
    </div>
</div>
</body>

</html>
