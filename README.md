# camlistTask
camlist techincal task using spring-boot java8

## Technologies
+	MySQL Database  ✅ 
+	Spring Framework ✅ 
+	Build Tool Maven  ✅ 
+	REST ✅ 
## Bonus
+	Jpa ✅ 
+	Spring secuirty 


### Instructions to run the app
1. Clone the app and open to IDE and run it on port=8080.
2. For database Just create the database(name=camlist,username= ,pass=) maunally replase user name and password on application.properties file and run the application and it will create the Tables with it's entities.
3.  Then you can test using swaggerapi http://localhost:8080/swagger-ui.html.

 #### Bids Apis located under the store route /addBid /getBids
- for this apis you should be authenticated user 
- authenticated user means user have an account and get token using /login api
- /login api is open api for using accept username and password and return token which need it to authenticate your request
- /addCategory , /addtag  , /createUser api doesn't need token
- /addBid , /addPet, /getPids need authenticated user (pet and bids has assigned to the user)


#### how you can test the senario  
- first you need to create user using /user api on swagger and it will return username and password you can use them to get token from /login api
- create category and tag first before add pet becouse it's mandatory 
- the id's in category and tag and pets which send in request are not important only what you recived in the response is the actual id for the entity saved in database.
- add another users and bid on the pet you added with user one 
- use /getpid to list all users bids on your bids by username and the bid offer.



#### Challenge 2: 
- you will find it impelemented in GeneralizedSecondPrice.java script 

