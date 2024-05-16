# KATA Academy. PRE-PROJECT

### Студент: Ковалёв А.Н.
___

# Практическая задача 1.1.5 Java pre-project. Практическая задача 1.1.3. Работа с базой данных c помощью Hibernate.

---
## Практическая задача

В этом задании мы познакомимся с фреймворком Hibernate и научимся взаимодействовать с помощью него с базой данных.

### Для выполнения задания необходимо:
1. Ознакомиться с Hibernate. Подробнее узнать о Hibernate можно [Здесь](https://hibernate.org/orm/)
2. Готовая прошлая задача (работа будет происходить в этом же проекте)

### Описание задачи:
В прошлой задаче мы познакомились с Maven и JDBC, доработали приложение, взаимодействующее с базой данных.

На этот раз обратим внимание на класс UserHibernateDaoImpl, который реализует тот же интерфейс, что и UserDaoJdbcImpl.

В рамках этой задачи необходимо реализовать взаимодействие с базой данных с помощью Hibernate и дописать методы в классе UserHibernateDaoImpl,
проверить свои методы заранее написанными JUnit тестами из заготовки.

### Требования к классам приложения:

1. UserHibernateDaoImpl должен реализовывать интерфейс UserDao
2. В класс Util должна быть добавлена конфигурация для Hibernate (рядом с JDBC), без использования xml.
3. Service на этот раз использует реализацию dao через Hibernate
4. Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl должны быть реализованы с помощью SQL.

Алгоритм приложения и операции не меняются в сравнении с предыдущим заданием.
