# RestFixtureScenario
## introduction
this project is a wrapper of [RestFixre](https://github.com/smartrics/RestFixture) project, aimed at providing scenario support for RestFixture, it implements some functions for invoking from the scenario table in Fitnesse which have the same signature as the methods of RestFixture, thus users can use it easily, the frequently used HTTP calls can be implemented within a scenario table, the scenario table can be used in different tests like a function call, reducing the duplicated RestFixture tables in tests.

All the methods in RestFixture can be used with RestFixtureScenario, see the example.

## how to use
  In order to use RestFixtureScenario, you require the maven dependency RestFixture, the [official releases](https://github.com/smartrics/RestFixture) of RestFixre are not compatible with this project, you need to use [the project](https://github.com/jinlxz/RestFixture) I cloned from RestFixture project to make it working, I have opened a pull request to merge the changes to the original RestFixture project.
  
  * include the Fixture in classpath, thus it can be found by Fitnesse test runner.

  |import|
  |com.qa.http|

  * configure the settings for RestFixture and initialize a RestFixtureWrapper instance.

  | Table:smartrics.rest.fitnesse.fixture.RestFixtureConfig | |
  | restfixture.content.default.charset | UTF-8 |
  | http.client.connection.timeout | 10000 |

  |script|com.qa.http.RestFixtureWrapper| http://127.0.0.1:8080 |

  * implement your scenario table in Fitnesse test project.

## examples
  A get example.

  |scenario| query orders by userid | USER_ID | check rc | HTTP_CODE | check body | BODY |
  |setHeader;|Content-Type: application/json|
  |GET;| /some/uri/path?user_id=@USER_ID | | 200 | jsonbody.length==10 && jsonbody[0].order_name=='hello' | 
  
  A Post example.

  |scenario| new order by userid | USER_ID | check rc | HTTP_CODE | check body | BODY |
  |setHeader;|Content-Type: application/json|
  |setBody;|{"order_name":"xxx","order_id":123}|
  |POST;| /some/uri/path?user_id=@USER_ID | | 204 | no-body| 
 
## License
Apache License V2
   
