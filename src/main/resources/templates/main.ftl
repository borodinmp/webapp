<#import "parts/common.ftl" as c>
<@c.page>

<div>
    <form method="post" action="text">
        <div><input type="text" name="nameOrg" placeholder="Input text here"
                    value="<#if info ??>${info.nameOrg}</#if>">
            Введите наименование организации
            <div style="color: red">
        <#if nameOrgError??>
            <div>
                ${nameOrgError}
            </div>
        </#if>
                <#if checkNameOrg??>
                      <div class="invalid-feedback">
                          ${checkNameOrg}
                      </div>
                 </#if>
            </div>
        </div>
        <br>
        <div><input type="text" name="inn" minlength="10" maxlength="12" placeholder="Input text here"
                    value="<#if info ??>${info.inn}</#if>"> Введите ИНН
            <div style="color: red">
                <#if innError??>
                    <div>
                        ${innError}
                    </div>
                </#if>
                <#if checkInn??>
                    <div>
                        ${checkInn}
                    </div>
                </#if>
            </div>
        </div>
        <br>
        <div><input type="text" name="ogrn" minlength="13" maxlength="15" placeholder="Input text here"
                    value="<#if info ??>${info.ogrn}</#if>"> Введите ОГРН
            <div style="color: red">
                <#if ogrnError??>
                    <div>
                        ${ogrnError}
                    </div>
                </#if>
                <#if checkOgrn??>
                    <div>
                        ${checkOgrn}
                    </div>
                </#if>
            </div>
        </div>
        <br>
        <div><input type="text" name="address" placeholder="Input text here"
                    value="<#if info ??>${info.address}</#if>">
            Введите адрес
            <div style="color: red">
                <#if addressError??>
                    <div>
                        ${addressError}
                    </div>
                </#if>
            </div>
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