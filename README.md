File Upload & Serve Spring Boot Project

This project allows uploading files to the server and displaying them in the browser using Spring Boot.

User images and other files are stored on the server in the uploads/ folder.

Files can be viewed from the browser.

ResourceHandler is used for serving static files.

Technologies

Java 17+

Spring Boot 3+

Maven

Lombok

File Upload Endpoints
1. Add User (UsersController)
POST /api/v1/user

Parameters (multipart/form-data):

Parameter	Type	Description
photo	file	User's photo
userName	String	User name
age	Integer	User age

The file is automatically stored in the uploads/ folder.

The file name is determined by the controller (using photo.getOriginalFilename() or adding a UUID).

2. Add File (FileController)
POST /api/v1/files

Parameters (multipart/form-data):

Parameter	Type	Description
fileName	String	File name
url	file	File content
userId	Long	ID of the user uploading file

The file is stored in the uploads/ folder.

View Files in Browser
 Static Files (ResourceHandler)
registry.addResourceHandler("/uploads/**")
        .addResourceLocations("file:uploads/");

Example browser URL:

http://localhost:8080/uploads/photo.png

Files are served directly from the uploads/ folder.

Note: You cannot view a file without knowing its name.

File Storage Recommendation

Add a UUID to file names to ensure uniqueness:

String fileName = UUID.randomUUID() + "_" + photo.getOriginalFilename();

This prevents overwriting files with the same name.

Folder Structure
project-root/
│
├─ uploads/          # Folder for storing uploaded files
├─ src/
│   ├─ main/
│   │   ├─ java/com/example/file/
│   │   │   ├─ controller/
│   │   │   ├─ service/
│   │   │   └─ config/FileConfig.java
│   │   └─ resources/
│   └─ test/
└─ pom.xml
Running the Project

Build the project:

mvn clean package

Run the project:

java -jar target/<project-name>.jar

View in the browser:

Static: http://localhost:8080/uploads/<filename>
