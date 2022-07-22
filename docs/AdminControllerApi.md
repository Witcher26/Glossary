# AdminControllerApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createDataBase**](AdminControllerApi.md#createDataBase) | **POST** /adminController/v1/createDataBase | создание базы данныхек
[**deleteDataBase**](AdminControllerApi.md#deleteDataBase) | **DELETE** /adminController/v1/deleteDataBase | удаление базы данных
[**getIsDatabaseInfo**](AdminControllerApi.md#getIsDatabaseInfo) | **GET** /adminController/v1/getIsDatabaseInfo | получение информации о текущей базе данных
[**getLoggerInfo**](AdminControllerApi.md#getLoggerInfo) | **GET** /adminController/v1/getLoggerInfo | логгер
[**swichDataBase**](AdminControllerApi.md#swichDataBase) | **POST** /adminController/v1/switchDataBase/{isDataBase} | переключение базы данных

<a name="createDataBase"></a>
# **createDataBase**
> SuccessDataBase createDataBase()

создание базы данныхек

по умолчанию активна база данных MongoDB

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminControllerApi;


AdminControllerApi apiInstance = new AdminControllerApi();
try {
    SuccessDataBase result = apiInstance.createDataBase();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminControllerApi#createDataBase");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SuccessDataBase**](SuccessDataBase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteDataBase"></a>
# **deleteDataBase**
> SuccessDeletedDataBase deleteDataBase()

удаление базы данных

по умолчанию активна база данных MongoDB

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminControllerApi;


AdminControllerApi apiInstance = new AdminControllerApi();
try {
    SuccessDeletedDataBase result = apiInstance.deleteDataBase();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminControllerApi#deleteDataBase");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SuccessDeletedDataBase**](SuccessDeletedDataBase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getIsDatabaseInfo"></a>
# **getIsDatabaseInfo**
> getIsDatabaseInfo()

получение информации о текущей базе данных

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminControllerApi;


AdminControllerApi apiInstance = new AdminControllerApi();
try {
    apiInstance.getIsDatabaseInfo();
} catch (ApiException e) {
    System.err.println("Exception when calling AdminControllerApi#getIsDatabaseInfo");
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
 - **Accept**: application/json

<a name="getLoggerInfo"></a>
# **getLoggerInfo**
> getLoggerInfo()

логгер

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminControllerApi;


AdminControllerApi apiInstance = new AdminControllerApi();
try {
    apiInstance.getLoggerInfo();
} catch (ApiException e) {
    System.err.println("Exception when calling AdminControllerApi#getLoggerInfo");
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
 - **Accept**: application/json

<a name="swichDataBase"></a>
# **swichDataBase**
> SuccessSwitchDataBase swichDataBase(isDataBase)

переключение базы данных

по умолчанию активна база данных MongoDB

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.AdminControllerApi;


AdminControllerApi apiInstance = new AdminControllerApi();
String isDataBase = "isDataBase_example"; // String | Имя базы данных
try {
    SuccessSwitchDataBase result = apiInstance.swichDataBase(isDataBase);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AdminControllerApi#swichDataBase");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **isDataBase** | **String**| Имя базы данных | [enum: POSTGRESQL, MONGODB]

### Return type

[**SuccessSwitchDataBase**](SuccessSwitchDataBase.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

