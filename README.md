# N-Queens Genetic Algorithm

A robust Java implementation of a Genetic Algorithm (GA) designed to solve the classic N-Queens problem. This project
was developed to model evolutionary principles such as natural selection, crossover, and mutation to find a board
configuration where no queens threaten each other.

## 🧬 Evolutionary Concepts Implemented

This algorithm uses a purely Object-Oriented approach and incorporates several advanced genetic programming strategies:

* **Chromosome Representation:** A 1D array of integers of size `N`, where the index represents the column and the value
  represents the row position of a queen.
* **Fitness Function (Minimization):** Calculates the number of collisions (horizontal and diagonal). The optimal
  solution has a fitness of `0`.
* **Lazy Evaluation (Memoization):** The fitness value is cached upon its first calculation (`getFitness()`). This
  prevents redundant $O(n^2)$ recalculations for unmodified individuals, drastically improving performance.
* **Selection Strategy:** * **Elitism:** The top `N` individuals (lowest collisions) are guaranteed survival to the next
  generation.
    * **Roulette Wheel Selection (Fitness Proportionate Selection):** Because this is a minimization problem, fitness
      values are inverted using `1.0 / (fitness + 1.0)` to give higher selection probability to individuals with fewer
      collisions.
* **Crossover:** Single-point (or two-point) crossover combining the genetic material of two parents to produce two
  distinct offspring.
* **Mutation:** Random resetting of genes based on a predefined mutation rate to maintain genetic diversity and escape
  local minima.

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Building the Project

Clone the repository and compile the project using Maven:

```bash
mvn clean compile

### Running the Application
```bash
mvn exec:java -Dexec.mainClass="com.example.App"
```

### Running Tests

```bash
mvn test
```

## Project Structure

- `src/main/java/` - Main source code
- `src/test/java/` - Test source code
- `pom.xml` - Maven configuration