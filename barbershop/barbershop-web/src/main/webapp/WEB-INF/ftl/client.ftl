<#include "client-template.ftl"/>

<#macro content>

<!-- page content -->
<div class="">
    <div class="page-title">
        <div class="title_left">
            <h3>Записаться</h3>
        </div>

    </div>
    <div class="clearfix"></div>

    <div class="row">

        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <!-- Smart Wizard -->
                    <div id="wizard" class="form_wizard wizard_horizontal">
                        <ul class="wizard_steps">
                            <li>
                                <a href="#step-1">
                                    <span class="step_no">1</span>
                            <span class="step_descr">
                                Шаг 1
                                <br/>
                                <small>Выберите парикмахерскую</small>
                            </span>
                                </a>
                            </li>
                            <li>
                                <a href="#step-2">
                                    <span class="step_no">2</span>
                            <span class="step_descr">
                                              Шаг 2<br/>
                                              <small>Выберете парикмахера</small>
                                          </span>
                                </a>
                            </li>
                            <li>
                                <a href="#step-3">
                                    <span class="step_no">3</span>
                            <span class="step_descr">
                                              Шаг 3<br/>
                                              <small>Выберете услугу</small>
                                          </span>
                                </a>
                            </li>
                            <li>
                                <a href="#step-4">
                                    <span class="step_no">4</span>
                            <span class="step_descr">
                                              Шаг 4<br/>
                                              <small>Выберете дату</small>
                                          </span>
                                </a>
                            </li>
                            <li>
                                <a href="#step-5">
                                    <span class="step_no">5</span>
                            <span class="step_descr">
                                              Шаг 5<br/>
                                              <small>Выберете время</small>
                                          </span>
                                </a>
                            </li>
                        </ul>

                        <!-- FORM -->

                        <form class="form-horizontal form-label-left">
                            <div id="step-1">
                                <div class="form-group">
                                    <label class="col-md-3 col-sm-3 col-xs-12 control-label">Парикмахерские
                                        <br>
                                        <small class="text-navy">Выберете парикмахерскую</small>
                                    </label>

                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <#list barbershops as barbershop>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="barbershop-id" checked="checked"
                                                           class="flat" value="${barbershop.id}"> ${barbershop.address}
                                                </label>
                                            </div>
                                        </#list>
                                    </div>
                                </div>
                            </div>

                            <div id="step-2">

                                <div class="form-group">
                                    <label class="col-md-3 col-sm-3 col-xs-12 control-label">Парикмахеры
                                        <br>
                                        <small class="text-navy">Выберете парикмахера</small>
                                    </label>

                                    <div id="barbers" class="col-md-9 col-sm-9 col-xs-12">
                                        <div class="radio">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div id="step-3">
                                <div class="form-group">
                                    <label class="col-md-3 col-sm-3 col-xs-12 control-label">Услуги
                                        <br>
                                        <small class="text-navy">Выберете услугу</small>
                                    </label>

                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                        <#list attendances as attendance>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="attendance-id" checked="checked"
                                                           class="flat" value="${attendance.id}"> ${attendance.name} (${attendance.price}.руб)
                                                </label>
                                            </div>
                                        </#list>
                                    </div>
                                </div>
                            </div>
                            <div id="step-4">
                                <div class="form-group">
                                    <label class="col-md-3 col-sm-3 col-xs-12 control-label">Дата
                                        <br>
                                        <small class="text-navy">Выберете дату</small>
                                    </label>

                                    <div class="col-md-6 col-sm-6 col-xs-9">
                                        <input type="date" id="rdate" name="rdate" class="date-picker form-control col-md-4 col-xs-8" placeholder="DD.MM.YYYY" required="required">
                                    </div>
                                </div>
                            </div>
                            <div id="step-5">
                                <div class="form-group">
                                    <label class="col-md-3 col-sm-3 col-xs-12 control-label">Время
                                        <br>
                                        <small class="text-navy">Выберете время</small>
                                    </label>

                                    <div class="col-md-6 col-sm-6 col-xs-9">
                                        <select id="time" class="form-control">
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- End SmartWizard Content -->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /page content -->

</#macro>

<@main title="Клиент"/>
