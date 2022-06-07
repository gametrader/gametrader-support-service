# CategoryControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllCategories**](CategoryControllerApi.md#getAllCategories) | **GET** /v1/support/category/get/all | 



## getAllCategories

> List&lt;String&gt; getAllCategories()



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.CategoryControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        CategoryControllerApi apiInstance = new CategoryControllerApi(defaultClient);
        try {
            List<String> result = apiInstance.getAllCategories();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CategoryControllerApi#getAllCategories");
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

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

