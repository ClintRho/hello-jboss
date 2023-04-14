<html>
<head>
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>
  <p>Name: ${person.name}</p>
  <ul>
    <#list todos as todo>
      <li>${todo_index + 1}. Priority: ${todo.priority}, Description: ${todo.description}</li>
    </#list>
  </ul>
</body>
</html>
