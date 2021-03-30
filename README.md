# Chess of Hastings
## Introduction
Chess of Hastings is a simple board game for two players, based on Chess and inspired by the [Battle of Hastings](https://en.wikipedia.org/wiki/Battle_of_Hastings "Wikipedia page"). The two sides are asymmetrical, meaning they aren't equal in terms of pieces. Please do tell me in the Issues tab if you think a piece is overpowered.

I originally came up with the idea as a History class assignment. Back then it was a *real* board game. Then, to learn Java, I decided to remake it into a computer board game, which brings us to the present. Right now I'm trying to compress the code into a single JAR file and release it, until then you'll have to manually build and run.

*Don't play this game, it's rubbish.*
## How To Play
TODO
## Installation
Right now I haven't found a way to compile this into a single JAR file for release. You'll have to compile it manually with the following commands (untested):

```
git clone https://github.com/sy3c4ll/ChessOfHastings
cd ChessOfHastings/src
javac com/github/sy3c4ll/ChessOfHastings/Main.java com/github/sy3c4ll/ChessOfHastings/core/* com/github/sy3c4ll/ChessOfHastings/pieces/*
java com.github.sy3c4ll.ChessOfHastings.Main
```
