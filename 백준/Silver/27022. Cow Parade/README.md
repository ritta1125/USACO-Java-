# [Silver V] Cow Parade - 27022 

[문제 링크](https://www.acmicpc.net/problem/27022) 

### 성능 요약

메모리: 14640 KB, 시간: 120 ms

### 분류

구현

### 제출 일자

2025년 12월 26일 23:13:33

### 문제 설명

<p>Farmer John's cows are participating in the annual Bovington, Wisconsin Cow Parade.  The streets in this city form a rectangular grid: they all run north-south or east-west and are equally spaced. Farmer John's cattle parade through the streets.</p>

<p>The cows, being meticulous record keepers, recorded the path of their parade.  They wrote exactly a series of D (1 ≤ D ≤ 1,000) directions, such as "north for 3 blocks", then "east for 2 blocks", etc. The distance traveled was always in the range 1..10,000. See the sample data for some of the silly ways the cows recorded their march.</p>

<p>After the parade, the cows wanted to know how many different streets they paraded on. If they paraded on one street, left it, and later paraded on the same street, they only count that street once.</p>

### 입력 

 <ul>
	<li>Line 1: A single integer, D</li>
	<li>Lines 2..N+1: Each line describes a sequence part of the parade route and contains:
	<ul>
		<li>A character representing the direction ('N', 'S', 'E', or 'W')</li>
		<li>the number of blocks travelled in that direction.</li>
	</ul>
	</li>
</ul>

### 출력 

 <ul>
	<li>Line 1: A single integer containing the number of unique streets visited by the cows.</li>
</ul>

