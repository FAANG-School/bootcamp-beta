# Data Center Service

The Data Center Service is a Java-based solution designed to manage and optimize a data center. It performs operations
such as adding and removing servers, allocating and releasing resources, and managing energy consumption. The solution
employs a customizable optimization strategy to ensure efficient resource utilization and energy management.

## Features
* Adding and removing servers to/from the data center
* Allocating and releasing resources based on server load
* Managing energy consumption by calculating the total consumption of all servers
* Customizable optimization strategy to optimize the data center according to specific requirements
* Finding servers that meet specific conditions for resource allocation or release
Usage

To use the Data Center Service, create a DataCenter instance and an `OptimizationStrategy` implementation. Then, create a
`DataCenterService instance with the data center and optimization strategy.

````java
DataCenter dataCenter = new DataCenter();
OptimizationStrategy optimizationStrategy = new CustomOptimizationStrategy();
DataCenterService dataCenterService = new DataCenterService(dataCenter, optimizationStrategy);
````

### Adding and removing servers
Add a server to the data center by calling `addServer()` on the `DataCenterService` instance:

```java
Server server = new Server(100, 200, 50);
dataCenterService.addServer(server);
```

Remove a server from the data center by calling `removeServer()`:
```java
dataCenterService.removeServer(server);
```
### Allocating and releasing resources
Allocate resources for a `ResourceRequest` by calling `allocateResources()`:
```java
ResourceRequest request = new ResourceRequest(50);
dataCenterService.allocateResources(request);
```
Release resources for a `ResourceRequest` by calling `releaseResources()`:
```java
dataCenterService.releaseResources(request);
```
#### Optimizing the data center
Optimize the data center using the provided optimization strategy by calling `optimize()`:
```java
dataCenterService.optimize(dataCenter);
```
#### Customization
To create a custom optimization strategy, implement the `OptimizationStrategy` interface:
```java
public class CustomOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        // Optimization logic goes here
    }
}
```
Then, pass an instance of the custom strategy when creating the `DataCenterService`:
```java
OptimizationStrategy optimizationStrategy = new CustomOptimizationStrategy();
DataCenterService dataCenterService = new DataCenterService(dataCenter, optimizationStrategy);
```