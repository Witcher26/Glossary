# DatabaseControllerApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**readDatabase**](DatabaseControllerApi.md#readDatabase) | **GET** /databaseController/v1/database/read | Метод чтения данных из базы данных
[**updateDatabase**](DatabaseControllerApi.md#updateDatabase) | **PUT** /databaseController/v1/database/update | Метод обнолвения базы данных

<a name="readDatabase"></a>
# **readDatabase**
> ErrorDataBase readDatabase()

Метод чтения данных из базы данных

по умолчанию активна база данных MongoD

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DatabaseControllerApi;


DatabaseControllerApi apiInstance = new DatabaseControllerApi();
try {
    ErrorDataBase result = apiInstance.readDatabase();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DatabaseControllerApi#readDatabase");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ErrorDataBase**](ErrorDataBase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateDatabase"></a>
# **updateDatabase**
> updateDatabase()

Метод обнолвения базы данных

по умолчанию активна база данных MongoD

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DatabaseControllerApi;


DatabaseControllerApi apiInstance = new DatabaseControllerApi();
try {
    apiInstance.updateDatabase();
} catch (ApiException e) {
    System.err.println("Exception when calling DatabaseControllerApi#updateDatabase");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

