# RatingsAPIsApi

All URIs are relative to *http://localhost:9999/health-connect-plus*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createReview**](RatingsAPIsApi.md#createReview) | **POST** /reviews |  |
| [**deleteReview**](RatingsAPIsApi.md#deleteReview) | **DELETE** /reviews |  |
| [**getReview**](RatingsAPIsApi.md#getReview) | **GET** /reviews |  |
| [**updateReview**](RatingsAPIsApi.md#updateReview) | **PUT** /reviews |  |


<a name="createReview"></a>
# **createReview**
> Rating createReview(Rating)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Rating** | [**Rating**](../Models/Rating.md)|  | [optional] |

### Return type

[**Rating**](../Models/Rating.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteReview"></a>
# **deleteReview**
> deleteReview(review\_id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **review\_id** | **Integer**|  | [default to null] |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getReview"></a>
# **getReview**
> List getReview(review\_id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **review\_id** | **String**|  | [default to null] |

### Return type

[**List**](../Models/Rating.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateReview"></a>
# **updateReview**
> Rating updateReview(Rating)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Rating** | [**Rating**](../Models/Rating.md)|  | [optional] |

### Return type

[**Rating**](../Models/Rating.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

