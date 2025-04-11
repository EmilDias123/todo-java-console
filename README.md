# 📝 Java TODO-List CLI Application

Простое консольное Java-приложение для управления списком задач (TODO) с возможностью сохранения в JSON-файл.

## 🚀 Возможности

- ✅ Добавление новой задачи с датой
- 📋 Просмотр всех задач
- ✔ Отметить задачу как выполненную
- 🗑 Удаление задачи по ID
- 💾 Сохранение задач в `tasks.json` при выходе
- 📂 Автоматическая загрузка при запуске

## 🛠 Используемые технологии

- Java 17+ (поддерживается Java 24)
- Jackson (для сериализации JSON и `LocalDate`)
- Maven (опционально)

## 📁 Структура проекта

src/
   ├── org.example 
   │   └── Main.java 
       ├── org.example.model 
       │   └── Task.java 
       ├── org.example.service 
       │   └── TaskManager.java 
       ├── org.example.storage 
       │   └── FileStorage.java 
       └── org.example.ui 
           └── ConsoleUI.java

## ⚙️ Как запустить

1. Склонируйте проект:

```bash
git clone https://github.com/EmilDias123/todo-java-console.git
cd todo-java-console

2. Скомпилируйте и запустите:
javac -d out $(find ./src -name "*.java")
java -cp out org.example.Main

## 📂 Сохранение задач
Задачи сохраняются в: target/tasks.json

Формат хранения:
[
  {
    "id": 0,
    "title": "Закончить диплом",
    "deadline": "2025-04-11",
    "done": false
  }
]

## 💻 Интерфейс

1 - Добавление новой задачи
2 - Показать все задачи
3 - Отметить задачу как выполненную
4 - Удалить задачу по ID
9 - Завершение приложения

## 🧑‍💻 Автор
Создатель: Юрий Черединов
GitHub: EmilDias123

📄 Лицензия
Проект с открытым исходным кодом (MIT License).

Репозиторий: github.com/EmilDias123/todo-java-console
