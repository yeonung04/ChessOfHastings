# Chess of Hastings
## Introduction
Chess of Hastings is a simple board game for two players, based on Chess and inspired by the [Battle of Hastings](https://en.wikipedia.org/wiki/Battle_of_Hastings "Wikipedia page"). The two sides are asymmetrical, meaning they aren't equal in terms of pieces. Please do tell me in the Issues tab if you think a piece is overpowered.

I originally came up with the idea as a History class assignment. Back then it was a *real* board game. Then, to learn Java, I decided to remake it into a *computer* board game.

*Don't play this game, it's rubbish.*
## How To Play
1. Normans (blue) start first.
2. Norman and Saxon foot soldiers can move one square horizontally or vertically each turn.
3. Norman archers can only advance one square each turn, but can attack enemies up to three squares in front of them.
4. Norman cavalry can move up to two squares horizontally or vertically each turn.
5. Saxon shieldsmen move similarly to foot soldiers, however they are immune to archer fire.
6. Saxon huscarls can move up to two squares horizontally or vertically, or one square diagonally each turn.
7. Norman and Saxon kings can move one square horizontally, vertically or diagonally. They can attack all pieces, including their own.
8. Any unit in the King square (the squares above and below the 8x8 board) can only see the adjacent eight squares.
9. Killing the opponent's king wins you the game.
## Installation
With release 20210331 I've managed to package the application into a single JAR. You can [download it here](https://github.com/sy3c4ll/ChessOfHastings/releases/download/20210331/20210331.jar) or from the [release tab](https://github.com/sy3c4ll/ChessOfHastings/releases). Alternatively, you can build from source. From the terminal, type
```
git clone https://github.com/sy3c4ll/ChessOfHastings
cd ChessOfHastings/src
javac com/github/sy3c4ll/chessofhastings/*
java com.github.sy3c4ll.chessofhastings.ChessOfHastings
```
to run the binary. Follow with
```
jar -cfm ChessOfHastings.jar MANIFEST.MF .
java -jar ChessOfHastings.jar
```
to build and run a JAR.
