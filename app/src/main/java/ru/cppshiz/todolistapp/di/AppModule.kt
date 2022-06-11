package ru.cppshiz.todolistapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.cppshiz.todolistapp.feature_todo.data.data_source.TodoDatabase
import ru.cppshiz.todolistapp.feature_todo.data.repository.TodoRepositoryImpl
import ru.cppshiz.todolistapp.feature_todo.domain.repository.TodoRepository
import ru.cppshiz.todolistapp.feature_todo.domain.use_case.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(app: Application): TodoDatabase {
        return Room.databaseBuilder(
            app,
            TodoDatabase::class.java,
            TodoDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: TodoDatabase): TodoRepository {
        return TodoRepositoryImpl(db.todoDao)
    }

    @Provides
    @Singleton
    fun provideTodoUseCases(repository: TodoRepository): TodosUseCases {
        return TodosUseCases(
            getTodos = GetTodos(repository),
            deleteTodo = DeleteTodo(repository),
            addTodo = AddTodo(repository),
            getTodo = GetTodo(repository)
        )
    }
}
