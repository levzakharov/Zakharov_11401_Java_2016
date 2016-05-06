<#include "admin-template.ftl"/>

<#macro content>
    <#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<div class="page-title">
    <div class="title_left">
        <h3>Парикмахеры</h3>
    </div>
</div>

<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Добавить парикмахера</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br/>

                <@form.form action="/admin/barbers" method="post" modelAttribute="barber-form" cssClass="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="login">Логин <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="login" id="input-login" required="required" cssClass="form-control col-md-7 col-xs-12" />
                            <@form.errors path="login" cssClass="alert"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Имя <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="firstName" id="first-name" required="required" cssClass="form-control col-md-7 col-xs-12" />
                            <@form.errors path="firstName" cssClass="alert"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Фамилия <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="lastName" id="last-name" cssClass="form-control col-md-7 col-xs-12" />
                            <@form.errors path="lastName" cssClass="alert"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password">Пароль</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.password path="password" id="password" class="form-control" />
                            <@form.errors path="password" cssClass="alert"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="gender">Выберите пол</label>
                        <div class="col-md-3 col-sm-3 col-xs-12">
                            <@form.select path="gender" id="gender" class="form-control">
                                <@form.option value="M">Мужской</@form.option>
                                <@form.option value="F">Женский</@form.option>
                            </@form.select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="birthday">Дата рождения<span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="birthdate" id="birthday"
                            cssClass="date-picker form-control col-md-7 col-xs-12" required="required"
                            placeholder="DD.MM.YYYY" />
                            <@form.errors path="birthdate" cssClass="alert"/>
                        </div>
                    </div>


                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-success">Добавить</button>
                        </div>
                    </div>
                </@form.form>
            </div>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <table id="datatable" class="table table-hover">
                <thead>
                <tr>
                    <th>Имя</th>
                    <th>Логин</th>
                    <th>Пароль</th>
                    <th>Пол</th>
                    <th>Дата рождения</th>
                    <th>Парикмахерская</th>
                    <th>Операция</th>
                </tr>
                </thead>

                <tbody>
                    <#list barbers as barber>
                    <tr onclick="location.href = '/admin/barbers/${barber.id}';">
                        <td>${barber.lastName} ${barber.firstName}</td>
                        <td>${barber.credential.login}</td>
                        <td>${barber.credential.password}</td>
                        <td>${barber.gender}</td>
                        <td>${barber.birthdate}</td>
                        <td>
                            <#if barber.barbershop??>
                            ${barber.barbershop.address}, ${barber.barbershop.phone}
                            <#else>
                                Нет
                            </#if>
                        </td>
                        <td>
                            <a class="btn btn-danger btn-xs" href="/admin/barbers/delete/${barber.id}">
                                <i class="fa fa-trash-o"></i>
                                Удалить
                            </a>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</#macro>

<@main title="Парикмахеры"/>