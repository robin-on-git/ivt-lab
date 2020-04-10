# IVT Spaceship

This is a sample application for the [Integration and Verification Techniques](http://www.mit.bme.hu/oktatas/targyak/vimiac04) course at BME MIT.

The application is simplified and deliberately contains bugs.

## Getting started

- The project is implemented in Java 11.
- The project can be built using [Maven](https://maven.apache.org/).
- [JUnit](https://junit.org/junit5/) is used for tests, and [Mockito](https://site.mockito.org/) for isolating dependencies.

Clone the repository and execute Maven to build the application:

```
mvn compile
```

To compile and run tests also execute:

```
mvn test
```

(That will be enough to know for the current exercises. If you are more interested, see [this](https://github.com/ftsrg/swsv-labs/wiki/0b-Build-tools) short guide about Maven.)

As this is a really simple project, you can use the command-line build tools or a light-weight IDE like [Visual Studio Code](https://code.visualstudio.com/).

## Overview

The project represents an alpha version of a spaceship.

- The ship (`SpaceShip` interface) can fire one or more lasers or torpedos.
- We have only one spaceship as of now (`GT4500`).
- Currently two firing modes (`FiringMode`) are supported: firing only one or all instances of a given weapon type.
- Lasers are not yet implemented, but the code for torpedo stores are ready (`TorpedoStore`).
- For the GT4500 ship the rules for firing torpedoes can be found in the Javadoc comment of method `fireTorpedos`. They are already partially implemented.
- There are currently two tests (`GT4500Test`), but be aware that they are not proper unit tests, as they do not isolate the dependencies of the tested class.

The code can be built, but due to missing features one of the tests fails. The first execercise will be to fix this.