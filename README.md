# Worldline Technical Test

## Content

* [Prerequisites](#prerequisites)
* [Evalution](#eval)
	* [Criterias](#criterias)
		* [Code](#code)
		* [Commit](#commit)
		* [Production](#prod)
	* [Exercises](#exercises)
		* [Exercise 1](#exercise1)
		* [Exercise 2](#exercise2)
		* [Exercise 3](#exercise3)
		* [Exercise 4](#exercise4)
		* [Exercise 5](#exercise5)
		* [Exercise 6](#exercise6)

## <a name="prerequisites"></a>Prerequisites

List of prerequisites to realize the test:
* On your PC, you must have :
   * _Maven_ installed (Version __3.x__)
   * _Git_ Installed (Version __2.x__) 
   * _JAVA JDK_ installed (Version __7__ or __8__)
   * _JAVA IDE_ installed (__Eclipse__ / __KazanStudio__ / __IntelliJ IDEA__ / …)
   * _REST Client tool_ to make HTTP Requests 
     * _Chrome_ Extension
       * Postman - REST Client shortcut
       * Sense (Beta)
     * …

* Authorized access at the following services
  * __GitLab__ (https://gitlab.kazan.priv.atos.fr/) 
  * Login with your DAS account to create a user.

## <a name="eval"></a>Evalution
### <a name="criterias"></a>Criterias

The aim of this evaluation is to check if you have the basic competences to integrate a Worldline FPL Digital Banking development team. To verify these competences, we will analyze the following elements: 

* Your developments
* Your analysis
* The way of working

To evaluate these elements, we have created the following categories:

* [Code](#code)
* [Commit](#commit)
* [Production](#prod)

The following sections explain what is expected. 

#### <a name="code"></a>Code

We will be attentive to the “Quality of code”
* Complexity
* Duplication
* Performance
* Readable / Maintainable
* Reusable / Evolutivity
* Comment

#### <a name="commit"></a>Commit

We will be attentive to the “Quality of Commit”

* Relevant 
* Readable
* Comment

A real Git Repository will be available to realize this evaluation. You must use this repository like in a real development project (commit/branch/comment…).

#### <a name="prod"></a>Production

The code must be Production Ready
* Rules compliance
* Work
* Tested

### <a name="exercises"></a>Exercises

#### <a name="exercise1"></a>Exercise 1

Install and run the project on your device/PC

1. Retrieve the __GITLAB__ project
2. Mount the project on your development IDE (Eclipse or other …)
3. Compile the project (Java and Maven compilation)
4. Launch the project (Launch the Main class of project : WebshopBoot)

#### <a name="exercise2"></a>Exercise 2

Understand the project and make several tests on it in the current state 

1.	Understand the project (This project simulates a webshop __REST__ server)
	* __SAAS__ project (Software as a service)
	* __REST__ server (Representational state transfer)
		* __Host__ : http://localhost:8080
	* __Webshop service__
		* __Product__ Management
		* __Basket__ Management

2.	Try to retrieve All products (Launch a REST request with these parameters)
	* __Verb__ : _GET_
	* __URL__ : /product/all

3.	Try to retrieve your basket (Replace the __YOUR_ID__ by your name)
	* __Verb__ : _GET_
	* __URL__ : /basket/__YOUR_ID__

4. Try to add a product in your basket
	* __Verb__ : _POST_
	* __URL__ : /basket/add
	* Add following Parameters
		* __sessionId__ : your name
		* __poductId__ : You can take a productId of the product list (1st request)
		* __quantity__ : a number (Warning at the quantity given in the product list)

There are any other functions that you can find in the correspondent services.

#### <a name="exercise3"></a>Exercise 3

After several test, the client has found a bug on the application.

It is possible to add a product in the basket with a quantity which is bigger than the stock. 

You must fix this issue and add this test at the future test plan.

#### <a name="exercise4"></a>Exercise 4

Currently, it is possible to add a product in the basket with the application and view the content of this basket. 

For the next application version, the client wants to add a new feature: Remove a product in basket.

You must implement this new feature in the application and add on more tests at the future test plan.

#### <a name="exercise5"></a>Exercise 5

For the next application version, the client wants to add an Administration section in the application.

This new feature regroups the following parts:
* New Controller to management the following REST Requests
	* __Basket__
		* Get All Baskets
		*	Get a Basket
		* Remove a Basket
	* __Product__
		* Add a new product
		* Update the stock of product

* New Service to management the functionalities

This new Administration section is very sensitive for the application because with this section it is possible to modify a client basket. 

To avoid a future commercial issue, the client wants that all Administration action must traced in the application log.

__Info__: This new service can use the existing services to avoid duplication.

#### <a name="exercise6"></a>Exercise 6

For the next application version, Worldline wants to change the management of data in application. Indeed, currently the application stores the products and the baskets directly in the JAVA services. 

This situation is no longer acceptable and the application must be refactored with a real database service.

In the evaluation case, you must implement a memory database (hsql) in the application and refactor the services.# fpl-db-recruitment
