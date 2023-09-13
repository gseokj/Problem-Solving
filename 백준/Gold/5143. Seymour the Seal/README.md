# [Gold IV] Seymour the Seal - 5143 

[문제 링크](https://www.acmicpc.net/problem/5143) 

### 성능 요약

메모리: 35964 KB, 시간: 440 ms

### 분류

너비 우선 탐색, 그래프 이론, 그래프 탐색

### 문제 설명

<p>Seymour the Seal is very upset! Not only did he have to witness a huge explosion while he was minding his own business and munching on some tasty herrings (and — truth be told — some of his whiskers were even seared a little), but now he has to put up with all that black gooey stuff that burns in the eyes and makes breathing so hard. Swimming certainly used to be a lot more fun before. He has already figured out that if he travels through too much of that gooey stuff, it is really bad for him, and a few times he came close to dying. Fortunately, there are those nice people on the beach who clean him off. He definitely needs to make sure to visit them regularly enough if he is going to make it to some of his favorite herring hunting grounds. Alas, it seems like some of his herrings are now behind so much goop that he can’t get there at all. So Seymour wants to compute how many of his herring supplies are still accessible.</p>

<p>You will be given a two-dimensional map representing Seymour’s neighborhood. Seymour can move one square at a time horizontally or vertically (but not diagonally). Each character will show what’s located at that point. An ‘S’ denotes Seymour’s seal colony (there will be exactly one ‘S’ in the map). ‘H’ means that there’s a herring supply. ‘G’ means black goop. ‘P’ designates a place with one of those nice seal cleaners. Finally, a dot ‘.’ denotes open water. Seymour has figured out that he can barely survive swimming through 3 squares of goop. The fourth one would kill him. If he visits one of the nice people, they will clean him completely, so he can then survive another 3, and can repeat this as often as he wants.</p>

### 입력 

 <p>The first line contains the number K of data sets. This is followed by K data sets, each of the following form:</p>

<p>The first line contains two integers 1 ≤ x,y ≤ 50, the size of the map.</p>

<p>This is followed by y lines of x characters each, describing one row of Seymour’s map as explained above.</p>

### 출력 

 <p>For each data set, first output “Data Set x:” on a line by itself, where x is its number. Then, on the next line, output the total number of herring supplies that Seymour can still reach without dying along the way. Each data set should be followed by a blank line.</p>

