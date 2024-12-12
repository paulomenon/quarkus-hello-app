![MIT License](https://img.shields.io/badge/license-MIT-green.svg)

# Quarkus Hello App

This repository contains a simple **Quarkus-based application** that demonstrates a basic "Hello" service using a **POST** method.

## Features
- A simple REST endpoint that accepts a POST request.
- Demonstrates Quarkus framework for building Java microservices.

## Getting Started

### Prerequisites
Ensure you have the following installed:
- Java 11 or later
- Maven
- Docker or Podman (optional, for containerization)

### Running the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/paulomenon/quarkus-hello-app.git
   cd quarkus-hello-app
   ```
2. Run the application using Maven:
   ```bash
   ./mvnw quarkus:dev
   ```
   The application will be available at [http://localhost:8080](http://localhost:8080).

3. Optionally, build a Docker image:
   ```bash
   ./mvnw clean package -Dquarkus.profile=prod
   docker build -f src/main/docker/Dockerfile.native -t quarkus-hello-app .
   ```

## Test with cURL
You can test the application using the following `curl` command:

```bash
curl -X POST http://localhost:8080/welcome \
-H "Content-Type: application/json" \
-d '{"name": "London Java Community Meetup", "location": "Remote"}'
```

## Endpoints
- **POST /welcome** - Accepts a POST request and returns a Welcome message.
- **GET /thanks** - Accepts a GET request and returns a Thank you to our amazing organiser: {app.sponsor}

## Source-To-Image (S2I)

[Document page](https://github.com/openshift/source-to-image?tab=readme-ov-file)

## Openshift deployment

The command:

```bash
oc new-app openshift/java:openjdk-17-ubi8~https://github.com/paulomenon/quarkus-hello-app.git
```

**Explanation:**

1. **`oc new-app`**: Creates a new application on OpenShift.
2. **`openshift/java:openjdk-17-ubi8`**: Specifies the S2I builder image for Java 17 on the UBI 8 base.
3. **`~`**: Links the builder image to the source code repository.
4. **`https://github.com/paulomenon/quarkus-hello-app.git`**: Points to the Git repository containing the application's source code.

This command instructs OpenShift to:
1. Fetch the source code.
2. Build it using the specified Java 17 builder image.
3. Deploy the resulting application.

To create a route from the command line in OpenShift, you can use the `oc expose` command:

```bash
oc expose service <service-name>
```

For example, if your service is named `quarkus-hello-app`, run:

```bash
oc expose service quarkus-hello-app
```

This will create a route that exposes your service. To view the route and its URL, use:

```bash
oc get route
```

The URL in the output can be used to access your application externally.

Using **Postman** to test your OpenShift-deployed application involves the following steps:

### Steps to Test with Postman:
1. **Retrieve the Route URL**:
   After running `oc expose service <service-name>`, use:
   ```bash
   oc get route
   ```
   Copy the URL listed under the `HOST/PORT` column.

2. **Create a New Postman Request**:
   - Open Postman and create a new `POST` request.
   - Use the route URL, adding the specific endpoint (e.g., `/welcome`):
     ```
     http://<route-url>/welcome
     ```

3. **Set Headers**:
   Add the following header:
   ```
   Content-Type: application/json
   ```

4. **Add a JSON Payload**:
   In the body section, choose **raw** and set the type to JSON. For example:
   ```json
   {
     "name": "Londo Java Community Meetup",
     "location": "Red Hat"
   }
   ```

5. **Send the Request**:
   Click **Send** to make the request and view the response from your application.

This ensures you test the functionality exposed via OpenShift routes effectively.

## Kubernetes deployment

If you're using the `s2i` command to achieve what the OpenShift `oc new-app` command does, it would look something like this:

```bash
s2i build https://github.com/paulomenon/quarkus-hello-app.git openshift/java:openjdk-17-ubi8 my-quarkus-hello-app
```

This command:
- Pulls the source code from the specified Git repository.
- Uses the `openshift/java:openjdk-17-ubi8` S2I builder image.
- Produces a new image named `my-quarkus-hello-app` that you can use for deployment. 

You would then deploy the resulting image to Kubernetes.

### Prerequisites
- source2image tool

### MacOS

```bash
brew install source-to-image
```


## License
This project is licensed under the MIT License.

---

Feel free to adapt further!