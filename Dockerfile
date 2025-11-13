# Use Tomcat 11 with JDK 17
FROM tomcat:11.0.14-jdk17

# Remove default apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR into Tomcat
COPY target/ProductManagementSystem-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/productmanagementsystem.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]

