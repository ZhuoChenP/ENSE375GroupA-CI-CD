# Project 3 - Continuous Integration Personal Process Summary

#### By Rishabh Prasad, 200389227

***

## Starting Project 3

The process for this project initiated with researching about the Continuous Integration (CI) process and forming report on our findings. My portion of the report was dedicated to exploring Jenkins and its benefits as a tool to create an efficient and effective CI process for a project.

## Implementing Jenkins and Maven

Following the report, I applied my knowledge of Docker from the step of the project and Jenkins from the current step to create a Jenkins pipeline which worked locally on a docker container. The pipeline was implemented to build and test newly committed code.

Once the pipeline was functional locally, I attempted to use a program known as ngrok to host my local environment publicly so that my team members could connect to a single installation of Jenkins. However, Ngrok as a software was limiting and did not allow multiple connections. I also attempted the technique of port forwarding, however, in this case the router and its security became the limiting factor. Due to these reasons, we decided to run Jenkins locally and only push new code once it was confirmed to be integrated.

The pipeline was initially working with traditional java commands, however this was not optimal due to the hierarchy of directories being preferable to Maven's architecture. To work with Maven we created a pom.xml which recognized the structure of directories to allow us to use maven commands to build and test our project.

## Implementing PostalCode

The class I implemented was ` PostalCode `

I first started by implementing tests for the method ` isValidPostalCode `. This method returns a boolean value of `true` or `false` based on the PostalCode given to it in the form of a string. Then proceeding the test, I implemented functionality. Then I ran test to see if the actual output was the same as the expected output.

Each layer of tests checks to see if the following conditions are valid for the following format of postal code: `K1a-bxy`

+ The Postal Code always begins with `K1`
+ `a` is a letter between `A` & `T`
+ The first 3 characters and the last 3 characters are separated with a `-`
+ `b` is a digit between `0` & `9`
+ `x` is any uppercase letter
+ `y` is any digit

If the following cases have not been met, the method throws an InvalidPostalCodeException error.

Using logic, tests were implemented first then the methods were slowly given further functionality.