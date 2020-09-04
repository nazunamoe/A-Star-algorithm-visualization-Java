# A* algorithm visualization in Java

This program is designed in JAVA language to visualize A Star algorithms.

## What is A* Algorithm? 

>A* (pronounced "A-star") is a graph traversal and path search algorithm, which is often used in many fields of 
>computer science due to its completeness, optimality, and optimal efficiency. One major practical drawback is its O(b^d) 
>space complexity, as it stores all generated nodes in memory. Thus, in practical travel-routing systems, 
>it is generally outperformed by algorithms which can pre-process the graph to attain better performance,
>as well as memory-bounded approaches; however, A* is still the best solution in many cases.

from [Wikipedia](https://en.wikipedia.org/wiki/A*_search_algorithm, "Wikipedia link")

## Program language

JAVA with Swing framework

## How it works?

* Start search 
  1. Make map file
      - Text file rules
        - Expresss 1 pixel in 1 character
          - '.' : Blank
          - 'W' : Wall
          - 'E' : Exit (Only one character is allowed)
        - Leave a space of 1 space between letters and letters.
        - Refer the included map.txt and map2.txt files.

  2. Open program and click 'Open Map' button
  3. Click 'Analysis' button
  4. You can start search via click on 'Search' button
  * You can adjust speed via 'Speed' textbox, insert speed you want (It is recommended not to exceed 20), and click 'Apply'
  
* Edit map 
  - After opening the map file, click on 'Start the editor' button
  
    - You can make start point, end point and wall
    - Before moving start point or end point, You need to remove existing start point or end point or cause error.
    - After editing map, click 'Exit the editor'.

Video (CLI) : [Youtube](https://youtu.be/MhFao8uijY0, "Youtube video link")

## Screenshots

![Intro](/Screenshots/intro.jpg)
![Edit](/Screenshots/edit.jpg)
![Result](/Screenshots/result.jpg)
