package dev.eury.advancedui.data

import dev.eury.advancedui.models.Answer
import dev.eury.advancedui.models.Question

fun Question.Companion.mockList() = listOf(
    Question(
        "What does MVC stand for in the context of software architecture?",
        listOf(
            Answer("Model-View-Controller", true),
            Answer("Multiple-View-Configuration", false),
            Answer("Minimum-Viable-Code", false),
            Answer("Model-View-Component", false)
        )
    ),
    Question(
        "Which programming language uses indentation to define code blocks?",
        listOf(
            Answer("Java", false),
            Answer("Python", true),
            Answer("C++", false),
            Answer("JavaScript", false)
        )
    ),
    Question(
        "What does API stand for?",
        listOf(
            Answer("Application Programming Interface", true),
            Answer("Automated Program Interaction", false),
            Answer("Application Process Integration", false),
            Answer("Automated Protocol Invocation", false)
        )
    ),
    // Add more questions following the same structure...
    Question(
        "In object-oriented programming, what is encapsulation?",
        listOf(
            Answer("Hiding the internal state of an object", true),
            Answer("Inheriting from multiple classes", false),
            Answer("Breaking a program into smaller functions", false),
            Answer("Converting code to machine code", false)
        )
    ),
    Question(
        "What is the purpose of the 'git rebase' command?",
        listOf(
            Answer("To combine multiple branches", true),
            Answer("To create a new branch", false),
            Answer("To undo the last commit", false),
            Answer("To revert changes in a file", false)
        )
    ),
    Question(
        "What does DRY stand for in software development?",
        listOf(
            Answer("Don't Repeat Yourself", true),
            Answer("Do Rewrite Yourself", false),
            Answer("Duplicate Resource Yielding", false),
            Answer("Data Retention Yield", false)
        )
    ),
    Question(
        "Which data structure uses LIFO (Last In, First Out) principle?",
        listOf(
            Answer("Queue", false),
            Answer("Stack", true),
            Answer("Array", false),
            Answer("Linked List", false)
        )
    ),
    Question(
        "What is the purpose of the 'npm' command in Node.js?",
        listOf(
            Answer("To install packages", true),
            Answer("To create a new module", false),
            Answer("To execute JavaScript code", false),
            Answer("To update Node.js", false)
        )
    ),
    Question(
        "What is a 'lambda function' in programming?",
        listOf(
            Answer("A function without a name", true),
            Answer("A function with multiple parameters", false),
            Answer("A function that calls other functions", false),
            Answer("A function used for mathematical calculations", false)
        )
    ),
    Question(
        "What does SQL stand for in database programming?",
        listOf(
            Answer("Sequential Query Language", false),
            Answer("Structured Question Language", false),
            Answer("Standard Query Language", true),
            Answer("Single Query Logic", false)
        )
    ),
    Question(
        "What does OOP stand for in programming?",
        listOf(
            Answer("Object-Oriented Programming", true),
            Answer("Overarching Optimization Process", false),
            Answer("Optimized Object Protocol", false),
            Answer("Object-Oriented Process", false)
        )
    ),
    Question(
        "Which sorting algorithm has the best average time complexity?",
        listOf(
            Answer("Bubble Sort", false),
            Answer("Quick Sort", true),
            Answer("Insertion Sort", false),
            Answer("Selection Sort", false)
        )
    ),
    Question(
        "What is the purpose of the 'this' keyword in JavaScript?",
        listOf(
            Answer("To refer to the current object", true),
            Answer("To declare a variable", false),
            Answer("To access global variables", false),
            Answer("To create a new object", false)
        )
    ),
    Question(
        "What is a 'singleton' design pattern?",
        listOf(
            Answer("A design pattern that restricts instantiation of a class to one object", true),
            Answer("A pattern to create multiple instances of a class", false),
            Answer("A pattern to handle exceptions in a class", false),
            Answer("A pattern for creating nested classes", false)
        )
    ),
    Question(
        "What is the purpose of a 'try-catch' block in programming?",
        listOf(
            Answer("To execute code repeatedly", false),
            Answer("To handle exceptions", true),
            Answer("To define a loop", false),
            Answer("To declare variables", false)
        )
    ), Question(
        "What does the acronym 'REST' stand for in web services?",
        listOf(
            Answer("Representational State Transfer", true),
            Answer("Remote Execution System Transfer", false),
            Answer("Resource Execution State Transfer", false),
            Answer("Representative Endpoint System Transfer", false)
        )
    ),
    Question(
        "What is a 'closure' in programming?",
        listOf(
            Answer("A function that captures its lexical environment", true),
            Answer("A function with no parameters", false),
            Answer("A function that doesn't return anything", false),
            Answer("A function that runs only once", false)
        )
    ),
    Question(
        "What is the purpose of a 'foreign key' in a relational database?",
        listOf(
            Answer("To uniquely identify a record in a table", false),
            Answer("To ensure referential integrity between two related tables", true),
            Answer("To speed up database queries", false),
            Answer("To store large binary data", false)
        )
    ),
    Question(
        "What is a 'race condition' in programming?",
        listOf(
            Answer(
                "A situation where two threads access shared data concurrently and the outcome depends on timing",
                true
            ),
            Answer("A condition where a loop runs infinitely", false),
            Answer("A situation where a program crashes unexpectedly", false),
            Answer("A condition where a variable's value cannot be changed", false)
        )
    ),
    Question(
        "What is the purpose of the 'else if' statement in programming?",
        listOf(
            Answer("To execute a block of code if a condition is true", false),
            Answer("To handle multiple conditions sequentially", true),
            Answer("To terminate a loop", false),
            Answer("To declare variables", false)
        )
    ),
    Question(
        "What does 'NaN' stand for in JavaScript?",
        listOf(
            Answer("Not a Node", false),
            Answer("Not a Null", false),
            Answer("Not a Number", true),
            Answer("Null and None", false)
        )
    ),
    Question(
        "What is the purpose of the 'finally' block in a try-catch-finally statement?",
        listOf(
            Answer("To define the catch block", false),
            Answer("To handle exceptions", false),
            Answer("To execute code regardless of whether an exception is thrown or not", true),
            Answer("To declare variables", false)
        )
    ),
    Question(
        "What is 'Big O notation' used for in computer science?",
        listOf(
            Answer("To analyze the complexity of algorithms", true),
            Answer("To calculate memory allocation in a program", false),
            Answer("To define the size of objects", false),
            Answer("To measure code execution speed", false)
        )
    ),
    Question(
        "What is 'polymorphism' in object-oriented programming?",
        listOf(
            Answer("The ability of a function to call itself", false),
            Answer("The ability of an object to take on many forms", true),
            Answer("The process of converting objects into primitive data types", false),
            Answer("The concept of restricting access to certain methods", false)
        )
    ),
    Question(
        "What is a 'callback function' in JavaScript?",
        listOf(
            Answer(
                "A function passed as an argument to another function to be executed later",
                true
            ),
            Answer("A function that calls itself", false),
            Answer("A function used to calculate a callback value", false),
            Answer("A function that handles exceptions", false)
        )
    )
)