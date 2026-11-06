# University File System — Visitor Pattern

**Software Design Patterns — Assignment #6**

## Project Description

This Java project demonstrates the **Visitor Behavioral Design Pattern** using a university file system.

The system contains files and directories. The Visitor Pattern allows us to perform different operations on these elements without modifying their classes.

## Features

- **TotalSizeVisitor** — Calculates the total size of files, including files inside directories.
- **SearchVisitor** — Searches for a file or directory by its name.

## Project Structure

| File | Responsibility |
|---|---|
| `FileSystemElement.java` | Element Interface — declares `accept()` |
| `FileNode.java` | Concrete Element representing a file |
| `DirectoryNode.java` | Concrete Element representing a directory |
| `FileSystemVisitor.java` | Visitor Interface — declares `visitFile()` and `visitDirectory()` |
| `TotalSizeVisitor.java` | Concrete Visitor for size calculation |
| `SearchVisitor.java` | Concrete Visitor for searching |
| `Main.java` | Client — creates objects and applies Visitors |

## How the Visitor Pattern Works

The project uses **Double Dispatch**:

1. The Client calls `element.accept(visitor)`.
2. The Concrete Element calls `visitor.visitFile(this)` or `visitor.visitDirectory(this)`.
3. The corresponding Concrete Visitor method performs the operation.

This allows us to add new operations without changing the existing Element classes.

## Clean Code Principles

**1. Meaningful Names**

Class and method names clearly describe their responsibilities, such as `TotalSizeVisitor`, `SearchVisitor` and `getTotalSize()`.

**2. Single Responsibility Principle (SRP)**

Each Concrete Visitor performs one operation: calculating file sizes or searching by name.

**3. Open/Closed Principle (OCP)**

New operations can be added by creating another class that implements `FileSystemVisitor`, without modifying `FileNode` or `DirectoryNode`.

**4. Encapsulation**

Element fields are private. Visitors access the necessary data through getter methods. `DirectoryNode` returns a copy of its children list to protect the original collection.

**5. No instanceof / Type Checking**

The project uses Double Dispatch instead of `instanceof` or type-checking chains to select the correct operation for each element type.

## Example

University file structure:

- **University/**
  - `report.pdf` — 500 bytes
  - **Documents/**
    - `notes.txt` — 200 bytes

Expected output:

`Total size: 700 bytes`

`File found: true`

## Conclusion

The project demonstrates how the Visitor Pattern separates operations from the object structure. It supports easy extension, follows Clean Code principles and uses Double Dispatch to process different element types.
