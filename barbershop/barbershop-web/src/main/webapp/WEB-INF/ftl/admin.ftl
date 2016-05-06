<#include "admin-template.ftl"/>

<#macro content>

<!-- top tiles -->
<div class="row tile_count">
    <div class="col-md-3 col-sm-4 col-xs-6 tile_stats_count">
        <span class="count_top"><i class="fa fa-user"></i> Количество пользователей</span>
        <div class="count">${total}</div>
    </div>
    <div class="col-md-3 col-sm-4 col-xs-6 tile_stats_count">
        <span class="count_top"><i class="fa fa-user"></i> Количество клиентов</span>
        <div class="count green">${clients_count}</div>
    </div>
    <div class="col-md-3 col-sm-4 col-xs-6 tile_stats_count">
        <span class="count_top"><i class="fa fa-user"></i> Количество парикмахеров</span>
        <div class="count green">${barbers_count}</div>
    </div>
    <div class="col-md-3 col-sm-4 col-xs-6 tile_stats_count">
        <span class="count_top"><i class="fa fa-scissors"></i> Количество заказов</span>
        <div class="count blue">${records_count}</div>
    </div>

</div>
<!-- /top tiles -->

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>Заказы</h2>
                <div class="clearfix"></div>
            </div>

            <div class="x_content">
                <table id="datatable" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Дата</th>
                        <th>Время</th>
                        <th>Парикмахер</th>
                        <th>Услуга</th>
                        <th>Цена</th>
                    </tr>
                    </thead>

                    <tbody>
                        <#list records as record>
                        <tr>
                            <td>${record.date}</td>
                            <td>${record.hour}:00</td>
                            <td>${record.barber.firstName} ${record.barber.lastName}</td>
                            <td>${record.attendance.name}</td>
                            <td>${record.attendance.price}</td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


</#macro>

<@main title="Администратор"/>