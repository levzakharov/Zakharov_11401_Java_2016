<#include "admin-template.ftl"/>

<#macro content>
    <#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<div class="page-title">
    <div class="title_left">
        <h3>Услуги</h3>
    </div>
</div>

<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Добавить услуги</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br/>

                <@form.form action="/admin/attendances" method="post" modelAttribute="attendance-form" cssClass="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Название <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="name" id="name" required="required" cssClass="form-control col-md-7 col-xs-12" />
                            <@form.errors path="name" cssClass="alert"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="price">Цена <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="price" id="price" required="required" cssClass="form-control col-md-7 col-xs-12" />
                            <@form.errors path="price" cssClass="alert"/>
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-success">Submit</button>
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
            <table id="datatable" class="table">
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Цена</th>
                    <th>Операция</th>
                </tr>
                </thead>

                <tbody>
                    <#list attendances as attendance>
                    <tr>
                        <td>${attendance.name}</td>
                        <td>${attendance.price}руб.</td>
                        <td>
                            <a class="btn btn-danger btn-xs" href="/admin/attendances/delete/${attendance.id}">
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

<@main title="Услуги"/>