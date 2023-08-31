# Documentation for HealthConnect+

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *http://localhost:9999/health-connect-plus*

| Class | Method | HTTP request | Description |
|------------ | ------------- | ------------- | -------------|
| *AppointmentsAPIsApi* | [**bookAppointment**](Apis/AppointmentsAPIsApi.md#bookappointment) | **POST** /appointments |  |
*AppointmentsAPIsApi* | [**deleteAppointment**](Apis/AppointmentsAPIsApi.md#deleteappointment) | **DELETE** /appointments |  |
*AppointmentsAPIsApi* | [**getAppointment**](Apis/AppointmentsAPIsApi.md#getappointment) | **GET** /appointments |  |
*AppointmentsAPIsApi* | [**updateAppointment**](Apis/AppointmentsAPIsApi.md#updateappointment) | **PUT** /appointments |  |
| *AuthAPIsApi* | [**login**](Apis/AuthAPIsApi.md#login) | **POST** /auth/login |  |
| *DefaultApi* | [**healthyGet**](Apis/DefaultApi.md#healthyget) | **GET** /healthy |  |
*DefaultApi* | [**readyGet**](Apis/DefaultApi.md#readyget) | **GET** /ready |  |
| *DoctorsAPIsApi* | [**createDoctor**](Apis/DoctorsAPIsApi.md#createdoctor) | **POST** /doctors |  |
*DoctorsAPIsApi* | [**deleteDoctor**](Apis/DoctorsAPIsApi.md#deletedoctor) | **DELETE** /doctors |  |
*DoctorsAPIsApi* | [**getDoctor**](Apis/DoctorsAPIsApi.md#getdoctor) | **GET** /doctors |  |
*DoctorsAPIsApi* | [**updateDoctor**](Apis/DoctorsAPIsApi.md#updatedoctor) | **PUT** /doctors |  |
| *HealthReportsAPIsApi* | [**createReport**](Apis/HealthReportsAPIsApi.md#createreport) | **POST** /health-reports |  |
*HealthReportsAPIsApi* | [**deleteReport**](Apis/HealthReportsAPIsApi.md#deletereport) | **DELETE** /health-reports |  |
*HealthReportsAPIsApi* | [**getReport**](Apis/HealthReportsAPIsApi.md#getreport) | **GET** /health-reports |  |
*HealthReportsAPIsApi* | [**updateReport**](Apis/HealthReportsAPIsApi.md#updatereport) | **PUT** /health-reports |  |
| *MedicinesAPIsApi* | [**createMedicine**](Apis/MedicinesAPIsApi.md#createmedicine) | **POST** /medicines |  |
*MedicinesAPIsApi* | [**deleteMedicine**](Apis/MedicinesAPIsApi.md#deletemedicine) | **DELETE** /medicines |  |
*MedicinesAPIsApi* | [**getMedicine**](Apis/MedicinesAPIsApi.md#getmedicine) | **GET** /medicines |  |
*MedicinesAPIsApi* | [**updateMedicine**](Apis/MedicinesAPIsApi.md#updatemedicine) | **PUT** /medicines |  |
| *OrdersAPIsApi* | [**createOrder**](Apis/OrdersAPIsApi.md#createorder) | **POST** /orders |  |
*OrdersAPIsApi* | [**deleteOrder**](Apis/OrdersAPIsApi.md#deleteorder) | **DELETE** /orders |  |
*OrdersAPIsApi* | [**getOrder**](Apis/OrdersAPIsApi.md#getorder) | **GET** /orders |  |
*OrdersAPIsApi* | [**updateOrder**](Apis/OrdersAPIsApi.md#updateorder) | **PUT** /orders |  |
| *RatingsAPIsApi* | [**createReview**](Apis/RatingsAPIsApi.md#createreview) | **POST** /reviews |  |
*RatingsAPIsApi* | [**deleteReview**](Apis/RatingsAPIsApi.md#deletereview) | **DELETE** /reviews |  |
*RatingsAPIsApi* | [**getReview**](Apis/RatingsAPIsApi.md#getreview) | **GET** /reviews |  |
*RatingsAPIsApi* | [**updateReview**](Apis/RatingsAPIsApi.md#updatereview) | **PUT** /reviews |  |
| *UsersAPIsApi* | [**createUser**](Apis/UsersAPIsApi.md#createuser) | **POST** /users |  |
*UsersAPIsApi* | [**deleteUser**](Apis/UsersAPIsApi.md#deleteuser) | **DELETE** /users |  |
*UsersAPIsApi* | [**getUser**](Apis/UsersAPIsApi.md#getuser) | **GET** /users |  |
*UsersAPIsApi* | [**updateUser**](Apis/UsersAPIsApi.md#updateuser) | **PUT** /users |  |


<a name="documentation-for-models"></a>
## Documentation for Models

 - [AppointmentDetails](./Models/AppointmentDetails.md)
 - [Doctor](./Models/Doctor.md)
 - [ErrorObject](./Models/ErrorObject.md)
 - [LoggedInUserDetails](./Models/LoggedInUserDetails.md)
 - [LoginCreds](./Models/LoginCreds.md)
 - [Medicine](./Models/Medicine.md)
 - [OrderDetails](./Models/OrderDetails.md)
 - [ProbeResponse](./Models/ProbeResponse.md)
 - [Rating](./Models/Rating.md)
 - [Report](./Models/Report.md)
 - [User](./Models/User.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="bearerAuth"></a>
### bearerAuth

- **Type**: HTTP Bearer Token authentication (JWT)

