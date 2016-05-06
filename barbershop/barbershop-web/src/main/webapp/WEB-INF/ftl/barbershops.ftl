<#include "admin-template.ftl"/>

<#macro content>
    <#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<div class="page-title">
    <div class="title_left">
        <h3>Парикмахерские</h3>
    </div>
</div>

<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Добавить парикмахерскую</h2>
                <ul class="nav navbar-right panel_toolbox">
                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br/>

                <@form.form action="/admin/barbershops" method="post" modelAttribute="barbershop-form" cssClass="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">Адрес <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="address" id="address" required="required" cssClass="form-control col-md-7 col-xs-12" />
                            <@form.errors path="address" cssClass="alert"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">Телефон <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="phone" id="phone" required="required" cssClass="form-control col-md-7 col-xs-12" />
                            <@form.errors path="phone" cssClass="alert"/>
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
            <table id="datatable" class="table table-hover">
                <thead>
                <tr>
                    <th>Адрес</th>
                    <th>Телефон</th>
                    <th>Операция</th>
                </tr>
                </thead>

                <tbody>
                    <#list barbershops as barbershop>
                    <tr onclick="location.href = '/admin/barbershop/${barbershop.id}';">
                        <td>${barbershop.address}</td>
                        <td>${barbershop.phone}</td>
                        <td>
                            <a class="btn btn-danger btn-xs" href="/admin/barbershops/delete/${barbershop.id}">
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

<@main title="Парикмахеские"/>