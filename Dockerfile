FROM openjdk:8
EXPOSE 8090
ADD target/Cab-Booking-0.0.1-SNAPSHOT.war Cab-Booking-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "java","-jar","/Cab-Booking-0.0.1-SNAPSHOT.war" ]
