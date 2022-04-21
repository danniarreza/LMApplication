FROM adoptopenjdk/openjdk11
COPY /build/libs/LMA-0.0.1-SNAPSHOT.jar .
CMD java -jar LMA-0.0.1-SNAPSHOT.jar