# How to build from CONSOLE

# COMPILE THE `*.java` files
- `javac -d bin src/ro/ase/java/primitives/MainArrays.java`
- `javac -d bin src/ro/ase/java/oop/Showroom.java src/ro/ase/java/oop/MainOOPArrays.java`

# CHANGE DIRECTORY INTO OUTPUT DIRECTORY
- `cd bin/`

# YOU COULD SEE NOW THE INTERMEDIATE BYTECODE FILES `*.class`
- `cd ro/ase/java/primitives`
- `cd ro/ase/java/oop`

# RUN THE PROGRAM
- `java ro.ase.java.primitives.MainArrays`
- `java ro.ase.java.oop.MainOOPArrays`

# CREATE `JAR` FROM EXISTING PROJECT
- `jar cvf ooparrays.jar ro/ase/java/oop/Showroom.class`