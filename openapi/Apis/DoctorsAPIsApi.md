# DoctorsAPIsApi

All URIs are relative to *http://localhost:9999/health-connect-plus*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createDoctor**](DoctorsAPIsApi.md#createDoctor) | **POST** /doctors |  |
| [**deleteDoctor**](DoctorsAPIsApi.md#deleteDoctor) | **DELETE** /doctors |  |
| [**getDoctor**](DoctorsAPIsApi.md#getDoctor) | **GET** /doctors |  |
| [**updateDoctor**](DoctorsAPIsApi.md#updateDoctor) | **PUT** /doctors |  |


<a name="createDoctor"></a>
# **createDoctor**
> Doctor createDoctor(Doctor)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Doctor** | [**Doctor**](../Models/Doctor.md)|  | [optional] |

### Return type

[**Doctor**](../Models/Doctor.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteDoctor"></a>
# **deleteDoctor**
> deleteDoctor(email)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **email** | **String**|  | [default to null] |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getDoctor"></a>
# **getDoctor**
> List getDoctor(email)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **email** | **String**|  | [default to null] |

### Return type

[**List**](../Models/Doctor.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateDoctor"></a>
# **updateDoctor**
> Doctor updateDoctor(Doctor)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Doctor** | [**Doctor**](../Models/Doctor.md)|  | [optional] |

### Return type

[**Doctor**](../Models/Doctor.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

