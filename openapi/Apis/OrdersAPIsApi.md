# OrdersAPIsApi

All URIs are relative to *http://localhost:9999/health-connect-plus*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createOrder**](OrdersAPIsApi.md#createOrder) | **POST** /orders |  |
| [**deleteOrder**](OrdersAPIsApi.md#deleteOrder) | **DELETE** /orders |  |
| [**getOrder**](OrdersAPIsApi.md#getOrder) | **GET** /orders |  |
| [**updateOrder**](OrdersAPIsApi.md#updateOrder) | **PUT** /orders |  |


<a name="createOrder"></a>
# **createOrder**
> OrderDetails createOrder(OrderDetails)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **OrderDetails** | [**OrderDetails**](../Models/OrderDetails.md)|  | [optional] |

### Return type

[**OrderDetails**](../Models/OrderDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteOrder"></a>
# **deleteOrder**
> deleteOrder(order\_id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **order\_id** | **String**|  | [default to null] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getOrder"></a>
# **getOrder**
> List getOrder(email)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **email** | **String**|  | [default to null] |

### Return type

[**List**](../Models/OrderDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateOrder"></a>
# **updateOrder**
> OrderDetails updateOrder(OrderDetails)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **OrderDetails** | [**OrderDetails**](../Models/OrderDetails.md)|  | [optional] |

### Return type

[**OrderDetails**](../Models/OrderDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

