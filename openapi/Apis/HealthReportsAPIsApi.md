# HealthReportsAPIsApi

All URIs are relative to *http://localhost:9999/health-connect-plus*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createReport**](HealthReportsAPIsApi.md#createReport) | **POST** /health-reports |  |
| [**deleteReport**](HealthReportsAPIsApi.md#deleteReport) | **DELETE** /health-reports |  |
| [**getReport**](HealthReportsAPIsApi.md#getReport) | **GET** /health-reports |  |
| [**updateReport**](HealthReportsAPIsApi.md#updateReport) | **PUT** /health-reports |  |


<a name="createReport"></a>
# **createReport**
> Report createReport(Report)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Report** | [**Report**](../Models/Report.md)|  | [optional] |

### Return type

[**Report**](../Models/Report.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteReport"></a>
# **deleteReport**
> deleteReport(report\_id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **report\_id** | **Integer**|  | [default to null] |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getReport"></a>
# **getReport**
> List getReport(email)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **email** | **String**|  | [default to null] |

### Return type

[**List**](../Models/Report.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateReport"></a>
# **updateReport**
> Report updateReport(Report)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Report** | [**Report**](../Models/Report.md)|  | [optional] |

### Return type

[**Report**](../Models/Report.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

