# IssueControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createIssue**](IssueControllerApi.md#createIssue) | **POST** /v1/support/issue/create | 
[**getAllPosts**](IssueControllerApi.md#getAllPosts) | **GET** /v1/support/issue/get/all | 
[**getAllPostsByAuthorId**](IssueControllerApi.md#getAllPostsByAuthorId) | **GET** /v1/support/issue/get/all/{authorId} | 
[**getAllPostsByAuthorId1**](IssueControllerApi.md#getAllPostsByAuthorId1) | **GET** /v1/support/issue/get/all/unresolved | 
[**getAllPostsByCategory**](IssueControllerApi.md#getAllPostsByCategory) | **GET** /v1/support/issue/get/all/{category} | 
[**getPostById**](IssueControllerApi.md#getPostById) | **GET** /v1/support/issue/get/{id} | 
[**updateIssue**](IssueControllerApi.md#updateIssue) | **PUT** /v1/support/issue/update/{id} | 



## createIssue

> createIssue(issueDto)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.IssueControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        IssueControllerApi apiInstance = new IssueControllerApi(defaultClient);
        IssueDto issueDto = new IssueDto(); // IssueDto | 
        try {
            apiInstance.createIssue(issueDto);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueControllerApi#createIssue");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **issueDto** | [**IssueDto**](IssueDto.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAllPosts

> List&lt;IssueDto&gt; getAllPosts()



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.IssueControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        IssueControllerApi apiInstance = new IssueControllerApi(defaultClient);
        try {
            List<IssueDto> result = apiInstance.getAllPosts();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueControllerApi#getAllPosts");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;IssueDto&gt;**](IssueDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAllPostsByAuthorId

> List&lt;IssueDto&gt; getAllPostsByAuthorId(authorId)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.IssueControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        IssueControllerApi apiInstance = new IssueControllerApi(defaultClient);
        Long authorId = 56L; // Long | 
        try {
            List<IssueDto> result = apiInstance.getAllPostsByAuthorId(authorId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueControllerApi#getAllPostsByAuthorId");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorId** | **Long**|  |

### Return type

[**List&lt;IssueDto&gt;**](IssueDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAllPostsByAuthorId1

> List&lt;IssueDto&gt; getAllPostsByAuthorId1()



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.IssueControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        IssueControllerApi apiInstance = new IssueControllerApi(defaultClient);
        try {
            List<IssueDto> result = apiInstance.getAllPostsByAuthorId1();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueControllerApi#getAllPostsByAuthorId1");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;IssueDto&gt;**](IssueDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getAllPostsByCategory

> List&lt;IssueDto&gt; getAllPostsByCategory(category)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.IssueControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        IssueControllerApi apiInstance = new IssueControllerApi(defaultClient);
        String category = "BUG"; // String | 
        try {
            List<IssueDto> result = apiInstance.getAllPostsByCategory(category);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueControllerApi#getAllPostsByCategory");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **category** | **String**|  | [enum: BUG, PAYMENTS]

### Return type

[**List&lt;IssueDto&gt;**](IssueDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getPostById

> IssueDto getPostById(id)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.IssueControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        IssueControllerApi apiInstance = new IssueControllerApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            IssueDto result = apiInstance.getPostById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueControllerApi#getPostById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

[**IssueDto**](IssueDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## updateIssue

> updateIssue(issueDto)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.IssueControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        IssueControllerApi apiInstance = new IssueControllerApi(defaultClient);
        IssueDto issueDto = new IssueDto(); // IssueDto | 
        try {
            apiInstance.updateIssue(issueDto);
        } catch (ApiException e) {
            System.err.println("Exception when calling IssueControllerApi#updateIssue");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **issueDto** | [**IssueDto**](IssueDto.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

