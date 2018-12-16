<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <H3>Информация о страховых организациях</H3>
</div>
<div>
    <H4>Ввод данных</H4>
</div>
<div>
    <form method="post" action="text">
        <table border="0">
            <tr>
                <td align="right">
                    Введите наименование организации
                </td>
                <td>
                    <input type="text" name="nameOrg" placeholder="Input text here"
                           value="<#if info ??>${info.nameOrg}</#if>">
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
                </td>
            </tr>
            <tr>
                <td align="right">
                    Введите ИНН
                </td>
                <td>
                    <div>
                        <input type="text" name="inn" minlength="10" maxlength="10" placeholder="Input text here"
                               value="<#if info ??>${info.inn}</#if>">
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
                </td>
            </tr>
            <tr>
                <td align="right">
                    Введите ОГРН
                </td>
                <td>
                    <div>
                        <input type="text" name="ogrn" minlength="13" maxlength="15" placeholder="Input text here"
                               value="<#if info ??>${info.ogrn}</#if>">
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
                </td>
            </tr>
            <tr>
                <td align="right">
                    Введите Адрес
                </td>
                <td>
                    <div>
                        <input type="text" name="address" placeholder="Input text here"
                               value="<#if info ??>${info.address}</#if>">
                        <div style="color: red">
                <#if addressError??>
                    <div>
                        ${addressError}
                    </div>
                </#if>
                        </div>
                    </div>
                </td>
            </tr>
            <br>
            <tr>
                <td></td>
                <td align="right">
                    <button type="submit">Отправить</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<br>
<div><H4>Поиск по таблице</H4></div>
<form method="get" action="/">
    <select name="selectFilter">
        <option value="1">Все поля</option>
        <option value="2">Наименование организации</option>
        <option value="3">ИНН</option>
        <option value="4">ОГРН</option>
        <option value="5">Адрес</option>
    </select>
    <input type="text" name="filter" placeholder="Input text here" value="${filter?ifExists}">
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
        Информация не найдена
        </#list>
    </table>
</div>
</@c.page>