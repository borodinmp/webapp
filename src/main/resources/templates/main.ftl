<#import "parts/common.ftl" as c>
<@c.page>

<div>
    <form method="post" action="text">
        <div><input type="text" name="nameOrg" placeholder="Input text here" required> Введите наименование организации
        </div>
        <br>
        <div><input type="text" name="inn" placeholder="Input text here" required minlength="10" maxlength="12"> Введите ИНН
        </div>
        <br>
        <div><input type="text" name="ogrn" placeholder="Input text here" required minlength="13" maxlength="15"> Введите ОГРН
        </div>
        <br>
        <div><input type="text" name="address" placeholder="Input text here" required> Введите адрес
        </div>
        <br>
        <button type="submit">Отправить</button>
    </form>
</div>

<br>
<div>Поиск по таблице</div>
<form method="get" action="/">
    <select name="selectFilter">
        <option value="1">Все поля</option>
        <option value="2">Наименование организации</option>
        <option value="3">ИНН</option>
        <option value="4">ОГРН</option>
        <option value="5">Адрес</option>
    </select>
    <input type="text" name="filter" value="${filter?ifExists}">
    <button type="submit">Найти</button>
</form>
<br>

<div>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Наименование организации</th>
            <th>Инн</th>
            <th>ОГРН</th>
            <th>Адрес</th>
        </tr>
        <#list infos as information>
        <tr>
            <td>${information.id}</td>
            <td>${information.nameOrg}</td>
            <td>${information.inn}</td>
            <td>${information.ogrn}</td>
            <td>${information.address}</td>
        </tr>
        <#else>
        No info
        </#list>
    </table>
</div>

</@c.page>