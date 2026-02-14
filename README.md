# Лабораторная работа №13-14
Коллекции, обобщения и функциональный стиль в Kotlin
## Описание
Данная лабораторная работа посвящена изучению продвинутых возможностей языкаKotlin,которые активно используются при разработке Android-приложений.
В рамках работы рассматриваются:
- обобщённые типы (Generics);
- коллекции Kotlin;
- функции высшего порядка;
- extension-функции;
  Все примеры ориентированы на практическое применение и подготовку к разработкемобильных приложений.

### Примеры, рассмотренные в работе:
- Работа с массивами и списками
- Работа с парами «ключ-значение»
- Использование singleton-объекта (object)
- Extension-свойства
- Классы данных (data class)
- Функции высшего порядка:
  - фильтрация (filter) — выбор мягкого печенья из списка;
  - сортировка (sortedBy) — сортировка печений по названию;
  - группировка (groupBy) — разделение печений на «мягкие» и «хрустящие»;
  - подсчёт суммы (fold) — вычисление общей стоимости печений.
- Обобщённые типы (Generic)

### Примеры кода 
Создание обобщённого класса Question
```kotlin
class Question<T>(
  val questionText: String,
  val answer: T,
  val difficulty: String
)
```
Использование extention-свойства
```kotlin
val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered"
```
Создание массива 
```kotlin
val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
```
Создание списка
```kotlin
val solarSystem = listOf(
    "Mercury", "Venus", "Earth", "Mars",
    "Jupiter", "Saturn", "Uranus", "Neptune"
)
```
Использование forEach()
```kotlin
cookies.forEach {
    println("Пункт меню: $it")
}
```
Использование map()
```kotlin
val fullMenu = cookies.map { "${it.name} - $$${it.price}" }
```
Использование filter()
```kotlin
val softBakedMenu = cookies.filter {
    it.softBaked
}
```
groupBy() для коллекций
```kotlin
val groupedMenu = cookies.groupBy { it.softBaked }
```
Использование fold()
```kotlin
val totalPrice = cookies.fold(initial = 0.0) { total, cookie -> total + cookie.price }
```
Функция sortedBy()
```kotlin
val alphabeticalMenu = cookies.sortedBy { it.name }
```




## Как запустить проект
1. Клонируйте репозиторий:
```bash
git clone https://github.com/gorbashevarita/Kotlin_Advanced_Lab_13_14_Gorbcheva.git
```
## Автор
[Горбачева Маргарита]
## Лицензия
Проект создан в учебных целях.