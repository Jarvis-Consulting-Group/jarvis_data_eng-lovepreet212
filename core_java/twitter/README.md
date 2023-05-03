# Introduction
This project is created to post, read, and update tweets to and from Twitter using the Twitter REST API. It uses OAuth 1.0 method to authenticate a user and grant access to perform operations using the Twitter API. The project's design is based on the MVC architecture and uses models and controllers to build the application. The libraries used in this project are Jackson to convert an object to a string and vice versa, Mockito for unit testing, JUnit for integration testing, and Apache HttpClient4 for client-server interaction. The project is implemented in three ways: first, by using the normal program of calling constructors one after the other; second, by using the Spring Framework; and third, by using Spring Boot. The application is containerized to make it easy to deploy and run on different environments.
# Quick Start
- Package application using maven
```
a. Go to project directory
   cd core_java/twitter
   
b. Package your java app
   mvn -Dmaven.test.skip package
   
c. Export your enviornment variables
   export consumerKey="your_key"
   export consumerSecret="your_key"
   export accessToken="your_key"
   export tokenSecret="your_key"
   
d. Run you application
   java -jar java_apps-1.0-SNAPSHOT.jar post|show|delete your_input
```
- Run your app with docker
```
a. Pull the docker image from docker hub.
   docker pull lovekaur325/twitter
b. Run the docker container using the following commands:
   1. For Posting a Tweet
   docker run --rm -e "consumerKey=your_key" -e "consumerSecret=your_key" -e "accessToken=your_key" -e "tokenSecret=your_key" ${user}/twitter post "content_to_be_posted"
   2. For Reading a Tweet
   docker run --rm -e "consumerKey=your_key" -e "consumerSecret=your_key" -e "accessToken=your_key" -e "tokenSecret=your_key" ${user}/twitter get "id"
   3. For Deleting a Tweet
   docker run --rm -e "consumerKey=your_key" -e "consumerSecret=your_key" -e "accessToken=your_key" -e "tokenSecret=your_key" ${user}/twitter delete "id"
```
# Design
## UML diagram
![twitter.png](src%2Fmain%2Ftwitter.png)
## Components of MVC Architecture
   - TwitterCLIApp/Main:It is the main class that implements traditional dependency management techniques. It declares and instantiates all components and calls a run method. The run method parses args and calls the controller methods. It also prints tweet(s) returned by controller methods.
   - Controller:This layer consumes user input (args in this app) and verifies the required number of arguments. Then, it calls the corresponding service layer method. It does not handle any business logic.
   - Service:The service layer handled the business logic of the application. In this app, it is responsible for checking if the tweet text exceeds 140 characters and also validates if the Id is in the correct format. Then, it calls the corresponding Twitter DAO class.
   - DAO:DAO layer classes only handle data with external storage, such as databases, REST APIs, file systems. In this application, TwitterDao constructs Twitter REST API URIs and makes HTTP calls using HttpHelper.
## Models
   -Tweet Model:The tweet model encapsulates Tweet data (Tweet Objects) which display in JSON format. It requires four model classes named: Coordinates, entities, HashTag, and UserMention to construct a tweet object.
   -Sample JSON of a tweet constructed using tweet model is as follow:
```
{
   "created_at":"Mon Feb 18 21:24:39 +0000 2019",
   "id":1097607853932564480,
   "id_str":"1097607853932564480",
   "text":"test with loc223",
   "entities":{
      "hashtags":[
         {
            "text":"documentation",
            "indices":[
               211,
               225
            ]
         },
         {
            "text":"parsingJSON",
            "indices":[
               226,
               238
            ]
         }
      ],
      "user_mentions":[
         {
            "name":"Twitter API",
            "indices":[
               4,
               15
            ],
            "screen_name":"twitterapi",
            "id":6253282,
            "id_str":"6253282"
         }
      ]
   },
   "coordinates":{
      "coordinates":[
         -75.14310264,
         40.05701649
      ],
      "type":"Point"
   },
   "retweet_count":0,
   "favorite_count":0,
   "favorited":false,
   "retweeted":false
}
```
## Spring
In this project, we used three approaches to implement TwitterCLIApp using the spring framework and springboot to manage dependencies.
1. Beans Approach:
   - Defined dependency relationship using @Bean and passed dependencies through method arguments
   - Created an IoC container/context which will automatically instantiate all Beans based on the relationship we specified earlier.
   - Got the main entry point (TwitterCLIApp) from the IoC container and start the program
2. Component Approach:
   - Used @Autowired annotation to tell the IoC container to inject dependency through the constructor of a component/class.
3. Using Springboot:
   -The TwitterCLISpringBoot uses @SpringBootApplication which is a composition of multiple annotations and helps to configure Spring automatically.
# Test
Integration testing was done using JUnit.It contains @Test and @Before annotations. @Before gets executed before each test execution in the current Test class. This method usually helps initialize the resources required for test to execute. It is executed every time before running a test method. @Test annotation tells JUnit that method to which it is attached can be run as a test case. To run the method, JUnit first constructs a fresh instance of the class and then invokes the annotated method.

## Deployment
I used Docker to containerize the application, so it can be deployed and accessed on different environments. I created a Docker image using a Dockerfile, which contained a collection of instructions and commands, including an entrypoint. The Docker image was created using the following steps:
```
a. Move to project directory
cd core_java/twitter
b. Register Docker hub account
docker_user=your_docker_id
c. Login to your account
docker login -u ${docker_user} --password-stdin 
d. Create dockerfile
cat > Dockerfile << EOF
FROM openjdk:8-alpine
COPY target/java_apps*.jar /usr/local/app/twitter/lib/twitter.jar
ENTRYPOINT ["java","-jar","/usr/local/app/twitter/lib/twitter.jar"]
EOF
e. Package your java app
mvn clean package
f. Build a new docker image locally
docker build -t ${docker_user}/twitter .
g. Verify your image
docker image ls | grep "twitter"
h. Push your image to Docker Hubg
docker push ${docker_user}/twitter
```

# Improvements
- Unit Testing could be implemented using Mockito.
- Can create own database to keep records of posted, searched or deleted tweets
- Can use paid version of developer account to playaround with more features of Twitter REST Api.

