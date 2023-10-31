# [Gold I] House Prices Going Up - 25778 

[문제 링크](https://www.acmicpc.net/problem/25778) 

### 성능 요약

메모리: 145392 KB, 시간: 756 ms

### 분류

자료 구조, 세그먼트 트리

### 제출 일자

2023년 10월 31일 21:04:39

### 문제 설명

<p>The house prices have been going up and the Virtual County Tax Collection Agency needs help to keep track of prices.</p>

<p>We assume the houses in Virtual County (VC) are numbered 1 through n, i.e., the house numbers are 1, 2, 3, …, n. VC keeps track of the house prices as they go up and would like to know the total price for different sections of the county, e.g., the total price for houses 4 through 15.</p>

### 입력 

 <p>The first input line contains an integer, n (1 ≤ n ≤ 5 ×10<sup>5</sup>), indicating the number of houses in VC. Each of the next n input lines contains an integer (between 1 and 10<sup>9</sup>, inclusive) indicating the initial price for a house; first integer is the price for the first house, second integer is the price for the second house, etc.</p>

<p>After the initial price information for all the houses, the input will have a set of transactions (operations) to be processed. This section of the input starts with an integer, t (1 ≤ t ≤ 10<sup>5</sup>), indicating the number of transactions. Each of the next t input lines contains a transaction to be processed. There will be two types of transactions:</p>

<ul>
	<li>Update Transaction: This input line starts with the letter U in the first column, followed by one space, followed by a valid house number, followed by a space, followed by an integer (between 1 and 10<sup>9</sup>, inclusive), indicating the increase in the price of that house.</li>
	<li>Retrieve Transaction: This input line starts with the letter R in the first column, followed by one space, followed by a valid starting house number, followed by a space, followed by a valid ending house number. The total price for this range is being requested. Assume that the ending house number will not be less than the starting house number, i.e., the requested range is valid.</li>
</ul>

### 출력 

 <p>There is no output required for Update transactions. For each Retrieve transaction, output a separate line providing the total price for the range being requested.</p>

