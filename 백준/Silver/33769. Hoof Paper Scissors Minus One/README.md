# [Silver III] Hoof Paper Scissors Minus One - 33769 

[문제 링크](https://www.acmicpc.net/problem/33769) 

### 성능 요약

메모리: 60988 KB, 시간: 616 ms

### 분류

수학, 구현, 조합론, 비트마스킹

### 제출 일자

2025년 11월 19일 18:06:38

### 문제 설명

<p>In a game of Hoof Paper Scissors, Bessie and Elsie can put out one of $N$ ($1 \leq N \leq 3000$) different hoof symbols labeled $1\dots N$, each corresponding to a different material. There is a complicated chart of how the different materials interact with one another, and based on that chart, either:</p>

<ul>
	<li>One symbol wins and the other loses.</li>
	<li>The symbols draw against each other.</li>
</ul>

<p>Hoof Paper Scissors Minus One works similarly, except Bessie and Elsie can each put out two symbols, one with each hoof. After observing all four symbols that they have all put out, they each choose one of their two symbols to play. The outcome is decided based on normal Hoof Paper Scissor conventions.</p>

<p>Given the $M$ ($1 \leq M \leq 3000$) symbol combinations that Elsie plans to make across each game, Bessie wants to know how many different symbol combinations would result in a guaranteed win against Elsie. A symbol combination is defined as an ordered pair $(L,R)$ where $L$ is the symbol the cow plays with her left hoof and $R$ is the symbol the cow plays with her right hoof. Can you compute this for each game?</p>

### 입력 

 <p>The first line contains two space-separated integers $N$ and $M$ representing the number of hoof symbols and the number of games that Bessie and Elsie play.</p>

<p>Out of the following $N$ lines of input, the $i$th line consists of $i$ characters $a_{i,1}a_{i,2}\ldots a_{i,i}$ where each $a_{i,j} \in \{\texttt D,\texttt W,\texttt L\}$. If $a_{i,j} = \texttt D$, then symbol $i$ draws against symbol $j$. If $a_{i,j} = \texttt W$, then symbol $i$ wins against symbol $j$. If $a_{i,j} = \texttt L$, then symbol $i$ loses against symbol $j$. It is guaranteed that $a_{i,i} = \texttt D$.</p>

<p>The next $M$ lines contain two space separated integers $s_1$ and $s_2$ where $1 \leq s_1,s_2 \leq N$. This represents Elsie's symbol combination for that game.</p>

### 출력 

 <p>Output $M$ lines where the $i$-th line contains the number of symbol combinations guaranteeing that Bessie can beat Elsie in the $i$-th game.</p>

