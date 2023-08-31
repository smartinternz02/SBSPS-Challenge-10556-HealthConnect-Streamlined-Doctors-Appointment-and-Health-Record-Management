# AppointmentsAPIsApi

All URIs are relative to *http://localhost:9999/health-connect-plus*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**bookAppointment**](AppointmentsAPIsApi.md#bookAppointment) | **POST** /appointments |  |
| [**deleteAppointment**](AppointmentsAPIsApi.md#deleteAppointment) | **DELETE** /appointments |  |
| [**getAppointment**](AppointmentsAPIsApi.md#getAppointment) | **GET** /appointments |  |
| [**updateAppointment**](AppointmentsAPIsApi.md#updateAppointment) | **PUT** /appointments |  |


<a name="bookAppointment"></a>
# **bookAppointment**
> AppointmentDetails bookAppointment(AppointmentDetails)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **AppointmentDetails** | [**AppointmentDetails**](../Models/AppointmentDetails.md)|  | [optional] |

### Return type

[**AppointmentDetails**](../Models/AppointmentDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteAppointment"></a>
# **deleteAppointment**
> deleteAppointment(ref\_id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **ref\_id** | **String**|  | [default to null] |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getAppointment"></a>
# **getAppointment**
> List getAppointment(email)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **email** | **String**|  | [default to null] |

### Return type

[**List**](../Models/AppointmentDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateAppointment"></a>
# **updateAppointment**
> AppointmentDetails updateAppointment(AppointmentDetails)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **AppointmentDetails** | [**AppointmentDetails**](../Models/AppointmentDetails.md)|  | [optional] |

### Return type

[**AppointmentDetails**](../Models/AppointmentDetails.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

