# [Silver I] Reflection - 33735 

[문제 링크](https://www.acmicpc.net/problem/33735) 

### 성능 요약

메모리: 66744 KB, 시간: 592 ms

### 분류

구현

### 제출 일자

2025년 12월 1일 10:19:03

### 문제 설명

<p>Farmer John has a square canvas represented by an $N$ by $N$ grid of cells ($2 \leq N \leq 2000$, $N$ is even). He paints the canvas according to the following steps:</p>

<ol>
	<li>First, he divides the canvas into four equal quadrants, separated by horizontal and vertical lines through the center of the canvas.</li>
	<li>Next, he paints a lovely painting in the top-right quadrant of the canvas. Each cell of the top-right quadrant will either be painted (represented by '#') or unpainted (represented by '.').</li>
	<li>Finally, since he is so proud of his painting, he reflects it across the previously mentioned horizontal and vertical lines into the other quadrants of the canvas.</li>
</ol>

<p>For example, suppose $N=8$ and FJ painted the following painting in the top-right quadrant in step 2:</p>

<pre>.#..
.#..
.##.
....
</pre>

<p>Then after reflecting across the horizontal and vertical lines into the other quadrants in step 3, the canvas would look as follows:</p>

<pre>..#..#..
..#..#..
.##..##.
........
........
.##..##.
..#..#..
..#..#..
</pre>

<p>However, while FJ was sleeping, Bessie broke into his barn and stole his precious canvas. She totally vandalized the canvas—removing some painted cells and adding more painted cells! Before FJ woke up, she returned the canvas to FJ.</p>

<p>FJ would like to modify his canvas so that it once again satisfies the reflective condition: that is, it is the result of reflecting the top-right quadrant into each of the other quadrants. Since he only has a limited number of resources, he would like to achieve this in as few operations as possible, where a single operation consists of either painting a cell or removing paint from a cell.</p>

<p>You are given the canvas after Bessie's vandalism, as well as a sequence of $U$ ($0\le U \leq 10^5$) updates to the canvas, each toggling a single cell to '.' if it is '#', or vice versa. Before any updates, and after each update, output the minimum number of operations $x$ FJ needs to perform so that the reflective condition is satisfied.</p>

### 입력 

 <p>The first line contains integers $N$ and $U$.</p>

<p>The next $N$ lines each contain $N$ characters representing the canvas after Bessie's vandalism. Every character is either '#' or '.'.</p>

<p>The following $U$ lines each contain integers $r$ and $c$, where $1 \leq r, c \leq N$, representing an update to the cell in the $r$th row from the top and $c$th column from the left of the canvas.</p>

### 출력 

 <p>Output $U+1$ lines representing $x$ before any updates and after each update.</p>

