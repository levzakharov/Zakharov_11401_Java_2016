<#include "admin-template.ftl"/>

<#macro content>
    <#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<div class="page-title">
    <div class="title_left">
        <h2>${barber.firstName} ${barber.lastName}</h2>
    </div>
</div>

<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Информация</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <br/>

                <@form.form action="/admin/barbers/${barber.id}" method="post" modelAttribute="barber-form"
                cssClass="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Имя <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="firstName" id="first-name" required="required"
                            cssClass="form-control col-md-7 col-xs-12" value="${barber.firstName}"/>
                            <@form.errors path="firstName" cssClass="alert"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Фамилия <span
                                class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <@form.input path="lastName" id="last-name" cssClass="form-control col-md-7 col-xs-12"
                            value="${barber.lastName}"/>
                            <@form.errors path="lastName" cssClass="alert"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="gender">Выберите пол</label>
                        <div class="col-md-3 col-sm-3 col-xs-12">
                            <@form.select path="gender" id="gender" class="form-control">
                                <#if barber.gender == "M">
                                    <@form.option value="M">Мужской</@form.option>
                                    <@form.option value="F">Женский</@form.option>
                                <#else>
                                    <@form.option value="F">Женский</@form.option>
                                    <@form.option value="M">Мужской</@form.option>
                                </#if>
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
                            value="${barber.birthdate}" />
                            <@form.errors path="birthdate" cssClass="alert"/>
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-success">Обновить</button>
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
            <div class="x_title">
                <h2>Выберете парикмахерскую</h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <form action="/admin/barbers/${barber.id}/barbershop" method="post"
                      class="form-horizontal form-label-left">
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="gender">Выберите
                            парикмихерскую</label>
                        <div class="col-md-3 col-sm-3 col-xs-12">
                            <select name="barbershop-id" id="barbershop" class="form-control">
                                <option value="-1">Нет</option>
                                <#list barbershops as barbershop>
                                    <option value="${barbershop.id}" <#if barber.barbershop??><#if barber.barbershop.id == barbershop.id>selected="selected"</#if></#if> >
                                        ${barbershop.address}
                                    </option>
                                </#list>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-success">Установить</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</#macro>

<@main title="Парикмахер"/>


