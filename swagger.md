# Credit Cards - BFF Internal API


<a name="overview"></a>
## Overview

### Version information
*Version* : 0.0.1


### URI scheme
*Host* : 127.0.0.1:9002  
*Schemes* : HTTP




<a name="paths"></a>
## Paths

<a name="submitsmartsearch"></a>
### POST /bin/services/forms.submit.creditCards.smart-search.json

#### Description
Internal AEM related BFF API for Credit Cards - Submit Smart Search Form Data.


#### Parameters

|Type|Name|Description|Schema|
|---|---|---|---|
|**Body**|**body**  <br>*required*|Submit Smart Search Form Data|[SmartSearchFormData](#smartsearchformdata)|


#### Responses

|HTTP Code|Description|Schema|
|---|---|---|
|**201**|Created - Successful response with Enquiry Id.|[EnquiryResponse](#enquiryresponse)|
|**400**|Bad Request - The request could not be understood by the server due to malformed syntax.|No Content|
|**422**|Unprocessable Entity - The server understands the content type of the request entity and the syntax of the request entity is correct but was unable to process the contained instructions.|No Content|
|**500**|Internal Server Error - There was an unexpected server error while processing the request.|No Content|


#### Consumes

* `application/json`


#### Produces

* `application/json`


#### Example HTTP request

##### Request body
```
json :
{
  "goalCode" : "CC_BALTRANSFER",
  "accountId" : "XaKXGTm8-J0Ho-JSsn-isI3-U2zkeRwlJGw0",
  "visitorId" : "4tTCyjZSqUSKasLwoYL1",
  "isAuthenticated" : true,
  "titleId" : 3,
  "firstName" : "John",
  "lastName" : "Doe",
  "dateOfBirth" : "1975-08-14T00:00:00.000+0000",
  "employmentStatusId" : 3,
  "employmentContractTypeId" : 1,
  "annualIncome" : 50000,
  "bankCode" : 1003,
  "email" : "test@moneysupermarket.com",
  "currentResidence" : {
    "yearsAtAddress" : 5,
    "residentialStatusId" : 8,
    "address" : {
      "buildingName" : "dolor",
      "county" : "aliqua",
      "department" : "esse ut",
      "dependantLocality" : "minim dolor reprehenderit ad",
      "dependantThoroughfare" : "commo",
      "doubleDependantLocality" : "Ut ullamco cillum culpa anim",
      "organisation" : "u",
      "poBox" : "culpa exercitation aute ut",
      "subBuildingName" : "exercitation elit",
      "thoroughfare" : "ut",
      "town" : "in eu dolore",
      "additionalBuildingNumber" : "amet nostrud",
      "additionalSubBuildingNumber" : "eiusmod nisi laboris ex",
      "country" : "adipisicing id proident Duis",
      "primaryBuildingNumber" : "exercitation elit nulla Lorem fugiat",
      "primarySubBuildingNumber" : "consequat Duis anim",
      "postcode" : "W1A AAA"
    }
  },
  "communicationPreferences" : [ "email", "sms", "phone" ]
}
```


#### Example HTTP response

##### Response 201
```
json :
{
  "success" : true,
  "enquiryId" : "7718035f-1164-4a33-9d85-33e4672b7123"
}
```




<a name="definitions"></a>
## Definitions

<a name="address"></a>
### Address

|Name|Description|Schema|
|---|---|---|
|**additionalBuildingNumber**  <br>*required*|**Maximal length** : `10`|string|
|**additionalSubBuildingNumber**  <br>*required*|**Maximal length** : `10`|string|
|**buildingName**  <br>*required*|**Maximal length** : `30`  <br>**Pattern** : `"^[0-9a-zA-Z-',!&amp;/()\\\\.\\\\\\\\\\ \\t\\r\\n]*$"`|string|
|**country**  <br>*required*|**Maximal length** : `20`|string|
|**county**  <br>*required*|**Maximal length** : `50`|string|
|**department**  <br>*required*|**Maximal length** : `50`|string|
|**dependantLocality**  <br>*required*|**Maximal length** : `50`|string|
|**dependantThoroughfare**  <br>*required*|**Maximal length** : `50`|string|
|**doubleDependantLocality**  <br>*required*|**Maximal length** : `50`|string|
|**organisation**  <br>*required*|**Maximal length** : `100`|string|
|**poBox**  <br>*required*|**Maximal length** : `50`|string|
|**postcode**  <br>*required*|**Length** : `6 - 8`  <br>**Pattern** : `"^(([Gg][Ii][Rr] {1}0[Aa]{2})\|((([A-Za-z][0-9]{1,2})\|([A-Za-z]{2}[0-9]{1,2})\|([A-Za-z]{1,2}[0-9][A-Za-z]))( {1}[0-9][A-Za-z]{2})))$"`|string|
|**primaryBuildingNumber**  <br>*required*|**Maximal length** : `15`|string|
|**primarySubBuildingNumber**  <br>*required*|**Maximal length** : `10`|string|
|**subBuildingName**  <br>*required*|**Maximal length** : `50`|string|
|**thoroughfare**  <br>*required*|**Maximal length** : `50`|string|
|**town**  <br>*required*|**Maximal length** : `50`|string|


<a name="enquiryresponse"></a>
### EnquiryResponse

|Name|Schema|
|---|---|
|**enquiryId**  <br>*required*|string|
|**success**  <br>*required*|boolean|


<a name="residence"></a>
### Residence

|Name|Description|Schema|
|---|---|---|
|**address**  <br>*required*||[Address](#address)|
|**residentialStatusId**  <br>*required*|https://moneysupermarket.atlassian.net/wiki/display/PT/Reference+Data+List%3A+%28REJECTED%29credit-card-residential-statuses<br>https://moneysupermarket.atlassian.net/wiki/display/PT/Reference+Data+List%3A+%28OBSOLETE%29+Residential+Status  <br>**Example** : `2`|integer|
|**yearsAtAddress**  <br>*required*|How many years does the customer live here?  <br>**Minimum value** : `0`  <br>**Maximum value** : `16`  <br>**Example** : `4`|integer|


<a name="smartsearchformdata"></a>
### SmartSearchFormData

|Name|Description|Schema|
|---|---|---|
|**accountId**  <br>*required*|Customer account identifier  <br>**Pattern** : `"^[a-zA-Z0-9]{8}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{4}-[a-zA-Z0-9]{12}$"`  <br>**Example** : `"XaKXGTm8-J0Ho-JSsn-isI3-U2zkeRwlJGw0"`|string|
|**annualIncome**  <br>*required*|Annual Salary.  <br>**Minimum value** : `1`  <br>**Maximum value** : `999999999`  <br>**Example** : `12000`|integer|
|**bankCode**  <br>*required*|We have no reference data list neither in AEM nor in api-docs currently.<br>https://moneysupermarket.atlassian.net/wiki/display/PT/Reference+Data+List%3A+%28REJECTED%29banking-org-codes  <br>**Example** : `1003`|integer|
|**communicationPreferences**  <br>*required*|Communication Preferences.|< enum (email, sms, phone) > array|
|**currentResidence**  <br>*required*||[Residence](#residence)|
|**dateOfBirth**  <br>*required*|The date of birth.  <br>**Pattern** : `"^[0-9]{4}-(0[1-9]\|1[0-2])-(0[1-9]\|[1-2][0-9]\|3[0-1])$"`  <br>**Example** : `"1975-08-14T00:00:00.000+0000"`|string|
|**email**  <br>*required*|Email address of the customer.  <br>**Example** : `"test@moneysupermarket.com"`|string|
|**employmentContractTypeId**  <br>*required*|https://github.com/MSMFG/api-docs/blob/master/static-lists/reference-data-service/csv/employment-contract-types.csv<br>1 - Full Time, 2 - Part Time  <br>**Example** : `1`|integer|
|**employmentStatusId**  <br>*required*|The employment status relating to the occupation<br>https://github.com/MSMFG/cms-contents/tree/EPAM-Prod-Content-Backfeed/src/main/content/jcr_root/etc/tags/moneysupermarket/reference-data/employment-statuses<br>1 - Company, 2 - Contractor, 3 - Employed, 4 - Financially assisted, 5 - Housewife / househusband, 6 - Student, <br>7 - Independent means, 8 - Not Employed due to disability, 9 - Retired, 10 - Self-employed, 11 - Unemployed, 12 - Voluntary work  <br>**Example** : `2`|integer|
|**firstName**  <br>*required*|First name of the customer.  <br>**Length** : `2 - 30`  <br>**Pattern** : `"^[a-zA-Z-' \\u00c0-\\u00d6\\u00d8-\\u00f6\\u00f8-\\u024f\\u1e00-\\u1eff]+$"`  <br>**Example** : `"Jane"`|string|
|**goalCode**  <br>*required*|Credit card purposes. <br>https://moneysupermarket.atlassian.net/wiki/display/PT/Reference+Data+List%3A+%28REJECTED%29credit-card-purposes OR <br>https://moneysupermarket.atlassian.net/wiki/display/DT/BE007%2C+BE009%3A+Goal+Codes  <br>**Example** : `"CC_BALTRANSFER"`|enum (CC_ALLCARDS, CC_BALTRANSFER, CC_BALTRANSFERPURCHASE, CC_CREDITBUILDER, CC_LOWRATE, CC_OVERSEAS, CC_PURCHASE, CC_REWARD)|
|**isAuthenticated**  <br>*required*|Whether or not customer was authenticated when enquiry was submitted  <br>**Example** : `false`|boolean|
|**lastName**  <br>*required*|Last name of the customer.  <br>**Length** : `2 - 30`  <br>**Pattern** : `"^[a-zA-Z-' \\u00c0-\\u00d6\\u00d8-\\u00f6\\u00f8-\\u024f\\u1e00-\\u1eff]+$"`  <br>**Example** : `"Wilson"`|string|
|**residentialHistory**  <br>*optional*|Previous Addresses of the Customer. Required only if the yearsAtAddress is less than 2.|< [Residence](#residence) > array|
|**titleId**  <br>*required*|https://github.com/MSMFG/api-docs/blob/master/static-lists/reference-data-service/csv/titles.csv<br>3 - Mr, 4 - Mrs, 2 - Miss, 5 - Ms, 1 - Dr  <br>**Example** : `3`|integer|
|**visitorId**  <br>*required*|MSM user identifier.  <br>**Length** : `20 - 36`  <br>**Pattern** : `"^[0-9a-zA-Z]{20}$\|^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$"`  <br>**Example** : `"4tTCyjZSqUSKasLwoYL1"`|string|





