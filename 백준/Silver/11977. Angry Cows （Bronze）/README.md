# [Silver II] Angry Cows (Bronze) - 11977 

[문제 링크](https://www.acmicpc.net/problem/11977) 

### 성능 요약

메모리: 14252 KB, 시간: 100 ms

### 분류

브루트포스 알고리즘, 구현

### 제출 일자

2025년 10월 10일 22:15:52

### 문제 설명

<p>Bessie the cow has designed what she thinks will be the next big hit video game: "Angry Cows". The premise, which she believes is completely original, is that the player shoots a cow with a slingshot into a one-dimensional scene consisting of a set of hay bales located at various points on a number line; the cow lands on a hay bale with sufficient force to cause the bale to explode, which in turn might set of a chain reaction that causes additional nearby hay bales to explode. The goal is to use a single cow to start a chain reaction that detonates as many hay bales as possible.</p>

<p>There are \(N\) hay bales located at distinct integer positions \(x_1, x_2, \ldots, x_N\) on the number line. If a cow is launched onto a hay bale at position \(x\), this hay bale explodes with a "blast radius" of 1, meaning that any other hay bales within 1 unit of distance are also engulfed by the explosion. These neighboring bales then themselves explode (all simultaneously), each with a blast radius of 2, so these explosions may engulf additional yet-unexploded bales up to 2 units of distance away. In the next time step, these bales also explode (all simultaneously) with blast radius 3. In general, at time \(t\) a set of hay bales will explode, each with blast radius \(t\). Bales engulfed by these explosions will themselves explode at time \(t+1\) with blast radius \(t+1\), and so on.</p>

<p>Please determine the maximum number of hay bales that can explode if a single cow is launched onto the best possible hay bale to start a chain reaction.</p>

### 입력 

 <p>The first line of input contains \(N\) (\(1 \leq N \leq 100\)). The remaining \(N\) lines all contain integers \(x_1 \ldots x_N\) (each in the range \(0 \ldots 1,000,000,000\)).</p>

### 출력 

 <p>Please output the maximum number of hay bales that a single cow can cause to explode.</p>

