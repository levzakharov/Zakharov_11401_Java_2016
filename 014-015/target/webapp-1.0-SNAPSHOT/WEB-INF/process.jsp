<%--
  Created by IntelliJ IDEA.
  User: lzakharov
  Date: 19.03.16
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Process</title>
</head>
<body>
    <form name="process" action="/process" method="post">
        <textarea name="text"></textarea>
        <select name="operation">
            <option disabled>Выберете операцию</option>
            <option disabled>Выберите операцию</option>" +
            <option value=symbols-cnt>Количество символов</option>
            <option value=words-cnt>Количество слов</option>
            <option value=sentences-cnt>Количество предложений</option>
            <option value=paragraphs-cnt>Количество абзацев</option>
        </select>
        <input name="process" value="Process!" type="submit">
    </form>
</body>
</html>
