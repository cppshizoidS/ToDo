package ru.cppshiz.todolistapp.feature_todo.domain.use_case

data class TodosUseCases(
    val getTodos: GetTodos,
    val deleteTodo: DeleteTodo,
    val addTodo: AddTodo,
    val getTodo: GetTodo
)
