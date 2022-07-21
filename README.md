## Добро пожаловать в репозиторий RESP-API - приложения "Glossary"
Glossary
- API version: 0.0.1
  - Build date: 2022-07-21T12:56:34.978Z[GMT]

  For more information, please visit [https://github.com/Witcher26](https://github.com/Witcher26)


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven

## Installation

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```
Then manually install the following JARs:

* `target/swagger-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AdminControllerApi* | [**createDataBase**](docs/AdminControllerApi.md#createDataBase) | **POST** /adminController/v1/createDataBase | создание базы данных
*AdminControllerApi* | [**deleteDataBase**](docs/AdminControllerApi.md#deleteDataBase) | **DELETE** /adminController/v1/deleteDataBase | удаление базы данных
*AdminControllerApi* | [**getIsDatabaseInfo**](docs/AdminControllerApi.md#getIsDatabaseInfo) | **GET** /adminController/v1/getIsDatabaseInfo | получение информации о текущей базе данных
*AdminControllerApi* | [**getLoggerInfo**](docs/AdminControllerApi.md#getLoggerInfo) | **GET** /adminController/v1/getLoggerInfo | логгер
*AdminControllerApi* | [**swichDataBase**](docs/AdminControllerApi.md#swichDataBase) | **POST** /adminController/v1/switchDataBase/{isDataBase} | переключение баз данных
*DatabaseControllerApi* | [**readDatabase**](docs/DatabaseControllerApi.md#readDatabase) | **GET** /databaseController/v1/database/read | Ммтод чтения данных из базы данных
*DatabaseControllerApi* | [**updateDatabase**](docs/DatabaseControllerApi.md#updateDatabase) | **PUT** /databaseController/v1/database/update | метод обнолвения базы данных
*EngineControllerApi* | [**engine**](docs/EngineControllerApi.md#engine) | **POST** /engineController/v1/startEngine/{requestFromClientInJson} | метод добавления слова, удаления слова, вывод всех слов

## Documentation for Models

 - [ErrorDataBase](docs/ErrorDataBase.md)
 - [SuccessDataBase](docs/SuccessDataBase.md)
 - [SuccessDeletedDataBase](docs/SuccessDeletedDataBase.md)
 - [SuccessSwitchDataBase](docs/SuccessSwitchDataBase.md)

## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:



## Author

1816178@mail.ru

***
Для того, чтобы начать пользоваться данным REST-API, необходимо проделать следующие шаги:
+  развернуть приложение на компьютере и запустить его (Внимание, приложение необходимо развернуть на локальном компьютере, поскольку на удаленном сервере его нет).
+ запустить мануал по использованию:

![guide](img/2.guide.JPG)
+ выбрать браузер:

![запуск](img/3.%20browser.JPG)

Перед вами откроется интерактивное окно API-интерфейса:

![запуск](img/1.%20interface.JPG)

либо можете воспользоваться альтернативным способом - перейдя по указанной ссылке, предварительно запустив приложение:
http://localhost:8080/swagger-ui/index.html

Результат будет таким же.

**Первый блок запросов - запросы администратора, такие как**
- переключение между базами данных;
- удаление базы данных;
- создание базы данных;
- получение информации от логгера
- получение информации о текущей базе данных:

![](img/4_admin.JPG)

**Второй блок запросов - запросы взаимодействия с базой данных**
- чтение из базы данных;
- обновление базы данных.

![](img//5_datatbase.JPG)

**Третий блок запросов - запросы взаимодействия с хранилищем**
- добавление слова и его перевод;
- удаление слова;
- вывод всех слов

![](img/6_engine.JPG)

**Пример интерактивного окна метода из группы контролера Admin**

![](img/7_example.JPG)
