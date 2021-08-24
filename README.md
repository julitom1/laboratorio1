## Spring Boot Rest API


### Part 1: Implementing the Users Microservice RESTFUL API

1. Create a new project using the [Spring Initializr](https://start.spring.io/)
  * Use either *Java* or *Kotlin* as programming language.
  * Use Gradle as project option(if your computer is slow then use  Maven)
  * Add Spring Web dependency before generating the project.
2. Create a new repository on Github and commit the files generated in 1.
3. Create a new package called *dto* and inside define your *UserDto* object with at least the following fields:
    * name.
    * email.
    * lastName.
    
![](img/postman1.JPG)

4. Create a new package called *data* and inside define your *User* data object with at least the following fields:
    * id.
    * name.
    * email.
    * lastName.
    * createdAt.

![](img/postman2.JPG)

5. Create a new package called *service* an inside create the following interface:

![](img/postman3.JPG)


6. Create an implementation of the UserService using a HashMap data structure inside.
7. Make your service implementation *UserServiceHashMap* injectable using the *@Service* annotation.

![](img/postman4.JPG)


8. Create a new package called *controller* and create a new class *UserController* inside.
9. Annotate your *UserController* so it becomes a REST Controller:
10. Inject your UserService implementation inside the UserController via the constructor:

![](img/postman5.JPG)

11. Implement all the endpoints needed to interact with you *UserService*. Use the following method signatures to help you achieve the Level 2 RESTFUL Maturity:

![](img/postman6.JPG)

12. Download and install [Postman](https://www.postman.com/) and test ALL the endpoints of your API.

## Create()

![](img/postman7.JPG)     ![](img/postman8.JPG)

## all()

![](img/postman9.JPG)

## update()

![](img/postman10.JPG)

#### Control Errores updade()

![](img/postman11.JPG)

## delete()

![](img/postman12.JPG)

#### Control Errores delete() 

![](img/postman15.JPG)

## findById()

![](img/postman14.JPG)

#### Control Errores delete() 

![](img/postman13.JPG)
