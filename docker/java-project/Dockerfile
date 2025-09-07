FROM openjdk
WORKDIR /user/src/myapp

# Copy everything from source to working directory
COPY . /user/src/myapp 

RUN javac Test.java
CMD [ "java","Test" ]