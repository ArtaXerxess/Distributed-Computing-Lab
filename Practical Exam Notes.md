# Summary

1. Clock Synchronization:

    a. Cristian Algorithm

    b. Berkeley Algorithm

2. Mutual exclusion Algorithms:

    a. Lamport’s Distributed Mutual Algorithm

    b. Ricart-Agrawala Algorithm

    c. Maekawa’s Algorithm

    d. Suzuki-Kasami’s Broadcast Algorithms, 

    e. Raymond’s Tree based Algorithm

3. Election Algorithms:

    a. Bully Algorithm 

    b. Ring Algorithm

4. Load Balancing: Banker’s Algorithm

5. Deadlock Detection: Chandy-Misra-Haas’s Algorithm


| Name | Description | Pros | Cons | Steps |
|------|-------------|------|------|-------|
| Clock Synchronization - Cristian Algorithm | A time synchronization algorithm where a client requests the time from a time server and adjusts its clock accordingly. | - Simple and easy to implement<br>- Provides a rough estimate of time synchronization<br>- Suitable for small-scale systems | - Assumes symmetric network delay<br>- Not suitable for large-scale systems<br>- Vulnerable to network delay variations | 1. Client sends a request to the time server.<br>2. Time server responds with its local time.<br>3. Client calculates the time difference and adjusts its clock. |
| Clock Synchronization - Berkeley Algorithm | A time synchronization algorithm where multiple servers exchange their time information to calculate an average time. | - Provides a more accurate estimate of time synchronization compared to Cristian Algorithm<br>- Suitable for larger systems<br>- Handles clock drift better | - Requires more computational resources<br>- Complexity increases with the number of servers<br>- Not suitable for systems with high network latency | 1. Servers exchange their time information.<br>2. Each server calculates the average time.<br>3. Servers adjust their clocks based on the average time. |
| Mutual Exclusion - Lamport's Distributed Mutual Algorithm | A distributed algorithm that ensures mutual exclusion among processes using logical timestamps. | - Simple and easy to understand<br>- Ensures mutual exclusion among processes<br>- Suitable for small-scale systems | - Assumes FIFO message delivery<br>- Requires synchronization on each request<br>- Not suitable for large-scale systems with high contention | 1. Process requests to enter critical section.<br>2. Process sends a timestamped request to all other processes.<br>3. Process enters critical section when all requests with lower timestamps have been acknowledged. |
| Mutual Exclusion - Ricart-Agrawala Algorithm | A distributed algorithm that uses request and reply messages to ensure mutual exclusion among processes. | - Allows concurrent requests to be granted<br>- Handles network failures and process crashes<br>- Suitable for large-scale systems | - Requires multiple rounds of message exchange<br>- Can result in message congestion<br>- Requires synchronization on each request | 1. Process requests to enter critical section.<br>2. Process sends request messages to all other processes.<br>3. Process waits for replies from all processes.<br>4. Process enters critical section when all replies have been received. |
| Mutual Exclusion - Maekawa's Algorithm | A distributed algorithm that uses a voting-based approach to ensure mutual exclusion among processes. | - Provides high concurrency<br>- Scalable and suitable for large-scale systems<br>- Ensures mutual exclusion among processes | - Requires significant communication overhead<br>- Complex and difficult to implement<br>- Requires synchronization on each request | 1. Process requests to enter critical section.<br>2. Process sends a request to a subset of processes called "quorum".<br>3. Process waits for "quorum" to reply with a "yes" vote.<br>4. Process enters critical section when "quorum" replies with "yes" votes. |
| Mutual Exclusion - Suzuki-Kasami's Broadcast Algorithm | A distributed algorithm that uses broadcast messages to ensure mutual exclusion among processes. | - Ensures mutual exclusion among processes<br>- Suitable for dynamic systems with process failures<br>- Handles concurrent requests | - Requires multiple rounds of message exchange<br>- Can result in message congestion<br>- Requires synchronization on each request | 1. Process requests to enter critical section.<br>2. Process broadcasts a request message to all other processes.<br>3. Process waits for replies from all processes.<br>4. Process enters critical section when all replies have been received. |


Name | Description | Pros | Cons | Steps
--- | --- | --- | --- | ---
Raymond's Tree based Algorithm | A distributed algorithm for resource allocation and management in a distributed system that uses a tree structure for communication and coordination. | - Scalable and efficient in terms of message complexity. <br> - Enables distributed decision making based on a hierarchical tree structure. <br> - Provides a fault-tolerant approach for resource allocation. | - Requires an initial tree construction phase which can introduce overhead. <br> - May not be suitable for systems with dynamic or changing topologies. | 1. Construct a spanning tree of the distributed system. <br> 2. Use the tree for communication and coordination, with nodes sending requests and responses up and down the tree. <br> 3. Use the tree structure to make distributed decisions based on the hierarchy.
Bully Election Algorithm | A distributed algorithm for electing a coordinator or leader in a distributed system where each node compares its own priority with that of its neighbors to determine the leader. | - Simple and easy to understand. <br> - Guarantees the election of the highest priority node as the leader. <br> - Does not require any initial configuration or knowledge of the system size. | - May not be efficient in terms of message complexity, as it involves a lot of message exchanges during the election process. <br> - Can be slow in large systems with many nodes. <br> - Requires a predefined priority or ranking for each node. | 1. Nodes start the election by sending election messages to their neighbors with higher priority. <br> 2. If a node does not receive any response, it declares itself as the leader. <br> 3. If a higher priority node is detected during the election, the lower priority node stops its own election and participates in the higher priority node's election.
Ring Election Algorithm | A distributed algorithm for electing a coordinator or leader in a distributed system where nodes form a ring structure and pass a token around to determine the leader. | - Simple and easy to implement. <br> - Requires fewer message exchanges compared to some other algorithms. <br> - Can be efficient in terms of message complexity. | - Requires a predefined order or priority for nodes in the ring. <br> - May not be fault-tolerant if nodes fail or drop out of the ring. <br> - Can result in delays if the token gets stuck or lost in the ring. | 1. Nodes form a ring structure and pass a token around in a predefined direction. <br> 2. When a node receives the token, it checks its own priority and compares it with the current leader. <br> 3. If the node has higher priority, it becomes the new leader and sends a notification to other nodes.
Chandy-Misra-Haas's Algorithm | A distributed algorithm for detecting termination in distributed computations by using a token-based approach to mark finished processes. | - Can detect termination in distributed computations efficiently. <br> - Can be used in various distributed computing models. <br> - Provides a flexible and scalable approach for termination detection. | - Requires additional message overhead for token passing. <br> - Can be complex to implement and may require careful handling of corner cases. <br> - May not be suitable for highly dynamic or large-scale systems. | 1. Start with an initiator process that creates a token and sends it to a neighbor process. <br> 2. Processes that finish their computation mark the token and pass it to their neighbors. <br> 3. The token circulates in the system, marking finished






![image](https://user-images.githubusercontent.com/74452252/234154842-4a8a866c-b195-4a99-b210-47c2cc26ceab.png)




1. Throughput: <ins>Throughput is a measure of how many units of information a system can process in a given amount of time. </ins> It is applied broadly to systems ranging from various aspects of computer and network systems to organizations.In the context of mutual exclusion algorithms in distributed systems, throughput refers to the number of requests or operations that a system can successfully process or complete within a given time period. It is a measure of the system's efficiency in handling concurrent requests or operations without conflicts or contention. Higher throughput indicates that the system is capable of processing a larger number of requests in parallel, resulting in better performance and increased utilization of system resources.

2. Synchronization delay: The synchronization delay is the <ins>time required after a site exits the CS and before the next site enters the CS</ins> and it is measured in terms of the average message delay . Synchronization delay in the context of mutual exclusion algorithms in distributed systems refers to the time delay incurred when processes or nodes in a distributed system coordinate and synchronize with each other to ensure that only one process or node accesses a shared resource at a time. Synchronization delay occurs due to various factors such as communication delays, processing delays, and contention for access to shared resources. It can impact the overall performance and efficiency of the distributed system, as processes or nodes may need to wait for synchronization before accessing shared resources, leading to potential delays and reduced throughput. Efficiently managing synchronization delay is an important consideration in designing mutual exclusion algorithms for distributed systems to minimize contention and maximize system performance.
