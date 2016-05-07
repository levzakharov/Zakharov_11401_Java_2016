<#include "barber-template.ftl"/>

<#macro content>

<!-- page content -->
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>История</h2>
                <div class="clearfix"></div>
            </div>
            <table id="datatable" class="table table-hover">
                <thead>
                <tr>
                    <th>Дата</th>
                    <th>Время</th>
                    <th>Клиент</th>
                    <th>Услуга</th>
                    <th>Цена</th>
                </tr>
                </thead>

                <tbody>
                    <#list records as record>
                    <tr>
                        <td>${record.date}</td>
                        <td>${record.hour}:00</td>
                        <td>${record.client.firstName} ${record.client.lastName}</td>
                        <td>${record.attendance.name}</td>
                        <td>${record.attendance.price}</td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- /page content -->

</#macro>

<@main title="Парикмахер"/>