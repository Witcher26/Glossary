# EngineControllerApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**engine**](EngineControllerApi.md#engine) | **POST** /engineController/v1/startEngine/{requestFromClientInJson} | Метод добавления слова, удаления слова, вывод всех слов

<a name="engine"></a>
# **engine**
> engine(requestFromClientInJson)

Метод добавления слова, удаления слова, вывод всех слов

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.EngineControllerApi;


EngineControllerApi apiInstance = new EngineControllerApi();
String requestFromClientInJson = "requestFromClientInJson_example"; // String | ADD - добавление слова, REMOVE - удаление слова, GETALLTASKS - вывод всех слов
try {
    apiInstance.engine(requestFromClientInJson);
} catch (ApiException e) {
    System.err.println("Exception when calling EngineControllerApi#engine");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestFromClientInJson** | **String**| ADD - добавление слова, REMOVE - удаление слова, GETALLTASKS - вывод всех слов | [enum: {"target":"ADD","word":"test","translation":"тестовое слово для проверки","locale":"EN"}, {"target":"REMOVE","word":"test"}, {"target":"GETALLTASKS"}]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

