# MedicinesAPIsApi

All URIs are relative to *http://localhost:9999/health-connect-plus*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createMedicine**](MedicinesAPIsApi.md#createMedicine) | **POST** /medicines |  |
| [**deleteMedicine**](MedicinesAPIsApi.md#deleteMedicine) | **DELETE** /medicines |  |
| [**getMedicine**](MedicinesAPIsApi.md#getMedicine) | **GET** /medicines |  |
| [**updateMedicine**](MedicinesAPIsApi.md#updateMedicine) | **PUT** /medicines |  |


<a name="createMedicine"></a>
# **createMedicine**
> Medicine createMedicine(Medicine)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Medicine** | [**Medicine**](../Models/Medicine.md)|  | [optional] |

### Return type

[**Medicine**](../Models/Medicine.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteMedicine"></a>
# **deleteMedicine**
> deleteMedicine(id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | [default to null] |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="getMedicine"></a>
# **getMedicine**
> List getMedicine(medicine\_id)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **medicine\_id** | **String**|  | [default to null] |

### Return type

[**List**](../Models/Medicine.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateMedicine"></a>
# **updateMedicine**
> Medicine updateMedicine(Medicine)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **Medicine** | [**Medicine**](../Models/Medicine.md)|  | [optional] |

### Return type

[**Medicine**](../Models/Medicine.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

