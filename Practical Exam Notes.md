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
