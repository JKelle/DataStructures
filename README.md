# DataStructures
This repo contains skeleton code for common data structures for educational purposes. The idea is that people can use this repo to implement the missing methods of data structures (lists, trees, maps, etc.). This is good for learning, practicing, and/or reviewing data structures. It comes complete with unit tests and "solution" implementations.

These projects assume a basic understanding of java and general programming. In addition to data structure theory, they also aim to gradually teach programming concepts like generics, abstraction, interfaces, etc.

This is a work in progress. I'll be adding more data structures when I can!

How to
------
This repo is comprised of several projects, each focused on implementing a common data structure. Each project is a directory that contains

1. skeleton code for the data structure. The public methods are declared, but most of their implementation is missing.
2. unit tests. Most of these should fail (not crash) in the beginning. The goal is to implement the missing code in the data structure file so that it passes all these tests.
3. a Makefile. At the command line, enter the command `make` to compile the project, and `make run` to compile the project and run the unit tests.

I recommend forking this repo and filling in the missing code to get all tests passing.

Array List
---------
`IntArrayList.java` defines an ArrayList that only allows ints (for simplicity).
Fill in the missing code in `IntArrayList.java`.

Objectives:
* General programming
* Array list data structure
* Object Oriented Programming (OOP)
* Abstraction
* Encapsulation

`GenericArrayList.java` defines an ArrayList that allows any Object. The methods to implement are a subset of those in IntArrayList

Objectives:
* Generics

Linked List
----------
`MyLinkedList.java` defines a linked list, which implements the `MyList.java` interface. These mirror java's `LinkedList` class and `List` interface, but have fewer methods. There are multiple correct ways to implement list class. The solution is doubly-linked, non-circular with dummy nodes head and tail.

Objectives:
* Linked list data structure
* Interfaces
* Iterators
* Argument checking and throwing Exceptions

Stack
-----
`MyStack.java` defines a simple stack, which implements only the classic methods `push()`, `pop()`, `peek()`, and `isEmpty()`. There are multiple correct ways to implement a stack, but the solution uses an ArrayList under the hood.

Objectives:
* Stack data structure
* Using one data structure to implement another

Queue
-----
`MyQueue.java` defines a simple queue, which implements only the classic methods `add()`, `remove()`, `peek()`, and `isEmpty()`. There are multiple correct ways to implement a queue, but the solution uses a LinkedList under the hood.

Objectives:
* Queue data structure
* Using one data structure to implement another
