# UsersAPIsApi

All URIs are relative to *http://localhost:9999/health-connect-plus*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createUser**](UsersAPIsApi.md#createUser) | **POST** /users |  |
| [**deleteUser**](UsersAPIsApi.md#deleteUser) | **DELETE** /users |  |
| [**getUser**](UsersAPIsApi.md#getUser) | **GET** /users |  |
| [**updateUser**](UsersAPIsApi.md#updateUser) | **PUT** /users |  |


<a name="createUser"></a>
# **createUser**
> User createUser(User)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **User** | [**User**](../Models/User.md)|  | [optional] |

### Return type

[**User**](../Models/User.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

<a name="deleteUser"></a>
# **deleteUser**
> deleteUser(email)



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

<a name="getUser"></a>
# **getUser**
> List getUser(email)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **email** | **String**|  | [default to null] |

### Return type

[**List**](../Models/User.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="updateUser"></a>
# **updateUser**
> User updateUser(User)



### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **User** | [**User**](../Models/User.md)|  | [optional] |

### Return type

[**User**](../Models/User.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

